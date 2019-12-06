package com.zhiyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Speaker;

public interface SpeakerMapper {

	public List<Speaker> selectAllSpea(@Param("a1") int page, @Param("a2") int number);

	public int countSpea();

	public List<Speaker> selectName();

	public void addSpea(Speaker speaker);

	public Speaker selectById(Integer id);

	public void updateSpea(Speaker speaker);

	public void deleteSpea(Integer id);

	public int dAll(@Param("userIdList") List<Integer> userIdList);

	Speaker selectById2(int id);
}
