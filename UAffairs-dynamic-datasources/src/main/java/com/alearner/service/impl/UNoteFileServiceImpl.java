package com.alearner.service.impl;

import com.alearner.entity.mysql.UNoteFile;
import com.alearner.mapper.mysql.UNoteFileMapper;
import com.alearner.service.UNoteFileService;
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
public class UNoteFileServiceImpl implements UNoteFileService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UNoteFileMapper uNoteFileMapper;

    @Override
    public long addUNoteFile(UNoteFile uNoteFile) {
        logger.info("访问service层 ：UNoteFileService  方法 ：addUNoteFile  参数 ： " + uNoteFile.toString());
        return uNoteFileMapper.addUNoteFile(uNoteFile);
    }

    @Override
    public UNoteFile getUNoteFileById(int id) {
        logger.info("访问service层 ：UNoteFileService  方法 ：getUNoteFileById  参数 ： id " + id);
        return uNoteFileMapper.getUNoteFileById(id);
    }
}
