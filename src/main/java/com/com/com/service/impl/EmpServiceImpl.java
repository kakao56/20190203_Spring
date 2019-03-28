package com.com.com.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.com.com.dao.EmpDao;
import com.com.com.service.EmpService;

@Service("service")
public class EmpServiceImpl implements EmpService {

	@Resource(name="dao")
	private EmpDao empDao;
	
	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return empDao.list(map);
	}

	@Override
	public Map<String, Object> detail(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return empDao.detail(map);
	}

	@Override
	public int insert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return empDao.insert(map);
	}

	@Override
	public int delete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return empDao.delete(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return empDao.getCount(map);
	}

}
