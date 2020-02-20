<%@page import="com.tj.model1ex.dao.BookDao"%>
<%@page import="com.tj.model1ex.dto.BookDto"%>
<%@page import="java.sql.Date"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		request.setCharacterEncoding("utf-8"); //제목, 설명 등등에 한글 입력 고려
		String path = request.getRealPath("bookImg");
		int maxSize = 1024 * 1024 * 10;
		String[] image = {"", ""};
		MultipartRequest mRequest = null;
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mRequest.getFileNames(); //파라미터이름들
			int idx = 0;
			while (paramNames.hasMoreElements()) {
				String param = paramNames.nextElement();
				image[idx] = mRequest.getFilesystemName(param);
				idx++;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//서버에 올려진 파일을 소스폴더에 복사
		for (String imgfile : image) {
			if (image == null) {
				continue;
			}
			InputStream is = null;
			OutputStream os = null;
			File serverFile = new File(path + "/" + imgfile);
			if (!serverFile.exists()) {
				continue;
			}
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/mega_IT/git/mega_IT/6_jsp/model1ex/WebContent/bookImg/" + imgfile);
				byte[] bs = new byte[(int) serverFile.length()];
				while (true) {
					int readByteCnt = is.read(bs);
					if (readByteCnt == -1) {
						break;
					}
					os.write(bs, 0, readByteCnt);
				}

			} catch (Exception e) {
				System.out.print(e.getMessage());
			} finally {
				if (os != null)
					os.close();
				if (is != null)
					is.close();
			}
		}

		//책제목, 책설명, 가격, 할인율 등을 getParameter("")로 받아 BookDto객체 생성하여 DB에 insert
		String btitle = mRequest.getParameter("btitle");
		int bprice = Integer.parseInt(mRequest.getParameter("bprice"));
		String bimage1 = image[1] != null ? image[1] : "NOTHING.JPG";
		String bimage2 = image[0] != null ? image[0] : "noImg.png";
		String bcontent = mRequest.getParameter("bcontent");
		int bdiscount = Integer.parseInt(mRequest.getParameter("bdiscount"));
		//DB에 insertBook
		BookDto book = new BookDto(0, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, null);
		BookDao bDao = BookDao.getInstance();
		int result = bDao.insertBook(book);
		if (result == BookDao.SUCCESS) {
			out.println("<h2>책 등록 성공</h2>");

		} else {
			out.println("<h2>책 등록 실패</h2>");
		}
	%>
	<h3>
		책이름 :
		<%=btitle%></h3>
	<h3>
		책이미지1 :
		<%=path + "/" + bimage1%></h3>
	<img alt="book1" src="../bookImg/<%=bimage1%>">
	<h3>
		책이미지2 :
		<%=path + "/" + bimage2%></h3>
	<img alt="book2" src="../bookImg/<%=bimage2%>">
	<h3>책 설명</h3>
	<pre>
	<%=bcontent %>
	</pre>
	<h3>책 가격 : <del><%=bprice %></del><%=bprice*(100-bdiscount)/100 %></h3>
	<h3>할인율 : <%=bdiscount %></h3>
	
	<h3><a href='bookList.jsp'>책 리스트(1page)</a></h3>
	<h3><a href='bookRegister.jsp'>책 등록</a><br></h3>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>