package com.neusoft.busmis.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.busmis.security.model.RoleModel;

@Mapper
public interface IRoleDao {
	public void create(RoleModel roleModel) throws Exception;

	public void update(RoleModel roleModel) throws Exception;
	
	//为指定角色增加相关模块权限
	public void addModules(@Param("rno")int rno,@Param("mnoList")int[] mnoList) throws Exception;
	//为指定角色删除相关模块权限
	public void deleteModules(int rno) throws Exception;
	
	public void delete(RoleModel roleModel) throws Exception;

	public List<RoleModel> selectListByAll() throws Exception;
	//取得角色列表和其拥有的模块权限
	public List<RoleModel> selectListByAllWithCollectionByNestedResultMap() throws Exception;
	
	//取得指定的角色
	public RoleModel selectByNo(int rno) throws Exception;
	
	//取得所有角色的个数
	public int selectCountByAll() throws Exception;
	
	//取得指定用户的角色列表
	public List<RoleModel> selectListByUser(String userid) throws Exception;
	//取得指定模块的角色列表
	public List<RoleModel> selectListByModule(int mno ) throws Exception; 
	
}
