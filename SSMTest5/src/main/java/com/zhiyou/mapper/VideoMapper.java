package com.zhiyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Video;

public interface VideoMapper {

	public List<Video> selectAllVid(@Param("a1") int page, @Param("a2") int number);

	public int countVid();

	public void addVid(Video video);

	public Video selectById(Integer id);

	public void updateVid(Video video);

	public void deleteVid(Integer id);

	// 模糊查询
	public List<Video> selectLike(@Param("title") String title, @Param("speaker_id") Integer speaker_id,
			@Param("subject_id") Integer subject_id);

	public int dAll(@Param("userIdList") List<Integer> userIdList);
}
