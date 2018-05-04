package com.alearner.mapper.mysql;

import com.alearner.entity.mysql.UFamileRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 09:09
 **/
@Component
public interface UFamileRelationMapper {
    List<UFamileRelation> getUFamileRelationByStuId(@Param("stu_id")int stu_id);
}
