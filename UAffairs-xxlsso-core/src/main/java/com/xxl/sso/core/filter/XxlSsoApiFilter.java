package com.xxl.sso.core.filter;

import com.xxl.sso.core.conf.Conf;
import com.xxl.sso.core.user.XxlUser;
import com.xxl.sso.core.util.JacksonUtil;
import com.xxl.sso.core.util.SsoLoginHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-11 16:06
 **/
public class XxlSsoApiFilter extends HttpServlet implements Filter {

    private static Logger logger = LoggerFactory.getLogger(XxlSsoFilter.class);

    private String ssoServer;
    private String logoutPath;

    /**
     * 封装，不需要过滤的list列表
     */
    protected static List<Pattern> patterns = new ArrayList<Pattern>();


    public void init(FilterConfig filterConfig) throws ServletException {

        ssoServer = filterConfig.getInitParameter(Conf.SSO_SERVER);
        if (ssoServer!=null && ssoServer.trim().length()>0) {
            logoutPath = filterConfig.getInitParameter(Conf.SSO_LOGOUT_PATH);
        }
        String exclusionsStr  = filterConfig.getInitParameter("exclusions");
        for (String onePattern:exclusionsStr.split(",")){
            logger.info("exclusions 规则 ： "+onePattern);
            patterns.add(Pattern.compile(onePattern));
        }

        logger.info("XxlSsoFilter init.");
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String servletPath = ((HttpServletRequest) request).getServletPath();
        String link = req.getRequestURL().toString();



        String url = req.getRequestURI().substring(req.getContextPath().length());
        if (url.startsWith("/") && url.length() > 1) {
            url = url.substring(0);
        }
        logger.info("当前请求的url"+url);

        if (isInclude(url)){
            chain.doFilter(request, response);
            return;
        }


        // logout filter
        if (logoutPath!=null
                && logoutPath.trim().length()>0
                && logoutPath.equals(servletPath)) {

            // remove cookie
            SsoLoginHelper.removeSessionIdInCookie(req, res);

            // redirect logout
            String logoutPageUrl = ssoServer.concat(Conf.SSO_LOGOUT);
            res.sendRedirect(logoutPageUrl);

            return;
        }

        // login filter
        XxlUser xxlUser = null;

        // valid cookie user
        String cookieSessionId = SsoLoginHelper.getSessionIdByCookie(req);
        xxlUser = SsoLoginHelper.loginCheck(cookieSessionId);

        // valid param user, client login
        if (xxlUser == null) {

            // remove old cookie
            SsoLoginHelper.removeSessionIdInCookie(req, res);

            // set new cookie
            String paramSessionId = request.getParameter(Conf.SSO_SESSIONID);
            if (paramSessionId != null) {
                xxlUser = SsoLoginHelper.loginCheck(paramSessionId);
                if (xxlUser != null) {
                    SsoLoginHelper.setSessionIdInCookie(res, paramSessionId);
                }
            }
        }

        // valid login fail
        if (xxlUser == null) {

            String header = req.getHeader("content-type");
            // json msg
            res.setContentType("application/json;charset=utf-8");
            res.getWriter().println(JacksonUtil.writeValueAsString(Conf.SSO_LOGIN_FAIL_RESULT));
            return;

        }

        // ser sso user
        request.setAttribute(Conf.SSO_USER, xxlUser);


        // already login, allow
        chain.doFilter(request, response);
        return;
    }

    /**
     * 是否需要过滤
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
        logger.info("判断url是否需要过滤 : "+url);
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }
}
