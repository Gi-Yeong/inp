package com.hb.inp.model;

import java.util.List;

public interface CityDao {

	List selectAll();
	void insertOne(CityVo bean);
	CityVo selectOne(int ID);
	void UpdateOne(CityVo bean);
	void deleteOne(int ID);
	
}
