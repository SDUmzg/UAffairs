package com.alearner.service.impl;

import com.alearner.entity.mysql.UFamileRelation;
import com.alearner.service.UFamileRelationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 09:17
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UFamileRelationServiceImplTest {

    @Autowired
    private UFamileRelationService uFamileRelationService;

    @Test
    public void getUFamileRelationByStuId() {
        List<UFamileRelation> uFamileRelationList=uFamileRelationService.getUFamileRelationByStuId(1);
        for (UFamileRelation uFamileRelation:uFamileRelationList){
            System.err.println(uFamileRelation.getName());
        }
    }
}