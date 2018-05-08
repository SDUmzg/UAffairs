package com.alearner.service.impl;

import com.alearner.entity.mysql.UFamilyRelation;
import com.alearner.service.UFamilyRelationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}