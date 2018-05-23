package com.alearner.service.impl;

import com.alearner.modle.mysql.UNotify;
import com.alearner.modle.mysql.UUserNotify;
import com.alearner.service.UUserNotifyService;
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
 * @create: 2018-05-22 09:04
 **/
@Service
public class UUserNotifyServiceImpl implements UUserNotifyService{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public long addUUserNotify(UUserNotify uUserNotify) {
        String url = "http://dynamic-datasources/u-user-notify/addUUserNotify";
        logger.info("请求连接 url ："+url);
        logger.info("名称 ："+ uUserNotify.toString());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(uUserNotify,headers);
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, Long.class).getBody();
    }

    @Override
    public UUserNotify getUUserNotifyById(int id) {
        String url = "http://dynamic-datasources/u-user-notify/getUUserNotifyById?id="+id;
        logger.info("请求连接 id ："+id);
        return restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<UUserNotify>(){}).getBody();
    }

    @Override
    public List<UUserNotify> getUUserNotifyByUserId(int user) {
        String url = "http://dynamic-datasources/u-user-notify/getUUserNotifyById?user="+user;
        logger.info("请求连接 user ："+user);
        return restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<UUserNotify>>(){}).getBody();
    }
}
