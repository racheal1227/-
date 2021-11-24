package com.mycompany.homework.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.homework.model.dao.MemberDAO;
import com.mycompany.homework.model.vo.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDAO memberDAO;

	@Override
	public int signUp(Member member) throws Exception{
		return memberDAO.signUp(member);
	}

}
