package com.tripdiary.TMcontroller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tripdiary.TMservice.WriteService;
import com.tripdiary.TMutil.FileCheck;
import com.tripdiary.TMutil.ThumbnailCheck;
import com.tripdiary.TMvo.MapCmd;
import com.tripdiary.TMvo.TagCmd;
import com.tripdiary.TMvo.WriteCmd;


@Controller
public class WriteController {
	
	private WriteService writeService;
	private FileCheck fileCheck;
	private ThumbnailCheck thumbnailCheck;
	@Autowired
	public WriteController(WriteService writeService, FileCheck fileCheck,ThumbnailCheck thumbnailCheck) {
		this.writeService = writeService;
		this.fileCheck = fileCheck;
		this.thumbnailCheck = thumbnailCheck;
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeForm(HttpSession session, Model model) {
		if(session.getAttribute("id") == null) {
			model.addAttribute("msg", "�α��� �� �̿����ּ���.");
			model.addAttribute("url", "/signIn");
			return "/return/alert";
		}
		return "/write";
	}
	
    @RequestMapping(value="/write", method=RequestMethod.POST) 
    public String write(WriteCmd writeCmd,TagCmd tagCmd, MapCmd mapCmd, Model model, MultipartHttpServletRequest mpRequest) throws Exception {
    	//��ǥ ������ ���ٸ� ���û
    	if(mpRequest.getFile("thumbnail").getOriginalFilename().equals("")) {
    		model.addAttribute("msg", "��ǥ ������ ������ּ���.");
    		return "/return/historyback";
    	}
    	// ���ε�� �̹��� ���ε� ���� �˻�
    	if(!mpRequest.getFile("thumbnail").getOriginalFilename().equals("")) {
        	// ����� Ȯ���� �� �뷮 �˻�
        	if(thumbnailCheck.check(mpRequest) == false) {
        		model.addAttribute("msg", "�̹������ϸ� ���ε� �����մϴ�. (�ִ� 5MB)");
        		return "/return/historyback";
        	}
    	}
    	if(!mpRequest.getFiles("file").get(0).getOriginalFilename().equals("")){
        	// �߰� �̹������� Ȯ���� �� �뷮�˻�
           	if(fileCheck.check(mpRequest) == false) {
        		model.addAttribute("msg", "�̹������ϸ� ���ε� �����մϴ�. (�ִ� 5MB)");
        		return "/return/historyback";
        	}
    	}
    	writeService.write(writeCmd,tagCmd,mapCmd, mpRequest);
    	model.addAttribute("msg", "���ο� �ϱ⸦ �ۼ��Ͽ����ϴ�.");
		model.addAttribute("url", "/diary?memberNum=");
		return "/return/diaryAlert";
    }
    
    
	@RequestMapping(value = "/writeUpdate", method = RequestMethod.GET)
	public String writeUpdate(HttpSession session,Model model, int boardNum) {
		WriteCmd board = writeService.getBoard(boardNum);
		int memberNum = (int) session.getAttribute("memberNum");
		//�ۼ������� �˻�
    	if(memberNum != board.getMemberNum()) {
    		model.addAttribute("msg", "�ۼ��ڸ� ������ �����մϴ�.");
    		return "/return/historyback";
    	}
		model.addAttribute("mainImg", writeService.getMainImg(boardNum));
		model.addAttribute("subImg", writeService.getSubImg(boardNum));
		model.addAttribute("boardNum", boardNum);
		model.addAttribute("board", board);
		model.addAttribute("tag", writeService.getTag(boardNum));
		return "/writeUpdate";
	}
	
	
    @RequestMapping(value="/writeUpdate", method=RequestMethod.POST) 
    public String writeUpdate(MultipartHttpServletRequest mpRequest, WriteCmd writeCmd,TagCmd tagCmd, Model model) throws Exception {
    	
    	// ���ε�� �̹��� ���ε� ���� �˻�
    	if(!mpRequest.getFile("thumbnail").getOriginalFilename().equals("")) {
        	// ����� Ȯ���� �� �뷮 �˻�
        	if(thumbnailCheck.check(mpRequest) == false) {
        		model.addAttribute("msg", "�̹������ϸ� ���ε� �����մϴ�. (�ִ� 5MB)");
        		return "/return/historyback";
        	}
    	}
    	if(!mpRequest.getFiles("file").get(0).getOriginalFilename().equals("")){
        	// �߰� �̹������� Ȯ���� �� �뷮�˻�
           	if(fileCheck.check(mpRequest) == false) {
        		model.addAttribute("msg", "�̹������ϸ� ���ε� �����մϴ�. (�ִ� 5MB)");
        		return "/return/historyback";
        	}
    	}
    	
    	writeService.writeUpdate(writeCmd,tagCmd, mpRequest);
    	model.addAttribute("msg", "�ϱ⸦ �����Ͽ����ϴ�.");
		model.addAttribute("url", "/diary?memberNum=");
		return "/return/diaryAlert";
    }
    
}
