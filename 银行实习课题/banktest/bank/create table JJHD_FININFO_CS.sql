-- Create table
create table JJHD_FININFO_CS
(
  userno   VARCHAR2(19),
  username VARCHAR2(60),
  proname  VARCHAR2(100),
  buyamt   VARCHAR2(17),
  nowamt   VARCHAR2(17)
)
-- Add comments to the table 
comment on table JJHD_FININFO_CS
  is '理财信息表（所有非存款）cs';
-- Add comments to the columns 
comment on column JJHD_FININFO_CS.userno
  is '人员编号';
comment on column JJHD_FININFO_CS.username
  is '人员姓名';
comment on column JJHD_FININFO_CS.proname
  is 'no-无产品ipvs0120lc-理财产品-...';
comment on column JJHD_FININFO_CS.buyamt
  is '买入时总价';
comment on column JJHD_FININFO_CS.nowamt
  is '查询点估值';
