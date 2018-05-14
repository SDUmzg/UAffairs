package com.alearner.controller;


import com.alearner.modle.common.UserInformation;
import com.alearner.service.UserInformationService;
import com.xxl.sso.core.conf.Conf;
import com.xxl.sso.core.entity.ReturnT;
import com.xxl.sso.core.user.XxlUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 15:13
 **/
@RestController
@RequestMapping(value = "/user-info")
@CrossOrigin
public class UserInformationController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInformationService userInformationService;

    @RequestMapping(value = "/getCurrentUserInfo",method = RequestMethod.GET,produces = "application/json")
    public ReturnT<UserInformation> getCurrentUserInfo(HttpServletRequest request){
        XxlUser xxlUser = (XxlUser) request.getAttribute(Conf.SSO_USER);
        UserInformation userInformation=userInformationService.getUserInformationBySsoId(xxlUser.getUserid());
        return new ReturnT(userInformation);
    }
}
