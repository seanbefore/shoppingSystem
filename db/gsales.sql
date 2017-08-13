use shopdb;
CREATE TABLE if not exists gsales
(
       gsid  INT(10) not null auto_increment PRIMARY KEY,
                                          #外键必须是外表主键,
       gsgid  INT(10) not null, 
       gssid  INT(10) not null,
       sdate  TIMESTAMP  DEFAULT  CURRENT_TIMESTAMP NOT NULL, #表内数据改动时自动获取系统时间并同步到数据库
       snum  INT(11) NOT NULL,
       foreign key (gsgid) references goods(gid),
       foreign key (gssid) REFERENCES salesman(sid) 
);