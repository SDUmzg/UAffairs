package com.alearner.controller;

import com.alearner.entity.mysql.UUserNotify;
import com.alearner.service.UUserNotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 08:28
 **/
@RestController
@RequestMapping(value = "/u-user-notify")
public class UUserNotifyController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UUserNotifyService uUserNotifyService;

    @RequestMapping(value = "/addUUserNotify",method = RequestMethod.POST)
    public long addUUserNotify(@RequestBody UUserNotify uUserNotify){
        logger.info("UUserNotifyController,addUUserNotify,uUserNotify:"+uUserNotify.toString());
        long row = uUserNotifyService.addUUserNotify(uUserNotify);
        return uUserNotify.getId();
    }

    @RequestMapping(value = "/getUUserNotifyById",method = RequestMethod.GET)
    public UUserNotify getUUserNotifyById(@RequestParam(value = "id") int id){
        logger.info("UUserNotifyController , getUUserNotifyById , id -- "+id);
        return uUserNotifyService.getUUserNotifyById(id);
    }

    @RequestMapping(value = "/getUUserNotifyByUserId",method = RequestMethod.GET)
    public List<UUserNotify> getUUserNotifyByUserId(@RequestParam("user") int user){
        logger.info("UUserNotifyController , getUUserNotifyByUserId , user -- " + user);
        return uUserNotifyService.getUUserNotifyByUserId(user);
    }
}
