package com.alearner.service.impl;

import com.alearner.modle.mysql.UFamilyRelation;
import com.alearner.modle.mysql.USsoUserEdu;
import com.alearner.modle.mysql.UStudent;
import com.alearner.modle.mysql.UTeacher;
import com.alearner.service.UserInformationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 11:44
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserInformationServiceImplTest {

    @Autowired
    private UserInformationService userInformationService;
    @Test
    public void getUSsoUserEduById() {
        USsoUserEdu uSsoUserEdu = userInformationService.getUSsoUserEduById(1);
        System.err.println(uSsoUserEdu.getEduId());
    }

    @Test
    public void getUStudentById() {
        UStudent uStudent=userInformationService.getUStudentById(1);
        System.err.println(uStudent.getName());
    }

    @Test
    public void getUTeacherById() {
        UTeacher uTeacher=userInformationService.getUTeacherById(1);
        System.err.println(uTeacher.getName());
    }

    @Test
    public void getUFamilyRelationByStuId() {
        List<UFamilyRelation> uFamilyRelationList=userInformationService.getUFamilyRelationByStuId(1);
        for (UFamilyRelation uFamilyRelation:uFamilyRelationList){
            System.err.println(uFamilyRelation.getName());
        }
    }

    @Test
    public void addUFamilyRelation(){
        long id = userInformationService.addUFamilyRelation("1","马舅舅","17865160000","majiujiu@163.com","舅舅");
        System.err.println(id);
    }

    @Test
    public void updateFamilyRelationList() {
        List<UFamilyRelation> uFamilyRelationList = new ArrayList<>();
        UFamilyRelation uFamilyRelation1 = new UFamilyRelation();
        uFamilyRelation1.setId(3);
        uFamilyRelation1.setStuId("1");
        uFamilyRelation1.setName("马狗子");
        uFamilyRelation1.setPhone("17865169000");
        uFamilyRelation1.setEmail("mydog1@163.com");
        uFamilyRelation1.setRelation("配偶");

        UFamilyRelation uFamilyRelation2 = new UFamilyRelation();
        uFamilyRelation2.setId(4);
        uFamilyRelation2.setStuId("1");
        uFamilyRelation2.setName("马舅舅");
        uFamilyRelation2.setPhone("17865169000");
        uFamilyRelation2.setEmail("majiujiu1@163.com");
        uFamilyRelation2.setRelation("舅舅");

        uFamilyRelationList.add(uFamilyRelation1);
        uFamilyRelationList.add(uFamilyRelation2);

        long row = userInformationService.updateFamilyRelationList(uFamilyRelationList);
        System.err.println(row);
    }
}