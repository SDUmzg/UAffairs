package com.alearner.controller;

import com.alearner.entity.mysql.UTeacher;
import com.alearner.service.UTeacherService;
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
 * @create: 2018-05-04 10:45
 **/
@RestController
@RequestMapping(value = "/teacher")
public class UTeacherController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UTeacherService uTeacherService;

    @RequestMapping(value = "/getUTeacherById",method = RequestMethod.GET)
    private UTeacher getUTeacherById(@RequestParam(value = "id") int id){
        logger.info("请求controller层，方法 ：getUTeacherById ，Param : id - "+id);
        return uTeacherService.getUTeacherById(id);
    }
}
