package com.alearner.service.impl;

import com.alearner.modle.mysql.USubscription;
import com.alearner.service.USubscriptionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 22:53
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class USubscriptionServiceImplTest {
    @Autowired
    private USubscriptionService uSubscriptionService;

    @Test
    public void addUSubscription() {
        USubscription uSubscription = new USubscription();
        uSubscription.setTarget(1);
        uSubscription.setTargetType("note");
        uSubscription.setAction("like");
        uSubscription.setUser(1);
        long row  = uSubscriptionService.addUSubscription(uSubscription);
        System.err.println(row);
        System.err.println(uSubscription.getId());
    }

    @Test
    public void getUSubscriptionByUserId() {
    }

    @Test
    public void disableUSubscription(){
        USubscription uSubscription = new USubscription();
        uSubscription.setUser(1);
        uSubscription.setTarget(1);
        uSubscription.setTargetType("note");
        long  affect_row = uSubscriptionService.disableUSubscription(uSubscription);
        System.err.println(affect_row);
    }
}