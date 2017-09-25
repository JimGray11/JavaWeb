prompt PL/SQL Developer import file
prompt Created on 2015年11月11日 by Administrator
set feedback off
set define off
prompt Dropping DEPARTMENTS...
drop table DEPARTMENTS cascade constraints;
prompt Dropping POSITIONS...
drop table POSITIONS cascade constraints;
prompt Dropping T_CATEGORY...
drop table T_CATEGORY cascade constraints;
prompt Dropping T_RECORD...
drop table T_RECORD cascade constraints;
prompt Dropping T_SCORE...
drop table T_SCORE cascade constraints;
prompt Dropping USERS...
drop table USERS cascade constraints;
prompt Creating DEPARTMENTS...
create table DEPARTMENTS
(
  ID       NUMBER(6) not null,
  DEPNAME  VARCHAR2(20),
  PARENTID NUMBER(6),
  TASKDESC VARCHAR2(200)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table DEPARTMENTS
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating POSITIONS...
create table POSITIONS
(
  ID            NUMBER(6) not null,
  POSITION_NAME VARCHAR2(20),
  TASKDESC      VARCHAR2(200)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table POSITIONS
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating T_CATEGORY...
create table T_CATEGORY
(
  ID           VARCHAR2(50),
  CATEGORYNAME VARCHAR2(50),
  DESCRIPTION  VARCHAR2(50),
  REMARK       VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating T_RECORD...
create table T_RECORD
(
  RID       VARCHAR2(50),
  RJNAME    VARCHAR2(40),
  RCATEGORY VARCHAR2(40) not null,
  RBTIME    VARCHAR2(50),
  ROTIME    VARCHAR2(50),
  RCOST     VARCHAR2(40),
  RADDRESS  VARCHAR2(60),
  RHOSTER   VARCHAR2(40),
  RMETHOD   VARCHAR2(50) not null,
  RPNAME    VARCHAR2(40)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating T_SCORE...
create table T_SCORE
(
  SID     VARCHAR2(50),
  SPNAME  VARCHAR2(50),
  SDNAME  VARCHAR2(50),
  EDUNAME VARCHAR2(50),
  SCORE   VARCHAR2(50),
  PASS    VARCHAR2(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating USERS...
create table USERS
(
  ID           NUMBER(10) not null,
  USER_NAME    VARCHAR2(20),
  PASSWORD     VARCHAR2(32),
  DEPARTMENTID NUMBER(6),
  POSITIONID   NUMBER(6),
  SUBNAME      VARCHAR2(20),
  GENDER       NUMBER(1),
  TELL_PHONE   NUMBER(11),
  E_MAIL       VARCHAR2(20),
  REMARKS      VARCHAR2(200)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table USERS
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Disabling triggers for DEPARTMENTS...
alter table DEPARTMENTS disable all triggers;
prompt Disabling triggers for POSITIONS...
alter table POSITIONS disable all triggers;
prompt Disabling triggers for T_CATEGORY...
alter table T_CATEGORY disable all triggers;
prompt Disabling triggers for T_RECORD...
alter table T_RECORD disable all triggers;
prompt Disabling triggers for T_SCORE...
alter table T_SCORE disable all triggers;
prompt Disabling triggers for USERS...
alter table USERS disable all triggers;
prompt Loading DEPARTMENTS...
insert into DEPARTMENTS (ID, DEPNAME, PARENTID, TASKDESC)
values (125, null, 0, null);
insert into DEPARTMENTS (ID, DEPNAME, PARENTID, TASKDESC)
values (105, '需求工程', 105, '该部门主要负责软件需求的分析 确保满足客户的需求');
insert into DEPARTMENTS (ID, DEPNAME, PARENTID, TASKDESC)
values (103, 'IT部门', 103, 'IT部门主要负责软件的研发、维护....');
insert into DEPARTMENTS (ID, DEPNAME, PARENTID, TASKDESC)
values (104, '软件研发部', 103, '主要负责软件的开发');
insert into DEPARTMENTS (ID, DEPNAME, PARENTID, TASKDESC)
values (117, '软件UI 设计', 103, 'web 层工作的美化');
insert into DEPARTMENTS (ID, DEPNAME, PARENTID, TASKDESC)
values (112, '技术培训', 103, '培训新员工和新技术');
insert into DEPARTMENTS (ID, DEPNAME, PARENTID, TASKDESC)
values (126, '软件测试', 103, 'xxx');
commit;
prompt 7 records loaded
prompt Loading POSITIONS...
insert into POSITIONS (ID, POSITION_NAME, TASKDESC)
values (140, '人力资源管理', '负责人力资源的招聘');
insert into POSITIONS (ID, POSITION_NAME, TASKDESC)
values (110, '工程师', '软件的开发和技术支持');
insert into POSITIONS (ID, POSITION_NAME, TASKDESC)
values (150, 'IT高级工程师', '软件架构师');
insert into POSITIONS (ID, POSITION_NAME, TASKDESC)
values (170, '中级工程师', 'XXX');
commit;
prompt 4 records loaded
prompt Loading T_CATEGORY...
insert into T_CATEGORY (ID, CATEGORYNAME, DESCRIPTION, REMARK)
values ('2', '你知道', '不知道', '去吧皮卡');
insert into T_CATEGORY (ID, CATEGORYNAME, DESCRIPTION, REMARK)
values ('5', 'fasdsfsdf', '发的共和党', '地方');
commit;
prompt 2 records loaded
prompt Loading T_RECORD...
insert into T_RECORD (RID, RJNAME, RCATEGORY, RBTIME, ROTIME, RCOST, RADDRESS, RHOSTER, RMETHOD, RPNAME)
values ('2', 'Jone2', '111', '2014-05-16', '2014-06-03', '212', '打分', '的高发', '等多方面', '等原文');
insert into T_RECORD (RID, RJNAME, RCATEGORY, RBTIME, ROTIME, RCOST, RADDRESS, RHOSTER, RMETHOD, RPNAME)
values ('1', '555', '22', '2014-05-16', '2014-06-03', '2', '2', '2', '2', '2');
commit;
prompt 2 records loaded
prompt Loading T_SCORE...
insert into T_SCORE (SID, SPNAME, SDNAME, EDUNAME, SCORE, PASS)
values ('4', '调动', '销售', '营销', '60', '是');
insert into T_SCORE (SID, SPNAME, SDNAME, EDUNAME, SCORE, PASS)
values ('2', '张三', '销售', '营销', '90', '是');
insert into T_SCORE (SID, SPNAME, SDNAME, EDUNAME, SCORE, PASS)
values ('3', '李四', '后勤', '管理学', '78', '是');
commit;
prompt 3 records loaded
prompt Loading USERS...
insert into USERS (ID, USER_NAME, PASSWORD, DEPARTMENTID, POSITIONID, SUBNAME, GENDER, TELL_PHONE, E_MAIL, REMARKS)
values (1048, '徐珩翔', '202cb962ac59075b964b07152d234b70', 106, 110, '徐珩翔', 1, 18234567890, 'lijing@126,.com', '静态页面制作及前台功能维护');
insert into USERS (ID, USER_NAME, PASSWORD, DEPARTMENTID, POSITIONID, SUBNAME, GENDER, TELL_PHONE, E_MAIL, REMARKS)
values (1001, 'hrms', 'e10adc3949ba59abbe56e057f20f883e', 104, 110, '人力资源管理系统', null, null, null, null);
insert into USERS (ID, USER_NAME, PASSWORD, DEPARTMENTID, POSITIONID, SUBNAME, GENDER, TELL_PHONE, E_MAIL, REMARKS)
values (1054, null, '111', 0, 0, null, 0, null, null, null);
commit;
prompt 3 records loaded
prompt Enabling triggers for DEPARTMENTS...
alter table DEPARTMENTS enable all triggers;
prompt Enabling triggers for POSITIONS...
alter table POSITIONS enable all triggers;
prompt Enabling triggers for T_CATEGORY...
alter table T_CATEGORY enable all triggers;
prompt Enabling triggers for T_RECORD...
alter table T_RECORD enable all triggers;
prompt Enabling triggers for T_SCORE...
alter table T_SCORE enable all triggers;
prompt Enabling triggers for USERS...
alter table USERS enable all triggers;
set feedback on
set define on
prompt Done.
