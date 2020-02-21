<%@page import="com.tj.model1ex.dto.CustomerDto"%>
<%@page import="com.tj.model1ex.dto.FileBoardDto"%>
<%@page import="com.tj.model1ex.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style2.css">
<style>
#content_form {
	width: 1000px;
	margin: 0px auto;
	height: 600px;
	text-align: center;
	color: #003300;
	padding-top:100px;
}
</style>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div id="content_form">
	<%
	String pageNum=request.getParameter("pageNum");
	if(pageNum==null) pageNum="1";
	if(request.getParameter("fnum")==null){
		response.sendRedirect("fboardList.jsp");
	}
	int fnum =Integer.parseInt(request.getParameter("fnum"));
	FileBoardDao fDao = FileBoardDao.getInstance();
	FileBoardDto dto = fDao.getFileBoard(fnum);
	CustomerDto customer = (CustomerDto)session.getAttribute("customer");
%>
	<table>
		<caption>글 내용 상세보기</caption>
		<tr><th>글번호</th><td><%=fnum %></td></tr>
		<tr><th>글제목</th><td><%=dto.getFsubject() %></td></tr>
		<tr><th>작성자</th><td><%=dto.getCname() %>(<%=dto.getCemail()==null?" - ":dto.getCemail() %>)</td></tr>
		<tr><th>첨부파일</th><td><%
		if(dto.getFfilename()==null){
			out.print("첨부파일 없음");
		}else{%>
			<a href="../fileboardUpload/<%=dto.getFfilename() %>" target="_blank"><%=dto.getFfilename() %></a>
		<%}
		%></td></tr>
		<tr><th>본문</th><td><pre><%=dto.getFcontent() %></pre></td></tr>
		<tr><th>작성일</th><td><%=dto.getFrdate() %></td></tr>
		<tr><th>조회수</th><td><%=dto.getFhit() %></td></tr>
		<tr><th>ip</th><td><%=dto.getFip() %></td></tr>
		<tr><td colspan="2">
			<button onclick="location.href='fboardList.jsp?pageNum=<%=pageNum%>'">목록</button>
			<%if(customer!=null && customer.getCid().equals(dto.getCid())){%>
				<button onclick="location.href='fboardUpdateForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">글수정</button>
			<%}%>
			<button onclick="location.href='fboardDeleteForm.jsp?fnum=<%=fnum%>'">글삭제</button>
			<%if(customer!=null){%>
			<button onclick="location.href='fboardWriteForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">답변</button>
			<%}%>
		</td></tr>
	</table>

	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>