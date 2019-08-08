package com.neusoft.busmis.security.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;

@RestController
@RequestMapping("api/user")
//@CrossOrigin
public class UserAPIController {
	
	@Autowired 
	IUserService us ;
	
	/*
	 * 1.单个Controller类内部的异常处理方法
	 * 
	 * @ExceptionHandler 
	 * public ResponseEntity<String> handle(Exception ex) { 
	 * 	return new ResponseEntity<String>(ex.getMessage(),null,HttpStatus.EXPECTATION_FAILED); 
	 * }
	 * 
	 */
	@RequestMapping("/list")
	public List<UserModel> getUsers() throws Exception{
		return us.selectListByAll();
	}
	
	@RequestMapping("/get")
	public UserModel getUser(String userid) throws Exception{
		return us.selectById(userid);
	}
	
	
	
	@RequestMapping(path="/get01/{userid}",method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<UserModel> getUser01(@PathVariable String userid)  throws Exception{
		UserModel um=us.selectById(userid);
		//设定响应头
		MultiValueMap<String, String> headersMap=new LinkedMultiValueMap<String,String>();
		headersMap.add("token", "23333");
		headersMap.add("username", "negosan");
		
		ResponseEntity<UserModel> resultEntity=new ResponseEntity<UserModel>(um,headersMap,HttpStatus.BAD_REQUEST);

		return resultEntity;
	}
	
	@RequestMapping("/get02/{userid}")
	public UserModel getUser(@PathVariable String userid,@RequestHeader("token") String token) throws Exception{
		System.out.println(token);
		return us.selectById(userid);
	}
	
	
	
	
	@PostMapping("/add1")
	public String add(@RequestBody UserModel um) throws Exception{
		
		
		return "OK";
	}
	
	@RequestMapping("/add2")
	public String add(String userid,String password, String username,int age, Date joinDate) 
			throws Exception{
		
		
		return "OK";	
	}
	
	@RequestMapping("/add02")
	public String add(@RequestHeader("user") String userid) throws Exception{
		
		System.out.println(userid);
		return "OK";	
	}
	
	@RequestMapping("/add3")
	public String add3(@PathVariable String userid,@PathVariable String password,
			@PathVariable String username,
			@PathVariable int age, @PathVariable Date joinDate) 
			throws Exception{
		
		
		return "OK";	
	}
	
	//下载指定用户ID的头像
	@RequestMapping(path="/downphoto/{userid}",method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<byte[]> downPhoto(@PathVariable String userid)  throws Exception{
		UserModel um=us.selectById(userid);
		byte[] photo= um.getPhoto();
		//设定响应头
		MultiValueMap<String, String> headersMap=new LinkedMultiValueMap<String,String>();
		headersMap.add("token", "23333");
		headersMap.add("username", "negosan");
		headersMap.add("Content-Type", "image/jpeg");
		
		ResponseEntity<byte[]> resultEntity=new ResponseEntity<byte[]>(photo,headersMap,HttpStatus.BAD_REQUEST);
		return resultEntity;
	}
	
	
	
}
