package com.alearner;

import com.alearner.job.domain.Job;
import com.alearner.job.service.JobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


/**
 * @description:
 * @author: MZG
 * @create: 2018-04-23 20:42
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FebsClientApplication.class)
public class FebsClientApplicationTest {


    @Autowired
    private JobService jobService;

    @Test
    public void test() throws Exception {
        Job job = new Job();
        job.setBeanName("testTask");
        job.setMethodName("test2");
        job.setCronExpression("0/3 * * * * ?");
        job.setStatus("1");
        job.setRemark("异常测试");
        job.setCreateTime(new Date());
        this.jobService.addJob(job);
        System.out.println(job.getJobId());
    }
}