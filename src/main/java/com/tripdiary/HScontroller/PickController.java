package com.tripdiary.HScontroller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tripdiary.HSservice.PickService;
import com.tripdiary.HSvo.MainBoardListVo;
import com.tripdiary.HSvo.MemberVo;
import com.tripdiary.HSvo.PageVo;
import com.tripdiary.HSvo.PickVo;
import com.tripdiary.HSvo.ProfileImgVo;
import com.tripdiary.HSvo.TagVo;

@Controller
public class PickController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Inject
	private PickService pickService;	
	
	// 찜하기 버튼을 눌렀을 때 작동되는 코드
	@RequestMapping(value = "/pickClick", method = RequestMethod.GET)
	public String pickClick(PickVo pickVo, HttpServletRequest request, 
							HttpServletResponse response, HttpSession session) throws Exception {
		
		// pickVo에 해당하는 데이터확인
		System.out.println("pickVo : " + pickVo.toString());
		
		// 로그인 상태에서만 동작 : 세션검사
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");		
		if(memberVo != null && memberVo.getMemberNum() == pickVo.getMemberNum()) {
			// 회원이 로그인된 상태이고 로그인한 회원과 찜하기를 누른 회원이 같은지 검사 후 같다면 동작
			System.out.println(memberVo.toString());
			
			PickVo pickCheck = pickService.pickCheck(pickVo);
			// main에서 가져온 pickVo에 해당하는 정보가 Pick테이블에 존재하는지 확인
			// 만약 pick테이블에서 가져오는 정보가 없다면 찜하기를 누르지 않은 상태,
			// 만약 pick테이블에서 가져오는 정보가 있다면 찜하기를 누른 상태
			System.out.println("pickCheck : " + pickCheck);
			PickCmd pickCmd = null;
			String updateType = null;
			// mybatis에서 updateQuery를 받아 insert면 +1 delete면 -1해줘야됨

			if(pickCheck == null) {
				// 테이블에 데이터가 없을 경우 : pick테이블에 찜하기를 눌렀다는 의미로 데이터를 저장, member_act_cnt + 1
				updateType = "insert";
				pickCmd = new PickCmd(pickVo.getMemberNum(), pickVo.getBoardNum(), updateType);
				pickService.pickInsert(pickCmd);
				pickService.memberActCntPick(pickCmd);
				return "redirect:/";
			} else {
				// 테이블에 데이터가 있을 경우 : pick테이블에 찜하기를 취소했다는 의미로 데이터를 삭제, member_act_cnt - 1
				updateType = "delete";
				pickCmd = new PickCmd(pickCheck.getMemberNum(), pickCheck.getBoardNum(), updateType);
				pickService.pickDelete(pickCheck);
				pickService.memberActCntPick(pickCmd);
				return "redirect:/";
			}
			
		} else {
			// 로그인 상태가 아닐 경우 아무런 동작을 하지 않는다.
			return "redirect:/";
		}
	}
	
	// 찜하기 버튼을 눌렀을 때 작동되는 코드
	@RequestMapping(value = "/pickPageClick", method = RequestMethod.GET)
	public String pickPageClick(PickVo pickVo, HttpServletRequest request, 
			HttpServletResponse response, HttpSession session) throws Exception {
		
		// pickVo에 해당하는 데이터확인
		System.out.println("pickVo : " + pickVo.toString());
		
		// 로그인 상태에서만 동작 : 세션검사
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");		
		if(memberVo != null && memberVo.getMemberNum() == pickVo.getMemberNum()) {
			// 회원이 로그인된 상태이고 로그인한 회원과 찜하기를 누른 회원이 같은지 검사 후 같다면 동작
			System.out.println(memberVo.toString());
			
			PickVo pickCheck = pickService.pickCheck(pickVo);
			// main에서 가져온 pickVo에 해당하는 정보가 Pick테이블에 존재하는지 확인
			// 만약 pick테이블에서 가져오는 정보가 없다면 찜하기를 누르지 않은 상태,
			// 만약 pick테이블에서 가져오는 정보가 있다면 찜하기를 누른 상태
			System.out.println("pickCheck : " + pickCheck);
			PickCmd pickCmd = null;
			String updateType = null;
			// mybatis에서 updateQuery를 받아 insert면 +1 delete면 -1해줘야됨
			
			if(pickCheck == null) {
				// 테이블에 데이터가 없을 경우 : pick테이블에 찜하기를 눌렀다는 의미로 데이터를 저장, member_act_cnt + 1
				updateType = "insert";
				pickCmd = new PickCmd(pickVo.getMemberNum(), pickVo.getBoardNum(), updateType);
				pickService.pickInsert(pickCmd);
				pickService.memberActCntPick(pickCmd);
				return "redirect:/pick";
			} else {
				// 테이블에 데이터가 있을 경우 : pick테이블에 찜하기를 취소했다는 의미로 데이터를 삭제, member_act_cnt - 1
				updateType = "delete";
				pickCmd = new PickCmd(pickCheck.getMemberNum(), pickCheck.getBoardNum(), updateType);
				pickService.pickDelete(pickCheck);
				pickService.memberActCntPick(pickCmd);
				return "redirect:/pick";
			}
			
		} else {
			// 로그인 상태가 아닐 경우 아무런 동작을 하지 않는다.
			return "redirect:/pick";
		}
	}
	
	@RequestMapping(value = "/pick", method = RequestMethod.GET)
	public String pick(Model model, PageVo pageVo, HttpSession session) throws Exception {
		session.removeAttribute("sort");
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
		
		if(memberVo != null) {
			// pageVo : 정렬(sort), 여행지검색(place), 태그(tag)를 가지고 있는 객체
			// pageVo의 sort, place, tag값이 어떤게 들어왔는지 확인
			System.out.println("pick페이지 sort : " +  pageVo.getSort());
			System.out.println("pick페이지 place : " +  pageVo.getPlace());
			System.out.println("pick페이지 tag : " +  pageVo.getTag());
	
			if(pageVo.getSort() == null && session.getAttribute("sort") == null) {
				// 페이지가 처음 실행됐을 때 정렬값이 아예 존재하지 않는 경우 초기 정렬값 설정
				pageVo.setSort("regdate"); 
				session.setAttribute("sort", pageVo.getSort());
			} else if(pageVo.getSort() == null && session.getAttribute("sort") != null) {
				// 요청되는 정렬값은 없지만 세션에 저장된 정렬값이 있을경우 : 정렬상태를 유지시키기 위한 작업
				pageVo.setSort((String) session.getAttribute("sort")); 
			} else if(pageVo.getSort() != null) {
				// 새로운 정렬값이 들어왔을 때
				session.setAttribute("sort",  pageVo.getSort());
			}
			
			// 여행지검색(place), 태그(tag)를 계속사용하여 결과를 유지시키기 위해 세션에 저장
			model.addAttribute("place",  pageVo.getPlace());
			model.addAttribute("tag",  pageVo.getTag());
	
			// 페이징 처리
			int total = pickService.listCount(pageVo);
			System.out.println("pickController total : " + total);
			if(pageVo.getPage() == null) {
				pageVo.setPage(1);
			}
			pageVo = new PageVo(pageVo.getSort(), pageVo.getPlace(), pageVo.getTag(), total, pageVo.getPage(), memberVo.getMemberNum());
			System.out.println("pick페이지 pageVo toSting" + pageVo.toString());
			model.addAttribute("paging", pageVo);
			
			System.out.println("pick페이지 pageVo : " + pageVo.toString());
	
			// 메인페이지에서 보여줄 게시글들을 가져옴
			List<MainBoardListVo> pickPageList = pickService.pickPageList(pageVo);
			
			// 게시글 결과가 존재하지 않을 경우를 파악하기 위해 사용
			if(pickPageList.isEmpty()) {
				model.addAttribute("pickPageList", null);
				System.out.println("pick페이지 pickPageList 내용 없음");
			} else {
				model.addAttribute("pickPageList", pickPageList);
				System.out.println("pick페이지 " + pickPageList.toString());
			}
	
			// 메인페이지에서 게시글을 보여줄 때 사용하기 위한 태그결과
			// 각 게시글 마다 회원 닉네임, 게시글 정보, 태그등을 보여주는데 사용하는 코드
			if(pageVo.getTag() != null && !pageVo.getTag().equals("")) {
				// 태그검색을 했을 경우
				List<TagVo> pickPageTagList = pickService.tagSearch(pageVo);
				System.out.println("pick페이지 " + pickPageTagList.toString());
				model.addAttribute("pickPageTagList", pickPageTagList);
			} else {
				// 태그검색을 안했거나 검색어가 없을 경우
				List<TagVo> pickPageTagList = pickService.pickPageTagList();
				System.out.println("pick페이지 " + pickPageTagList.toString());
				model.addAttribute("pickPageTagList", pickPageTagList);
			}
	
			// 로그인 테스트용 코드 삭제해야됨 : 시작 
			// 세션에 저장되어 있는 로그인 세션을 검사하여 있다면 해당 세션에 저장된 회원번호를 통해 프로필 사진에 대한 정보를 가져온다.
			
			// 로그인 된 회원의 프로필 사진 정보 가져올 DB : 세션에 저장된 회원번호로 사용 => header에서 사용
			ProfileImgVo profileImgVo = pickService.profileImg(memberVo.getMemberNum());
			System.out.println("pick페이지 profileImgVo : " + profileImgVo);
			session.setAttribute("profileImg", profileImgVo);
			
			// 로그인 테스트용 코드 삭제해야됨 : 끝		
			return "/pick/pick";
		} else {
			return "redirect:/";
		}
		
	}
}
