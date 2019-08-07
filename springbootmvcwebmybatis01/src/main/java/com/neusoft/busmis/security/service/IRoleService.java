package com.neusoft.busmis.security.service;

import java.util.List;

import com.neusoft.busmis.security.model.RoleModel;

public interface IRoleService {
	public void add(RoleModel role) throws Exception;
	
	//为指定角色增加相关模块权限
    public void addModules(int rno,int[] mnoList) throws Exception;
    //为指定角色删除相关模块权限
    public void deleteModules(int rno) throws Exception; 
    
	public void modify(RoleModel role) throws Exception;
	
	public void delete(RoleModel role) throws Exception;
	//取得所有角色
	public List<RoleModel> getListByAll() throws Exception;
	//取得角色列表和其拥有的模块权限
	public List<RoleModel> getListByAllWithCollectionByNestedResultMap() throws Exception; 
	
	public RoleModel selectByNo(int no) throws Exception;
	
	//取得指定用户的角色列表
	public List<RoleModel> getListByUser(String userid) throws Exception;
	//取得指定模块的角色列表
	public List<RoleModel> getListByModule(int mno ) throws Exception;
}
