package com.alearner.service;

import com.alearner.entity.mysql.UFamilyRelation;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 09:12
 **/
public interface UFamilyRelationService {
    List<UFamilyRelation> getUFamilyRelationByStuId(int stu_id);
    long addUFamilyRelation(UFamilyRelation uFamilyRelation);
    long updateFamilyRelationList(List<UFamilyRelation> uFamilyRelationList);

}
