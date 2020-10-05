-- Create table
create table JJHD_ACCINFO_CS
(
  userno   VARCHAR2(19),
  username VARCHAR2(60),
  accno    VARCHAR2(30),
  amount   VARCHAR2(17),
  currtype VARCHAR2(30),
  rate     VARCHAR2(17),
  accnotes VARCHAR2(20)
)

-- Add comments to the table 
comment on table JJHD_ACCINFO_CS
  is '账户信息表（活期和定期）cs';
-- Add comments to the columns 
comment on column JJHD_ACCINFO_CS.userno
  is '人员编号';
comment on column JJHD_ACCINFO_CS.username
  is '人员姓名';
comment on column JJHD_ACCINFO_CS.accno
  is '账号(卡号)';
comment on column JJHD_ACCINFO_CS.amount
  is '账户金额';
comment on column JJHD_ACCINFO_CS.currtype
  is '币种';
comment on column JJHD_ACCINFO_CS.rate
  is '汇率';
comment on column JJHD_ACCINFO_CS.accnotes
  is '存款种类no-无存款current-活期fix-定期ad-通知存款tsad-特色通知存款';
