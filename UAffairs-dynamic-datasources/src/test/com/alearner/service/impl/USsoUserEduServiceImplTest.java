package com.alearner.service.impl;

import com.alearner.entity.mysql.USsoUserEdu;
import com.alearner.service.USsoUserEduService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-03 19:45
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class USsoUserEduServiceImplTest {

    @Autowired
    private USsoUserEduService uSsoUserEduService;
    @Test
    public void getUSsoUserEduById() {
        USsoUserEdu uSsoUserEdu=uSsoUserEduService.getUSsoUserEduById(1);
        System.err.println("学生的身份id为 ："+uSsoUserEdu.getEduId());
    }
}