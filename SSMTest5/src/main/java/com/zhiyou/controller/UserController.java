package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
import com.zhiyou.util.FTPUtil;
import com.zhiyou.util.MD5Util;

@Controller
public class UserController {

	@Autowired

	UserService service;

	@RequestMapping("/selectByemailAjax")
	private void selectByemailAjax(String accounts, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		boolean b = service.selectByAccountsAjax(accounts);
		resp.getWriter().write(b + "");
	}

	@RequestMapping("/loginUser")
	public void loginUser(String accounts, String password, HttpServletRequest req, HttpServletResponse resp)
			throws Exception, IOException {

		String password5 = MD5Util.getMD5String(password);
		User user = service.selectByAccounts(req, accounts, password5);

		if (user != null) {

			req.setAttribute("user", req.getSession().getAttribute("user"));
			req.getRequestDispatcher("index.jsp").forward(req, resp);

		} else {

			req.setAttribute("msg", req.getAttribute("msg"));
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}

	}

	@RequestMapping("/loginUserajax")
	public void loginUserajax(String loginaccounts, String loginpassword, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		String password5 = MD5Util.getMD5String(loginpassword);
		boolean b = service.selectByAccountsAndPwd(loginaccounts, password5);

		resp.getWriter().write(b + "");
	}

	@RequestMapping("/returnindex")
	public void returnindex(HttpServletRequest req, HttpServletResponse resp) throws Exception, IOException {
		req.setAttribute("user", req.getSession().getAttribute("user"));
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	@RequestMapping("/logout")
	public void logout(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws Exception, IOException {
		session.invalidate();
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	@RequestMapping("/celebrity")
	public String celebrity(HttpServletRequest req, HttpServletResponse resp) {

		User user = (User) req.getSession().getAttribute("user");
		User user1 = service.selectByID(user.getId());
		req.setAttribute("user", user1);
		return "WEB-INF/jsp/celebrity";
	}

	@RequestMapping("/regUser")
	public void regUser(String accounts, String password, String psw_again, HttpServletRequest req,
			HttpServletResponse resp) throws Exception, IOException {

		String password5 = MD5Util.getMD5String(password);

		String psw_again5 = MD5Util.getMD5String(psw_again);
		boolean b = service.selectByAccountsAjax(accounts);
		if (b) {

			if (password5.equals(psw_again5)) {
				User user = new User();
				user.setAccounts(accounts);
				user.setPassword(password5);
				service.addUser(user);
			} else {
				req.setAttribute("msg11", "两次密码不一致");
			}
		} else {
			req.setAttribute("msg12", "账号已经存在");
		}

		req.getRequestDispatcher("index.jsp").forward(req, resp);

	}

	@RequestMapping("/userinfo")
	public String userinfo(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute("user");
		User user1 = service.selectByID(user.getId());
		req.setAttribute("user", user1);
		return "WEB-INF/jsp/userinfo";
	}

	@RequestMapping("/updateinfo")
	public String updateinfo(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute("user");
		User user1 = service.selectByID(user.getId());
		req.setAttribute("user", user1);
		return "WEB-INF/jsp/updateinfo";
	}

	@RequestMapping("/updateinfo2")
	public String updateinfo2(User user, HttpServletRequest req, HttpServletResponse resp) {

		service.updateuser(user);
		User user2 = (User) req.getSession().getAttribute("user");
		User user1 = service.selectByID(user2.getId());
		req.setAttribute("user", user1);
		return "forward:userinfo";
	}

	@RequestMapping("/updatehead")
	public String updatehead(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute("user");
		User user1 = service.selectByID(user.getId());
		req.setAttribute("user", user1);
		return "WEB-INF/jsp/updatehead";
	}

	@RequestMapping("/updatepwd")
	public String updatepwd(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute("user");
		User user1 = service.selectByID(user.getId());
		req.setAttribute("user", user1);
		return "WEB-INF/jsp/updatepwd";
	}

	@RequestMapping("/uploadhead2")
	public String uploadhead2(MultipartFile fileName, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {

		System.out.println(fileName);

		String string = FTPUtil.upload(fileName.getInputStream(), fileName.getOriginalFilename());
		User user = (User) req.getSession().getAttribute("user");
		User user1 = service.selectByID(user.getId());

		user1.setImgurl(string);
		service.updateuser(user1);
		return "forward:userinfo";
	}

	@RequestMapping("oldpassword")
	public void oldpassword(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		User user = (User) req.getSession().getAttribute("user");
		String parameter = req.getParameter("oldpassword");
		String password5 = MD5Util.getMD5String(parameter);
		boolean b = service.selectByIdAndPwd(user.getId(), password5);

		resp.getWriter().write(b + "");
	}

	@RequestMapping("/updatepwd2")
	public String updatepwd2(String oldpassword, String password, String password2, HttpServletRequest req,
			HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute("user");
		String oldpassword2 = MD5Util.getMD5String(oldpassword);

		boolean b = service.selectByIdAndPwd(user.getId(), oldpassword2);
		if (b) {

			if (password.equals(password2)) {
				String password5 = MD5Util.getMD5String(password);
				user.setPassword(password5);

				service.updateuser(user);
				return "forward:userinfo";
			} else {
				req.setAttribute("msg1", "两次密码不一致，请重新输入密码");
				return "forward:updatepwd";
			}

		} else {
			req.setAttribute("msg", "原密码错误，请重新确认原密码");
			return "forward:updatepwd";
		}

	}

	@RequestMapping("regUseraccountsajax")
	public void regUseraccountsajax(String regaccounts, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {

		boolean b = service.selectByAccountsAjax(regaccounts);
		resp.getWriter().write(b + "");
	}
}
