package com.neusoft.busmis.security.dao;

import java.util.Date;

import java.util.List;

import javax.management.relation.RoleList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.busmis.security.model.ModuleModel;
import com.neusoft.busmis.security.model.UserModel;

@Mapper
public interface IUserDao {

	public void create(UserModel userModel) throws Exception;
	
	public void createWithPhoto(UserModel userModel) throws Exception;


	public void update(UserModel userModel) throws Exception;

	public void delete(UserModel userModel) throws Exception;

	public List<UserModel> selectListByAll() throws Exception;
	
	public List<UserModel> selectListByAllWithRoles() throws Exception;
	
	//start:起始记录号  rows:取的个数
	public List<UserModel> selectListByAllWithPage(@Param("start") int start,@Param("rows")int rows) throws Exception;

	public UserModel selectById(String id) throws Exception;
	
	
	//为用户增加角色
	//每次增加一个
	public void addRole(@Param("id")String id,@Param("rno") int rno) throws Exception;
	//每次增加多个
	public void addRoles(@Param("id")String id,@Param("rnoList") int[] rnoList) throws Exception;
	//删除指定用户的角色列表
	public void deleteRoles(String id) throws Exception;
	//取得指定用户角色列表
	public List<RoleList> selectRoleListByUser(String id) throws Exception;
	//判断指定用户是否有指定角色
	public int selectCountByUserAndRoles(@Param("id")String id,@Param("rno") int rno) throws Exception;
	//按检索条件取得用的列表
	//
	public List<UserModel> selectListByCondition(@Param("rno")int rno,@Param("keyName")String keyName,
			@Param("minAge")int minAge,@Param("maxAge")int maxAge,@Param("startDate")Date startDate,@Param("endDate")Date endDate) throws Exception;
	//取得指定用户的模块列表
	public List<ModuleModel> selectModuleListByUser(String id) throws Exception;
}
