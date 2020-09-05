package com.web.mypage.dto;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;

import com.web.mypage.dao.TestDAO;





public class TestDTO {
	private static final String NAME_SPACE = "com.web.mapper.TestMapper.";
	private SqlSessionTemplate sqlSession;



	public List<TestDAO> getTestData() throws Exception {
		try {
			return sqlSession.selectList(NAME_SPACE + "selectTest");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
}
