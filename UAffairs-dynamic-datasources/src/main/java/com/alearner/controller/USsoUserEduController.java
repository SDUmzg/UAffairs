package com.alearner.controller;


import com.alearner.entity.mysql.USsoUserEdu;
import com.alearner.service.USsoUserEduService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 09:40
 **/
@RestController
@RequestMapping(value = "/sso-user-edu")
public class USsoUserEduController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private USsoUserEduService uSsoUserEduService;


    @RequestMapping(value = "/getUSsoUserEduById",method = RequestMethod.GET)
    public USsoUserEdu getUSsoUserEduById(@RequestParam(value = "sso_id") int sso_id){
        logger.info("访问 controller 层 ，方法 ：getUSsoUserEduById ，Param : sso_id - "+sso_id);
        return uSsoUserEduService.getUSsoUserEduById(sso_id);
    }
}
