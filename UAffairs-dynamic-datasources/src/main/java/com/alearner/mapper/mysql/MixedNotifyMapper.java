package com.alearner.mapper.mysql;

import com.alearner.entity.mysql.UNotify;
import com.alearner.entity.mysql.UserNotifyList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 17:01
 **/
@Component
public interface MixedNotifyMapper {
    UNotify getLastAnnounceTimeByUserId(@Param("userId") int userId);
    List<UserNotifyList> getUserNotifyListByUserId(@Param("userId") int userId);
}
