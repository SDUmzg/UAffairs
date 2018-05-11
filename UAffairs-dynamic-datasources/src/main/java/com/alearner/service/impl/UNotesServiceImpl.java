package com.alearner.service.impl;

import com.alearner.entity.mysql.UNotes;
import com.alearner.mapper.mysql.UNotesMapper;
import com.alearner.service.UNotesService;
import com.alearner.util.DataSourceType;
import com.alearner.util.MyDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-10 18:58
 **/
@Service
public class UNotesServiceImpl  implements UNotesService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UNotesMapper uNotesMapper;

    @Override
    @MyDataSource(DataSourceType.Master)
    public long addUNotes(UNotes uNotes) {
        logger.info("访问service层 ：UNotesService  方法 ：addUNotes  参数 ： " + uNotes.toString());
        uNotesMapper.addUNotes(uNotes);
        logger.info("插入完成 ，返回 id ："+uNotes.getId());
        return uNotes.getId();
    }

    @Override
    @MyDataSource(DataSourceType.Master)
    public UNotes getUNotesById(int id) {
        logger.info("访问service层 ：UNotesService  方法 ：getUNotesById  参数 ：id " + id);
        return uNotesMapper.getUNotesById(id);
    }
}
