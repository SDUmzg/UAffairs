package com.alearner.entity.mysql;

import com.alearner.entity.common.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-03 18:40
 **/
@Getter
@Setter
public class USubscriptionConfig extends BaseModel {
    private int user;
    private String action;
}
