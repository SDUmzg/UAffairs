# DROP DATABASE IF EXISTS uaffairs;
# create database uaffairs;

DROP TABLE IF EXISTS u_school;
create table u_school(
  id int(11) AUTO_INCREMENT PRIMARY KEY  COMMENT '编号',
  name varchar(50) NOT NULL  COMMENT '学校名称',
  able_status boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'
);

INSERT INTO u_school(id,name,description)VALUES (1,'山东大学','山东省济南市');

DROP TABLE IF EXISTS u_college;
create table u_college(
  id int(11) AUTO_INCREMENT PRIMARY KEY  COMMENT '编号',
  school_id int(11) COMMENT '学校',
  name varchar(50) NOT NULL COMMENT '学院名称',
  able_status boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'
);

INSERT INTO u_college(id,school_id,name)VALUES(1,1,'软件学院');



DROP TABLE IF EXISTS u_classes;
create table u_classes(
  id int(11) AUTO_INCREMENT PRIMARY KEY COMMENT '编号',
  college_id int(11) COMMENT '学院',
  name varchar(50) NOT NULL COMMENT '班级名称',
  enrollment TIMESTAMP NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '入学时间',
  year_system TINYINT(4) NOT NULL DEFAULT '4' COMMENT '学制',
  able_status boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'
);

INSERT INTO u_classes(id,college_id,name)VALUES (1,1,'软件三班');


DROP TABLE IF EXISTS u_student;
create table u_student(
  id int(11) AUTO_INCREMENT PRIMARY KEY COMMENT '编号',
  u_id varchar(30) NOT NULL COMMENT '学号',
  name varchar(30) NOT NULL COMMENT '姓名',
  sex varchar(5) NOT NULL DEFAULT 'm' COMMENT 'm : man , w : woman',
  phone varchar(20) COMMENT '手机号码',
  email varchar(50) COMMENT '邮箱',
  id_card varchar(30) COMMENT '身份证号',
  classes_id int(11) COMMENT '所在班级的id',
  role tinyint(4)  DEFAULT '0' COMMENT '角色  0:普通    1：管理员',
  status tinyint(4) DEFAULT '0' COMMENT '状态： 0：正常  1：休学  2：退学 3：已毕业',
  able_status boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'
);

INSERT INTO u_student(id,u_id,name,sex,phone,email,id_card,classes_id,role)VALUES (1,'201400301185','马宗广','m','17865169606','1666188122@qq.com','371322199512030000',1,1);
INSERT INTO u_student(id,u_id,name,sex,phone,email,id_card,classes_id,role)VALUES (2,'201400301245','杨莹涛','m','17865169857','yangyingtao@163.com','371322199512030001',1,0);
INSERT INTO u_student(id,u_id,name,sex,phone,email,id_card,classes_id,role)VALUES (3,'201400301345','朱斯亮','m','17865169999','zhusiliang@163.com','371322199512030002',1,0);


DROP TABLE IF EXISTS u_family_relation;
create table u_family_relation(
  id int(11) AUTO_INCREMENT PRIMARY KEY COMMENT '编号',
  stu_id varchar(30) NOT NULL COMMENT '学生编号',
  name varchar(30) NOT NULL COMMENT '姓名',
  phone varchar(30) NOT NULL COMMENT '电话',
  email varchar(30) COMMENT '邮箱',
  relation varchar(20) COMMENT '关系',
  able_status boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'
);

INSERT INTO u_family_relation(id, stu_id, name, phone, email, relation)VALUES (1,1,'马爸爸','17865160000','mababa@163.com','父亲');
INSERT INTO u_family_relation(id, stu_id, name, phone, email, relation)VALUES (2,1,'马妈妈','17865160000','mamama@163.com','母亲');

DROP TABLE IF EXISTS  u_teacher;
create table u_teacher(
  id int(11) AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
  u_id varchar(30) NOT NULL COMMENT '工号',
  name varchar(30) NOT NULL COMMENT '姓名',
  sex varchar(5) NOT NULL DEFAULT 'm' COMMENT 'm : man , w : woman',
  phone varchar(20) COMMENT '手机号码',
  email varchar(50) COMMENT '邮箱',
  id_card varchar(30) COMMENT '身份证号',
  college_id int(11) COMMENT '所在学院的id',
  role tinyint(4) COMMENT '角色',
  status tinyint(4),
  able_status boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'
);
INSERT INTO u_teacher(id, u_id, name, sex, phone, email, id_card, college_id, role, status)VALUES (1,'100000','马老师','w','178651690000','malaoshi@163.com','371322199012030000',1,0,0);



DROP TABLE IF EXISTS u_notify;
create table u_notify(
  id int(11) AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
  content varchar(100) NOT NULL COMMENT '消息的内容',
  type  tinyint(4) NOT NULL COMMENT '消息的类型，1: 公告 Announce，2: 提醒 Remind，3：信息 Message',
  target int(11) NOT NULL COMMENT '目标的ID',
  target_type varchar(20) NOT NULL COMMENT '目标的类型',
  action  varchar(20) NOT NULL COMMENT '提醒信息的动作类型',
  sender int(11) NOT NULL COMMENT '发送者的ID',
  able_status boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'

);


DROP TABLE IF EXISTS u_subscription;
create table u_subscription(
  id int(11) AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
  target int(11) NOT NULL COMMENT '目标的ID',
  target_type varchar(20) NOT NULL COMMENT '目标的类型',
  action varchar(20) NOT NULL COMMENT '订阅动作,如: comment/like/post/update etc',
  user int(11) NOT NULL COMMENT '订阅的人',
  able_status boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'
);

DROP TABLE IF EXISTS u_subscription_config;
create table u_subscription_config(
  user int(11) NOT NULL PRIMARY KEY COMMENT '主键',
  action JSON NOT NULL COMMENT '订阅的配置',
  able_status boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'
);

DROP TABLE IF EXISTS xxl_sso_user;
CREATE TABLE xxl_sso_user (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  username varchar(50) NOT NULL COMMENT '用户名',
  password varchar(50) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
);
INSERT INTO `xxl_sso_user` VALUES (null, 'user', '123456');

DROP TABLE IF EXISTS u_sso_user_edu;
CREATE TABLE u_sso_user_edu(
  sso_id int(11) NOT NULL PRIMARY KEY COMMENT 'xxl_sso_user 表的id',
  edu_id int(11) NOT NULL COMMENT 'u_student或者u_teacher表的id',
  edu_type TINYINT(4) NOT NULL COMMENT 'teacher或者student身份   0:老师   1：学生',
  able_status boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'

);

INSERT INTO u_sso_user_edu(sso_id, edu_id, edu_type) VALUES(1,1,1);


DROP TABLE IF EXISTS u_note_file;
CREATE TABLE u_note_file(
  id int(11) AUTO_INCREMENT PRIMARY KEY COMMENT '编号',
  name varchar(50) NOT NULL COMMENT '文件或者便签名',
  type varchar(20) NOT NULL COMMENT '文件类型',
  subject varchar(200) NOT NULL COMMENT '主题',
  store_tool tinyint(4) NOT NULL COMMENT '存储工具  0：mysql  1：postgresql',
  store_id int(11) NOT NULL COMMENT '文件在mysql或postgresql中的存储的主键id',
  able_status boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'
);


DROP TABLE IF EXISTS u_notes;
CREATE TABLE u_notes(
  id int(11) AUTO_INCREMENT PRIMARY KEY COMMENT '编号',
  subject varchar(200) NOT NULL COMMENT '主题',
  content text NOT NULL COMMENT '内容',
  owner_id int(11) NOT NULL COMMENT '文件所有者id',
  owner_type tinyint(4) NOT NULL COMMENT '文件所有者的类型',
  able_status boolean NOT NULL DEFAULT '1' COMMENT '0:失效  1：有效',
  description VARCHAR(100) COMMENT '描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间'
);

