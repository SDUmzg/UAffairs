package com.alearner.service.impl;

import com.alearner.modle.common.UserInformation;
import com.alearner.service.UserInformationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 14:40
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserInformationServiceImplTest {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInformationService userInformationService;
    @Test
    public void getUserInformationBySsoId() {
        UserInformation userInformation = userInformationService.getUserInformationBySsoId(1);
        System.err.println(userInformation.toString());
    }
}