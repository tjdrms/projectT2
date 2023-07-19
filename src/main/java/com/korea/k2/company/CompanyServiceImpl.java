package com.korea.k2.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyDaoImpl dao;

	@Override
	public void insertCompany(CompanyVO vo) {
		dao.insertCompany(vo);
	}

	@Override
	public List<CompanyVO> selectAllCompany(CompanyVO vo) {
		return dao.selectAllCompany(vo);
	}

	@Override
	public CompanyVO selectOneCompany(CompanyVO vo) {
		return dao.selectOneCompany(vo);
	}

	@Override
	public CompanyVO selectOneCompany2(CompanyVO vo) {
		return dao.selectOneCompany2(vo);
	}

}
