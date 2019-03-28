package com.com.com.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.com.com.service.EmpService;
import com.com.com.util.PageUtil;

@Controller
public class EmpController {
	
	@Resource(name="service")
	private EmpService empService;
	
	private int nowPage, totalCount, pagePerBlock=5, pagePerSize=10;
	
	@RequestMapping("emplist")
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		ModelAndView mv = new ModelAndView("list");
		List<Map<String, Object>> list = null;
		if(map.get("nowPage") != null)
			nowPage = Integer.parseInt(map.get("nowPage").toString());
		else {
			nowPage = 1;
			map.put("searchType","");
			map.put("searchValue","");
		}
		totalCount = empService.getCount(map);
		
		PageUtil page = new PageUtil(nowPage, totalCount, pagePerSize, pagePerBlock);
		
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		
		list = empService.list(map);
		if(list == null)
			System.out.println("조회할 데이터가 없습니다.");
		else {
			mv.addObject("list",list);
			mv.addObject("nowPage", page.getNowPage());
			mv.addObject("searchType", map.get("searchType"));
			mv.addObject("searchVluae", map.get("searchValue"));
			mv.addObject("pageCode",page.getpageCode());
			
		
		}
		
		return mv;
	}
	
	@RequestMapping("empdetail")
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		ModelAndView mv = new ModelAndView();
		Map<String , Object> item = null;
		item = empService.detail(map);
		if(item == null)
			System.out.println("선택한 사원을 조회할 수 없습니다.");
		else
			mv.addObject("item", item);
		return mv;
	}
	
	@RequestMapping("empinsert")
	public String insert(@RequestParam Map<String, Object> map) {
		int cnt = 0;
		cnt = empService.insert(map);
		if(cnt == 0)
			System.out.println("데이터 등록 오류");
		return "redirect:emplist";
	}
	
	@RequestMapping("empdelete")
	public String delete(@RequestParam Map<String, Object> map) {
		int cnt = 0;
		cnt = empService.delete(map);
		if(cnt == 0)
			System.out.println("데이터 삭제 오류");
		return "redirect:emplist";
	}


}
