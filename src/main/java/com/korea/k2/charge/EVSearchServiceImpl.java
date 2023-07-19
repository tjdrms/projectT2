package com.korea.k2.charge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EVSearchServiceImpl implements EVSearchService {
	
	@Autowired
	private EVSearchDaoImpl dao;
	
	@Override
	public void insertEV(EVSearchVO vo) {
		dao.insertEV(vo);
	}

	@Override
	public List<EVSearchVO> selectAllEV(EVSearchVO vo) {
		return dao.selectAllEV(vo);
	}

	@Override
	public void deleteEV(EVSearchVO vo) {
		dao.deleteEV(vo);
	}

	@Override
	public EVSearchVO editEV(EVSearchVO vo) {
		return dao.editEV(vo);
	}

}
