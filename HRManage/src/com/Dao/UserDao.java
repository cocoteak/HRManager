package com.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;
import com.Domian.User;
import com.Provider.UserProvider;

@Repository("userDao")
public interface UserDao {
	//登录查询
	@Select("SELECT * FROM user_inf WHERE loginname=#{loginname} and PASSWORD=#{PASSWORD} ")
    public User selectUser(@Param("loginname") String loginname,@Param("PASSWORD")  String PASSWORD);
	
	//通过登录名查询
	@Select("SELECT * FROM user_inf WHERE loginname=#{loginname}")
    public User selectUserByName(@Param("loginname") String loginname);
	
	//全部查询
	@Select("SELECT * FROM user_inf")
    public List<User> selectAllUser();
	
	//通过id查询
	@Select("SELECT * FROM user_inf WHERE ID=#{ID}")
    public User selectUserById(@Param("ID") Integer ID);
	
	//分页查询
	@SelectProvider(type=UserProvider.class,method="selectUserWithPage")
	List<User> selectUserWithParamPage(Map map);
	
	//查询数据总数
	@SelectProvider(type=UserProvider.class,method="selectUserAcount")
	List<User> selectUserAccount(Map map);
	
	//动态插入用户
	@InsertProvider(type=UserProvider.class,method="insertUser")
	@Options(useGeneratedKeys=true,keyProperty="ID")
	int InsertUser(User user);

	//更新用户信息(未更改ID)
	@UpdateProvider(type=UserProvider.class,method="updateUser")
	int updateUser(User user);

	//通过id删除用户
	@Delete("delete from user_inf WHERE ID=#{ID}")
    public int deleteUser(@Param("ID") Integer ID);

}
