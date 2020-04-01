package com.tj.ch15.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class FileUploadService {
	public boolean fileUp(MultipartHttpServletRequest mRequest,Model model) {
		boolean isUpload = false;
		String uploadPath = mRequest.getRealPath("upload/");
		String backupPath = "D:/mega_IT/git/mega_IT/9_Spring/ch15_fileup/src/main/webapp/upload/";
		String[] fileNames = new String[3];
		int idx = 0;
		Iterator<String> params = mRequest.getFileNames();
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);
			String originalFileName = mFile.getOriginalFilename();//업로드 했을때 이름
			fileNames[idx] = originalFileName;
			if(fileNames[idx]!=null && !fileNames[idx].equals("")) {
				if(new File(uploadPath+fileNames[idx]).exists()) {
					// 첨부파일과 같은 이름의 파일이 서버에 존재하는 경우 -> 파일이름을 변경
					fileNames[idx] = System.currentTimeMillis()+fileNames[idx];
				}// 이름 중복처리
				try {
					mFile.transferTo(new File(uploadPath+fileNames[idx]));
					System.out.println("서버에 저장된 파일 : "+uploadPath+fileNames[idx]);
					System.out.println("백업위해 복사 할 파일 : "+backupPath+fileNames[idx]);
					isUpload = filecopy(uploadPath+fileNames[idx],backupPath+fileNames[idx]);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				} //서버에 파일저장
			}//if
			idx++;
		}//while
		model.addAttribute("fileNames", fileNames);
		return isUpload;
	}
	
	private boolean filecopy(String serverFileName, String backupFileName) {
		boolean isCopy = false;
		FileInputStream is = null;
		FileOutputStream os = null;
		
		try {
			File file = new File(serverFileName);
			is = new FileInputStream(serverFileName);
			os = new FileOutputStream(backupFileName);
			byte[] buffer = new byte[(int) file.length()];
			
			while(true) {
				int nReadByte = is.read(buffer);
				if(nReadByte == -1) break;
				os.write(buffer, 0, nReadByte);
			}
			isCopy = true;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return isCopy;
	}
	
	
}
