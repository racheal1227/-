package com.mycompany.myapp09.model.service;

import com.mycompany.myapp09.model.vo.Member;

public interface MemberService {
	public abstract int idCheck(Member member) throws Exception;
}
