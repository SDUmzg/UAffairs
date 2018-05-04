package com.alearner.mapper.mysql;

import com.alearner.entity.mysql.UTeacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 10:20
 **/
@Component
public interface UTeacherMapper {
    UTeacher getUTeacherById(@Param(value = "id")int id);
}
