package com.tripdiary.JCcontroller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.project.regist.vo.MemberVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tripdiary.JCservice.ReadService;
import com.tripdiary.JCvo.TdLikeVo;

@Controller
public class TdLikeController {

	@Inject
	ReadService service;

	@RequestMapping(value = "/likeClick", method = RequestMethod.GET)
	public String tdlike(TdLikeVo tdlikeVo, ReadViewCmd readCmd, Model model, HttpSession session) throws Exception {
		// 현재 로그인 멤버 확인
		MemberVo memberVo = (MemberVo) session.getAttribute("authInfo");
		System.out.println("readView(memberVo) : " + memberVo.toString());
		model.addAttribute("memberVo", memberVo);

		if (tdlikeVo != null) {
			System.out.println("pickVo : " + tdlikeVo.toString());
		} else {
			System.out.println("널");
		}

		// 만약 memberVo가 null이 아니고 member의 memberNum과 readCmd의 boardNum이 같다면 ,
		// 로그인상태에서 동작 확인
		String url = "";

		if (memberVo != null) {
			System.out.println(memberVo.toString() + "이게 언제 뽑히냐");

			MemberActCntCmd memberActCntCmd = new MemberActCntCmd(readCmd.getBoardNum(), readCmd.getMemberNum(),
					memberVo.getMemberNum(), "like");

			TdLikeVo tdLikeCheck = service.tdLikeCheck(tdlikeVo);
			model.addAttribute("tdLikeCheck", tdLikeCheck);
			// 해당 회원의 memberNum으로 조회한 tdLike테이블을 List로 가져와서
			// 리스트일때 통째로 비교할때 is empty -- 공부해야함
			if (tdLikeCheck != null) {
				// 안비어있으면 삭제
				service.deleteTdlike(tdlikeVo);
				memberActCntCmd.setUpdateType("delete");
				
				System.out.println("삭제 후 readCmd(당연히 없겠찌..) : " + readCmd);
				System.out.println("delete : " + tdLikeCheck.toString());
				System.out.println("memberActCntCmd.delete : " + memberActCntCmd.toString());

				url = "redirect:/readView?boardNum=" + tdLikeCheck.getBoardNum() + "&memberNum="
						+ tdLikeCheck.getMemberNum();
			} else {
				// 비어있으면 insert
				service.insertTdlike(tdlikeVo);
				memberActCntCmd.setUpdateType("insert");
				
				System.out.println("찜한 후 readCmd : " + readCmd);
				System.out.println("readCmd.insert : " + tdlikeVo.toString());
				System.out.println("memberActCntCmd.insert : " + memberActCntCmd.toString());

				url = "redirect:/readView?boardNum=" + tdlikeVo.getBoardNum() + "&memberNum=" + tdlikeVo.getMemberNum();
			}
			service.boardTotalLike(memberActCntCmd);
			service.memberActCntCmd(memberActCntCmd);
			service.memberLikeReceiveCnt(memberActCntCmd);
			// return "redirect:/readView?boardNum=" + readCmd.getBoardNum();
		}
		// delete 동작 후
		return url;

//	// pickCheck
	}

}