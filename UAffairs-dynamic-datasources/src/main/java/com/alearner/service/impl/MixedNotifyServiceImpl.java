package com.alearner.service.impl;

import com.alearner.entity.mysql.UNotify;
import com.alearner.entity.mysql.UserNotifyList;
import com.alearner.mapper.mysql.MixedNotifyMapper;
import com.alearner.service.MixedNotifyService;
import com.alearner.util.DataSourceType;
import com.alearner.util.MyDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 19:36
 **/
@Service
public class MixedNotifyServiceImpl implements MixedNotifyService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MixedNotifyMapper mixedNotifyMapper;
    @Override
    @MyDataSource(DataSourceType.Master)
    public UNotify getLastAnnounceTimeByUserId(int user_id) {
        logger.info("MixedNotifyService,getLastAnnounceTimeByUserId");
        return mixedNotifyMapper.getLastAnnounceTimeByUserId(user_id);
    }

    @Override
    @MyDataSource(DataSourceType.Master)
    public List<UserNotifyList> getUserNotifyListByUserId(int userId) {
        logger.info("MixedNotifyService,getUserNotifyListByUserId");
        return mixedNotifyMapper.getUserNotifyListByUserId(userId);
    }
}
