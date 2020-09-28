select user.age 年龄,cun.product 存款产品 from user,cun where user.age = '21-25岁' and user.cunkuan != '1万元以下' and  user.id = cun.id;
select user.age 年龄,cun.product 存款产品 from user,cun where user.age = '21-25岁' and user.cunkuan = '1万元以下' and user.id = cun.id;
select user.age 年龄,cun.product 存款产品 from user,cun where user.age != '21-25岁' and user.age != '20岁及以下' and user.id = cun.id;