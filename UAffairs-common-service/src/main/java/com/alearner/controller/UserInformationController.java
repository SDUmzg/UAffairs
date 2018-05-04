package com.alearner.controller;

import com.alearner.modle.common.UserInformation;
import com.alearner.modle.mysql.UFamilyRelation;
import com.alearner.modle.mysql.USsoUserEdu;
import com.alearner.modle.mysql.UStudent;
import com.alearner.modle.mysql.UTeacher;
import com.alearner.service.UserInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 12:11
 **/
@RestController
@RequestMapping(value = "/user-info")
public class UserInformationController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInformationService userInformationService;

    @RequestMapping(value = "/getUserInformationBySsoId")
    public UserInformation getUserInformationBySsoId(@RequestParam(value = "sso_id") int sso_id){
        UserInformation userInformation = null;
        logger.info("请求controller层，方法：getUserInformationBySsoIdn ,Param : sso_id - "+sso_id);
        USsoUserEdu uSsoUserEdu=userInformationService.getUSsoUserEduById(sso_id);
        if (uSsoUserEdu==null){
            return null;
        }

        //  edu_type TINYINT(4) NOT NULL COMMENT 'teacher或者student身份   0:老师   1：学生',
        if (uSsoUserEdu.getEduType()==0){
            UTeacher uTeacher=userInformationService.getUTeacherById(uSsoUserEdu.getEduId());
            userInformation=new UserInformation(uSsoUserEdu,uTeacher,null,null);
        }else if (uSsoUserEdu.getEduType()==1){
            UStudent uStudent=userInformationService.getUStudentById(uSsoUserEdu.getEduId());
            List<UFamilyRelation> uFamilyRelationList = userInformationService.getUFamilyRelationByStuId(uSsoUserEdu.getEduId());
            userInformation=new UserInformation(uSsoUserEdu,null,uStudent,uFamilyRelationList);
        }
        return userInformation;
    }


}
