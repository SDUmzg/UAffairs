package com.alearner.service;

import com.alearner.modle.mysql.USubscription;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 22:21
 **/
public interface USubscriptionService {
    long addUSubscription(USubscription uSubscription);
    List<USubscription> getUSubscriptionByUserId(int user);
    long disableUSubscription(USubscription uSubscription);
}