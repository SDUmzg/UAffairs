package com.alearner.controller;

import com.alearner.entity.mysql.UNotify;
import com.alearner.entity.mysql.USubscription;
import com.alearner.mapper.mysql.UNotifyMapper;
import com.alearner.service.UNotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @description:
 * @author: MZG
 * @create: 2018-05-21 10:23
 **/
@RestController
@RequestMapping(value = "/u-notify")
public class UNotifyController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UNotifyService uNotifyService;

    @RequestMapping(value = "/addUNotify", method = RequestMethod.POST)
    public long addUNotify(@RequestBody UNotify uNotify){
        logger.info("UNotifyController addUNotify"+uNotify.getContent());
        return uNotifyService.addUNotify(uNotify);
    }

    @RequestMapping(value = "/getUNotifyById",method = RequestMethod.GET)
    public UNotify getUNotifyById(@RequestParam("id") int id){
        logger.info("UNotifyController getUNotifyById   id :"+id);
        return uNotifyService.getUNotifyById(id);
    }

    @RequestMapping(value = "/getUNotifyByCreateTime",method = RequestMethod.GET)
    public List<UNotify> getUNotifyByCreateTime(@RequestParam("createTime") String createTime){
        logger.info("UNotifyController,getUNotifyByCreateTime,createTime -- "+createTime);
        return uNotifyService.getUNotifyByCreateTime(createTime);
    }

    @RequestMapping(value = "/getUNotifyBySubscription", method = RequestMethod.POST)
    public List<UNotify> getUNotifyBySubscription(@RequestBody USubscription uSubscription) {
        return uNotifyService.getUNotifyBySubscription(uSubscription);
    }
}
