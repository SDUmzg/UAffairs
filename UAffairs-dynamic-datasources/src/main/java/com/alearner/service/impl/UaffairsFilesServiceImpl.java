package com.alearner.service.impl;

import com.alearner.entity.postgresql.UaffairsFiles;
import com.alearner.mapper.postgresql.UaffairsFilesMapper;
import com.alearner.service.UaffairsFilesService;
import com.alearner.util.DataSourceType;
import com.alearner.util.MyDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-08 18:06
 **/
@Service
public class UaffairsFilesServiceImpl implements UaffairsFilesService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UaffairsFilesMapper uaffairsFilesMapper;

    @Override
    @MyDataSource(DataSourceType.Slave)
    public long addUaffairsFiles(UaffairsFiles uaffairsFiles) {
        logger.info("访问postgresql库");
        logger.info("访问表 uaffairs_files");
        logger.info("访问 server层 ， 方法 ： addUaffairsFilesMapper(UaffairsFiles uaffairsFiles)");
        return uaffairsFilesMapper.addUaffairsFilesMapper(uaffairsFiles);
    }

    @Override
    @MyDataSource(DataSourceType.Slave)
    public UaffairsFiles getUaffairsFilesById(int id) {
        logger.info("访问postgresql库");
        logger.info("访问表 uaffairs_files");
        logger.info("访问 server层 ， 方法 ： getUaffairsFilesById(int id)");
        return uaffairsFilesMapper.getUaffairsFilesById(id);
    }
}
