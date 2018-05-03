package com.alearner.service.impl;

import com.alearner.entity.mysql.USchool;
import com.alearner.mapper.mysql.USchoolMapper;
import com.alearner.service.USchoolService;
import com.alearner.util.DataSourceType;
import com.alearner.util.MyDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-03 16:07
 **/
@Service
public class USchoolServiceImpl implements USchoolService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private USchoolMapper uSchoolMapper;

    @Override
    @MyDataSource(DataSourceType.Master)
    public List<USchool> getUSchoolAll() {
        logger.info("访问表 ： u_school");
        return uSchoolMapper.getUSchoolAll();
    }
}
