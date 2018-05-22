package com.alearner.util;

import com.alearner.modle.mysql.USsoUserEdu;
import com.alearner.service.UserInformationService;
import com.xxl.sso.core.conf.Conf;
import com.xxl.sso.core.user.XxlUser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-14 16:15
 **/
@Component
public class XxlUtil {
    public USsoUserEdu getXxlUSsoUserEdu(HttpServletRequest request,UserInformationService userInformationService){
        XxlUser xxlUser = (XxlUser) request.getAttribute(Conf.SSO_USER);
        USsoUserEdu uSsoUserEdu = userInformationService.getUSsoUserEduById(xxlUser.getUserid());
        return uSsoUserEdu;
    }

    public XxlUser getXxlUser(HttpServletRequest request){
        return (XxlUser) request.getAttribute(Conf.SSO_USER);
    }
}
