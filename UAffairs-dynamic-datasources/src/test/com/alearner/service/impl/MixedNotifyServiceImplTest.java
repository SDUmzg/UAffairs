package com.alearner.service.impl;

import com.alearner.entity.mysql.UserNotifyList;
import com.alearner.service.MixedNotifyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-23 13:48
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MixedNotifyServiceImplTest {

    @Autowired
    private MixedNotifyService mixedNotifyService;

    @Test
    public void getUserNotifyListByUserId() {
        List<UserNotifyList> userNotifyListList = mixedNotifyService.getUserNotifyListByUserId(1);
        for (UserNotifyList userNotifyList:userNotifyListList){
            System.err.println(userNotifyList.toString());
        }
    }
}