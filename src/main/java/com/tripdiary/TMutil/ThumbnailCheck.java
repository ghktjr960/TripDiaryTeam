package com.tripdiary.TMutil;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component
public class ThumbnailCheck {
	
	public boolean check(MultipartHttpServletRequest mpRequest) throws Exception{
		MultipartFile multipartFile = mpRequest.getFile("thumbnail");		
		String originalFileName = null;
		String type = null;
		double size = 0;
		boolean check = true;
		
		// ���� �̸�
		originalFileName = multipartFile.getOriginalFilename();
		// ���� Ȯ����
		type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
		
		size = multipartFile.getSize();
		if(type.equals("jpg") || type.equals("jpeg") || type.equals("png") || type.equals("gif") || type.equals("bmp") || type.equals("pdf") || 
				type.equals("JPG") || type.equals("JPEG") || type.equals("PNG") || type.equals("GIF") || type.equals("BMP") || type.equals("PDF")) {
		
		}else {
			check = false;
		}
		if (size > 8 * 1024 * 1024 * 5) {
			check = false;
		}
			
		
		return check;
	}
}