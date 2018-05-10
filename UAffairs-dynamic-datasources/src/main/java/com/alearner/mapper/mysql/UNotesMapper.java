package com.alearner.mapper.mysql;

import com.alearner.entity.mysql.UNotes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-10 18:21
 **/
@Component
public interface UNotesMapper {
    long addUNotes(UNotes uNotes);
    UNotes getUNotesById(@Param("id")int id);
}
