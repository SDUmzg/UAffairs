package com.alearner.service.impl;

import com.alearner.entity.mysql.UNotify;
import com.alearner.mapper.mysql.MixedNotifyMapper;
import com.alearner.service.MixedNotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public UNotify getLastAnnounceTimeByUserId(int user_id) {
        logger.info("MixedNotifyService,getLastAnnounceTimeByUserId");
        return mixedNotifyMapper.getLastAnnounceTimeByUserId(user_id);
    }
}
