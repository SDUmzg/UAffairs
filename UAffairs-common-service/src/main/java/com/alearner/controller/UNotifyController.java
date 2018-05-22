package com.alearner.controller;

import com.alearner.modle.common.ReturnT;
import com.alearner.modle.common.SqlType;
import com.alearner.modle.mysql.UNotify;
import com.alearner.service.UNotifyService;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 00:17
 **/
@RestController
@RequestMapping(value = "/u-notify",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UNotifyController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UNotifyService uNotifyService;

    /**
     id int(11) AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
     content varchar(100) NOT NULL COMMENT '消息的内容',
     type  tinyint(4) NOT NULL COMMENT '消息的类型，1: 公告 Announce，2: 提醒 Remind，3：信息 Message',
     target int(11) NOT NULL COMMENT '目标的ID',
     target_type varchar(20) NOT NULL COMMENT '目标的类型',
     action  varchar(20) NOT NULL COMMENT '提醒信息的动作类型',
     sender int(11) NOT NULL COMMENT '发送者的ID',
     */

    @RequestMapping(value = "/createAnnounce",method = RequestMethod.POST)
    public ReturnT<Long> createAnnounce(@RequestParam(value = "content") String content,
                                        @RequestParam(value = "sender") int sender){
        logger.info("UNotifyController,createAnnounce, content -- "+content +"   sender -- "+sender);
        UNotify uNotify = new UNotify();
        uNotify.setContent(content);
        uNotify.setType(SqlType.NOTIFY.ANNOUNCE);
        uNotify.setTarget(SqlType.NOTIFY.TARGET_ALL);
        uNotify.setTargetType(SqlType.NOTIFY.TARGET_TYPE_ALL);
        uNotify.setAction(SqlType.NOTIFY.ACTION_NULL);
        uNotify.setSender(sender);
        long id = uNotifyService.addUNotify(uNotify);
        return new ReturnT(String.valueOf(id));
    }


    @RequestMapping(value = "/createRemind",method = RequestMethod.POST)
    public ReturnT<Long> createRemind(@RequestParam(value = "content") String content,
                                      @RequestParam(value = "target")int target,
                                      @RequestParam(value = "targetType")String targetType,
                                      @RequestParam(value = "action")String action,
                                      @RequestParam(value = "sender")int sender){
        logger.info("UNotifyController ,createRemind , content -- " + content);
        UNotify uNotify = new UNotify();
        uNotify.setContent(content);
        uNotify.setType(SqlType.NOTIFY.REMIND);
        uNotify.setTarget(target);
        uNotify.setTargetType(targetType);
        uNotify.setAction(action);
        uNotify.setSender(sender);
        long row = uNotifyService.addUNotify(uNotify);
        return new ReturnT(row);
    }


//    createMessage(content, sender, receiver)

    public ReturnT<Long> createMessage(String content,int sender,int receiver){
        return new ReturnT(0);
    }
}
