CREATE DATABASE IF NOT EXISTS appointment default charset utf8 COLLATE utf8_general_ci; 

DROP TABLE IF EXISTS `user`;  
CREATE TABLE `user` (  
  user_id INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  username VARCHAR(30) NOT NULL COMMENT '用户名',
  password VARCHAR(50) COMMENT '密码MD5加密',
  email VARCHAR(30) COMMENT '用户邮箱',
  register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '注册日期',
  deleted TINYINT DEFAULT 0 COMMENT '0标识启用，1标识停用',
  PRIMARY KEY (`user_id`)  
) ENGINE=INNODB  DEFAULT CHARSET=utf8 COMMENT '用户信息表';
CREATE INDEX index_username ON USER(username);
COMMIT;
