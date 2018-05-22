package com.alearner.service.impl;

import com.alearner.entity.mysql.UNotify;
import com.alearner.service.UNotifyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 00:08
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UNotifyServiceImplTest {


    @Autowired
    private UNotifyService uNotifyService;
    @Test
    public void addUNotify() {
        UNotify uNotify=new UNotify();
        uNotify.setContent("test");
        uNotify.setType(1);
        uNotify.setTarget(1);
        uNotify.setTargetType("word");
        uNotify.setAction("上传");
        uNotify.setSender(1);
        long row = uNotifyService.addUNotify(uNotify);
        System.err.println(row);



    }
    @Test
    public void getUNotifyById() {
    }
}