<%@page import="com.tj.model1ex.dto.CustomerDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.model1ex.dao.CustomerDao"%>
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
	<jsp:include page="header.jsp" />
	<div id="content_form">
		<%
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null)
				pageNum = "1";
			int currentPage = Integer.parseInt(pageNum);
			final int PAGESIZE = 5, BLOCKSIZE = 2;
			int startRow = (currentPage - 1) * PAGESIZE + 1;
			int endRow = startRow + PAGESIZE - 1;
			CustomerDao cDao = CustomerDao.getInstance();
			ArrayList<CustomerDto> customers = cDao.listCustomer(startRow, endRow);
		%>
		<table>
			<tr>
				<th>회원ID</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>주소</th>
			</tr>
			<%
				if (customers.size() == 0) {
			%>
			<tr>
				<td colspan="5">가입된 회원이 없습니다.</td>
			</tr>
			<%
				} else {
					for (CustomerDto c : customers) {
						out.print("<tr><td>" + c.getCid() + "</td><td>" + c.getCpw() + "</td><td>" + c.getCname());
						out.print("</td><td>" + (c.getCemail() == null ? "" : c.getCemail()) + "</td><td>"
								+ (c.getCaddress() == null ? "" : c.getCaddress()) + "</td></tr>");
					}
				}
			%>
		</table>
		<div class="paging">
			<%
				int totCustomerCnt = cDao.getCustomerTotCnt(); //회원수
				int pageCnt = (totCustomerCnt - 1) / PAGESIZE + 1; //페이지수
				int startPage = (currentPage - 1) / BLOCKSIZE * BLOCKSIZE + 1;
				int endPage = startPage + BLOCKSIZE - 1;
				if (endPage > pageCnt)
					endPage = pageCnt;
				if (startPage > BLOCKSIZE) {
			%>
			<a href="main.jsp?pageNum=<%=startPage - 1%>">[ 이전 ]</a>
			<%
				}
				for (int i = startPage; i <= endPage; i++) {
					if (i == currentPage) {
			%>
			[ <b><%=i%></b> ]
			<%
				} else {
			%>
			[ <a href="main.jsp?pageNum=<%=i%>"><%=i%></a> ]
			<%
				}
			}

				if (endPage != pageCnt) {
			%>
			<a href="main.jsp?pageNum=<%=endPage + 1%>">[ 다음 ]</a>

			<%
				}
			%>

		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
