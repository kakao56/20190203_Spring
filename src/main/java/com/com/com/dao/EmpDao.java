package com.com.com.dao;

import java.util.List;
import java.util.Map;

public interface EmpDao {

	int getCount(Map<String, Object> map);

	List<Map<String, Object>> list(Map<String, Object> map);

	Map<String, Object> detail(Map<String, Object> map);

	int insert(Map<String, Object> map);

	int delete(Map<String, Object> map);


}
