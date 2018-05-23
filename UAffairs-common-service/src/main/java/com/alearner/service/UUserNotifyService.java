package com.alearner.service;

import com.alearner.modle.mysql.UUserNotify;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 08:24
 **/
public interface UUserNotifyService {
    long addUUserNotify(UUserNotify uUserNotify);
    UUserNotify getUUserNotifyById(int id);
    List<UUserNotify> getUUserNotifyByUserId(int user);
}
