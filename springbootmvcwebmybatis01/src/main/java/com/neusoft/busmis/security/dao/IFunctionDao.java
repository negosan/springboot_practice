package com.neusoft.busmis.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.busmis.security.model.FunctionModel;

@Mapper
public interface IFunctionDao {
	public void create(FunctionModel functionModel) throws Exception;

	public void update(FunctionModel functionModel) throws Exception;

	public void delete(FunctionModel functionModel) throws Exception;

	public List<FunctionModel> selectListByAll() throws Exception;
	
	//取得指定的系统功能对象
	public FunctionModel selectByNo(int funno) throws Exception;
	public List<FunctionModel> selectListByAllWithNestedSelect() throws Exception;
	public List<FunctionModel> selectListByAllWithNestedResultMap() throws Exception;
	//取得所有功能的个数
	public int selectCountByAll() throws Exception;
	
	
	//取得指定模块系统功能列表,参数:moduleNo 模块编号
	public List<FunctionModel> selectListByModule(int mno) throws Exception;
	//取得指定模块的功能的个数,参数:moduleNo 模块编号
	public int selectCountByModule(int mno) throws Exception;
}
