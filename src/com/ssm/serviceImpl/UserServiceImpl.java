package com.ssm.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.UserDao;
import com.ssm.service.UserService;

@Service("UserService")
public class UserServiceImpl implements  UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public String findUser(String username, String password) {
		
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("password", password);
		map.put("username", username);
		Map<String,Object> map2= userDao.findUser(map);
		System.out.println(map2);
		if(map2!= null){
			return "登录成功";
		}else{
			return "登录失败";
		}
		
	}

	@Override
	public String addApplyUser(String username, String password,String a) {
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("username", username);
		map.put("password", password);
		map.put("picture_url", a);
		int c=userDao.addApplyUser(map);
		if(c!= 0){
			return "";
		}else{
			return "";
		}

	}

}
