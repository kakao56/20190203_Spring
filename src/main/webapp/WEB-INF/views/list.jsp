<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<style type="text/css">
#page_num_area {
float: left;
text-align: center;
}

.page_button {
	padding: 5px;
	display: inline-block;
}

.page_area {
	border: 1px solid #dedede;
	border-radius: 5px;
	text-align: center;
	padding: 0;
}

.page_area a {
	color: rgba(0, 84, 255);
}

.page_disable {
	display: inline-block;
	color: #ababab;
}

.page_selected {
	font-size: 20px;
	font-weight: bold;
} 
</style>

<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function goPage(pg){
		alert(pg);
	}
</script>
</head>
<body>
	<h1>자유게시판</h1> 
	<form>
		<div id="searchdv">
			<select name="searchType">
				<option value="전체">전체</option>
				<option value="사번">사번</option>
				<option value="이름">이름</option>
				<option value="부서명">부서명</option>
			</select>
			<input type="text" name="searchValue">
			<input type="button" value="검색">
		</div>
	</form>
		<input type="button" value="글쓰기">
		<input type="button" value="삭제">
	<form>
		<div id="listdv">
			<table border="">
				<thead>
					<tr> 
						<th>사번</th>
						<th>이름</th>
						<th>직업</th>
						<th>부서명</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list ne null }">
						<c:forEach items="${list}" var="item" step="1" >
							<tr>
								<td><a href="empdetail?employee_id=${item.emp_id}">${item.emp_id}</a></td>
								<td>${item.l_name}</td>
								<td>${item.job_id}</td>
								<td>${item.dept_id}</td>
							</tr> 
						</c:forEach>					
					</c:if>
					<c:if test="${list eq null }">
						<tr>
							<td colspan="4">검색된 데이터가 없습니다.</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</div>
	</form>
	${pageCode}
	<form>
		<div id="pagedv" style="display: none;">
			<input type="hidden" value="${searchType }" name="searchType">
			<input type="hidden" value="${searchValue }" name="searchValue">
		</div>
	</form>
	안녕하세요~~ hi ㅋㅋㅋㅋ pom.xml 복사 했습니다. 된거 같습니다. 진짭니다 재식작 안합니다. 인코딩 수정
	호이 한번더 호이
</body>
</html>