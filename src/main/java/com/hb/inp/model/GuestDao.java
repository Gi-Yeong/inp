package com.hb.inp.model;

import java.util.List;

public interface GuestDao {
	
	List selectAll();
	void insertOne(GuestVo bean);
	GuestVo selectOne(int sabun);
	void UpdateOne(GuestVo bean);
	void deleteOne(int sabun);
	
}
