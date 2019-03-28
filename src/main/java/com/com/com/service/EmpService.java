package com.com.com.service;

import java.util.List;
import java.util.Map;

public interface EmpService {

	List<Map<String, Object>> list(Map<String, Object> map);

	Map<String, Object> detail(Map<String, Object> map);

	int insert(Map<String, Object> map);

	int delete(Map<String, Object> map);

	int getCount(Map<String, Object> map);

}
