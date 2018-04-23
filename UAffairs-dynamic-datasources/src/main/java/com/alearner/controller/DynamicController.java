package com.alearner.controller;

import com.alearner.entity.mysql.Student;
import com.alearner.entity.postgresql.Users;
import com.alearner.service.DynamicService;
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


    @RequestMapping(value = "/getAllStudent")
    public List<Student>  getAllStudent(){
        return dynamicService.findAllStudent();
    }

    @RequestMapping(value = "/getAllUsers")
    public List<Users> getAllUsers(){
        return dynamicService.findAllUsers();
    }
}
