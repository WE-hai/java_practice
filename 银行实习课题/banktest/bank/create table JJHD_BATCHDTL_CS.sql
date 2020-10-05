-- Create table
create table JJHD_BATCHDTL_CS
(
  userno   VARCHAR2(19),
  username VARCHAR2(60),
  idno     VARCHAR2(30),
  age      VARCHAR2(5)
)
-- Add comments to the table 
comment on table JJHD_BATCHDTL_CS
  is '批次明细表cs';
-- Add comments to the columns 
comment on column JJHD_BATCHDTL_CS.userno
  is '人员编号';
comment on column JJHD_BATCHDTL_CS.username
  is '人员姓名';
comment on column JJHD_BATCHDTL_CS.idno
  is '证件号码标识确定需要核对人员身份的证件号码（身份证为标准的18位）';
comment on column JJHD_BATCHDTL_CS.age
  is '年龄';
