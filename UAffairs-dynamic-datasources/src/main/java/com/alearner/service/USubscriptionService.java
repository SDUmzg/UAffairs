package com.alearner.service;

import com.alearner.entity.mysql.USubscription;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 22:01
 **/
public interface USubscriptionService {
    long addUSubscription(USubscription uSubscription);
    List<USubscription> getUSubscriptionByUserId(int user);
}
