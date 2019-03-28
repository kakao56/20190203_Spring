package com.com.com.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.com.com.dao.EmpDao;

@Repository("dao")
public class EmpDaoImpl implements EmpDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int getCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.getCount",map);
	}

	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.list", map);
	}

	@Override
	public Map<String, Object> detail(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.select", map);
	}

	@Override
	public int insert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.insert("mapper.insert", map);
	}

	@Override
	public int delete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.delete("mapper.delete", map);
	}

}
