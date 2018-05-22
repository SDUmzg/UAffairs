package com.alearner.service;

import com.alearner.entity.mysql.UNotify;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-21 10:16
 **/
public interface UNotifyService {
    long addUNotify(UNotify uNotify);
    UNotify getUNotifyById(int id);
    List<UNotify> getUNotifyByCreateTime(String createTime);

}
