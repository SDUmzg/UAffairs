package com.alearner.service.impl;

import com.alearner.modle.mysql.UFamilyRelation;
import com.alearner.modle.postgresql.UaffairsFiles;
import com.alearner.service.UaffairsFilesService;
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
 * @create: 2018-05-09 14:48
 **/
@Service
public class UaffairsFilesServiceImpl implements UaffairsFilesService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public long addUaffairsFiles(UaffairsFiles uaffairsFiles) {
        String url = "http://dynamic-datasources/fileUpload/addUaffairsFiles";
        logger.info("请求连接 url ："+url);
        logger.info("文件名称 ："+ uaffairsFiles.getFileName());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(uaffairsFiles,headers);
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, Long.class).getBody();
    }

    @Override
    public UaffairsFiles getUaffairsFilesById(int id) {
        String url = "http://dynamic-datasources/fileUpload/getUaffairsFilesById?id="+id;
        logger.info("请求连接 id ："+id);
        return restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<UaffairsFiles>(){}).getBody();

    }

}
