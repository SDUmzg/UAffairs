package com.alearner.service;

import com.alearner.entity.mysql.UNotify;
import com.alearner.entity.mysql.UserNotifyList;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 19:35
 **/
public interface MixedNotifyService {
    UNotify getLastAnnounceTimeByUserId(int user_id);
    List<UserNotifyList> getUserNotifyListByUserId(int userId);
}
