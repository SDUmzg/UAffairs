package com.alearner.service.impl;

import com.alearner.entity.mysql.UNotify;
import com.alearner.mapper.mysql.UNotifyMapper;
import com.alearner.service.UNotifyService;
import com.alearner.util.DataSourceType;
import com.alearner.util.MyDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-21 10:17
 **/
@Service
public class UNotifyServiceImpl implements UNotifyService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UNotifyMapper uNotifyMapper;

    @Override
    @MyDataSource(DataSourceType.Master)
    public long addUNotify(UNotify uNotify) {
        logger.info("get access   u_notify method: addUNotify");
        uNotifyMapper.addUNotify(uNotify);
        return uNotify.getId();
    }

    @Override
    @MyDataSource(DataSourceType.Master)
    public UNotify getUNotifyById(int id) {
        return uNotifyMapper.getUNotifyById(id);
    }
}
