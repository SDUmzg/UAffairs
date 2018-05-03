package com.alearner.mapper.mysql;

import com.alearner.entity.mysql.USchool;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-03 16:02
 **/
@Component
public interface USchoolMapper {
    List<USchool> getUSchoolAll();
}
