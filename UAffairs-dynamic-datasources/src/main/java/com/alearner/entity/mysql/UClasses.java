package com.alearner.entity.mysql;

import com.alearner.entity.common.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-03 18:22
 **/
@Setter
@Getter
public class UClasses extends BaseModel {
    private int id;
    private int collegeId;
    private String name;
    private String enrollment;
    private int yearSystem;
}
