package com.alearner.service.impl;

import com.alearner.modle.mysql.UNoteFile;
import com.alearner.modle.postgresql.UaffairsFiles;
import com.alearner.service.UNoteFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-11 10:18
 **/
public class UNoteFileServiceImpl implements UNoteFileService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public long addUNoteFile(UNoteFile uNoteFile) {
        String url = "http://dynamic-datasources/u-note-file/addUNoteFile";
        logger.info("请求连接 url ："+url);
        logger.info("名称 ："+ uNoteFile.getName());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(uNoteFile,headers);
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, Long.class).getBody();
    }

    @Override
    public UNoteFile getUNoteFileById(int id) {
        String url = "http://dynamic-datasources/u-note-file/getUNoteFileById?id="+id;
        logger.info("请求连接 id ："+id);
        return restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<UNoteFile>(){}).getBody();

    }
}
