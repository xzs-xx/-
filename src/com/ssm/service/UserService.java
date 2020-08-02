package com.ssm.service;

import java.util.List;

import com.ssm.entity.User;

public interface UserService {
	String findUser(String username, String password);
	String addApplyUser(String username, String password, String a);

}
