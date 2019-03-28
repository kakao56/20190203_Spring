package com.com.com.util;

public class PageUtil {
	private int nowPage, totalCount, pagePerSize, pagePerBlock, totalPage, startPage, endPage, begin, end;

	private boolean isPrePage;
	private boolean isNextPage;
	
	private StringBuffer pageCode;
	
	public PageUtil(int nowPage, int totalCount, 
			int pagePerSize, int pagePerBlock) {
		this.nowPage = nowPage;
		this.totalCount = totalCount;
		this.pagePerSize = pagePerSize;
		this.pagePerBlock = pagePerBlock;
		isPrePage = false;
		isNextPage = false;
		totalPage = (int)Math.ceil((double)totalCount/pagePerSize);
		if(nowPage > totalPage)
			nowPage = totalPage;
		startPage = (int)((nowPage-1)/pagePerBlock) * pagePerBlock + 1;
		endPage = startPage + pagePerBlock - 1;
		if(endPage > totalPage)
			endPage = totalPage;
		begin = (nowPage - 1) * pagePerSize + 1;
		end = begin + pagePerSize - 1;
		if(startPage > 1)
			isPrePage = true;
		if(endPage < totalPage)
			isNextPage = true;

		pageCode = new StringBuffer("<div id='page_num_area'><ol class='page_area'>");
		
		if(isPrePage) { //이전 페이지 세트가 존재하면
			pageCode.append("<li class='page_button'><a href='javascript:goPage(");
			pageCode.append(nowPage - pagePerBlock);
			pageCode.append(")'> &lt; </a></li>");
		}else { //이전 페이지세트로 못가는 경우
			pageCode.append("<li class='page_button page_disable'>  &lt; </li>");
		}
		
		// 페이지세트의 숫자페이지를 만든다
		for(int i=startPage ; i<=endPage ; i++) {
			if(i == nowPage) {//현재 선택한 페이지이면
				pageCode.append("<li class='page_button page_selected'>");
			}else {//선택하지 않은 페이지
				pageCode.append("<li class='page_button'>");
			}			
			pageCode.append("<a href='javascript:goPage(");
			pageCode.append(i);
			pageCode.append(")'>");
			pageCode.append(i);
			pageCode.append("</a></li>");
		}
		//다음페이지세트가 존재하는 경우
		if(isNextPage) {
			pageCode.append("<li class='page_button'><a href='javascript:goPage(");
			pageCode.append(nowPage + pagePerBlock);
			pageCode.append(")'> &gt; </a></li>");
		}else {
			pageCode.append("<li class='page_button page_disable'> &gt; </li>");
		}
		pageCode.append("</ol></div>");
		
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int gettotalCount() {
		return totalCount;
	}

	public void settotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getpagePerSize() {
		return pagePerSize;
	}

	public void setpagePerSize(int pagePerSize) {
		this.pagePerSize = pagePerSize;
	}

	public int getpagePerBlock() {
		return pagePerBlock;
	}

	public void setpagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean isPrePage() {
		return isPrePage;
	}

	public void setPrePage(boolean isPrePage) {
		this.isPrePage = isPrePage;
	}

	public boolean isNextPage() {
		return isNextPage;
	}

	public void setNextPage(boolean isNextPage) {
		this.isNextPage = isNextPage;
	}

	public StringBuffer getpageCode() {
		return pageCode;
	}

	public void setpageCode(StringBuffer pageCode) {
		this.pageCode = pageCode;
	}
	
}
