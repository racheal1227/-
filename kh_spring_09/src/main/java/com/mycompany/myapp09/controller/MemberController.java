package com.mycompany.myapp09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp09.model.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
		public String idCheck() {
			return "/idCheck";
		}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	@ResponseBody
	public String doIdCheck(@RequestParam("id") String memberId) {
		String resultStr = "";
		int result = 0;
		
		try {
			result = memberService.idCheck(memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (result > 0) {
			resultStr = "false";
		} else {
			resultStr = "true";
		}
		return resultStr;
	}
}
