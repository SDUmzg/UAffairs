package com.alearner.service.impl;

import com.alearner.modle.mysql.UFamilyRelation;
import com.alearner.modle.mysql.USsoUserEdu;
import com.alearner.modle.mysql.UStudent;
import com.alearner.modle.mysql.UTeacher;
import com.alearner.service.UserInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 11:27
 **/
@Service
public class UserInformationServiceImpl implements UserInformationService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public USsoUserEdu getUSsoUserEduById(int sso_id) {
        String url = "http://dynamic-datasources/sso-user-edu/getUSsoUserEduById?sso_id="+sso_id;
        logger.info("请求连接 url ："+url);
        return restTemplate.getForObject(url,USsoUserEdu.class);
    }

    @Override
    public UStudent getUStudentById(int id) {
        String url = "http://dynamic-datasources/student/getUStudentById?id="+id;
        logger.info("请求连接 url ："+url);
        return restTemplate.getForObject(url,UStudent.class);
    }

    @Override
    public UTeacher getUTeacherById(int id) {
        String url = "http://dynamic-datasources/teacher/getUTeacherById?id="+id;
        logger.info("请求连接 url ："+url);
        return restTemplate.getForObject(url,UTeacher.class);
    }

    @Override
    public List<UFamilyRelation> getUFamilyRelationByStuId(int stu_id) {
        String url = "http://dynamic-datasources/family-relation/getUFamilyRelationByStuId?stu_id="+stu_id;
        logger.info("请求连接 url ："+url);
        return restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<UFamilyRelation>>(){}).getBody();
    }

    @Override
    public long addUFamilyRelation(String stuId, String name, String phone, String email, String relation) {
        String url = "http://dynamic-datasources/family-relation/addUFamilyRelation?stuId="+stuId+"&name="+name+"&phone="+phone+"&email="+email+"&relation="+relation;
        logger.info("请求连接 url ："+url);
        return  restTemplate.getForObject(url,Long.class);
    }
}
