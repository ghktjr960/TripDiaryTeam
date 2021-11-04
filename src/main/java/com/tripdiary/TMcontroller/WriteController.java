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

		return "/write";
	}
	
    @RequestMapping(value="/write", method=RequestMethod.POST) 
    public String write(WriteCmd writeCmd,TagCmd tagCmd, MapCmd mapCmd, Model model, MultipartHttpServletRequest mpRequest) throws Exception {
    	//占쏙옙표 占쏙옙占쏙옙占쏙옙 占쏙옙占쌕몌옙 占쏙옙占시�
    	if(mpRequest.getFile("thumbnail").getOriginalFilename().equals("")) {
    		model.addAttribute("msg", "占쏙옙표 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙玲占쏙옙占�.");
    		return "/return/historyback";
    	}
    	// 占쏙옙占싸듸옙占� 占싱뱄옙占쏙옙 占쏙옙占싸듸옙 占쏙옙占쏙옙 占싯삼옙
    	if(!mpRequest.getFile("thumbnail").getOriginalFilename().equals("")) {
        	// 占쏙옙占쏙옙占� 확占쏙옙占쏙옙 占쏙옙 占쎈량 占싯삼옙
        	if(thumbnailCheck.check(mpRequest) == false) {
        		model.addAttribute("msg", "占싱뱄옙占쏙옙占쏙옙占싹몌옙 占쏙옙占싸듸옙 占쏙옙占쏙옙占쌌니댐옙. (占쌍댐옙 5MB)");
        		return "/return/historyback";
        	}
    	}
    	if(!mpRequest.getFiles("file").get(0).getOriginalFilename().equals("")){
        	// 占쌩곤옙 占싱뱄옙占쏙옙占쏙옙占쏙옙 확占쏙옙占쏙옙 占쏙옙 占쎈량占싯삼옙
           	if(fileCheck.check(mpRequest) == false) {
        		model.addAttribute("msg", "占싱뱄옙占쏙옙占쏙옙占싹몌옙 占쏙옙占싸듸옙 占쏙옙占쏙옙占쌌니댐옙. (占쌍댐옙 5MB)");
        		return "/return/historyback";
        	}
    	}
    	writeService.write(writeCmd,tagCmd,mapCmd, mpRequest);
    	model.addAttribute("msg", "占쏙옙占싸울옙 占싹기를 占쌜쇽옙占싹울옙占쏙옙占싹댐옙.");
		model.addAttribute("url", "/diary?memberNum=");
		return "/return/diaryAlert";
    }
    
    
	@RequestMapping(value = "/writeUpdate", method = RequestMethod.GET)
	public String writeUpdate(HttpSession session,Model model, int boardNum) {
		WriteCmd board = writeService.getBoard(boardNum);
/*		int memberNum = (int) session.getAttribute("loginMemberNum");
		//占쌜쇽옙占쏙옙占쏙옙占쏙옙 占싯삼옙
    	if(memberNum != board.getMemberNum()) {
    		model.addAttribute("msg", "占쌜쇽옙占쌘몌옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쌌니댐옙.");
    		return "/return/historyback";
    	}*/
		model.addAttribute("mainImg", writeService.getMainImg(boardNum));
		model.addAttribute("subImg", writeService.getSubImg(boardNum));
		model.addAttribute("boardNum", boardNum);
		model.addAttribute("board", board);
		model.addAttribute("tag", writeService.getTag(boardNum));
		return "/writeUpdate";
	}
	
	
    @RequestMapping(value="/writeUpdate", method=RequestMethod.POST) 
    public String writeUpdate(MultipartHttpServletRequest mpRequest, WriteCmd writeCmd,TagCmd tagCmd, Model model) throws Exception {
    	
    	// 占쏙옙占싸듸옙占� 占싱뱄옙占쏙옙 占쏙옙占싸듸옙 占쏙옙占쏙옙 占싯삼옙
    	if(!mpRequest.getFile("thumbnail").getOriginalFilename().equals("")) {
        	// 占쏙옙占쏙옙占� 확占쏙옙占쏙옙 占쏙옙 占쎈량 占싯삼옙
        	if(thumbnailCheck.check(mpRequest) == false) {
        		model.addAttribute("msg", "占싱뱄옙占쏙옙占쏙옙占싹몌옙 占쏙옙占싸듸옙 占쏙옙占쏙옙占쌌니댐옙. (占쌍댐옙 5MB)");
        		return "/return/historyback";
        	}
    	}
    	if(!mpRequest.getFiles("file").get(0).getOriginalFilename().equals("")){
        	// 占쌩곤옙 占싱뱄옙占쏙옙占쏙옙占쏙옙 확占쏙옙占쏙옙 占쏙옙 占쎈량占싯삼옙
           	if(fileCheck.check(mpRequest) == false) {
        		model.addAttribute("msg", "占싱뱄옙占쏙옙占쏙옙占싹몌옙 占쏙옙占싸듸옙 占쏙옙占쏙옙占쌌니댐옙. (占쌍댐옙 5MB)");
        		return "/return/historyback";
        	}
    	}
    	
    	writeService.writeUpdate(writeCmd,tagCmd, mpRequest);
    	model.addAttribute("msg", "占싹기를 占쏙옙占쏙옙占싹울옙占쏙옙占싹댐옙.");
		model.addAttribute("url", "/diary?memberNum=");
		return "/return/diaryAlert";
    }
    
}
