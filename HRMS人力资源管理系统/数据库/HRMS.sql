prompt PL/SQL Developer import file
prompt Created on 2015��11��11�� by Administrator
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
values (105, '���󹤳�', 105, '�ò�����Ҫ�����������ķ��� ȷ������ͻ�������');
insert into DEPARTMENTS (ID, DEPNAME, PARENTID, TASKDESC)
values (103, 'IT����', 103, 'IT������Ҫ����������з���ά��....');
insert into DEPARTMENTS (ID, DEPNAME, PARENTID, TASKDESC)
values (104, '����з���', 103, '��Ҫ��������Ŀ���');
insert into DEPARTMENTS (ID, DEPNAME, PARENTID, TASKDESC)
values (117, '���UI ���', 103, 'web �㹤��������');
insert into DEPARTMENTS (ID, DEPNAME, PARENTID, TASKDESC)
values (112, '������ѵ', 103, '��ѵ��Ա�����¼���');
insert into DEPARTMENTS (ID, DEPNAME, PARENTID, TASKDESC)
values (126, '�������', 103, 'xxx');
commit;
prompt 7 records loaded
prompt Loading POSITIONS...
insert into POSITIONS (ID, POSITION_NAME, TASKDESC)
values (140, '������Դ����', '����������Դ����Ƹ');
insert into POSITIONS (ID, POSITION_NAME, TASKDESC)
values (110, '����ʦ', '����Ŀ����ͼ���֧��');
insert into POSITIONS (ID, POSITION_NAME, TASKDESC)
values (150, 'IT�߼�����ʦ', '����ܹ�ʦ');
insert into POSITIONS (ID, POSITION_NAME, TASKDESC)
values (170, '�м�����ʦ', 'XXX');
commit;
prompt 4 records loaded
prompt Loading T_CATEGORY...
insert into T_CATEGORY (ID, CATEGORYNAME, DESCRIPTION, REMARK)
values ('2', '��֪��', '��֪��', 'ȥ��Ƥ��');
insert into T_CATEGORY (ID, CATEGORYNAME, DESCRIPTION, REMARK)
values ('5', 'fasdsfsdf', '���Ĺ��͵�', '�ط�');
commit;
prompt 2 records loaded
prompt Loading T_RECORD...
insert into T_RECORD (RID, RJNAME, RCATEGORY, RBTIME, ROTIME, RCOST, RADDRESS, RHOSTER, RMETHOD, RPNAME)
values ('2', 'Jone2', '111', '2014-05-16', '2014-06-03', '212', '���', '�ĸ߷�', '�ȶ෽��', '��ԭ��');
insert into T_RECORD (RID, RJNAME, RCATEGORY, RBTIME, ROTIME, RCOST, RADDRESS, RHOSTER, RMETHOD, RPNAME)
values ('1', '555', '22', '2014-05-16', '2014-06-03', '2', '2', '2', '2', '2');
commit;
prompt 2 records loaded
prompt Loading T_SCORE...
insert into T_SCORE (SID, SPNAME, SDNAME, EDUNAME, SCORE, PASS)
values ('4', '����', '����', 'Ӫ��', '60', '��');
insert into T_SCORE (SID, SPNAME, SDNAME, EDUNAME, SCORE, PASS)
values ('2', '����', '����', 'Ӫ��', '90', '��');
insert into T_SCORE (SID, SPNAME, SDNAME, EDUNAME, SCORE, PASS)
values ('3', '����', '����', '����ѧ', '78', '��');
commit;
prompt 3 records loaded
prompt Loading USERS...
insert into USERS (ID, USER_NAME, PASSWORD, DEPARTMENTID, POSITIONID, SUBNAME, GENDER, TELL_PHONE, E_MAIL, REMARKS)
values (1048, '������', '202cb962ac59075b964b07152d234b70', 106, 110, '������', 1, 18234567890, 'lijing@126,.com', '��̬ҳ��������ǰ̨����ά��');
insert into USERS (ID, USER_NAME, PASSWORD, DEPARTMENTID, POSITIONID, SUBNAME, GENDER, TELL_PHONE, E_MAIL, REMARKS)
values (1001, 'hrms', 'e10adc3949ba59abbe56e057f20f883e', 104, 110, '������Դ����ϵͳ', null, null, null, null);
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
