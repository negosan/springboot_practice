package com.neusoft.busmis.security.service;

import java.util.List;

import com.neusoft.busmis.security.model.ModuleModel;

public interface IModuleService {
	public void add(ModuleModel moduleModel) throws Exception;
	public void modify(ModuleModel moduleModel) throws Exception;
	public void delete(ModuleModel moduleModel) throws Exception;
	
	public List<ModuleModel> getListByAll() throws Exception;
	public List<ModuleModel> getListByAllWithCollectionBySNestedSelect() throws Exception;
	public List<ModuleModel> getListByAllWithCollectionBySNestedResultMap() throws Exception;
	
	public ModuleModel getByNo(int no) throws Exception;
	//取得所有模块的个数
	public int getCountByAll() throws Exception;
	//取得指定角色的模块列表
	public List<ModuleModel> getListByRole(int roleNo) throws Exception;
	//验证指定角色是否有此模块权限: 参数：模块编号，角色编号
	public boolean checkAccessForRole(int moduleNo,int roleNo) throws Exception;

}
