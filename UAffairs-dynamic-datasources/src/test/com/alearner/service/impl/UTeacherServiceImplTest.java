package com.alearner.service.impl;

import com.alearner.entity.mysql.UTeacher;
import com.alearner.service.UTeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 10:40
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UTeacherServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UTeacherService uTeacherService;
    @Test
    public void getUTeacherById() {
        UTeacher uTeacher = uTeacherService.getUTeacherById(1);
        System.err.println(uTeacher.getName());
    }
}