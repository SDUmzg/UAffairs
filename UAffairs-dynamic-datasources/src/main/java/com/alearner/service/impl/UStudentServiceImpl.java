package com.alearner.service.impl;

import com.alearner.entity.mysql.UStudent;
import com.alearner.mapper.mysql.UStudentMapper;
import com.alearner.service.UStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @description:
 * @author: MZG
 * @create: 2018-05-03 19:58
 **/
@Service
public class UStudentServiceImpl implements UStudentService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UStudentMapper uStudentMapper;

    @Override
    public UStudent getUStudentById(int id) {
        logger.info("请求接口 ： uStudentMapper.getUStudentById(id)");
        return uStudentMapper.getUStudentById(id);
    }
}
