package com.zhiyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.SubjectMapper;
import com.zhiyou.model.Subject;
import com.zhiyou.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	SubjectMapper mapper;

	public Subject selectById(int id) {
		return mapper.selectById(id);
	}

}
