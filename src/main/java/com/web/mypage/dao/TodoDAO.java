package com.web.mypage.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.web.mypage.dto.TodoDTO;

public class TodoDAO {
	private static final String NAME_SPACE = "com.web.mapper.TodoMapper.";
	private SqlSessionTemplate sqlSession;

	public List<TodoDTO> getTodoList() throws Exception {
		try {
			return sqlSession.selectList(NAME_SPACE + "selectTodoList");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
}
