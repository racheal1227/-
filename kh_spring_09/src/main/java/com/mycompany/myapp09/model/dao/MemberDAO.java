package com.mycompany.myapp09.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp09.model.vo.Member;

@Repository("MemberDAO")
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public Member idCheck(String memberId) throws Exception {
		Member result = sqlSessionTemplate.selectOne("Member.idCheck", memberId);
		return result;
	}
}
