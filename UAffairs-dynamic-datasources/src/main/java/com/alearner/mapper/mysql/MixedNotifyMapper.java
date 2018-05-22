package com.alearner.mapper.mysql;

import com.alearner.entity.mysql.UNotify;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 17:01
 **/
@Component
public interface MixedNotifyMapper {
    UNotify getLastAnnounceTimeByUserId(@Param("user_id") int user_id);
}
