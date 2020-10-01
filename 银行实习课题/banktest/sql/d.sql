select user.age 年龄,dai.fangmian 贷款产品 from user,dai where user.id = dai.id and user.age = '20岁及以下';
select user.age 年龄,dai.fangmian 贷款产品 from user,dai where user.id = dai.id and user.age = '21-25岁';
select user.age 年龄,dai.fangmian 贷款产品 from user,dai where user.id = dai.id and user.age != '21-25岁' and user.age != '20岁及以下';