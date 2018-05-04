package com.alearner.service.impl;

import com.alearner.entity.mysql.UTeacher;
import com.alearner.mapper.mysql.UTeacherMapper;
import com.alearner.service.UTeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 10:28
 **/
@Service
public class UTeacherServiceImpl implements UTeacherService {

    private Logger logger =LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UTeacherMapper uTeacherMapper;
    @Override
    public UTeacher getUTeacherById(int id) {
        logger.info("访问 server层，方法 ：getUTeacherById，Param : id - "+id);
        return uTeacherMapper.getUTeacherById(id);
    }
}
