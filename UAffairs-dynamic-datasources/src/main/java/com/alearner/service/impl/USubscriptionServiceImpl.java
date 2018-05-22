package com.alearner.service.impl;

import com.alearner.entity.mysql.USubscription;
import com.alearner.mapper.mysql.USubscriptionMapper;
import com.alearner.service.USubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 22:02
 **/
@Service
public class USubscriptionServiceImpl implements USubscriptionService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private USubscriptionMapper uSubscriptionMapper;


    @Override
    public long addUSubscription(USubscription uSubscription) {
        logger.info("USubscriptionService, addUSubscription ");
        uSubscriptionMapper.addUSubscription(uSubscription);
        return uSubscription.getId();
    }

    @Override
    public List<USubscription> getUSubscriptionByUserId(int user) {
        return null;
    }
}
