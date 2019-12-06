package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Speaker;

/**
 * 讲师增删改查
 * 
 * @author Administrator
 *
 */
public interface SpeakerService {
	public List<Speaker> selectAllSpea(int page, int number);

	public int countSpea();

	public void addSpea(Speaker speaker);

	public List<Speaker> selectName();

	public Speaker selectById(Integer id);

	public void updateSpea(Speaker speaker);

	public void deleteSpea(Integer id);

	// 批量删除
	public int dAll(List<Integer> userIdList, HttpServletResponse response);

	Speaker selectById2(int id);
}
