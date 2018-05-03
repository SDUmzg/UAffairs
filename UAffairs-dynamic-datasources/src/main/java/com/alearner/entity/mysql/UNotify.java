package com.alearner.entity.mysql;

import com.alearner.entity.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-03 18:33
 **/
@Getter
@Setter
public class UNotify extends BaseModel {
    private int id;
    private String content;
    private int type;
    private int target;
    private String targetType;
    private String action;
    private int sender;
}
