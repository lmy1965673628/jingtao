package com.ly.service;

import com.ly.vo.EasyUIImage;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	EasyUIImage uploadFile(MultipartFile uploadFile);

}
