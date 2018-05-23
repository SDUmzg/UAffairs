package com.alearner.modle.mysql;

import com.alearner.modle.common.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-03 18:37
 **/
@Setter
@Getter
@ToString
public class USubscription extends BaseModel{
    private int id;
    private int target;
    private String targetType;
    private String action;
    private int user;
}
