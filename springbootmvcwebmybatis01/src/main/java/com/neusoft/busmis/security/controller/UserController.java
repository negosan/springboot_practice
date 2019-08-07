package com.neusoft.busmis.security.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService us ;
	
	@RequestMapping("/tolist")
	public String tolist(Model model) throws Exception {
		List<UserModel> userlist = us.selectListByAll();
		model.addAttribute("userlist",userlist);
		return "user/list";
	}
	
	
	@RequestMapping("/tologin")
	public String tologin() throws Exception {
		return "user/login";
	}
	
	@RequestMapping("/login")
	public String login(String id,String password) throws Exception {
		if(us.validate(id, password)) {		
			return "user/list";
		}
		else {
			return "user/login";
		}
	}
	
	@RequestMapping("/toregister")
	public String toregister() throws Exception {
		return "user/register";
	}

	//有头像上传的用户注册
	@RequestMapping("/register")
	public String register(UserModel um, @RequestParam(required=false) MultipartFile photo) throws Exception{
		
		if(photo==null||photo.isEmpty()) {
			System.out.println("无文件");
		}
		else {
			//取得文件的名
			String fileName=photo.getOriginalFilename();
			//取得文件的类型
			String contentType=photo.getContentType();
			um.setPhoto(photo.getBytes()); //设置到Model对象的属性。
			um.setPhotoFilename(fileName);
			um.setPhotoContentType(contentType);
			//把文件保存到指定的目录d:\\upload
			photo.transferTo(new File("classpasth:"+fileName));
					
		}
		
		us.register(um);
		System.out.println("注册处理");
		return "user/list";
		
	}
	
}