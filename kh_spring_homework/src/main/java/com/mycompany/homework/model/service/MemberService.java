package com.mycompany.homework.model.service;

import com.mycompany.homework.model.vo.Member;

public interface MemberService {
	public abstract int signUp(Member member) throws Exception;
}
