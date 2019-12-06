package com.zhiyou.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.AdminMapper;
import com.zhiyou.model.Admin;
import com.zhiyou.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper mapper;

	public Admin selectByAccounts(HttpServletRequest request, String accounts, String password) {
		Admin admin = mapper.selectByAccounts(accounts);
		if (admin != null) {
			if (admin.getPassword().equals(password)) {
				request.getSession().setAttribute("accounts", accounts);
				return admin;
			} else {
				request.setAttribute("msg", "密码错误");
			}
		} else {
			request.setAttribute("msg", "用户名不存在");
		}
		return null;
	}

}
