package com.alearner.mapper.mysql;

import com.alearner.entity.mysql.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-04-04 18:42
 **/

@Component
public interface StudentMapper {
    List<Student> findAll();
    Student findOne(@Param(value = "id")int id);
}
