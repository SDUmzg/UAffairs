package com.alearner.service;

import com.alearner.entity.mysql.UFamileRelation;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 09:12
 **/
public interface UFamileRelationService {
    List<UFamileRelation> getUFamileRelationByStuId(int stu_id);
}
