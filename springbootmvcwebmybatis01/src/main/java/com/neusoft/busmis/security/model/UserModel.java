package com.neusoft.busmis.security.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

//用户的Model类
@Alias("User")
@Data
public class UserModel implements Serializable {
	private String id = null;
	private String password = null;
	private String name = null;
	//private String role = null;
	private int age = 0;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joindate = null;
	private String status = null;
	private String statusname = null;
	private byte[] photo =null;//保存图片
	private  String photoFilename=null;
	private String photoContentType = null;
		
	
	
	//关联的角色列表
	private List<RoleModel> roles=null; 


}
