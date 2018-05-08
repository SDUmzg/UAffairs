package com.alearner.mapper.postgresql;

import com.alearner.entity.postgresql.UaffairsFiles;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-08 17:28
 **/
@Component
public interface UaffairsFilesMapper {
    long addUaffairsFilesMapper(UaffairsFiles uaffairsFiles);
    UaffairsFiles getUaffairsFilesById(@Param("id")int id);
}
