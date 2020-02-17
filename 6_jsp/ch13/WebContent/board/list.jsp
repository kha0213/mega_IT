<%@page import="com.tj.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");
String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<%=conPath %>/css/style.css' rel='stylesheet'>
</head>
<body>
	<table>
		<caption>게시판</caption>
		<tr onclick="location.href='writeForm.jsp'"><td><a href='writeForm.jsp'>글쓰기</a></td></tr>
	</table>
	<table>
		<tr><th>글번호</th><th>작성자</th><th>제목</th><th>메일</th><th>IP</th><th>작성일</th><th>조회수</th>
		</tr>
		<%
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum="1";
		int currentPage = Integer.parseInt(pageNum); // 현재 페이지
		final int PAGESIZE = 10, BLOCKSIZE=10; //내가 정한 페이지,블록 사이즈
		int startRow = (currentPage-1)*PAGESIZE+1;
		int endRow = startRow+PAGESIZE-1;
		
		
		
		BoardDao bDao = BoardDao.getInstance(); 
		int totCnt = bDao.getBoardTotalCnt();
		if(totCnt==0){
			out.print("<tr><td colspan='7'>등록된 길이 없습니다.</td></tr>");
		}else{
			ArrayList<BoardDto> dtos = bDao.listBoard(startRow,endRow);
			for(BoardDto dto : dtos){
				out.print("<tr><td>"+dto.getNum()+"</td><td>"+dto.getWriter()+"</td>");
				out.print("<td class='left'>");
				
				if(dto.getRe_level()>0){
					int width= dto.getRe_level()*15;
					out.println("<img src='../img/level.gif' width='"+width+"' height=10>");
					out.println("<img src='../img/re.gif'>");
				}
				if(dto.getHit()>10){
					out.print("<img src='../img/hot.gif'>");
				}
				out.print("<a href='content.jsp?num="+dto.getNum()+"&pageNum="+pageNum+"'>"+dto.getSubject()+"</a>");
				out.print("</td>");
				out.print("<td>"+(dto.getEmail()==null?"-":dto.getEmail())+"</td>");
				out.print("<td>"+dto.getIp()+"</td><td>"+dto.getRdate()+"</td>");
				out.print("<td>"+dto.getHit()+"</td></tr>");
			}
		}
		%>
	</table>
	<div class="paging">
		<%
			int pageCnt = (totCnt-1)/PAGESIZE+1;
			int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE+1;
			int endPage = Math.min(startPage+BLOCKSIZE-1 , pageCnt);
			if(startPage>BLOCKSIZE){
				out.print("<a href='list.jsp?pageNum="+(startPage-1)+"'>[이전]</a>");
			}
			for(int i=startPage; i<=endPage;i++){
				if(i==currentPage){
				out.print(" [<b>"+i+"</b>] ");					
				}else{
					out.print(" [<a href='list.jsp?pageNum="+i+"'>"+i+"</a>] ");
				}
			}
			if(endPage<pageCnt){
				out.print("<a href='list.jsp?pageNum="+(endPage+1)+"'>[다음]</a>");
			}
		%>
	</div>
</body>
</html>