package com.alearner.service;


import com.alearner.modle.mysql.UNotify;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-21 10:16
 **/
public interface UNotifyService {
    long addUNotify(UNotify uNotify);
    UNotify getUNotifyById(int id);
}
