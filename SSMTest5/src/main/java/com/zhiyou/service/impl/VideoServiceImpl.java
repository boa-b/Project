package com.zhiyou.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.VideoMapper;
import com.zhiyou.model.Video;
import com.zhiyou.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	VideoMapper mapper;

	public List<Video> selectAllVid(int page, int number) {
		List<Video> list = mapper.selectAllVid(page, number);
		return list;
	}

	public int countVid() {
		int count = mapper.countVid();
		return count;
	}

	public void addVid(Video video) {
		mapper.addVid(video);

	}

	public Video selectById(Integer id) {
		Video video = mapper.selectById(id);
		return video;
	}

	public void updateVid(Video video) {
		mapper.updateVid(video);

	}

	public void deleteVid(Integer id) {
		mapper.deleteVid(id);

	}

	public int dAll(List<Integer> userIdList, HttpServletResponse resp) {
		return mapper.dAll(userIdList);
	}

	public List<Video> selectLike(String title, Integer speaker_id, Integer subject_id) {
		List<Video> list = mapper.selectLike(title, speaker_id, subject_id);
		return list;
	}

	public List<Video> selectByCourseid(int id) {
		return mapper.selectByCourseid(id);
	}

	public Video selectById2(int id) {
		return mapper.selectById2(id);
	}
}
