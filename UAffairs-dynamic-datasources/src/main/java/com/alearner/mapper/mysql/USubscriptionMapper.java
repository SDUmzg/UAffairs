package com.alearner.mapper.mysql;

import com.alearner.entity.mysql.USubscription;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 21:31
 **/
@Component
public interface USubscriptionMapper {
    long addUSubscription(USubscription uSubscription);
    List<USubscription> getUSubscriptionByUserId(@Param("user")int user);
    long disableUSubscription(USubscription uSubscription);
}
