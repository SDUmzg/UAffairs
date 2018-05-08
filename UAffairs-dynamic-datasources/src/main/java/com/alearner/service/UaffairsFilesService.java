package com.alearner.service;

import com.alearner.entity.postgresql.UaffairsFiles;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-08 18:05
 **/
public interface UaffairsFilesService {
    long addUaffairsFilesMapper(UaffairsFiles uaffairsFiles);
    UaffairsFiles getUaffairsFilesById(@Param("id")int id);
}
