package com.ssm.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssm.entity.User;
import com.ssm.service.UserService;

/**
 * ��¼���
 * @author ��
 *2019/6/15
 */
@Controller
//@RequestMapping("/jsp")
public class LoginController {
	
	@Autowired
	private UserService userService;
	@ResponseBody
	@RequestMapping("login.do")
	public String login(String username,String password,HttpServletResponse rep,HttpServletRequest req,HttpSession session){
		//����session��Ϣ
		session.setAttribute("username", username);
		return userService.findUser(username,password);
	}
	@ResponseBody
	@RequestMapping("apply.do")
	public String addApplyUser(String username,String password,MultipartFile items_pic) throws Exception {
		String ori = items_pic.getOriginalFilename();//��ʼ���ļ�����
		String pic_path="";
		//�ϴ�ͼƬ
		if(items_pic!=null && ori !=null && ori.length()>0){
			pic_path = "D:\\update\\";
			String newFilename = UUID.randomUUID()+ori.substring(ori.lastIndexOf("."));
			//�µ�ͼƬ
			File newfile = new File(pic_path+newFilename);
			String a=pic_path+newFilename;
			System.out.println(a);
			items_pic.transferTo(newfile);
			System.out.println(newfile);
			return userService.addApplyUser(username,password,a);
			
		}else{
			return "index";
		}
	}
}
