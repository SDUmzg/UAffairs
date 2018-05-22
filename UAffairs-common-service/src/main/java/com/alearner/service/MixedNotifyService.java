package com.alearner.service;

import com.alearner.modle.mysql.UNotify;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 19:46
 **/
public interface MixedNotifyService {
    UNotify getLastAnnounceTimeByUserId(int user_id);
}
