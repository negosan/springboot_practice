package com.neusoft.busmis.security.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("Function")
@Data
public class FunctionModel implements Serializable{
	private int funno = 0;
	private String funname = null;
	private String funurl = null;
	
	private ModuleModel module=null; //外键字段对应的类型
}
