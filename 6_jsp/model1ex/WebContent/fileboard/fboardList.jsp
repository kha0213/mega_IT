<%@page import="java.util.ArrayList"%>
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
<%
String pageNum = request.getParameter("pageNum");
if(pageNum==null) pageNum="1";
if(pageNum=="") pageNum="1";
int currentPage = Integer.parseInt(pageNum);
FileBoardDao fDao = FileBoardDao.getInstance(); 
final int PAGESIZE = 10;
final int BLOCKSIZE = 10;
int startLow = (currentPage-1)*PAGESIZE+1;
int endLow = startLow+PAGESIZE-1;
int totCnt = fDao.getFileBoardTotCnt();
%>

	<jsp:include page="../main/header.jsp" />
	<div id="content_form">
	<table>
	<tr><td colspan="7">&nbsp;<%if(session.getAttribute("customer")!=null){%>
			<a href='fboardWriteForm.jsp?pageNum=<%=pageNum %>'>글쓰기</a>
			<%}%></td></tr><!-- 로그인해야 글쓰기가능 -->
		<tr><th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>IP</th><th>작성일</th><th>조회수</th>
		</tr>
		<%
		
		if(totCnt==0){
			out.print("<tr><td colspan='7'>등록된 글이 없습니다.</td></tr>");
		}else{
			ArrayList<FileBoardDto> dtos = fDao.listFileBoard(startLow, endLow);
			for(FileBoardDto dto : dtos){
				out.print("<tr><td>"+dto.getFnum()+"</td><td>"+dto.getCname()+"</td>");
				out.print("<td class='left'>"); //글제목은 왼쪽정렬
				if(dto.getFre_step()!=0){
					int width = dto.getFre_level()*20;%>
					<img src="../img/level.gif" width='<%=width %>' height='10'>
					<img src="../img/re.gif">
				<%}
				
				
				if(dto.getFhit()>10){
					out.print("<img src='../img/hot.gif'>");
				}
				if(dto.getFfilename()!=null){
					out.print("<img src='../img/fileup.jpg'>");
				}
				out.print("<a href='fboardContent.jsp?fnum="+dto.getFnum()+"&pageNum="+pageNum+"'>"+dto.getFsubject()+"</a>");
				out.print("</td>");
				out.print("<td>"+(dto.getCemail()==null?"-":dto.getCemail())+"</td>");
				out.print("<td>"+dto.getFip()+"</td><td>"+dto.getFrdate()+"</td>");
				out.print("<td>"+dto.getFhit()+"</td></tr>");
			}
		}
		%>
	</table>
		<div class="paging">
			<%
			
			int pageCnt = (totCnt-1)/PAGESIZE+1;
			int startPage = (currentPage-1)/BLOCKSIZE*BLOCKSIZE+1;
			int endPage = startPage+BLOCKSIZE-1;
			if(endPage > pageCnt) endPage = pageCnt;
				if (startPage > BLOCKSIZE) {
			%>
			<a href="fboardList.jsp?pageNum=<%=startPage - 1%>">[ 이전 ]</a>
			<%
				}
				for (int i = startPage; i <= endPage; i++) {
					if (i == currentPage) {
			%>
			[ <b><%=i%></b> ]
			<%
				} else {
			%>
			[ <a href="fboardList.jsp?pageNum=<%=i%>"><%=i%></a> ]
			<%
				}
			}
				if (endPage != pageCnt) {
			%>
			<a href="fboardList.jsp?pageNum=<%=endPage + 1%>">[ 다음 ]</a>
			<%
				}
			%>
		</div>
	
	
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>