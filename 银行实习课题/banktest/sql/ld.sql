select user.age 年龄,li.product 理财产品,dai.fangmian 信贷产品 from user,dai,li where user.id = dai.id and dai.id = li.id and user.age = '20岁及以下';
select user.age 年龄,li.product 理财产品,dai.fangmian 信贷产品 from user,dai,li where user.id = dai.id and dai.id = li.id and user.age = '21-25岁';
select user.age 年龄,li.product 理财产品,dai.fangmian 信贷产品 from user,dai,li where user.id = dai.id and dai.id = li.id and user.age != '21-25岁' and user.age != '20岁及以下';
