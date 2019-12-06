package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Video;

/**
 * 视频增删改查 分页+模糊查询+批量删除 模糊查询后未分页
 * 
 * @author Administrator
 *
 */
public interface VideoService {

	public List<Video> selectAllVid(int page, int number);

	public int countVid();

	public void addVid(Video video);

	public Video selectById(Integer id);

	public void updateVid(Video video);

	public void deleteVid(Integer id);

	// 模糊查询
	public List<Video> selectLike(String title, Integer speaker_id, Integer subject_id);

	// 批量删除
	public int dAll(List<Integer> userIdList, HttpServletResponse response);
}
