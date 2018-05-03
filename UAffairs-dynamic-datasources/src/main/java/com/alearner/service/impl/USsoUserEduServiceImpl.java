package com.alearner.service.impl;

import com.alearner.entity.mysql.USsoUserEdu;
import com.alearner.mapper.mysql.USsoUserEduMapper;
import com.alearner.service.USsoUserEduService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-03 19:43
 **/
@Service
public class USsoUserEduServiceImpl implements USsoUserEduService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private USsoUserEduMapper uSsoUserEduMapper;

    @Override
    public USsoUserEdu getUSsoUserEduById(int sso_id) {
        logger.info("请求接口 ： uSsoUserEduMapper.getUSsoUserEduById(sso_id)");
        return uSsoUserEduMapper.getUSsoUserEduById(sso_id);
    }
}
