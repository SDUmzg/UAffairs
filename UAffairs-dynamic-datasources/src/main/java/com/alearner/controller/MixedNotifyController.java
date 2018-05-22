package com.alearner.controller;

import com.alearner.entity.mysql.UNotify;
import com.alearner.service.MixedNotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 19:39
 **/
@RestController
@RequestMapping(value = "/mixed-notify")
public class MixedNotifyController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MixedNotifyService mixedNotifyService;

    @RequestMapping(value = "/getLastAnnounceTimeByUserId",method = RequestMethod.GET)
    public UNotify getLastAnnounceTimeByUserId(@RequestParam("user_id") int user_id){
        logger.info("MixedNotifyController,getLastAnnounceTimeByUserId,user_id -- "+ user_id);
        return mixedNotifyService.getLastAnnounceTimeByUserId(user_id);
    }
}
