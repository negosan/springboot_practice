package com.neusoft.busmis.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.busmis.security.dao.IFunctionDao;
import com.neusoft.busmis.security.model.FunctionModel;
import com.neusoft.busmis.security.service.IFunctionService;

@Service("functionService")
@Transactional(rollbackFor=Exception.class)
public class FunctionServiceImpl implements IFunctionService {

	@Autowired
	private IFunctionDao functionDao = null;
	
	@Override
	public void create(FunctionModel function) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(FunctionModel function) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FunctionModel function) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FunctionModel> selectListByAll() throws Exception {
	
		return functionDao.selectListByAll();
	}

	@Override
	public List<FunctionModel> selectListByModule(int moduleNo) throws Exception {
		
		return functionDao.selectListByModule(moduleNo);

	}

	@Override
	public FunctionModel selectByNo(int no) throws Exception {

		return  functionDao.selectByNo(no);

	}

	@Override
	public int selectCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectCountByModule(int moduleNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FunctionModel> selectListByAllWithNestedSelect() throws Exception {

		return functionDao.selectListByAllWithNestedSelect();
	}

	@Override
	public List<FunctionModel> selectListByAllWithNestedResultMap() throws Exception {
		
		return functionDao.selectListByAllWithNestedResultMap();
	}

}
