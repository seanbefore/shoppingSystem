use shopdb;
CREATE TABLE IF NOT EXISTS salesman
(
       sid        INT(10) not null auto_increment PRIMARY KEY,
       sname      VARCHAR(10) NOT NULL UNIQUE,
       spassword  VARCHAR(20) NOT NULL
       
)