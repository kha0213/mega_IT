package com.tj.ch18.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tj.ch18.dao.BookDao;
import com.tj.ch18.dto.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;
	
	
	@Override
	public List<Book> mainList() {
		return bookDao.mainList();
	}

	@Override
	public int cntBook() {
		return bookDao.cntBook();
	}

	@Override
	public List<Book> bookList(Book book) {
		return bookDao.bookList(book);
	}

	@Override
	public Book getBook(int bnum) {
		return bookDao.getBook(bnum);
	}

	@Override
	public int registerBook(MultipartHttpServletRequest mRequest, Book book) {
		return bookDao.registerBook(book);
	}

	@Override
	public int registerBook(MultipartHttpServletRequest mRequest) {
		int result = 0;
		
		int bnum = Integer.parseInt(mRequest.getParameter("bnum"));
		String btitle = mRequest.getParameter("btitle");
		String bwriter = mRequest.getParameter("bwriter");
		Date brdate = Date.valueOf(mRequest.getParameter("brdate"));
		String binfo = mRequest.getParameter("binfo");
		
		String bimg1="",bimg2="";
		String[] bimageArr = new String[2];
		int idx = 0;
		
		
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		String backupPath = "D:\\mega_IT\\git\\mega_IT\\9_Spring\\ch18\\src\\main\\webapp\\bookImgFileUpload/";
		
		Iterator<String> params = mRequest.getFileNames();
		while(params.hasNext()) {
			String temp = params.next();
			MultipartFile mFile = mRequest.getFile(temp);
			String originalFileName = mFile.getOriginalFilename();
			bimageArr[idx] = originalFileName;
			if(bimageArr[idx]!=null) {
				if(new File(uploadPath+bimageArr[idx]).exists()) {
					bimageArr[idx] += System.currentTimeMillis();
				}
			}
			try {
				mFile.transferTo(new File(uploadPath+bimageArr[idx]));
				filecopy(uploadPath+bimageArr[idx], backupPath+bimageArr[idx]);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			if(idx==0) {
				bimg1 = bimageArr[idx];
			}else if(idx == 1) {
				bimg2 = bimageArr[idx];
			}
			idx++;
		}
		Book book = new Book(bnum, btitle, bwriter, brdate, bimg1, bimg2, binfo, 0, 0);
		return bookDao.registerBook(book);
	}
	
	
	private int filecopy(String serverFileName, String backupFileName) {
		int result = 0;
		FileInputStream is = null;
		FileOutputStream os = null;
		
		File file = new File(serverFileName);
		try {
			is = new FileInputStream(file);
			os = new FileOutputStream(backupFileName);
			byte[] copyArr = new byte[(int) file.length()];
			
			while(true) {
				int nReadByte = is.read(copyArr);
				if(nReadByte == -1) break;
				os.write(copyArr, 0, nReadByte);
			}
			result = 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os != null) os.close();
				if(is != null) is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	

	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book) {
		return bookDao.modifyBook(book);
	}

	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest) {
		int bnum = Integer.parseInt(mRequest.getParameter("bnum"));
		String btitle = mRequest.getParameter("btitle");
		String bwriter = mRequest.getParameter("bwriter");
		Date brdate = Date.valueOf(mRequest.getParameter("brdate"));
		String bimg1 = mRequest.getParameter("bimg1");
		String bimg2 = mRequest.getParameter("bimg2");
		String binfo = mRequest.getParameter("binfo");
		int startRow = Integer.parseInt(mRequest.getParameter("startRow"));
		int endRow = Integer.parseInt(mRequest.getParameter("endRow"));
		Book book = new Book(bnum, btitle, bwriter, brdate, bimg1, bimg2, binfo, startRow, endRow);
		return bookDao.modifyBook(book);
	}

}
