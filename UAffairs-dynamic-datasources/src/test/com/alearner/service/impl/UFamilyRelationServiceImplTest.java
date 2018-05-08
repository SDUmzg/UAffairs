package com.alearner.service.impl;

import com.alearner.entity.mysql.UFamilyRelation;
import com.alearner.service.UFamilyRelationService;
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
 * @create: 2018-05-04 09:17
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UFamilyRelationServiceImplTest {

    @Autowired
    private UFamilyRelationService uFamilyRelationService;

    @Test
    public void getUFamilyRelationByStuId() {
        List<UFamilyRelation> uFamilyRelationList = uFamilyRelationService.getUFamilyRelationByStuId(1);
        for (UFamilyRelation uFamilyRelation : uFamilyRelationList){
            System.err.println(uFamilyRelation.getName());
        }
    }

    @Test
    public void addUFamilyRelation(){
        UFamilyRelation uFamilyRelation = new UFamilyRelation();
        uFamilyRelation.setStuId("1");
        uFamilyRelation.setName("狗子");
        uFamilyRelation.setPhone("17865169000");
        uFamilyRelation.setEmail("dog@163.com");
        uFamilyRelation.setRelation("配偶");
        long id = uFamilyRelationService.addUFamilyRelation(uFamilyRelation);
        System.err.println("id="+id);
        System.err.println(uFamilyRelation.getId());
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

        long matchedRow = uFamilyRelationService.updateFamilyRelationList(uFamilyRelationList);
        System.err.println(matchedRow);
    }
}