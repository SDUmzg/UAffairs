package com.alearner.service.impl;


import com.alearner.modle.mysql.UNotify;
import com.alearner.modle.mysql.USubscription;
import com.alearner.service.UNotifyService;
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
 * @create: 2018-05-21 16:17
 **/
@Service
public class UNotifyServiceImpl implements UNotifyService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public long addUNotify(UNotify uNotify) {
        String url = "http://dynamic-datasources/u-notify/addUNotify";
        logger.info("请求连接 url ："+url);
        logger.info("名称 ："+ uNotify.getContent());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(uNotify,headers);
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, Long.class).getBody();
    }

    @Override
    public UNotify getUNotifyById(int id) {
        String url = "http://dynamic-datasources/u-notify/getUNotifyById?id="+id;
        logger.info("请求连接 id ："+id);
        return restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<UNotify>(){}).getBody();

    }

    @Override
    public List<UNotify> getUNotifyByCreateTime(String createTime) {
        String url = "http://dynamic-datasources/u-notify/getUNotifyByCreateTime?createTime="+createTime;
        logger.info("请求连接 id ："+createTime);
        return restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<UNotify>>(){}).getBody();

    }

    @Override
    public List<UNotify> getUNotifyBySubscription(USubscription uSubscription) {
        String url = "http://dynamic-datasources/u-notify/getUNotifyBySubscription";
        logger.info("请求连接 url ："+url);
        logger.info("名称 ："+ uSubscription.toString());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(uSubscription,headers);
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<List<UNotify>>(){}).getBody();
    }
}
