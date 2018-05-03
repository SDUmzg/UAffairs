package com.alearner.service.impl;

import com.alearner.entity.mysql.UStudent;
import com.alearner.service.UStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-03 20:01
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UStudentServiceImplTest {

    @Autowired
    private UStudentService uStudentService;
    @Test
    public void getUStudentById() {
        UStudent uStudent = uStudentService.getUStudentById(1);
        System.err.println(uStudent.getName());
    }
}