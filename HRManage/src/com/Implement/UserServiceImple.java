package com.Implement;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.Dao.UserDao;
import com.Domian.User;
import com.Service.UserService;

@Service("userServiceImple")
public class UserServiceImple implements UserService {
	@Resource(name="userDao")
	UserDao userDao;
	
    public User selectUser(String loginname,String PASSWORD){
		return userDao.selectUser(loginname,PASSWORD);
	}

	public List<User> selectAllUser() {
		return userDao.selectAllUser();
	}

	@Override
	public int InsertUser(User user) {
		return userDao.InsertUser(user);
	}
//
//	@Override
//	public List<User> selectUserWithParam(User user) {
//		// TODO Auto-generated method stub
//		return userDao.selectUserWithParam(user);
//	}

	@Override
	public User selectUserByName(String loginname) {
		// TODO Auto-generated method stub
		return userDao.selectUserByName(loginname);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public User selectUserById(Integer integer) {
		// TODO Auto-generated method stub
		return userDao.selectUserById(integer);
	}

	@Override
	public int deleteUser(Integer ID) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(ID);
	}

	@Override
	public List<User> selectUserWithParamPage(Map map) {
		// TODO Auto-generated method stub
		return userDao.selectUserWithParamPage(map);
	}

	@Override
	public List<User> selectUserAccount(Map map) {
		// TODO Auto-generated method stub
		return userDao.selectUserAccount(map);
	}

}
