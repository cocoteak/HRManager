package com.Service;

import java.util.List;
import java.util.Map;

import com.Domian.User;

public interface UserService {
    public User selectUser(String loginname,String PASSWORD);
    
    public List<User> selectAllUser();
    
    public int InsertUser(User user);
    
//    public List<User> selectUserWithParam(User user);
    
    public User selectUserByName(String loginname);
    
    public int updateUser(User user);
    
    public User selectUserById(Integer ID);
    
    public int deleteUser(Integer ID);
    
    public List<User> selectUserWithParamPage(Map map);
    
    public List<User> selectUserAccount(Map map);
}
