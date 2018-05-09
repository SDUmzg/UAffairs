package com.alearner.service;

import com.alearner.modle.postgresql.UaffairsFiles;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-09 14:45
 **/
public interface UaffairsFilesService {
    long addUaffairsFilesMapper(UaffairsFiles uaffairsFiles);
    UaffairsFiles getUaffairsFilesById(int id);

}
