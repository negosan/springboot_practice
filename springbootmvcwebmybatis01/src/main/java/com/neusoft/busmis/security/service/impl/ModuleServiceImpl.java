package com.neusoft.busmis.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.busmis.security.dao.IModuleDao;
import com.neusoft.busmis.security.model.ModuleModel;
import com.neusoft.busmis.security.service.IModuleService;

@Service("moduleService")
@Transactional(rollbackFor=Exception.class)
public class ModuleServiceImpl implements IModuleService {
	
	@Autowired
	private IModuleDao moduleDao = null;

	@Override
	public void add(ModuleModel moduleModel) throws Exception {
		moduleDao.create(moduleModel);	
	}

	@Override
	public void modify(ModuleModel moduleModel) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ModuleModel moduleModel) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ModuleModel getByNo(int no) throws Exception {
				
		return moduleDao.selectByNo(no);

	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ModuleModel> getListByRole(int roleNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkAccessForRole(int moduleNo, int roleNo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<ModuleModel> getListByAll() throws Exception {
	
		return moduleDao.selectListByAll();		
	}

	@Override
	public List<ModuleModel> getListByAllWithCollectionBySNestedSelect() throws Exception {

		return moduleDao.selectListByAllWithCollectionBySNestedSelect();

	}

	@Override
	public List<ModuleModel> getListByAllWithCollectionBySNestedResultMap() throws Exception {

		return moduleDao.selectListByAllWithCollectionBySNestedResultMap();
	}

}
