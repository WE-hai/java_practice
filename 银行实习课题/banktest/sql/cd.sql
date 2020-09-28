select user.age 年龄,cun.product 存款产品,dai.fangmian 信贷产品 from user,cun,dai where user.id = cun.id and cun.id = dai.id and user.age = '20岁及以下';
select user.age 年龄,cun.product 存款产品,dai.fangmian 信贷产品 from user,cun,dai where user.id = cun.id and cun.id = dai.id and user.age = '21-25岁';
select user.age 年龄,cun.product 存款产品,dai.fangmian 信贷产品 from user,cun,dai where user.id = cun.id and cun.id = dai.id and user.age != '21-25岁' and user.age != '20岁及以下';
