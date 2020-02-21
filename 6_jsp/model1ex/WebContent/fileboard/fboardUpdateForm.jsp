<%@page import="com.tj.model1ex.dto.CustomerDto"%>
<%@page import="com.tj.model1ex.dao.FileBoardDao"%>
<%@page import="com.tj.model1ex.dto.FileBoardDto"%>
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
	padding-top: 100px;
}
</style>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div id="content_form">
		<%
			if (session.getAttribute("customer") == null || request.getParameter("fnum") == null) {
				response.sendRedirect("fboardList.jsp");
			}
			CustomerDto cDto = (CustomerDto) session.getAttribute("customer");
			int fnum = Integer.parseInt(request.getParameter("fnum"));
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null)
				pageNum = "1";
			FileBoardDao fDao = FileBoardDao.getInstance();
			FileBoardDto fDto = new FileBoardDto(); 
			fDto = fDao.getFileBoard(fnum);
			
		%>
		<form action="fboardUpdatePro.jsp" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pageNum" value="<%=pageNum%>"> <input
				type="hidden" name="fnum" value="<%=fnum%>"> <input
				type="hidden" name="fref" value="<%=fDto.getFref()%>"> <input
				type="hidden" name="fre_step" value="<%=fDto.getFre_step()%>"> <input
				type="hidden" name="fre_level" value="<%=fDto.getFre_level()%>">
			<table>
				<caption>고객센터 글수정</caption>
				<tr>
					<th>ID</th>
					<td><input type="text" name="cid" required="required"
						readonly="readonly" value="<%=cDto.getCid()%>"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="fsubject" required="required"
						value="<%=fDto.getFsubject()%>"></td>
				</tr>
				<tr>
					<th>본문내용</th>
					<td><pre><textarea rows="20" cols="5" name="fcontent"><%=fDto.getFcontent() %></textarea></pre></td>
				</tr>
				<tr>
					<th>파일첨부</th>
					<td><input type="file" name="ffilename" ><br>
					<%
					if(fDto.getFfilename()!=null){%>
					<a href="../fileboardUpload/<%=fDto.getFfilename() %>" class="left"><%=fDto.getFfilename() %></a>
					<h2 class="left">(첨부안할 시 기존파일 그대로)</h2>
					<input type="checkbox" name="fileChk" value="fileDelete" class="left">첨부파일 삭제
					</td>
					<%}%>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="fpw" required="required"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="글수정" class="btn">
						<input type="reset" value="다시쓰기" class="btn"> <input
						type="button" value="목록" class="btn"
						onclick="location.href='fboardList.jsp?pageNum=<%=pageNum%>'">
					</td>
				</tr>
			</table>
		</form>

	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>