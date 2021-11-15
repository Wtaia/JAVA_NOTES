package com.taiacloud.team.junit;

import org.junit.Test;

import com.taiacloud.team.domain.Employee;
import com.taiacloud.team.service.NameListService;
import com.taiacloud.team.service.TeamException;

/**
 * 
 * @Description 对NameListService类的单元测试
 * @author taia
 * @version 
 * @date 2021年10月11日上午11:46:28
 *
 */
public class NameListServiceTest {
	@Test
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		
		for(int i = 0;i < employees.length;i++) {
			System.out.println(employees[i]);
		}
	}
	
	
	@Test
	public void testGetEmployee(){
		NameListService service = new NameListService();
		int id = 1;
		id = 10;
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
