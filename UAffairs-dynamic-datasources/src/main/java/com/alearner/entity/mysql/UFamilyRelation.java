package com.alearner.entity.mysql;

import com.alearner.entity.common.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 09:06
 **/
@Setter
@Getter
@ToString
public class UFamilyRelation extends BaseModel{
    private int id;
    private String stuId;
    private String name;
    private String phone;
    private String email;
    private String relation;
}
