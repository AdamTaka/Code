package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeView;

public interface EmployeeService {
	List<EmployeeView> getAllEmployee();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(Integer Id);
	void HapusKaryawanById(Integer Id);
}
