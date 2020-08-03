package com.ssm.dao;

import java.util.Map;

import com.ssm.entity.User;

public interface UserDao {

	Map<String, Object> findUser(Map<String, Object> map);
	int addApplyUser(Map<String, Object> map);
	User findUsername(Map<String, Object> map);
}
