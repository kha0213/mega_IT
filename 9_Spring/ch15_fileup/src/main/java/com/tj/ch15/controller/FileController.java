package com.tj.ch15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tj.ch15.service.FileUploadService;

@Controller
public class FileController {
	@Autowired
	FileUploadService fService;
	
	@RequestMapping(value = "fileInput", method = RequestMethod.GET)
	public String fileInput() {
		return "fileInput";
	}
	
	@RequestMapping(value = "fileUpLoad", method = RequestMethod.POST)
	public String fileUpLoad(MultipartHttpServletRequest mRequest,Model model) {
		if(fService.fileUp(mRequest, model)) {
			model.addAttribute("fileResult","파일 업로드 성공");
		}else {
			model.addAttribute("fileResult","파일 업로드 실패");
		}
		return "fileResult";
	}
	
}
