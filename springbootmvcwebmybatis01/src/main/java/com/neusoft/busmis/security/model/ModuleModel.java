package com.neusoft.busmis.security.model;


import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("Module")
@Data
public class ModuleModel implements Serializable {
	private int mno = 0;
	private String mname = null;
	//关联的功能对象列表
	private List<FunctionModel> functions=null;
	//管理的角色对象列表
	private List<RoleModel> roles=null;
}
