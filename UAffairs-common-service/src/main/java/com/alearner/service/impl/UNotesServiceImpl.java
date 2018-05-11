package com.alearner.service.impl;

import com.alearner.modle.mysql.UNoteFile;
import com.alearner.modle.mysql.UNotes;
import com.alearner.service.UNotesService;
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

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-11 10:19
 **/
@Service
public class UNotesServiceImpl implements UNotesService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public long addUNotes(UNotes uNotes) {
        String url = "http://dynamic-datasources/u-notes/addUNotes";
        logger.info("请求连接 url ："+url);
        logger.info("名称 ："+ uNotes.getSubject());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(uNotes,headers);
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, Long.class).getBody();
    }

    @Override
    public UNotes getUNotesById(int id) {
        String url = "http://dynamic-datasources/u-notes/getUNotesById?id="+id;
        logger.info("请求连接 id ："+id);
        return restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<UNotes>(){}).getBody();

    }
}
