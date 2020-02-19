<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.File"%>
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
		
		String path = request.getRealPath("fileUpFolder");
		int maxSize = 1024 * 1024 * 1024;
		String[] filename = { "", "", "" };
		String[] oriFilename = { "", "", "" };
		try {
			MultipartRequest multiRequest = new MultipartRequest(request, path, maxSize, "utf-8",
					new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = multiRequest.getFileNames();
			int idx = filename.length-1;
			while (paramNames.hasMoreElements()) {
				String param = paramNames.nextElement();
				filename[idx] = multiRequest.getFilesystemName(param); // 서버에 저장된 파일이름
				oriFilename[idx] = multiRequest.getOriginalFileName(param);
				idx--;
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		//파일 카피
		for(String f : filename){
			if(f!=null){
				InputStream is = null;
				OutputStream os = null;
				try {
					File serverFile = new File(path + "/" + f);
					if (serverFile.exists()) {
						is = new FileInputStream(serverFile);
						os = new FileOutputStream(
								"D:/mega_IT/git/mega_IT/6_jsp/ch14_fileUp/WebContent/fileUpFolder/" + f);
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
				
			}else{
				continue;				
			}
			
			
		}
		
		
	%>
<h2>0번째 첨부</h2>
<h2><%=path %>/<%=filename[0] %></h2>
<img src="fileUpFolder/<%=filename[0] %>" alt="1첨부안함">
<h2>1번째 첨부</h2>
<h2><%=path %>/<%=filename[1] %></h2>
<img src="fileUpFolder/<%=filename[1] %>" alt="2첨부안함">
<h2>2번째 첨부</h2>
<h2><%=path %>/<%=filename[2] %></h2>
<img src="fileUpFolder/<%=filename[2] %>" alt="3첨부안함">

</body>
</html>