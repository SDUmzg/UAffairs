package com.alearner.modle.common;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-11 18:56
 **/
public class SqlType {
    public static class STORE_TOOL{
        public static final int MYSQL=0;
        public static final int POSTGRESQL=1;
    }
    /**
     id int(11) AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
     content varchar(100) NOT NULL COMMENT '消息的内容',
     type  tinyint(4) NOT NULL COMMENT '消息的类型，1: 公告 Announce，2: 提醒 Remind，3：信息 Message',
     target int(11) NOT NULL COMMENT '目标的ID',
     target_type varchar(20) NOT NULL COMMENT '目标的类型',
     action  varchar(20) NOT NULL COMMENT '提醒信息的动作类型',
     sender int(11) NOT NULL COMMENT '发送者的ID',
     */
    public static class NOTIFY{
        public static final int ANNOUNCE = 1;
        public static final int REMIND = 2;
        public static final int MESSAGE = 3;
        public static final int TARGET_ALL = 0;
        public static final String TARGET_TYPE_ALL = "all";
        public static final String ACTION_NULL = "announce action";
    }
}
