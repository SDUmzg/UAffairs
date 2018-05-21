package com.alearner.controller;

import com.alearner.entity.mysql.UNotify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @description:
 * @author: MZG
 * @create: 2018-05-21 10:23
 **/
@RestController
@RequestMapping(value = "/u-notify")
public class UNotifyController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping
    public long addUNotify(UNotify uNotify){
        return 0;
    }

    public UNotify getUNotifyById(int id){
        return null;
    }
}
