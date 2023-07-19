package com.korea.k2.company;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insertCompany(CompanyVO vo) {
		mybatis.insert("CompanyDao.insertCompany", vo);
	}

	@Override
	public List<CompanyVO> selectAllCompany(CompanyVO vo) {
		return mybatis.selectList("CompanyDao.selectAllCompany");
	}

	@Override
	public CompanyVO selectOneCompany(CompanyVO vo) {
		return mybatis.selectOne("CompanyDao.selectOneCompany", vo);
	}

	@Override
	public CompanyVO selectOneCompany2(CompanyVO vo) {
		return mybatis.selectOne("CompanyDao.selectOneCompany2", vo);
	}

}
