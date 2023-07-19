package com.korea.k2.charge;

import java.util.List;

public interface EVSearchDao {
	void insertEV(EVSearchVO vo);
	void deleteEV(EVSearchVO vo);
	EVSearchVO editEV(EVSearchVO vo);
	List<EVSearchVO> selectAllEV(EVSearchVO vo);
}
