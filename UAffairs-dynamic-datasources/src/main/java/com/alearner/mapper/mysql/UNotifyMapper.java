package com.alearner.mapper.mysql;

import com.alearner.entity.mysql.UNotify;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-21 10:08
 **/
@Component
public interface UNotifyMapper {
    long addUNotify(UNotify uNotify);
    UNotify getUNotifyById(@Param("id") int id);
    List<UNotify> getUNotifyByCreateTime(@Param("createTime") String createTime);
}
