package com.alearner.service.impl;

import com.alearner.modle.mysql.UNotify;
import com.alearner.modle.mysql.USubscription;
import com.alearner.service.USubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 22:22
 **/
@Service
public class USubscriptionServiceImpl implements USubscriptionService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public long addUSubscription(USubscription uSubscription) {
        String url = "http://dynamic-datasources/u-subscription/addUSubscription";
        logger.info("请求连接 url ："+url);
        logger.info("user id ："+ uSubscription.getUser());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(uSubscription,headers);
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, Long.class).getBody();
    }

    @Override
    public List<USubscription> getUSubscriptionByUserId(int user) {
        String url = "http://dynamic-datasources/u-subscription/getUSubscriptionByUserId?user="+user;
        logger.info("请求连接 id ："+user);
        return restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<USubscription>>(){}).getBody();

    }

    @Override
    public long disableUSubscription(USubscription uSubscription) {
        String url = "http://dynamic-datasources/u-subscription/disableUSubscription";
        logger.info("请求连接 url ："+url);
        logger.info("user id ："+ uSubscription.getUser());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(uSubscription,headers);
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, Long.class).getBody();
    }
}
