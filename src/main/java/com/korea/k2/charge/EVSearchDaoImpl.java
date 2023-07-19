package com.korea.k2.charge;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EVSearchDaoImpl implements EVSearchDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insertEV(EVSearchVO vo) {
		mybatis.insert("EVSearchDao.insertEV", vo);
	}

	@Override
	public List<EVSearchVO> selectAllEV(EVSearchVO vo) {
		return mybatis.selectList("EVSearchDao.selectAllEV", vo);
	}

	@Override
	public void deleteEV(EVSearchVO vo) {
		mybatis.delete("EVSearchDao.deleteEV");
	}

	@Override
	public EVSearchVO editEV(EVSearchVO vo) {
		return mybatis.selectOne("EVSearchDao.editEV", vo);
	}

}
