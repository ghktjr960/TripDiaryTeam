package com.tripdiary.TMservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tripdiary.TMdao.DiaryDao;
import com.tripdiary.TMutil.ProfileUtils;
import com.tripdiary.TMvo.BoardListVO;
import com.tripdiary.TMvo.EmblemCmd;
import com.tripdiary.TMvo.GetEmblemCmd;
import com.tripdiary.TMvo.HaveEmblemCmd;
import com.tripdiary.TMvo.MapCmd;
import com.tripdiary.TMvo.MemberActCmd;
import com.tripdiary.TMvo.PageCmd;
import com.tripdiary.TMvo.ProfileCmd;
import com.tripdiary.TMvo.TagCmd;

@Service
public class DiaryService {

	private DiaryDao diaryDao;
	private ProfileUtils profileUtils;
	
	@Autowired
	public DiaryService(DiaryDao emblemDao, ProfileUtils profileUtils) {
		this.diaryDao = emblemDao;
		this.profileUtils = profileUtils;
	}
	
	public List<EmblemCmd> selectEmblem(){	
		diaryDao.selectEmblem();
		return diaryDao.selectEmblem();
	}
	
	public List<HaveEmblemCmd> haveEmblem(int memberNum){
		return diaryDao.haveEmblem(memberNum);
	}
	
	public MemberActCmd getActCnt(int memberNum) {
		return diaryDao.getActCnt(memberNum);
	}
	
	public void getEmblem(GetEmblemCmd getEmblem) {
		diaryDao.getEmblem(getEmblem);
	}
	
	//���߿� ��¥ ������ ��ƿ��� �ٸ� ���񽺰� �ִٸ� ����
	public List<String> getDate(int memberNum){
		return diaryDao.getDate(memberNum);
	}
	
	public ProfileCmd getProfile(int memberNum) {
		return diaryDao.getProfile(memberNum);
	}
	
	public void profileUpdate(MultipartHttpServletRequest mpRequest, int memberNum, String message) throws Exception {
		// ������ ���¸޼��� ������Ʈ
		Map<String, Object> profileMessage = new HashMap<String, Object>();
		profileMessage.put("member_num", memberNum);
		profileMessage.put("message", message);
		diaryDao.profileMessageUpdate(profileMessage);
		
    	// ������ ���� ���ε� (if ���� ����ִٸ� ���� ����ִٸ� ����x)
		if(!mpRequest.getFile("profile_img").getOriginalFilename().equals("")) {
		   	Map<String, Object> profileImg = null;
		    profileImg = profileUtils.parseInsertFileInfo(memberNum, mpRequest);
		    diaryDao.profileImgUpdate(profileImg);	
		}
	}
	
	public List<MapCmd> getMap (int memberNum){
		return diaryDao.getMap(memberNum);
	}
	
	public int getArticleCount(int memberNum) {
		return diaryDao.getArticleCount(memberNum);
	}
	
	public List<BoardListVO> getBoardList(PageCmd pageVO) throws Exception{
		List<BoardListVO> boardList = diaryDao.getBoardList(pageVO);
		for(int i=0; i<boardList.size(); i++) {
			boardList.get(i).setTag(diaryDao.getTag(boardList.get(i).getBoardNum()));
		}
		
		return boardList;
	}
	
	
		
}
