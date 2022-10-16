drop table  IF exists native_member;
create table native_member (
                               memid long auto_increment primary key ,
                               memName varchar(32) unique ,
                               memNo   varchar(16) unique ,
                               memCell varchar(11),
    /**memFamilyCell  varchar(128),*/
                               memAge      integer,
                               createTime   time,
                               updateTime   time,
                               memAuditor   varchar(16)
)