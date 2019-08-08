package com.neusoft.busmis.security.service.impl;

import java.util.Date;
import java.util.List;

import javax.management.relation.RoleList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.busmis.security.dao.IUserDao;
import com.neusoft.busmis.security.model.ModuleModel;
import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;

//用户的业务实现类
@Service("userService")
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements IUserService {
	

	//@Autowired
	//private SqlSessionFactory sessionFactory=null;
	
	@Autowired
	private IUserDao userDao=null ;

	
	@Value("${server.port}")
	private String port = null;
	/*
	 * public void setUserDao(IUserDao userDao) { this.userDao = userDao; }
	 */
	/*
	 * 
	 * public void setSessionFactory(SqlSessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 * 
	 * 
	 * public UserServiceImpl() { //System.out.println("默认构造方法。。。"); }
	 * 
	 * //@Autowired public UserServiceImpl(SqlSessionFactory sessionFactory) {
	 * //System.out.println("带参构造方法。。。"); this.sessionFactory = sessionFactory; }
	 * 
	 */

	@Override
	public void register(UserModel userModel) throws Exception {	
		if(userModel.getPhotoFilename()!=null) {
			userDao.createWithPhoto(userModel);
		}
		else {
			userDao.create(userModel);	
		}
		
	}

	@Override
	public void modify(UserModel userModel) throws Exception {
		userDao.update(userModel);
	}

	@Override
	public void changePassword(String id, String password) throws Exception {

	}

	@Override
	public void changeRole(String id, String role) throws Exception {


	}

	@Override
	public boolean validate(String id, String password) throws Exception {

		boolean result = false;
		UserModel um = userDao.selectById(id);
		if (um != null && um.getPassword() != null && um.getPassword().equals(password)) {
			result = true;
		}
		return result;
	}

	@Override
	public void active(String id) throws Exception {
			
		UserModel um = userDao.selectById(id);
		um.setStatus("Y");
		userDao.update(um);

	}

	@Override
	public void disable(String id) throws Exception {
		
		UserModel um = userDao.selectById(id);
		um.setStatus("N");
		userDao.update(um);

	}

	@Override
	public void delete(UserModel userModel) throws Exception {
		
		userDao.delete(userModel);
	}

	@Override
	public List<UserModel> selectListByAll() throws Exception {
		System.out.println("实例启动端口："+port);
		return userDao.selectListByAll();
	}
	
	

	@Override
	public List<UserModel> getListByAllWithPage(int rows, int page) throws Exception {
	
		return userDao.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public UserModel selectById(String id) throws Exception {
			
		return userDao.selectById(id);
	}

	@Override
	public void addRole(String id, int rno) throws Exception {

		userDao.deleteRoles(id);
		userDao.addRole(id, rno);

	}

	@Override
	public void addRoles(String id, int[] rnoList) throws Exception {

		userDao.deleteRoles(id);
		userDao.addRoles(id, rnoList);
	}

	@Override
	public List<RoleList> selectRoleListByUser(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectCountByUserAndRoles(String id, int rno) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserModel> getListByCondition(int rno, String keyName, int minAge, int maxAge, Date startDate,
			Date endDate) throws Exception {
		
		if(keyName!=null&&keyName.trim().length()>0) {
			keyName= "%"+keyName+"%";
		}
		return userDao.selectListByCondition(rno, keyName, minAge, maxAge, startDate, endDate);	
	}

	@Override
	public List<ModuleModel> getModuleListByUser(String id) throws Exception {

		return userDao.selectModuleListByUser(id);
	}
	
}
