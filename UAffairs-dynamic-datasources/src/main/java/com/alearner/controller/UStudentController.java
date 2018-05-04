package com.alearner.controller;

import com.alearner.entity.mysql.UStudent;
import com.alearner.service.UStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 09:55
 **/
@RestController
@RequestMapping(value = "/student")
public class UStudentController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UStudentService uStudentService;

    @RequestMapping(value = "/getUStudentById",method = RequestMethod.GET)
    public UStudent getUStudentById(@RequestParam(value = "id") int id){
        logger.info("访问controller层，方法：getUStudentById ，Param ： id - "+id);
        return uStudentService.getUStudentById(id);
    }
}
