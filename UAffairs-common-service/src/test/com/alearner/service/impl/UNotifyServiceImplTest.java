package com.alearner.service.impl;

import com.alearner.modle.common.SqlType;
import com.alearner.modle.mysql.UNotify;
import com.alearner.modle.mysql.USubscription;
import com.alearner.service.UNotifyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-21 21:42
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UNotifyServiceImplTest {


    @Autowired
    private UNotifyService uNotifyService;

//    content varchar(100) NOT NULL COMMENT '消息的内容',
//    type  tinyint(4) NOT NULL COMMENT '消息的类型，1: 公告 Announce，2: 提醒 Remind，3：信息 Message',
//    target int(11) NOT NULL COMMENT '目标的ID',
//    target_type varchar(20) NOT NULL COMMENT '目标的类型',
//    action  varchar(20) NOT NULL COMMENT '提醒信息的动作类型',
//    sender int(11) NOT NULL COMMENT '发送者的ID',
    @Test
    public void addUNotify() {
        UNotify uNotify=new UNotify();
        uNotify.setContent("test");
        uNotify.setType(SqlType.NOTIFY.ANNOUNCE);
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

    @Test
    public void getUNotifyBySubscription(){
        USubscription uSubscription = new USubscription();
        uSubscription.setTarget(1);
        uSubscription.setTargetType("word");
        uSubscription.setAction("上传");
        uSubscription.setCreateTime("2018-05-21 23:55:06");
        List<UNotify> uNotifyList = uNotifyService.getUNotifyBySubscription(uSubscription);
        for (UNotify uNotify:uNotifyList){
            System.err.println(uNotify.toString());
        }
    }
}