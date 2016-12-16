package com.hb.inp.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBatisDaoImpl implements GuestDao {

	private static final String NS = "GuestDB.";
	@Autowired
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<GuestVo> selectAll() {
		return sqlSession.selectList(NS+"selectAll");
	}

	@Override
	public void insertOne(GuestVo bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public GuestVo selectOne(int sabun) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdateOne(GuestVo bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOne(int sabun) {
		// TODO Auto-generated method stub

	}

}
