DROP DATABASE IF EXISTS uaffairs;
create database uaffairs;

DROP TABLE IF EXISTS school;
create table school(
  id int(11) AUTO_INCREMENT PRIMARY KEY  COMMENT '编号',
  name varchar(50) NOT NULL  COMMENT '学校名称',
  is_able boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  updateTime TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'
);


DROP TABLE IF EXISTS college;
create table college(
  id int(11) AUTO_INCREMENT PRIMARY KEY  COMMENT '编号',
  name varchar(50) NOT NULL COMMENT '学院名称',
  is_able boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  updateTime TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'
);


DROP TABLE IF EXISTS classes;
create table classes(
  id int(11) AUTO_INCREMENT PRIMARY KEY COMMENT '编号',
  college_id int(11) COMMENT '学院',
  name varchar(50) NOT NULL COMMENT '班级名称',
  enrollment TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '入学时间',
  year_system TINYINT(4) COMMENT '学制',
  is_able boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  updateTime TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'
);


DROP TABLE IF EXISTS student;
create table student(
  id int(11) AUTO_INCREMENT PRIMARY KEY COMMENT '编号',
  u_id varchar(30) NOT NULL COMMENT '学号',
  name varchar(30) NOT NULL COMMENT '姓名',
  sex varchar(5) NOT NULL DEFAULT 'm' COMMENT 'm : man , w : woman',
  phone varchar(20) COMMENT '手机号码',
  email varchar(50) COMMENT '邮箱',
  id_card varchar(30) COMMENT '身份证号',
  classes_id int(11) COMMENT '所在班级的id',
  role tinyint(4) COMMENT '角色',
  status tinyint(4),
  is_able boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  updateTime TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'

);


DROP TABLE IF EXISTS notify;
create table notify(
  id int(11) AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
  content varchar(100) NOT NULL COMMENT '消息的内容',
  type  tinyint(4) NOT NULL COMMENT '消息的类型，1: 公告 Announce，2: 提醒 Remind，3：信息 Message',
  target int(11) NOT NULL COMMENT '目标的ID',
  target_type varchar(20) NOT NULL COMMENT '目标的类型',
  action  varchar(20) NOT NULL COMMENT '提醒信息的动作类型',
  sender int(11) NOT NULL COMMENT '发送者的ID',
  is_able boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  updateTime TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'

);


DROP TABLE IF EXISTS subscription;
create table subscription(
  id int(11) AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
  target int(11) NOT NULL ,
  target_type varchar(20) NOT NULL ,
  action varchar(20) NOT NULL ,
  user int(11) NOT NULL ,
  is_able boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  updateTime TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'
);

/*- user                   int(11)
- action                 JSON
- is_able                boolean
- description          varchar(100)
- create_time         timestamp
- update_time        timestamp
*/
DROP TABLE IF EXISTS subscription_config;
create table subscription_config(
  user int(11) NOT NULL PRIMARY KEY ,
  action JSON NOT NULL ,
  is_able boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  updateTime TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'
)




