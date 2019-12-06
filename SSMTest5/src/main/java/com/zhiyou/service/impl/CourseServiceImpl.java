package com.zhiyou.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.CourseMapper;
import com.zhiyou.model.Course;
import com.zhiyou.model.Subject;
import com.zhiyou.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseMapper mapper;

	public List<Course> selectAll(int page, int number) {
		List<Course> list = mapper.selectAll(page, number);
		return list;
	}

	public int count() {
		int count = mapper.count();
		return count;
	}

	public void update(Course course) {
		mapper.update(course);

	}

	public Course selectById(Integer id) {
		Course course = mapper.selectById(id);
		return course;
	}

	public void delete(Integer id) {
		mapper.delete(id);

	}

	public void add(Course course) {
		mapper.add(course);

	}

	public List<Subject> selectBySubId() {
		List<Subject> list = mapper.selectBySubId();
		return list;
	}

	public int dAll(List<Integer> userIdList, HttpServletResponse response) {

		return mapper.dAll(userIdList);
	}

	public List<Course> selectById2(int id) {

		return mapper.selectById2(id);
	}

	public Course selectByCourseid(int id) {
		return mapper.selectByCourseid(id);
	}

}
