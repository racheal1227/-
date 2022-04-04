package com.mycompany.myapp09.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("MemberDAO")
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int idCheck(String memberId) throws Exception {
		int result = 0;
		System.out.println("dao arg: " + memberId);
		result = sqlSessionTemplate.selectOne("Member.idCheck", memberId);
		System.out.println("dao result: " + result);
		return result;
	}
}
