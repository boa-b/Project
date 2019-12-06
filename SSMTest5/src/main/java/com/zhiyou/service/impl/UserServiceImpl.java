package com.zhiyou.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.UserMapper;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper mapper;

	public User selectByAccounts(HttpServletRequest req, String accounts, String password) {

		User user = mapper.selectByAccounts(accounts);

		if (user.getAccounts() != null) {

			if (user.getPassword().equals(password)) {

				req.getSession().setAttribute("user", user);
				return user;

			} else {

				req.setAttribute("msg", "密码错误，请重新输入");
				return null;
			}
		} else {
			req.setAttribute("msg", "用户名不存在");
			return null;
		}

	}

	public boolean selectByAccountsAjax(String accounts) {

		User user = mapper.selectByAccounts(accounts);
		if (user != null) {
			return false;
		} else {
			return true;
		}
	}

	public void addUser(User user) {
		mapper.adduser(user);

	}

	public void updateuser(User user) {
		mapper.updateuser(user);

	}

	public User selectByID(int id) {
		return mapper.selectByID(id);
	}

	public boolean selectByIdAndPwd(int id, String password) {
		User user = mapper.selectByIdAndPwd(id, password);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean selectByAccountsAndPwd(String accounts, String password) {
		User user = mapper.selectByAccountsAndPwd(accounts, password);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

}
