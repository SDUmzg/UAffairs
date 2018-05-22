package com.alearner.service.impl;


import com.alearner.modle.mysql.UNotify;
import com.alearner.service.MixedNotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 19:47
 **/
@Service
public class MixedNotifyServiceImpl implements MixedNotifyService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public UNotify getLastAnnounceTimeByUserId(int user_id) {
        logger.info("MixedNotifyService,getLastAnnounceTimeByUserId,user_id -- "+ user_id);
        String url = "http://dynamic-datasources/mixed-notify/getLastAnnounceTimeByUserId?user_id="+user_id;
        logger.info("请求连接 id ："+user_id);
        return restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<UNotify>(){}).getBody();
    }
}
