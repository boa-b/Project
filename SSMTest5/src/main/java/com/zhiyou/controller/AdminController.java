package com.zhiyou.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.model.Admin;
import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.Subject;
import com.zhiyou.model.Video;
import com.zhiyou.service.AdminService;
import com.zhiyou.service.CourseService;
import com.zhiyou.service.SpeakerService;
import com.zhiyou.service.VideoService;
import com.zhiyou.util.FTPUtil;

@Controller
public class AdminController {

	@Autowired
	AdminService service;

	// admin登录
	@RequestMapping("/LoginAdmin")
	public void selectByAccounts(String accounts, String password, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Admin admin = service.selectByAccounts(request, accounts, password);
		System.out.println(admin);
		if (admin != null) {
			request.getRequestDispatcher("view/course.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	@Autowired
	CourseService service1;

	// 课程查询+分页
	@RequestMapping("selectAllCourse")
	public void selectAllCourse(Integer page, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (page == null) {
			page = 1;
		}
		List<Course> list = service1.selectAll((page - 1) * 10, 10);
		int count = service1.count();
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		// System.out.println(list);
		request.getRequestDispatcher("view/courseshow.jsp").forward(request, response);
		// System.out.println("selectAll");
	}

//添加课程  跳转添加页面
	@RequestMapping("addCourse")
	public void addCourse(String accounts, String password, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Subject> list = service1.selectBySubId();
		request.setAttribute("list", list);
		request.getRequestDispatcher("view/alert.jsp").forward(request, response);
	}

//修改课程  跳转修改页面并回显
	@RequestMapping("updateCourse")
	public void updateCourse(Integer id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Course course = service1.selectById(id);
		List<Subject> list = service1.selectBySubId();
		request.setAttribute("list", list);
		request.setAttribute("course", course);
		System.out.println(course);
		request.getRequestDispatcher("view/updateCourse.jsp").forward(request, response);
	}

//添加  修改
	@RequestMapping("/alert")
	public String alert(Course course, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(course);
		if (course.getId() != null) {
			service1.update(course);
			return "forward:selectAllCourse";
		} else {
			service1.add(course);
			return "forward:selectAllCourse";
		}
	}

//删除课程
	@RequestMapping("/deleteCourse")
	public void alert(Integer id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service1.delete(id);

	}

	// 课程批删
	@ResponseBody
	@RequestMapping(value = "dAllC")
	public String dAllC(@RequestParam("userIds[]") Integer[] userIds, HttpServletRequest req,
			HttpServletResponse resp) {

		List<Integer> userIdList = Arrays.asList(userIds);
		int num = service1.dAll(userIdList, resp);
		System.out.println(num);
		if (num == 1 || num == 2 || num == 3) {
			return "ok";
		}
		return "error";

	}

	@Autowired
	VideoService service3;

//视频查询+分页
	@RequestMapping("/videoshow")
	public String videoshow(Integer page, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("video");
		if (page == null) {
			page = 1;
		}
		List<Video> list = service3.selectAllVid((page - 1) * 10, 10);
		int count = service3.countVid();
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("page", page);
		System.out.println(list);
		System.out.println("*********************");
		// 模糊查询下拉框中的值 课程
		List<Subject> list1 = service1.selectBySubId();
		request.setAttribute("list1", list1);
		// 模糊查询下拉框中的值 讲师
		List<Speaker> list2 = service4.selectName();
		request.setAttribute("list2", list2);
		return "view/video/videoShow";
		// return null;
	}

	// 视频批删
	@ResponseBody
	@RequestMapping(value = "dAll")
	public String dAll(@RequestParam("userIds[]") Integer[] userIds, HttpServletRequest req, HttpServletResponse resp) {
		List<Integer> userIdList = Arrays.asList(userIds);
		int num = service3.dAll(userIdList, resp);
		System.out.println(num);
		if (num == 1 || num == 2 || num == 3) {
			return "ok";
		}
		return "error";

	}

	// 视频模糊查询
	@RequestMapping("/videoFuzzy")
	public String videoFuzzy(String title, Integer speaker_id, Integer subject_id, HttpServletRequest request,
			HttpServletResponse response) {
		/*前端给value值 ， 不然400*/
		System.out.println("videoFuzzy");
		System.out.println(title + "**" + speaker_id + "**" + subject_id);
		List<Video> list = service3.selectLike(title, speaker_id, subject_id);

		request.setAttribute("list", list);
		System.out.println(list);
		return "view/video/videoShow";
		// return null;
	}

	// 视频添加
	@RequestMapping("/addVid")
	public String addVid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Subject> list = service1.selectBySubId();
		request.setAttribute("list", list);
		System.out.println("*********************");
		List<Speaker> list2 = service4.selectName();
		request.setAttribute("list2", list2);
		return "view/video/videoAdd";
	}

	// 视频删除
	@RequestMapping("/delVid")
	public void delVid(Integer id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(id);
		service3.deleteVid(id);
	}

//视频修改 跳转页面+回显
	@RequestMapping("/UpVid")
	public String updateVid(Integer id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Video video = service3.selectById(id);
		request.setAttribute("video", video);
		// 查询的是所属课程的id和名字
		List<Subject> list = service1.selectBySubId();
		request.setAttribute("list", list);
		System.out.println("*********************");
		// 查询的是讲师的id和名字
		List<Speaker> list2 = service4.selectName();
		request.setAttribute("list2", list2);
		return "view/video/videoUp";
	}

//添加 修改
	@RequestMapping(value = "/UpAdd", method = RequestMethod.POST)
	public String UpAdd(Video video, MultipartFile image, MultipartFile videourl, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println(image);
		System.out.println(videourl);
		System.out.println(video);
		String string = FTPUtil.upload(image.getInputStream(), image.getOriginalFilename());
		video.setImage_url(string);
		String string2 = FTPUtil.upload(videourl.getInputStream(), videourl.getOriginalFilename());
		video.setVideo_url(string2);
		System.out.println(video);
		if (video.getVideo_id() == null) {
			service3.addVid(video);
			return "forward:videoshow";
		} else {
			service3.updateVid(video);
			return "forward:videoshow";
		}

		// return null;
	}

	@Autowired
	SpeakerService service4;

	// 讲师查询+分页
	@RequestMapping("/speakerShow")
	public void speakerShow(Integer page, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("speaker");
		if (page == null) {
			page = 1;
		}
		List<Speaker> list = service4.selectAllSpea((page - 1) * 10, 10);
		int count = service4.countSpea();
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("paeg", page);

		request.getRequestDispatcher("view/speaker/speakerShow.jsp").forward(request, response);
	}

	// 讲师添加
	@RequestMapping("/speakerAdd")
	public void speakerAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("speakerAdd");

		request.getRequestDispatcher("view/speaker/speakerAdd.jsp").forward(request, response);
	}

	// 讲师修改
	@RequestMapping("/speakerUp")
	public void speakerUp(Integer id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("speakerUp");
		Speaker speaker = service4.selectById(id);
		request.setAttribute("speaker", speaker);
		request.getRequestDispatcher("view/speaker/speakerUp.jsp").forward(request, response);
	}

	/*
	 * 图片的name名与model类中name名不要重复，不然会直接把图片的name封装到model中
	 * 图片单独获取后set到pic_url中
	 * */
	// 具体方法实现 图片上传：讲师头像
	@RequestMapping(value = "/alertSpeaker", method = RequestMethod.POST)
	public void alertSpeaker(MultipartFile pic, Speaker speaker, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String string = FTPUtil.upload(pic.getInputStream(), pic.getOriginalFilename());
		speaker.setPic_url(string);

		if (speaker.getId() == null) {
			service4.addSpea(speaker);
			request.getRequestDispatcher("speakerShow").forward(request, response);
		} else {
			service4.updateSpea(speaker);
			request.getRequestDispatcher("speakerShow").forward(request, response);
		}

	}

	// 讲师删除
	@RequestMapping("/deleteSpeaker")
	public void deleteSpeaker(Integer id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service4.deleteSpea(id);
	}

	// 讲师批删
	@ResponseBody
	@RequestMapping(value = "dAllS")
	public String dAllS(@RequestParam("userIds[]") Integer[] userIds, HttpServletRequest req,
			HttpServletResponse resp) {
		List<Integer> userIdList = Arrays.asList(userIds);
		int num = service4.dAll(userIdList, resp);
		System.out.println(num);
		System.out.println("dAllC**************************************");
		if (num == 1 || num == 2 || num == 3) {
			return "ok";
		}
		return "error";

	}
}
