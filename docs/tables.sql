DROP DATABASE IF EXISTS appointment;
CREATE DATABASE IF NOT EXISTS appointment DEFAULT CHARSET utf8 COLLATE utf8_general_ci; 
USE appointment;

DROP TABLE IF EXISTS `YB_PersonInfo`;  
CREATE TABLE `YB_PersonInfo` (  
  userid INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  username VARCHAR(45) NOT NULL COMMENT '用户姓名',
  gender INT(1) NOT NULL COMMENT '性别 1:男 0:女',
  phonenumber VARCHAR(20) NOT NULL COMMENT '电话号码',
  PRIMARY KEY (`userid`)  
) ENGINE=INNODB  DEFAULT CHARSET=utf8 COMMENT '用户基本信息表';
CREATE INDEX index_username ON YB_PersonInfo(username);
COMMIT;
DROP TABLE IF EXISTS `YB_ActivityInfo`;  
CREATE TABLE `YB_ActivityInfo` (  
  activityid INT(11) NOT NULL AUTO_INCREMENT COMMENT '活动Id',
  activitytheme VARCHAR(50) NOT NULL COMMENT '活动主题',
  userid INT(11) NOT NULL COMMENT '外键，发起人Id',
  launchtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '活动发布时间',
  starttime TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '活动开始时间',
  endtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '活动结束时间',
  activitytype INT(1) NOT NULL COMMENT '0体育，1旅游，2户外，3娱乐，4其他',
  activityplace VARCHAR(50)  COMMENT '活动地址名',
  detailplace VARCHAR(200) COMMENT '活动详细地址',
  activityplace_x DOUBLE  COMMENT '活动地址坐标x',
  activityplace_y DOUBLE  COMMENT '活动地址坐标y',
  numbernow INT(11) DEFAULT 0 COMMENT '当前报名人数',
  numberup INT(11) DEFAULT 0 COMMENT '活动人数上限',
  activityinfo VARCHAR(200)  COMMENT '活动描述',
  contacter VARCHAR(45) NOT NULL COMMENT '联系人',
  contacternumber VARCHAR(20) NOT NULL COMMENT '联系人电话',
  genderrequire INT(1) DEFAULT 2 COMMENT '性别要求，0只女性，1只男性，2不限',
  activitystate INT(1) DEFAULT 1 COMMENT '活动状态 0已结束，1正在进行，2已取消',
  ifrequire INT(1) DEFAULT 0 COMMENT '参与条件 0无限制，1需要参与码',
  PASSWORD VARCHAR(20) DEFAULT 1 COMMENT '参与码',
  comments TEXT DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`activityid`),
  FOREIGN KEY(`userid`) REFERENCES YB_PersonInfo(userid)  
) ENGINE=INNODB  DEFAULT CHARSET=utf8 COMMENT '活动信息表';
CREATE INDEX index_activitythemee ON YB_ActivityInfo(activitytheme);
CREATE INDEX index_activityiduserid ON YB_ActivityInfo(activityid,userid);
COMMIT;

DROP TABLE IF EXISTS `YB_PaticipateInfo`;  
CREATE TABLE `YB_PaticipateInfo`(
paticipate INT(11) NOT NULL AUTO_INCREMENT COMMENT ' 参与Id 主键',
activityid INT(11) NOT NULL COMMENT '活动Id，外键',
userid INT(11) NOT NULL COMMENT '用户Id,外键',
number INT(9) NOT NULL DEFAULT 1 COMMENT '报名人数',
paticipatetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '报名时间',
PRIMARY KEY(paticipate),
FOREIGN KEY(activityid) REFERENCES YB_ActivityInfo(activityid),
FOREIGN KEY(userid) REFERENCES YB_PersonInfo(userid)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '活动参与信息表';
CREATE INDEX index_paticipate ON YB_PaticipateInfo(activityid,userid);
COMMIT;