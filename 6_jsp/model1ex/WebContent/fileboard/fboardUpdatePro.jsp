<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="com.tj.model1ex.dto.FileBoardDto"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.tj.model1ex.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
String path = request.getRealPath("fileboardUpload");
int maxSize = 1024 * 1024 * 10;	
MultipartRequest mRequest = null;
String pageNum="";
int fnum=0;
String fsubject="";
String fcontent="";
String fpw="";
String ffilename="";
FileBoardDao fDao = null;
FileBoardDto fDto = null;
try{
	mRequest = new MultipartRequest(request,path,maxSize,"utf-8",new DefaultFileRenamePolicy());
	pageNum = mRequest.getParameter("pageNum");
	fnum = Integer.parseInt(mRequest.getParameter("fnum"));
	fsubject = mRequest.getParameter("fsubject");
	fcontent = mRequest.getParameter("fcontent");
	fpw = mRequest.getParameter("fpw");
	
	fDao = FileBoardDao.getInstance();
	fDto = fDao.getFileBoard(fnum);
	if(!fpw.equals(fDto.getFpw())){%>
		<script>
			alert('비밀번호가 맞지 않아요 확인해주세요');
			location.href='fboardUpdateForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>';
		</script>
	<%}
	fDto.setFip(request.getRemoteAddr());

	fDto.setFsubject(fsubject);
	fDto.setFcontent(fcontent);
	fDto.setFpw(fpw);
	
	Enumeration<String> fileName = mRequest.getFileNames();
	String tempfilename = fileName.nextElement();
	ffilename = mRequest.getFilesystemName(tempfilename);
	if(ffilename==null) ffilename = fDto.getFfilename();	
	
	if(mRequest.getParameter("fileChk")!=null && mRequest.getParameter("fileChk").equals("fileDelete")){
		ffilename=null;
	}
	fDto.setFfilename(ffilename);
}catch(Exception e){
	System.out.println(e.getMessage());
}
//서버에 올려진 파일을 소스폴더에 복사
	if (ffilename!=null && ffilename!="") {
		InputStream is = null;
		OutputStream os = null;
		File serverFile = new File(path + "/" + ffilename);
		if (serverFile.exists()) {
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/mega_IT/git/mega_IT/6_jsp/model1ex/WebContent/fileboardUpload/" + ffilename);
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
	}
	
	
	int result = FileBoardDao.FAIL;
	if(fnum==0){
		result = fDao.modifyFileBoard(fDto);
	}else{
		result = fDao.modifyFileBoard(fDto);
	}
	 
	if(result==FileBoardDao.SUCCESS){
	%>
	<script type="text/javascript">
		alert('글수정 완료');
		location.href='fboardList.jsp?pageNum=<%=pageNum%>';
	</script>
	<%}else{%>
	<script type="text/javascript">
		alert('글수정 실패');
		history.back();
	</script>	
	<%}
%>
</body>
</html>