package com.neusoft.busmis.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.busmis.security.model.ModuleModel;


@Mapper
public interface IModuleDao {
	public void create(ModuleModel moduleModel) throws Exception;

	public void update(ModuleModel moduleModel) throws Exception;

	public void delete(ModuleModel moduleModel) throws Exception;

	public List<ModuleModel > selectListByAll() throws Exception;
	
	public List<ModuleModel > selectListByAllWithCollectionBySNestedSelect() throws Exception;
	
	public List<ModuleModel > selectListByAllWithCollectionBySNestedResultMap() throws Exception;
	
	public ModuleModel  selectByNo(int mno) throws Exception;
	
	//取所有模块个数
	public int selectCountByAll() throws Exception;
	//取指定角色的模块列表
	public List<ModuleModel > selectListWithRole() throws Exception;
	//取指定模块和角色的关联个数，用于业务层判断角色对此模块是否有权限
	public int selectCountWithRole() throws Exception;
}
