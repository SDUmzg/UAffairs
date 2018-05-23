package com.alearner.controller;

import com.alearner.entity.mysql.USubscription;
import com.alearner.service.USubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 22:13
 **/
@RestController
@RequestMapping(value = "/u-subscription")
public class USubscriptionController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private USubscriptionService uSubscriptionService;

    @RequestMapping(value = "/addUSubscription",method = RequestMethod.POST)
    public long addUSubscription(@RequestBody USubscription uSubscription){
        logger.info("USubscriptionController,addUSubscription");
        return uSubscriptionService.addUSubscription(uSubscription);
    }

    @RequestMapping(value = "/getUSubscriptionByUserId",method = RequestMethod.GET)
    public List<USubscription> getUSubscriptionByUserId(@RequestParam("user") int user){
        logger.info("USubscriptionController,getUSubscriptionByUserId");
        return uSubscriptionService.getUSubscriptionByUserId(user);
    }


    @RequestMapping(value = "/disableUSubscription",method = RequestMethod.POST)
    public long disableUSubscription(@RequestBody USubscription uSubscription){
        logger.info("USubscriptionController,disableUSubscription");
        return uSubscriptionService.disableUSubscription(uSubscription);
    }
}
