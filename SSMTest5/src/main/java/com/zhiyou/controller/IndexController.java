package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.Course;
import com.zhiyou.model.Video;
import com.zhiyou.service.CourseService;
import com.zhiyou.service.SpeakerService;
import com.zhiyou.service.SubjectService;
import com.zhiyou.service.VideoService;

@Controller
public class IndexController {

	@Autowired
	CourseService Service;
	@Autowired
	SubjectService Servicesub;
	@Autowired
	VideoService Servicevd;
	@Autowired
	SpeakerService Servicesp;

	@RequestMapping("/showclass")
	public String showclass(Integer subject_id, HttpServletRequest req, HttpServletResponse resp) {

		// 传session 判断是否登陆
		req.setAttribute("user", req.getSession().getAttribute("user"));

		// 公开课
		req.setAttribute("subject", Servicesub.selectById(subject_id));

		// 打开点击的课程
		List<Course> Courselist = Service.selectById2(subject_id);
		req.setAttribute("Courselist", Courselist);

		//
		for (int i = 0; i < Courselist.size(); i++) {
			List<Video> listvideo = Servicevd.selectByCourseid(Courselist.get(i).getId());
			req.setAttribute("listvideo" + i, listvideo);
		}

		return "WEB-INF/jsp/showclass";
	}

	@RequestMapping("/playvideo")
	public String courseinfo(Integer course_id, Integer speaker_id, Integer video_id, HttpServletRequest req,
			HttpServletResponse resp) {

		req.setAttribute("user", req.getSession().getAttribute("user"));
		// 通过speeaker_id 查询到相应的speaker信息，传给playvideo.jsp的讲师信息模块
		req.setAttribute("speaker", Servicesp.selectById(speaker_id));
		// 通过showclass传入的video_id搜索到相应的video信息，传给playvideo.jsp的本节内容模块
		req.setAttribute("video", Servicevd.selectById(video_id));
		// 通过showclass传入的course_id搜索到相应的course信息，传给playvideo.jsp的课程介绍模块

		req.setAttribute("course", Service.selectByCourseid(course_id));
		Course course = Service.selectByCourseid(course_id);
		req.setAttribute("subject", Servicesub.selectById(course.getSubject_id()));

		// 根据course_id查询相应的video 传入到playvideo.jsp的目录模块
		List<Video> listvideo = Servicevd.selectByCourseid(course_id);
		req.setAttribute("listvideo", listvideo);
		return "WEB-INF/jsp/playvideo";
	}
}
