package com.alearner.mapper.mysql;

import com.alearner.entity.mysql.UUserNotify;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 08:08
 **/
public interface UUserNotifyMapper {
    long addUUserNotify(UUserNotify uUserNotify);
    UUserNotify getUUserNotifyById(@Param("id")int id);
}
