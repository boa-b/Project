package com.zhiyou.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.SpeakerMapper;
import com.zhiyou.model.Speaker;
import com.zhiyou.service.SpeakerService;

@Service
public class SpeakerServiceImpl implements SpeakerService {

	@Autowired
	SpeakerMapper mapper;

	public List<Speaker> selectAllSpea(int page, int number) {
		List<Speaker> list = mapper.selectAllSpea(page, number);
		return list;
	}

	public int countSpea() {
		int count = mapper.countSpea();
		return count;
	}

	public void addSpea(Speaker speaker) {
		mapper.addSpea(speaker);

	}

	public Speaker selectById(Integer id) {
		Speaker speaker = mapper.selectById(id);
		return speaker;
	}

	public void updateSpea(Speaker speaker) {
		mapper.updateSpea(speaker);

	}

	public void deleteSpea(Integer id) {
		mapper.deleteSpea(id);

	}

	public List<Speaker> selectName() {
		List<Speaker> list = mapper.selectName();
		return list;
	}

	public int dAll(List<Integer> userIdList, HttpServletResponse response) {

		return mapper.dAll(userIdList);
	}

	public Speaker selectById2(int id) {
		// TODO Auto-generated method stub
		return mapper.selectById2(id);

	}

}
