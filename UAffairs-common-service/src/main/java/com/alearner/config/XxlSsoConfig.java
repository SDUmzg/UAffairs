package com.alearner.config;

import com.xxl.sso.core.conf.Conf;
import com.xxl.sso.core.filter.XxlSsoApiFilter;
import com.xxl.sso.core.util.JedisUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XxlSsoConfig {

    @Value("${xxl.sso.server}")
    private String xxlSsoServer;

    @Value("${xxl.sso.logout.path}")
    private String xxlSsoLogoutPath;

    @Value("${xxl.sso.redis.address}")
    private String xxlSsoRedisAddress;

    @Value("${xxl.sso.redis.password}")
    private String xxlSspRedisPassword;

    @Bean
    public FilterRegistrationBean xxlSsoFilterRegistration() {

        // redis init
        JedisUtil.init(xxlSsoRedisAddress,xxlSspRedisPassword);

        // filter
        FilterRegistrationBean registration = new FilterRegistrationBean();

        StringBuffer excludeUriStr = new StringBuffer();
        excludeUriStr.append("/swagger-resources/*");
        excludeUriStr.append(",");
        excludeUriStr.append("/swagger-ui.html");
        excludeUriStr.append(",");
        excludeUriStr.append("/v2/api-docs");
        excludeUriStr.append(",");
        excludeUriStr.append("/webjars/*");



        registration.setName("XxlSsoFilter");
        registration.setOrder(1);
        registration.addUrlPatterns("/*");
        registration.setFilter(new XxlSsoApiFilter());

        registration.addInitParameter("exclusions",excludeUriStr.toString());
        registration.addInitParameter(Conf.SSO_SERVER, xxlSsoServer);
        registration.addInitParameter(Conf.SSO_LOGOUT_PATH, xxlSsoLogoutPath);

        return registration;
    }

}
