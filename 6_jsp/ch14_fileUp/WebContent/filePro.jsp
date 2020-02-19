<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.IOException"%>
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
		String path = request.getRealPath("fileUpFolder"); //여기에 업로드 시킬 예정
		int maxSize = 1024 * 1024 * 10; //업로드 최대용량 10M
		String filename = "";
		String originalFilename = "";
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8",
					new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mRequest.getFileNames();
			while (paramNames.hasMoreElements()) {
				String param = paramNames.nextElement(); // param="file"
				filename = mRequest.getFilesystemName(param); //param이라는 파라미터로 올라온 파일 이름
				originalFilename = mRequest.getOriginalFileName(param); //original 파일이름
				System.out.println(
						"파라미터이름:" + param + ", 서버에 저장된 파일이름:" + filename + "사용자가 첨부한 오리지날 이름: " + originalFilename);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		//서버에 업로드 하자마자 소스폴더로 file copy
		InputStream is = null;
		OutputStream os = null;
		try {
			File serverFile = new File(path + "/" + filename);
			if (serverFile.exists()) {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream(
						"D:/mega_IT/git/mega_IT/6_jsp/ch14_fileUp/WebContent/fileUpFolder/" + filename);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true){
					int nReadCnt = is.read(bs); // nReadCnt : 읽어 온 바이트 수
					if(nReadCnt==-1){
						break;
					}
					os.write(bs, 0, nReadCnt);
				}
			} else {

			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try{
			if (os != null)
				os.close();
			if (is != null)
				is.close();				
			}catch(IOException e2){
				System.out.print(e2);
			}
		}
	%> 
	<h3>
		올린 오리지널 파일이름 :<%=path%>/<%=originalFilename%></h3>
	<h3>
		서버에 저장된 파일이름 :<%=path%>/<%=filename%></h3>
	<img src="fileUpFolder/<%=filename%>" alt="첨부안됨">
	<!-- D:\mega_IT\git\mega_IT\6_jsp\ch14_fileUp\WebContent\fileUpFolder -->





</body>
</html>