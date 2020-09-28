select user.age 年龄,cun.product 存款产品,li.product 理财产品 from user,cun,li where user.age = '20岁及以下' and user.id = cun.id and cun.id = li.id;
select user.age 年龄,cun.product 存款产品,li.product 理财产品 from user,cun,li where user.age = '21-25岁' and user.id = cun.id and cun.id = li.id;
select user.age 年龄,cun.product 存款产品,li.product 理财产品 from user,cun,li where user.age != '20岁及以下' and user.age != '21-25岁' and user.id = cun.id and cun.id = li.id;
