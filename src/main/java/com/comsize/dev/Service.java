package com.comsize.dev;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

//@Serviceアノテーション＝サービスクラスにつけるアノテーション
@org.springframework.stereotype.Service
public class Service {
	@Autowired
	private HelloRepository repository;
	
	public Employee findOne(int id) {
		Map<String, Object> map = repository.findOne(id);
		
		int employeeId = (Integer)map.get("Id");
		String employeeName = (String)map.get("Name");
		String employeeArea = (String)map.get("Area");
		
		Employee employee = new Employee();
		employee.setId(employeeId);
		employee.setName(employeeName);
		employee.setArea(employeeArea);

		return employee; 
	}
}
