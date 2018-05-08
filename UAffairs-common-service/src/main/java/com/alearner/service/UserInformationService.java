package com.alearner.service;

import com.alearner.modle.mysql.UFamilyRelation;
import com.alearner.modle.mysql.USsoUserEdu;
import com.alearner.modle.mysql.UStudent;
import com.alearner.modle.mysql.UTeacher;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 11:21
 **/
public interface UserInformationService {

    /*USsoUserEduController in dynamic-datasources*/
    USsoUserEdu getUSsoUserEduById(int sso_id);


    /*UStudentController in dynamic-datasources*/
    UStudent getUStudentById(int id);


    /*UTeacherController in dynamic-datasources*/
    UTeacher getUTeacherById(int id);


    /*UFamilyRelationController in dynamic-datasources*/
    List<UFamilyRelation> getUFamilyRelationByStuId(int stu_id);

    long addUFamilyRelation(String stuId, String name, String phone, String email, String relation);

    long updateFamilyRelationList(List<UFamilyRelation> uFamilyRelationList);


    }
