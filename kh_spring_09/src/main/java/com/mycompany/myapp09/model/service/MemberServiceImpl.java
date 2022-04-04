package com.mycompany.myapp09.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp09.model.dao.MemberDAO;
import com.mycompany.myapp09.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO memberDao;
	@Override
	public int idCheck(String memberId) throws Exception {
		return memberDao.idCheck(memberId);
	}
	
}
