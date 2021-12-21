package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeView;
import com.example.demo.repository.EmployeeFilterRepository;

@Service
public interface EmployeeService {
	
	//List<EmployeeView> getAllEmployee();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(Integer Id);
	void HapusKaryawanById(Integer Id);
    List<EmployeeView> listAll(String keywordnm, String keywordtgl, String keywordhp);
}
