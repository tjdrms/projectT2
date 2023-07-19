package com.korea.k2.company;

import java.util.List;

public interface CompanyDao {
	void insertCompany(CompanyVO vo);
	CompanyVO selectOneCompany(CompanyVO vo);
	CompanyVO selectOneCompany2(CompanyVO vo);
	List<CompanyVO> selectAllCompany(CompanyVO vo);
}
