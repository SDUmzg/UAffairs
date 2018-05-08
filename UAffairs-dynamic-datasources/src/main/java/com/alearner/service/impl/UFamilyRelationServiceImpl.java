package com.alearner.service.impl;

import com.alearner.entity.mysql.UFamilyRelation;
import com.alearner.mapper.mysql.UFamilyRelationMapper;
import com.alearner.service.UFamilyRelationService;
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
public class UFamilyRelationServiceImpl implements UFamilyRelationService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UFamilyRelationMapper uFamilyRelationMapper;

    @Override
    @MyDataSource(DataSourceType.Master)
    public List<UFamilyRelation> getUFamilyRelationByStuId(int stu_id) {
        logger.info("访问表 ：u_family_relation ");
        logger.info("请求 server 层 ：getUFamileRelationByStuId() Param : stu_id - "+stu_id);
        return uFamilyRelationMapper.getUFamilyRelationByStuId(stu_id);
    }

    @Override
    @MyDataSource(DataSourceType.Master)
    public long addUFamilyRelation(UFamilyRelation uFamilyRelation) {
        logger.info("访问表 ：u_family_relation ");
        logger.info("请求 server 层 ：addUFamilyRelation() Param : uFamilyRelation - "+uFamilyRelation.toString());
        return uFamilyRelationMapper.addUFamilyRelation(uFamilyRelation);
    }

    @Override
    @MyDataSource(DataSourceType.Master)
    public long updateFamilyRelationList(List<UFamilyRelation> uFamilyRelationList) {
        logger.info("访问表 ：u_family_relation ");
        logger.info("请求 server 层 ：updateFamilyRelationList() Param : uFamilyRelationList.size - "+uFamilyRelationList.size());
        return uFamilyRelationMapper.updateFamilyRelationList(uFamilyRelationList);
    }
}
