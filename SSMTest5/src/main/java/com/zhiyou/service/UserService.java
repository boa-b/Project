package com.zhiyou.service;

import javax.servlet.http.HttpServletRequest;

import com.zhiyou.model.User;

public interface UserService {
	User selectByAccounts(HttpServletRequest req, String accounts, String passwords);

	boolean selectByAccountsAjax(String accounts);

	void addUser(User user);

	void updateuser(User user);

	User selectByID(int id);

	boolean selectByIdAndPwd(int id, String password);

	boolean selectByAccountsAndPwd(String accounts, String password);
}
