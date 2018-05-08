package com.alearner.mapper.mysql;

import com.alearner.entity.mysql.Student;
import com.alearner.entity.mysql.UStudent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-03 19:54
 **/
@Component
public interface UStudentMapper {
    UStudent getUStudentById(@Param("id")int id);
    long updateStudentbyId(Student student);
}
