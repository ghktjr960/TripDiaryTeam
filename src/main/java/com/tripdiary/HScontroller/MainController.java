package com.tripdiary.HScontroller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tripdiary.HSservice.MainService;
import com.tripdiary.HSvo.MainBoardListVo;
import com.tripdiary.HSvo.MemberVo;
import com.tripdiary.HSvo.PageVo;
import com.tripdiary.HSvo.PickVo;
import com.tripdiary.HSvo.ProfileImgVo;
import com.tripdiary.HSvo.TagVo;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Inject
	private MainService mainService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String main() {
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainView(Model model, PageVo pageVo, HttpSession session) throws Exception {

		logger.info("main");
		
		try {
			// pageVo : 정렬(sort), 여행지검색(place), 태그(tag)를 가지고 있는 객체
			// pageVo의 sort, place, tag값이 어떤게 들어왔는지 확인
			System.out.println("sort : " +  pageVo.getSort());
			System.out.println("place : " +  pageVo.getPlace());
			System.out.println("tag : " +  pageVo.getTag());

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
			int total = mainService.listCount(pageVo);
			if(pageVo.getPage() == null) {
				pageVo.setPage(1);
			}
			pageVo = new PageVo(pageVo.getSort(), pageVo.getPlace(), pageVo.getTag(), total, pageVo.getPage());
			System.out.println("pageVo toSting" + pageVo.toString());
			model.addAttribute("paging", pageVo);
			
			System.out.println("pageVo : " + pageVo.toString());

			// 메인페이지에서 보여줄 게시글들을 가져옴
			List<MainBoardListVo> mainBoardList = mainService.mainBoardList(pageVo);
			
			// 게시글 결과가 존재하지 않을 경우를 파악하기 위해 사용
			if(mainBoardList.isEmpty()) {
				model.addAttribute("mainBoardList", null);
				System.out.println("mainBoardList 내용 없음");
			} else {
				model.addAttribute("mainBoardList", mainBoardList);
				System.out.println(mainBoardList.toString());
			}

			// 메인페이지에서 게시글을 보여줄 때 사용하기 위한 태그결과
			// 각 게시글 마다 회원 닉네임, 게시글 정보, 태그등을 보여주는데 사용하는 코드
			if(pageVo.getTag() != null && !pageVo.getTag().equals("")) {
				// 태그검색을 했을 경우
				List<TagVo> mainTagList = mainService.tagSearch(pageVo);
				System.out.println(mainTagList.toString());
				model.addAttribute("mainTagList", mainTagList);
			} else {
				// 태그검색을 안했거나 검색어가 없을 경우
				List<TagVo> mainTagList = mainService.mainTagList();
				System.out.println(mainTagList.toString());
				model.addAttribute("mainTagList", mainTagList);
			}

			// 로그인 테스트용 코드 삭제해야됨 : 시작 
			// 세션에 저장되어 있는 로그인 세션을 검사하여 있다면 해당 세션에 저장된 회원번호를 통해 프로필 사진에 대한 정보를 가져온다.
			MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
			if(memberVo != null) {
				System.out.println(memberVo.toString());
				// 로그인 된 회원의 찜하기 여부 확인 => main에서 사용
				List<PickVo> mainPickList = mainService.mainPickList(memberVo.getMemberNum());
				System.out.println(mainPickList.toString());
				model.addAttribute("mainPickList", mainPickList);

				// 로그인 된 회원의 프로필 사진 정보 가져올 DB : 세션에 저장된 회원번호로 사용 => header에서 사용
				ProfileImgVo profileImgVo = mainService.profileImg(memberVo.getMemberNum());
				System.out.println("profileImgVo : " + profileImgVo);
				session.setAttribute("profileImg", profileImgVo);
			}
			// 로그인 테스트용 코드 삭제해야됨 : 끝

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/main/main";
	}
	
}
