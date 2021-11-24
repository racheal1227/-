package com.mycompany.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.homework.model.service.MemberService;
import com.mycompany.homework.model.vo.Member;

//session 어노테이션 달아주면 이름이 같은 Model을 session처럼 동작하게.
//httpSession scope만큼은 아니고 reauest의 scope만큼. model만큼 한 페이지 이동할 때까지만.
//f5 중복실행되지 않고 한 번 전달되면 다시읽기 되지 않음.
@Controller
@SessionAttributes("msg")
public class MemberController {
	
//	Controller는 Dao에 직접 연결하지 않아! Service만 통해서.
	@Autowired
	MemberService memberService;
	
//	문제: 회원가입 요청 URL을 매핑하여 서비스 호출 및 뷰 연결처리를 하는 메소드
	@RequestMapping(value="/signUp", method = RequestMethod.POST)
	public String signUp(Member member, Model model) {
		/*
		@RequestParam(name="memberId", required=false) String id // 파라미터값이 없을 수도 있다!
		, @RequestParam(name="memberPwd", defaultValue="") String pw
		, @RequestParam("memberName") String name
		db테이블이 아니라 view에서 넘어오는 이름을 기준으로 변수이름 설정. 아니면 이렇게 넣어야 해.
		함수에서 변수를 일일히 다 가져오지 않고 Member vo로 한꺼번에 넣을 수 있는 이유가 이름이 같기 때문.
		아니면 set으로 하나씩 다 넣기.
		 */
		
		int result = 0;
		String msg = "";
		
//		dao - service - serviceImpl에서 전부 throws exception했기 때문에 예외 여기서 다룸. 
		try {
			result = memberService.signUp(member);
			if(result > 0) {
				msg = "회원가입 성공";
			} else {
				msg = "회원가입 실패";
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "회원가입 과정에서 오류 발생";
		}
		model.addAttribute("msg", msg);
		
//		redirect 기능 url replace 해 줌. 지금 'signUp'이 아니라 '/'가 보이게. HashMap을 다시 거치러 간다.
//		forward 기능 view(.jsp) 호출. ajax도 url에 안 보임.
		return "redirect:/";
	}

}
