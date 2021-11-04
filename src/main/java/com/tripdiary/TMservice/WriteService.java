package com.tripdiary.TMservice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tripdiary.TMdao.WriteDao;
import com.tripdiary.TMutil.FileUtils;
import com.tripdiary.TMutil.TagUtils;
import com.tripdiary.TMutil.ThumbnailUtils;
import com.tripdiary.TMvo.MapCmd;
import com.tripdiary.TMvo.TagCmd;
import com.tripdiary.TMvo.WriteCmd;

@Service
public class WriteService {

	private WriteDao writeDao;
	private FileUtils fileUtils;
	private ThumbnailUtils thumbnailUtils;
	private TagUtils tagUtils;
	
	@Autowired
	public WriteService(WriteDao writeDao, FileUtils fileUtils, ThumbnailUtils thumbnailUtils, TagUtils tagUtils) {
		this.writeDao = writeDao;
		this.fileUtils = fileUtils;
		this.thumbnailUtils = thumbnailUtils;
		this.tagUtils = tagUtils;
	}
	
	public void write(WriteCmd writeCmd,TagCmd tagCmd, MapCmd mapCmd, MultipartHttpServletRequest mpRequest) throws Exception {
		//���ۼ�
		if(writeCmd.getPlaceCheck().equals("abroad")) {
			writeCmd.setPlace("abroad");
		}
		writeDao.write(writeCmd);
		
		//�� ��ǥ ���
		if(mapCmd.getMarkerLat() != 0) {
			mapCmd.setBoardNum(writeCmd.getBoardNum());
			System.out.println(mapCmd.getBoardNum());
			writeDao.insertMap(mapCmd);
		}
		
		//�±׵��
		if(tagCmd.getTag() != null) {
		List<Map<String,Object>> tag = tagUtils.tagList(writeCmd, tagCmd);
			int tagSize = tagCmd.getTag().size();
			if(tagSize > 5) {
				tagSize = 5;
			}
			for (int i=0; i<tagSize; i++) {
				writeDao.insertTag(tag.get(i));
			}
		}
		
    	//��ǥ���� ���ε� (if ���� ����ִٸ� ���� ����ִٸ� ����x)
		if(!mpRequest.getFile("thumbnail").getOriginalFilename().equals("")) {
	   	Map<String, Object> thumbnail = null;
	    thumbnail = thumbnailUtils.parseInsertFileInfo(writeCmd, mpRequest);
	    writeDao.insertFile(thumbnail);	
		}
    	
    	
		//�߰� ���� ���ε� (if ���� ����ִٸ� ���� ����ִٸ� ����x)
	    if(!mpRequest.getFiles("file").get(0).getOriginalFilename().equals("")) {
			List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(writeCmd, mpRequest);
			int size = list.size();
			if(size > 10) {
				size = 10;
			}
			for(int i=0; i<size; i++){ 
				writeDao.insertFile(list.get(i)); 
			}
	    }
	    
	    //ȸ�� Ȱ�� ���ۼ� ī��Ʈ +1
	    writeDao.cntUp(writeCmd.getMemberNum());
	}
	
	public WriteCmd getBoard(int boardNum) {
		return writeDao.getBoard(boardNum);
	}
	
	public List<TagCmd> getTag(int boardNum) {
		return writeDao.getTag(boardNum);
	}
	
	public void writeUpdate(WriteCmd writeCmd,TagCmd tagCmd, MultipartHttpServletRequest mpRequest) throws Exception {
		//���ۼ�
		if(writeCmd.getPlaceCheck().equals("abroad")) {
			writeCmd.setPlace("abroad");
		}
		writeDao.writeUpdate(writeCmd);
		
		//���� �±� ����
		writeDao.deleteTag(writeCmd.getBoardNum());
		//�±� ����
		if(tagCmd.getTag() != null) {
		List<Map<String,Object>> tag = tagUtils.tagList(writeCmd, tagCmd);
			int tagSize = tagCmd.getTag().size();
			if(tagSize > 5) {
				tagSize = 5;
			}
			for (int i=0; i<tagSize; i++) {
				writeDao.insertTag(tag.get(i));
			}
		}
		
    	//��ǥ���� ���ε� (if ���� ����ִٸ� ���� ����ִٸ� ����x)
		if(!mpRequest.getFile("thumbnail").getOriginalFilename().equals("")) {
		//���� ���� ����
		writeDao.deleteThumbnail(writeCmd.getBoardNum());
	   	Map<String, Object> thumbnail = null;
	    thumbnail = thumbnailUtils.parseInsertFileInfo(writeCmd, mpRequest);
	    writeDao.insertFile(thumbnail);	
		}
    	
    	
		//�߰� ���� ���ε� (if ���� ����ִٸ� ���� ����ִٸ� ����x)
	    if(!mpRequest.getFiles("file").get(0).getOriginalFilename().equals("")) {
	    	//���� ���� ����
	    	writeDao.deleteFile(writeCmd.getBoardNum());
			List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(writeCmd, mpRequest);
			int size = list.size();
			if(size > 10) {
				size = 10;
			}
			for(int i=0; i<size; i++){ 
				writeDao.insertFile(list.get(i)); 
			}
	    } 
	}
	
	public String getMainImg(int boardNum) {
		return writeDao.getMainImg(boardNum);
	}
	
	public List<String> getSubImg(int boardNum) {
		return writeDao.getSubImg(boardNum);
	}
	
}
