package com.web.mypage.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

	public int addTodo(String title, String detail) throws Exception {
		return sqlSession.insert(NAME_SPACE + "inserTodo" , getTodoDTO(title, detail));
	}

	public int deleteTodo(int num) throws Exception {
		return sqlSession.delete(NAME_SPACE + "deleteTodo", num);
	}

	public int updateTodo(Map<String, String> map) throws Exception {
		Integer num = Integer.valueOf(map.get("num"));
		String title = map.get("title");
		String detail = map.get("detail");
		Integer done = Integer.valueOf(map.get("done"));
		return sqlSession.update(NAME_SPACE + "updateTodo", getTodoDTO(num.intValue(), title, detail, done, new Date()));
		
	}

	private TodoDTO getTodoDTO(String title, String detail) {
		return getTodoDTO(-1, title, detail, null, null);
	}

	private  TodoDTO getTodoDTO(int num, String title, String detail, Integer done, Date updatedt) {
		TodoDTO todoDTO = new TodoDTO();
		todoDTO.setNum(num);
		todoDTO.setTitle(title);
		todoDTO.setDetail(detail);
		todoDTO.setDone(done);
		todoDTO.setUpdatedt(updatedt);
		return todoDTO;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
}
