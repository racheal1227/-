package com.mycompany.homework.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mycompany.homework.model.vo.Member;

@Repository("MemberDAO")
public class MemberDAO {
	
//	Autowired 역할: 1. type이 같은 애 찾아주기 2. 이름이 같은 애 찾아주기
//	root-context bean에 설정된 이름. 무조건 동일하게 설정. 2개 이상 설정될 수 있기 때문에 확실하게 명시해 주기 위해
//	@Qualifier 어노테이션으로 명시 가능.
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
//	insert문이라서 return type int. parameter 인수로 넣어줌.
	public int signUp(Member member) throws Exception{
		System.out.println("Dao Member vo: " + member);
//		Member.signUp == Statement
//		(statement, parameter)
//		여기서 결과값 숫자로 받음!
		int result = sqlSessionTemplate.insert("Member.signUp", member);
		System.out.println("result: " + result);
		return result;
	}
//	함수 복사해서 Service로 이동
}
