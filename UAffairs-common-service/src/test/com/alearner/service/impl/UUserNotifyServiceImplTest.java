package com.alearner.service.impl;

import com.alearner.modle.mysql.UUserNotify;
import com.alearner.service.UUserNotifyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 09:07
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UUserNotifyServiceImplTest {

    @Autowired
    private UUserNotifyService uUserNotifyService;

    @Test
    public void addUUserNotify() {
        UUserNotify uUserNotify = new UUserNotify();
        uUserNotify.setReadStatus(true);
        uUserNotify.setUserId(1);
        uUserNotify.setNotifyId(1);
        long row = uUserNotifyService.addUUserNotify(uUserNotify);
        System.err.println("row : "+row);
        System.err.println("id : "+uUserNotify.getId());
    }

    @Test
    public void getUUserNotifyById() {
    }
}