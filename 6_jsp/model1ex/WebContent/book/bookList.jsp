<%@page import="com.tj.model1ex.dto.BookDto"%>
<%@page import="com.tj.model1ex.dao.BookDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<%
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null)
			pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 3, BLOCKSIZE = 5;

		int startRow = (currentPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		BookDao bDao = BookDao.getInstance();
		ArrayList<BookDto> books = bDao.listBook(startRow, endRow);
	%>
<div class="content_form">
	<table>
		<tr>
			<%
				for (BookDto book : books) {
			%>
			<td><a href='bookDetail.jsp?bid=<%=book.getBid()%>&pageNum=<%=pageNum%>'><img src='../bookImg/<%=book.getBimage1()%>'><br>
				<%=book.getBtitle()%><br> <del><%=book.getBprice()%></del> <b><%=book.getBprice() * (100 - book.getBdiscount()) / 100%>
					(<%=book.getBdiscount()%>% 할인) </b><br></a></td>

			<%
				}
			%>

			<%
				int bookTotCnt = bDao.getBookTotCnt();
				int pageCnt = (bookTotCnt - 1) / PAGESIZE + 1;
				int startPage = (currentPage - 1) / BLOCKSIZE * BLOCKSIZE + 1;
				int endPage = startPage + BLOCKSIZE - 1;
				if (endPage > pageCnt)
					endPage = pageCnt;
			%>
		</tr>
	</table>
	<div class="paging">
		<%
			if (startPage > BLOCKSIZE) {
		%>
		[<a href="bookList.jsp?pageNum=<%=startPage - 1%>"> 이전 </a>]
		<%
			}
		%>

		<%
			for (int i = startPage; i <= endPage; i++) {
				if (i == currentPage) {
					out.print(" [<b> " + i + " </b>] ");
				} else {
					out.print(" [ <a href='bookList.jsp?pageNum=" + i + "'>" + i + " ] ");
				}
			}
		%>

		<%
			if (endPage != pageCnt) {
		%>
		[<a href="bookList.jsp?pageNum=<%=endPage + 1%>"> 다음 </a>]
		<%
			}
		%>

	</div>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>