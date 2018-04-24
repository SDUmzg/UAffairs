package com.xxl.sso.server;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: MZG
 * @create: 2018-04-24 16:32
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class XxlSsoServerApplicationTest {

    @Autowired
    ApplicationContext ctx;

    @Test
    public void testContextLoads() throws Exception {
        Assert.assertNotNull(this.ctx);
//        Assert.assertTrue(this.ctx.containsBean("application"));
    }

}