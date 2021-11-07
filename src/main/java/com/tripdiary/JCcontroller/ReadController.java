package com.tripdiary.JCcontroller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.project.regist.vo.MemberVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tripdiary.HSvo.PickVo;
import com.tripdiary.HSvo.TagVo;
import com.tripdiary.JCservice.ReadService;
import com.tripdiary.JCvo.BoardImgVo;
import com.tripdiary.JCvo.ReadVo;
import com.tripdiary.JCvo.ReplyCommand;
import com.tripdiary.JCvo.ReplyVo;
import com.tripdiary.JCvo.TdLikeVo;

@Controller
public class ReadController {

	private static final Logger logger = LoggerFactory.getLogger(ReadController.class);

	@Inject
	ReadService service;

	// 게시판 상세 보기 + 댓글 목록
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(ReadVo readVo, ReadViewCmd readCmd, Model model, HttpSession session)
			throws Exception {
		logger.info("read");

		System.out.println(readCmd.toString());

		// 현재 로그인 멤버 확인
		MemberVo memberVo = (MemberVo) session.getAttribute("authInfo");
		System.out.println("readView(memberVo) : " + memberVo.toString());
		model.addAttribute("memberVo", memberVo);

		// 게시글 목록 - boardNum, memberNum, nickname, profileVo
		ReadVo read = service.read(readCmd.getBoardNum());
		System.out.println(read.toString());
		model.addAttribute("read", read);

		// 해당 게시글 댓글 목록 - replyVo, nickname
		List<ReplyCommand> replyList = service.replyList(readCmd.getBoardNum());
		System.out.println(replyList.toString());
		model.addAttribute("replyList", replyList);

		// 보드 이미지 목록
		List<BoardImgVo> boardImgList = service.BoardImgList(read.getBoardNum());
		System.out.println(boardImgList.toString());
		model.addAttribute("boardImgList", boardImgList);

		// 태그
		List<TagVo> tagList = service.tagList(read.getBoardNum());
		System.out.println("tagList : " + tagList.toString());
		model.addAttribute("tagList", tagList);

		// 찜 회원 확인
		PickVo pickVo = new PickVo(memberVo.getMemberNum(), readCmd.getBoardNum());
		System.out.println("pickVo : " + pickVo.toString());

		PickVo pickCheck = service.pickCheck(pickVo);

		if (pickCheck == null) {
			System.out.println("pickCheck 없음");
		} else {
			System.out.println("pickCheck : " + pickCheck.toString());
		}

		model.addAttribute("pickCheck", pickCheck);

		// 좋아요 회원 확인
		TdLikeVo tdLikeVo = new TdLikeVo(memberVo.getMemberNum(), readCmd.getBoardNum());
		System.out.println("tdLikeVo : " + tdLikeVo.toString());

		TdLikeVo tdLikeCheck = service.tdLikeCheck(tdLikeVo);

		if (tdLikeCheck == null) {
			System.out.println("tdLikeCheck 없음");
		} else {
			System.out.println("tdLikeCheck : " + tdLikeCheck.toString());
		}

		model.addAttribute("tdLikeCheck", tdLikeCheck);

		return "readView";
	}

	// 댓글 작성
	@RequestMapping(value = "/replyWrite", method = RequestMethod.POST)
	public String replyWrite(ReplyVo replyVo, ReadViewCmd readCmd, Model model, HttpSession session) throws Exception {
		logger.info("reply Write");

		System.out.println("작성하고 난 후 : " + readCmd.toString());

		// hidden에 들어가는거 - 삭제해야하나??
		ReadVo read = service.read(readCmd.getBoardNum());
		System.out.println(read.toString());
		model.addAttribute("read", read);

		// 현재 로그인 멤버 확인 - 삭제해야함
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
		System.out.println("replyWrite(memberVo) : " + memberVo.toString());
		model.addAttribute("memberVo", memberVo);

		MemberActCntCmd memberActCntCmd = new MemberActCntCmd(readCmd.getBoardNum(), readCmd.getMemberNum(),
				memberVo.getMemberNum(), "reply");

		// 작성
		service.replyWrite(replyVo);
		System.out.println(replyVo.toString());

		memberActCntCmd.setUpdateType("insert");
		service.replyActCnt(memberActCntCmd);
		System.out.println("reply :memberActCntCmd.insert : " + memberActCntCmd.toString());

		return "redirect:/readView?boardNum=" + replyVo.getBoardNum();
	}

	// 댓글 수정 GET
	@RequestMapping(value = "/replyUpdate", method = RequestMethod.GET)
	public String getReplyUpdate(ReplyVo replyVo, Model model, ReadViewCmd readCmd, HttpSession session)
			throws Exception {
		logger.info("reply Update");

		// hidden에 들어가는거 - 삭제해야하나??
		ReadVo read = service.read(readCmd.getBoardNum());
		System.out.println(read.toString());
		model.addAttribute("read", read);

		// 현재 로그인 멤버 확인 - 삭제해야함
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
		System.out.println("replyUpdate(memberVo) : " + memberVo.toString());
		model.addAttribute("memberVo", memberVo);

		System.out.println("replyUpdate,replyVo : " + replyVo.toString());
		ReplyVo replyVoCheck = service.selectReply(replyVo.getReplyNum());
		System.out.println(replyVoCheck.toString());

		// 수정하기위해 replyVo에서 정보 가져오기
		model.addAttribute("selectReply", replyVoCheck);

		return "replyUpdate";
	}

	// 댓글 수정 POST
	@RequestMapping(value = "/replyUpdate", method = RequestMethod.POST)
	public String replyUpdate(ReplyVo replyVo, Model model, ReadViewCmd readCmd, HttpSession session) throws Exception {
		logger.info("reply Update");

		System.out.println("replyUpdate,ㄷㄹㅇ");

		// hidden에 들어가는거 - 삭제해야하나??
		ReadVo read = service.read(readCmd.getBoardNum());
		System.out.println(read.toString());
		model.addAttribute("read", read);

		// 현재 로그인 멤버 확인 - 삭제해야함
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
		System.out.println(memberVo.toString());
		model.addAttribute("memberVo", memberVo);

		// 댓글 작성 업데이트
		service.replyUpdate(replyVo);
		System.out.println(replyVo.toString());

		return "redirect:/readView?boardNum=" + replyVo.getBoardNum();
	}

	// 댓글 삭제 POST
	@RequestMapping(value = "/replyDelete", method = RequestMethod.GET)
	public String replyDelete(ReplyVo replyVo, Model model, ReadViewCmd readCmd, HttpSession session) throws Exception {
		logger.info("reply Delete");

		System.out.println("replyDelete 들어왔다");

		// hidden에 들어가는거 - 삭제해야하나??
		ReadVo read = service.read(readCmd.getBoardNum());
		System.out.println(read.toString());
		model.addAttribute("read", read);

		// 현재 로그인 멤버 확인 - 삭제해야함
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
		System.out.println(memberVo.toString());
		model.addAttribute("memberVo", memberVo);

		MemberActCntCmd memberActCntCmd = new MemberActCntCmd(readCmd.getBoardNum(), readCmd.getMemberNum(),
				memberVo.getMemberNum(), "reply");

		// 댓글 삭제 업데이트
		service.replyDelete(replyVo);
		System.out.println(replyVo.toString());

		memberActCntCmd.setUpdateType("delete");
		System.out.println("reply : memberActCntCmd.insert : " + memberActCntCmd.toString());

		service.replyActCnt(memberActCntCmd);

		return "redirect:/readView?boardNum=" + replyVo.getBoardNum();
	}

}
