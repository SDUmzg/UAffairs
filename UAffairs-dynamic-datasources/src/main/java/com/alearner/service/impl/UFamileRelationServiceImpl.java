package com.alearner.service.impl;

import com.alearner.entity.mysql.UFamileRelation;
import com.alearner.mapper.mysql.UFamileRelationMapper;
import com.alearner.service.UFamileRelationService;
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
 * @create: 2018-05-04 09:14
 **/
@Service
public class UFamileRelationServiceImpl implements UFamileRelationService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UFamileRelationMapper uFamileRelationMapper;

    @Override
    @MyDataSource(DataSourceType.Master)
    public List<UFamileRelation> getUFamileRelationByStuId(int stu_id) {
        logger.info("访问表 ：u_famile_relation ");
        logger.info("请求 server 层 ：getUFamileRelationByStuId() Param : stu_id - "+stu_id);
        return uFamileRelationMapper.getUFamileRelationByStuId(stu_id);
    }
}
