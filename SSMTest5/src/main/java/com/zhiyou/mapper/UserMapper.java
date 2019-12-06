package com.zhiyou.mapper;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.User;

// 保持接口的权限定名与mapper中的namespace一致
public interface UserMapper {

	User selectByAccounts(String accounts);

	void adduser(User user);

	void updateuser(User user);

	User selectByID(int id);

	User selectByIdAndPwd(@Param("arg1") int id, @Param("arg2") String password);

	User selectByAccountsAndPwd(@Param("param1") String accounts, @Param("param2") String password);
}
