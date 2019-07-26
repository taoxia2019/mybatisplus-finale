package com.mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mp.dao.UserMapper;
import com.mp.entity.User;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
		List<User> list = userMapper.selectList(null);
		Assert.assertEquals(5, list.size());
		list.forEach(System.out::println);

	}

	@Test
	public void insert() {
		User user = new User();
		user.setAge(31);
		user.setName("中文123");
		user.setManagerId(1094590409767661570L);
		userMapper.insert(user);
	}
	@Test
	public void select1() {
		String name ="王";
		String email="";
		QueryWrapper<User> queryWrapper=new QueryWrapper<>();
		queryWrapper.like(StringUtils.isNotEmpty(name),"name",name)
				.like(StringUtils.isNotEmpty(email),"email",email);
		List<User> list = userMapper.selectList(queryWrapper);
		list.forEach(System.out::println);
	}

	@Test
	public void select2() {
		QueryWrapper<User> queryWrapper=new QueryWrapper<>();
		queryWrapper.select("avg(age) avg_age","min(age) min_age","max(age) max_age")
				.groupBy("manager_id").having("sum(age)<{0}",500);
		List<Map<String, Object>> userlist = userMapper.selectMaps(queryWrapper);
		userlist.forEach(System.out::println);
	}

	@Test
	public void select3() {
		LambdaQueryWrapper<User> lambda = new LambdaQueryWrapper<>();
		lambda.like(User::getName,"王");

		List<User> userlist = userMapper.selectList(lambda);
		userlist.forEach(System.out::println);
	}

	@Test
	public void select4() {

		QueryWrapper<User> queryWrapper=new QueryWrapper<>();
		queryWrapper.ge("age",26);
		Page<User> userPage = new Page<>(2,2);
		IPage<User> userIPage = userMapper.selectPage(userPage, queryWrapper);
		System.out.println(userIPage.getPages());
		System.out.println(userIPage.getTotal());
		System.out.println(userIPage.getSize());
		userIPage.getRecords().forEach(System.out::println);

	}

}
