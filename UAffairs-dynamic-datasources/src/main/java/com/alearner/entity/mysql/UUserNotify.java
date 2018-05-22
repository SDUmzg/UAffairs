package com.alearner.entity.mysql;

import com.alearner.entity.common.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 08:04
 **/
@Getter
@Setter
public class UUserNotify extends BaseModel{
    private int id;
    private boolean readStatus;
    private int userId;
    private int notifyId;
}
