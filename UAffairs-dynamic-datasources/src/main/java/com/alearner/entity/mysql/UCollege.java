package com.alearner.entity.mysql;

import com.alearner.entity.BaseModel;
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
