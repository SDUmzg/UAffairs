package com.alearner.mapper.mysql;

import com.alearner.entity.mysql.UNoteFile;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-10 18:13
 **/
@Component
public interface UNoteFileMapper {
    long addUNoteFile(UNoteFile uNoteFile);
    UNoteFile getUNoteFileById(@Param("id")int id);
}
