package com.alearner.entity.mysql;

import com.alearner.entity.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-03 18:37
 **/
@Setter
@Getter
public class USubscription extends BaseModel{
    private int id;
    private int target;
    private String targetType;
    private String action;
    private int user;
}
