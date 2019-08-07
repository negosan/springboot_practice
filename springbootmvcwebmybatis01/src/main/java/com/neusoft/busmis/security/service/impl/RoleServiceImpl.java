package com.neusoft.busmis.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.busmis.security.dao.IRoleDao;
import com.neusoft.busmis.security.model.RoleModel;
import com.neusoft.busmis.security.service.IRoleService;

@Service("roleService")
@Transactional(rollbackFor=Exception.class)
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private IRoleDao roleDao = null;

	@Override
	public void add(RoleModel role) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(RoleModel role) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(RoleModel role) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RoleModel> getListByAll() throws Exception {
	
		return roleDao.selectListByAll();	
	}

	@Override
	public RoleModel selectByNo(int no) throws Exception {
		
		return roleDao.selectByNo(no);	
	}

	@Override
	public List<RoleModel> getListByUser(String userid) throws Exception {
		
		return roleDao.selectListByUser(userid);		
	}

	@Override
	public List<RoleModel> getListByModule(int mno) throws Exception {

		return roleDao.selectListByModule(mno);	
	}

	@Override
	public List<RoleModel> getListByAllWithCollectionByNestedResultMap() throws Exception {

		return roleDao.selectListByAllWithCollectionByNestedResultMap();

	}

	@Override
	public void addModules(int rno, int[] mnoList) throws Exception {

		roleDao.addModules(rno, mnoList);
	}

	@Override
	public void deleteModules(int rno) throws Exception {

		roleDao.deleteModules(rno);
	}

}
