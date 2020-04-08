package com.ly.controller;


import com.ly.service.FileService;
import com.ly.vo.EasyUIImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



/**
 * 如果用户使用文件上传,重定向到上传页面
 * @author tarena
 *
 */
@Controller
public class FileController {
	
	@Autowired
	private FileService fileService;

	@RequestMapping("/pic/upload")
	@ResponseBody
	public EasyUIImage uploadFile(MultipartFile uploadFile) {
		return fileService.uploadFile(uploadFile);
	}
}
