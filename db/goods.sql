use shopdb;
CREATE TABLE IF NOT EXISTS Goods (
    gid INT(10) NOT NULL AUTO_INCREMENT  primary key,
    gname VARCHAR(20) NOT NULL UNIQUE,
    gprice FLOAT(18 , 2 ) NOT NULL,
    gnum INT(11) NOT NULL
)
;