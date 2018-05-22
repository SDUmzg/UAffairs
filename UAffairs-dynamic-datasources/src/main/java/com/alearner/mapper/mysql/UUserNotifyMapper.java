package com.alearner.mapper.mysql;

import com.alearner.entity.mysql.UUserNotify;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 08:08
 **/
@Component
public interface UUserNotifyMapper {
    long addUUserNotify(UUserNotify uUserNotify);
    UUserNotify getUUserNotifyById(@Param("id")int id);
}
