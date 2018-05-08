package com.alearner.mapper.mysql;

import com.alearner.entity.mysql.UFamilyRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 09:09
 **/
@Component
public interface UFamilyRelationMapper {
    List<UFamilyRelation> getUFamilyRelationByStuId(@Param("stu_id")int stu_id);
    long addUFamilyRelation(UFamilyRelation uFamilyRelation);
}
