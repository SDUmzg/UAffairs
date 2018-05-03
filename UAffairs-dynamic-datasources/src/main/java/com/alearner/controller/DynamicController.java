package com.alearner.controller;

import com.alearner.entity.mysql.Student;
import com.alearner.entity.mysql.USchool;
import com.alearner.entity.postgresql.Users;
import com.alearner.service.DynamicService;
import com.alearner.service.USchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-04-04 19:35
 **/

@RestController
public class DynamicController {

    @Autowired
    private DynamicService dynamicService;
    @Autowired
    private USchoolService uSchoolService;


    @RequestMapping(value = "/getAllStudent")
    public List<Student>  getAllStudent(){
        return dynamicService.findAllStudent();
    }

    @RequestMapping(value = "/getAllUsers")
    public List<Users> getAllUsers(){
        return dynamicService.findAllUsers();
    }

    @RequestMapping(value = "/getUSchoolAll")
    public List<USchool> getUSchoolAll(){
        return uSchoolService.getUSchoolAll();

    }}
