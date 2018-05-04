package com.alearner.entity.mysql;

import com.alearner.entity.common.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-03 18:24
 **/
@Getter
@Setter
public class UStudent extends BaseModel{
    private int id;
    private String uId;
    private String name;
    private String sex;
    private String phone;
    private String email;
    private String idCard;
    private int classesId;
    private int role;
    private int status;
}
