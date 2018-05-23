package com.alearner.mapper.mysql;

import com.alearner.entity.mysql.UUserNotify;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 08:08
 **/
@Component
public interface UUserNotifyMapper {
    long addUUserNotify(UUserNotify uUserNotify);
    UUserNotify getUUserNotifyById(@Param("id")int id);
    List<UUserNotify> getUUserNotifyByUserId(@Param("userId")int userId);
    long updateUserNotifyRead(@Param("userId") int userId ,@Param("notifyId") int notifyId);
}
