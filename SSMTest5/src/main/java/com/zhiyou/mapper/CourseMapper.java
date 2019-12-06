package com.zhiyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Course;
import com.zhiyou.model.Subject;

public interface CourseMapper {

	public List<Course> selectAll(@Param("a1") int page, @Param("a2") int number);

	public int count();

	public void update(Course course);

	public List<Subject> selectBySubId();

	public Course selectById(Integer id);

	public void delete(Integer id);

	public void add(Course course);

	public int dAll(@Param("userIdList") List<Integer> userIdList);

	List<Course> selectById2(int id);

	Course selectByCourseid(int id);
}
