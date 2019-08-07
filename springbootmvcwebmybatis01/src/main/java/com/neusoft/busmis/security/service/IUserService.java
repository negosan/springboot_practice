package com.neusoft.busmis.security.service;

import java.util.Date;
import java.util.List;

import javax.management.relation.RoleList;

import com.neusoft.busmis.security.model.ModuleModel;
import com.neusoft.busmis.security.model.UserModel;

//用户的业务接口
public interface IUserService {
	// 注册
	public void register(UserModel userModel) throws Exception;

	// 修改用户
	public void modify(UserModel userModel) throws Exception;

	// 修改密码
	public void changePassword(String id, String password) throws Exception;

	// 修改角色
	public void changeRole(String id, String role) throws Exception;

	// 验证用户合法性
	public boolean validate(String id, String password) throws Exception;

	// 激活用户，可以登录
	public void active(String id) throws Exception;

	// 终止用户，此用户不能登录
	public void disable(String id) throws Exception;

	// 删除用户
	public void delete(UserModel userModel) throws Exception;

	public List<UserModel> selectListByAll() throws Exception;
	
	public List<UserModel> getListByAllWithPage(int rows,int page) throws Exception;

	public UserModel selectById(String id) throws Exception;

	//为用户增加角色
	//每次增加一个
	public void addRole(String id, int rno) throws Exception;
	//每次增加多个
	public void addRoles(String id, int[] rnoList) throws Exception;
	
	//取得指定用户角色列表
	public List<RoleList> selectRoleListByUser(String id) throws Exception;
	//判断指定用户是否有指定角色
	public int selectCountByUserAndRoles(String id, int rno) throws Exception;

	public List<UserModel> getListByCondition(int rno,String keyName,int minAge,int maxAge,Date startDate,Date endDate) throws Exception;

	//取得指定用户的模块列表
    public List<ModuleModel> getModuleListByUser(String id) throws Exception;
}
