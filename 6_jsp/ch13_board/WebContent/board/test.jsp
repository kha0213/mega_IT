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
<style>
	h2{
		text-align: left;
	}
</style>
</head>
<body>
<%
	BoardDao bDao = BoardDao.getInstance();
	
	out.print("<h2>1. DB 글 갯수 : "+bDao.getBoardTotalCnt()+"</h2>");
	out.print("<h2>2. DB 모든 list 출력</h2>");
	ArrayList<BoardDto> bDtos = bDao.listBoard();
	for(BoardDto d : bDtos){
		out.print(d.toString()+"<br>");
	}
	out.print("<h2>3. DB 글쓰기</h2>");
	BoardDto dto = new BoardDto(0, "글쓴이", "글제목", "내용", null, 0, "111", 0, 0, 0, "127.0.0.11", null);
	int result = bDao.insertBoard(dto);	
	out.println(result==BoardDao.SUCCESS?"글쓰기 성공":"글쓰기 실패");
	
	out.print("<h2>4. 조회수 올리고 글번호로 dto가져오기</h2>");
	bDao.hitUp(15);
	bDao.hitUp(15);
	bDao.hitUp(15);
	bDao.hitUp(15);
	bDao.hitUp(15);
	bDao.hitUp(15);
	bDao.hitUp(15);
	bDao.hitUp(15);
	bDao.hitUp(15);
	bDao.hitUp(15);
	bDao.hitUp(15);
	bDao.hitUp(15);
	dto = bDao.getBoardOneLine(5);
	out.println(dto.toString());
	
	out.print("<h2>5. 글수정</h2>");
	dto.setWriter("xklnaㅋㅌㅊㅍㅋㅌ");
	dto.setSubject("바꾼제아");
	dto.setIp("0.0.0.0.");
	dto.setContent("sdklfkf");
	result = bDao.updateBoard(dto);
	out.print(result==BoardDao.SUCCESS?dto.getNum()+"번 수정성공":"수정실패");
	
	out.print("<h2>6. 글삭제(실패)</h2>");
	result = bDao.deleteBoard(26, "1111");
	out.print(result==BoardDao.SUCCESS?"삭제성공":"삭제실패");
	out.print("<h2>6. 글삭제(성공)</h2>");
	result = bDao.deleteBoard(26, "111");
	out.print(result==BoardDao.SUCCESS?"삭제성공":"삭제실패");
	
%>
	<a href="xx.jsp">xx</a>
</body>
</html>