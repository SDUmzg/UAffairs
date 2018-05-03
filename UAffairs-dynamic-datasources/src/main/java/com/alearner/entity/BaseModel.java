package com.alearner.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-03 15:34
 **/
@Setter
@Getter
public class BaseModel {
    private boolean ableStatus;
    private String description;
    private String createTime;
    private String updateTime;

}
