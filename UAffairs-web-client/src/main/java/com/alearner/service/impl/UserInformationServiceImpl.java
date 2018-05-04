package com.alearner.service.impl;

import com.alearner.modle.common.UserInformation;
import com.alearner.service.UserInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 14:36
 **/
@Service
public class UserInformationServiceImpl implements UserInformationService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserInformation getUserInformationBySsoId(int sso_id) {
        logger.info("请求service层，方法：getUserInformationBySsoId， Param : sso_id - "+sso_id);
        String url = "http://common-service/user-info/getUserInformationBySsoId?sso_id="+sso_id;
        logger.info("请求 url ： "+url);
        return restTemplate.getForObject(url,UserInformation.class);
    }
}
