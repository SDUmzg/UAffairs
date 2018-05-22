package com.alearner.service.impl;

import com.alearner.modle.mysql.UNotify;
import com.alearner.service.MixedNotifyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 19:54
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MixedNotifyServiceImplTest {
    @Autowired
    private MixedNotifyService mixedNotifyService;
    @Test
    public void getLastAnnounceTimeByUserId() {
        UNotify uNotify = mixedNotifyService.getLastAnnounceTimeByUserId(1);
        System.err.println(uNotify.toString());
        System.err.println(uNotify.getCreateTime());
    }
}