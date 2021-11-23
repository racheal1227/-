package com.mycompany.homework.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.homework.model.vo.Member;

@Repository("MemberDAO")
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public int signUp(Member member) {
		return sqlSession.insert("Member.signUp", member);
	}
}
