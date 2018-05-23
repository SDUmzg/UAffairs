package com.alearner.service.impl;

import com.alearner.entity.mysql.UUserNotify;
import com.alearner.mapper.mysql.UUserNotifyMapper;
import com.alearner.service.UUserNotifyService;
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
 * @create: 2018-05-22 08:24
 **/
@Service
public class UUserNotifyServiceImpl implements UUserNotifyService{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UUserNotifyMapper uUserNotifyMapper;

    @Override
    @MyDataSource(DataSourceType.Master)
    public long addUUserNotify(UUserNotify uUserNotify) {
        logger.info("UUserNotifyService , addUUserNotify ");
        uUserNotifyMapper.addUUserNotify(uUserNotify);
        return uUserNotify.getId();
    }

    @Override
    @MyDataSource(DataSourceType.Master)
    public UUserNotify getUUserNotifyById(int id) {
        logger.info("UUserNotifyService , getUUserNotifyById  , id -- "+id);
        return uUserNotifyMapper.getUUserNotifyById(id);
    }

    @Override
    @MyDataSource(DataSourceType.Master)
    public List<UUserNotify> getUUserNotifyByUserId(int user) {
        logger.info("UUserNotifyService , getUUserNotifyByUserId  , user -- " + user);
        return uUserNotifyMapper.getUUserNotifyByUserId(user);
    }

    @Override
    @MyDataSource(DataSourceType.Master)
    public long updateUserNotifyRead(int userId, int notifyId) {
        logger.info("UUserNotifyService , updateUserNotifyRead  , userId -- " + userId + "  notifyId -- "+notifyId);
        return uUserNotifyMapper.updateUserNotifyRead(userId,notifyId);
    }
}
