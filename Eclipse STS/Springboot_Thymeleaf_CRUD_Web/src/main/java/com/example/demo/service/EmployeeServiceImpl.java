package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeView;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeRepositoryView;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeerepository;

	@Autowired
	private EmployeeRepositoryView employeerepositoryv;
	
	@Override
	public List<EmployeeView> getAllEmployee() {
		return employeerepositoryv.findAllByOrderByIdAsc();
	}
	
	@Override
	public void saveEmployee(Employee employee) {
		this.employeerepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		 Optional < Employee > optional = employeerepository.findById(id);
	        Employee employee = null;
	        if (optional.isPresent()) {
	            employee = optional.get();
	        } else {
	            throw new RuntimeException(" Karyawan dengan id :: " + id + "tidak ditemukan");
	        }
	        return employee;
	}
	
	@Override
	public void HapusKaryawanById(Integer Id) {
		this.employeerepository.deleteById(Id);
	}

}
