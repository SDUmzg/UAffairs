package com.alearner.mapper.mysql;

import com.alearner.entity.mysql.USsoUserEdu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-03 19:34
 **/
@Component
public interface USsoUserEduMapper {
    USsoUserEdu getUSsoUserEduById(@Param("sso_id")int sso_id);
}
