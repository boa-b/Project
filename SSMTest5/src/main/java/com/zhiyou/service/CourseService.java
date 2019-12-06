package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Course;
import com.zhiyou.model.Subject;

/**
 * 课程增删改查
 * 
 * @author Administrator
 *
 */
public interface CourseService {

	public List<Course> selectAll(int page, int number);

	public int count();

	public void update(Course course);

	public Course selectById(Integer id);

	public void delete(Integer id);

	public void add(Course course);

	public List<Subject> selectBySubId();

	// 批量删除
	public int dAll(List<Integer> userIdList, HttpServletResponse response);
}
