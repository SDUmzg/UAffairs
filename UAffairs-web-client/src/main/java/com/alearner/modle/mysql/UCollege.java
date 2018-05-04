package com.alearner.modle.mysql;

import com.alearner.modle.common.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-03 18:20
 **/
@Getter
@Setter
public class UCollege extends BaseModel{
    private int id;
    private int schoolId;
    private String name;
}
