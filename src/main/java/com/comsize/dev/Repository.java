package com.comsize.dev;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@org.springframework.stereotype.Repository
public interface Repository {

	@Autowired
	private JdbcTemplate jdbcTmp;
	
	public Map<String, Object> findOne(int id){
		String sql = "SELECT id,name,area FROM employee WHERE id = ?";
		
		Map<String, Object> employee = jdbcTmp.queryForMap(sql,id);
		
		return employee;
	}
}
