package com.alearner.controller;

import com.alearner.modle.common.ReturnT;
import com.alearner.modle.common.SqlType;
import com.alearner.modle.mysql.UNotify;
import com.alearner.modle.mysql.USubscription;
import com.alearner.modle.mysql.UUserNotify;
import com.alearner.service.MixedNotifyService;
import com.alearner.service.UNotifyService;
import com.alearner.service.USubscriptionService;
import com.alearner.service.UUserNotifyService;
import com.alearner.util.XxlUtil;
import com.xxl.sso.core.user.XxlUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 00:17
 **/
@RestController
@RequestMapping(value = "/u-notify",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class NotifyController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UNotifyService uNotifyService;

    @Autowired
    private UUserNotifyService uUserNotifyService;
    @Autowired
    private MixedNotifyService mixedNotifyService;
    @Autowired
    private USubscriptionService uSubscriptionService;
    @Autowired
    private XxlUtil xxlUtil;

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



    @RequestMapping(value = "/createMessage",method = RequestMethod.POST)
    public ReturnT<Long> createMessage(@RequestParam(value = "content") String content,
                                       @RequestParam(value = "sender") int sender,
                                       @RequestParam(value = "receiver") int receiver){
        logger.info("UNotifyController ,createMessage , content -- " + content);
        UNotify uNotify = new UNotify();
        uNotify.setContent(content);
        uNotify.setType(SqlType.NOTIFY.MESSAGE);
        uNotify.setTarget(receiver);
        uNotify.setTargetType(SqlType.NOTIFY.TARGET_TYPE_USER);
        uNotify.setAction("message");
        uNotify.setSender(sender);
        long notify_id = uNotifyService.addUNotify(uNotify);
        UUserNotify uUserNotify = new UUserNotify();
        uUserNotify.setReadStatus(false);
        uUserNotify.setUserId(sender);
        uUserNotify.setNotifyId((int)notify_id);
        long user_notify_id=uUserNotifyService.addUUserNotify(uUserNotify);
        Map<String,String> res = new HashMap<>();
        res.put("notify",String.valueOf(notify_id));
        res.put("user_notify",String.valueOf(user_notify_id));
        return new ReturnT(res);
    }


    @RequestMapping(value = "/pullAnnounce",method = RequestMethod.GET)
    public ReturnT pullAnnounce(HttpServletRequest request){
        logger.info("UNotifyController ,pullAnnounce ");
        XxlUser xxlUser = xxlUtil.getXxlUser(request);
        int userId = xxlUser.getUserid();
        UNotify last_announce = mixedNotifyService.getLastAnnounceTimeByUserId(userId);
        List<UNotify> uNotifyList = uNotifyService.getUNotifyByCreateTime(last_announce.getCreateTime());
        addNotifyToUserNotify(uNotifyList,userId);
        return new ReturnT(uNotifyList);
    }

    @RequestMapping(value = "/pullRemind",method = RequestMethod.GET)
    public ReturnT pullRemind(HttpServletRequest request){
        logger.info("NotifyController,pullRemind");
        XxlUser xxlUser = xxlUtil.getXxlUser(request);
        int userId = xxlUser.getUserid();
        List<USubscription> uSubscriptionList = uSubscriptionService.getUSubscriptionByUserId(userId);
        for (USubscription uSubscription:uSubscriptionList){
            List<UNotify> uNotifyListTemp = uNotifyService.getUNotifyBySubscription(uSubscription);
            addNotifyToUserNotify(uNotifyListTemp,userId);
        }
        return new ReturnT(uSubscriptionList);
    }


    @RequestMapping(value = "/cancelSubscription",method = RequestMethod.GET)
    public ReturnT cancelSubscription(@RequestParam("user") int user,
                                      @RequestParam("target") int target,
                                      @RequestParam("targetType") String targetType){
        logger.info("NotifyController,cancelSubscription");
        USubscription uSubscription = new USubscription();
        uSubscription.setUser(user);
        uSubscription.setTarget(target);
        uSubscription.setTargetType(targetType);
        long affect_row = uSubscriptionService.disableUSubscription(uSubscription);
        return new ReturnT(affect_row);
    }




    // 将查询出来的notify与user notify 关联起来
    public void addNotifyToUserNotify(List<UNotify> uNotifyList,int userId){
        for (UNotify uNotify:uNotifyList){
            UUserNotify tempUUserNotify = new UUserNotify();
            tempUUserNotify.setReadStatus(true);
            tempUUserNotify.setUserId(userId);
            tempUUserNotify.setNotifyId(uNotify.getId());
            uUserNotifyService.addUUserNotify(tempUUserNotify);
        }
    }

}
