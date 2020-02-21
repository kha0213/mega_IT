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
			if (session.getAttribute("customer") == null) {
				response.sendRedirect("fboardList.jsp");
			}
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null){
				pageNum = "1";				
			}
			CustomerDto cDto = (CustomerDto) session.getAttribute("customer");

			int fnum = 0, fref = 0, fre_step = 0, fre_level = 0;
			FileBoardDto fDto = new FileBoardDto(); //답변글을 위해 들어왔다면 dto에 원글에 대한 정보

			//답변글일 경우
			if (request.getParameter("fnum") != null) {
				fnum = Integer.parseInt(request.getParameter("fnum"));
				FileBoardDao fDao = FileBoardDao.getInstance();
				fDto = fDao.getFileBoard(fnum);
				fref = fDto.getFref();
				fre_step = fDto.getFre_step();
				fre_level = fDto.getFre_level();
			}

			
		%>
		<form action="fboardWritePro.jsp" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pageNum" value="<%=pageNum%>"> <input
				type="hidden" name="fnum" value="<%=fnum%>"> <input
				type="hidden" name="fref" value="<%=fref%>"> <input
				type="hidden" name="fre_step" value="<%=fre_step%>"> <input
				type="hidden" name="fre_level" value="<%=fre_level%>">
			<table>
				<caption><%=fnum==0?"고객센터 글쓰기":(fnum+"번글 답글쓰기") %></caption>
				<tr>
					<th>ID</th>
					<td><input type="text" name="cid" required="required"
						readonly="readonly" value="<%=cDto.getCid()%>"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="fsubject" required="required"
						value="<%if (fnum != 0)
				out.print("[답]" + fDto.getFsubject());%>"></td>
				</tr>
				<tr>
					<th>본문내용</th>
					<td><textarea rows="20" cols="5" name="fcontent"></textarea></td>
				</tr>
				<tr>
					<th>파일첨부</th>
					<td><input type="file" name="ffilename"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="fpw" required="required"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="글쓰기" class="btn">
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