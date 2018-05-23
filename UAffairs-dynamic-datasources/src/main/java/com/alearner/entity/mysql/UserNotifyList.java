package com.alearner.entity.mysql;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-23 13:37
 **/
@Setter
@Getter
@ToString
public class UserNotifyList {
    private int id ;
    private boolean readStatus;
    private int userId;
    private int notifyId;
    private String content;
    private int type;
    private int target;
    private String targetType;
    private String action;
    private int sender;
    private boolean ableUserNotify;
    private boolean ableNotify;
    private String updateTime;

}
