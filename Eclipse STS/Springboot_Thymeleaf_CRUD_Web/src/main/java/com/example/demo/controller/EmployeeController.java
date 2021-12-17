package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeFilterRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

import org.springframework.jdbc.core.JdbcTemplate;
import com.example.demo.model.EmployeeView;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeFilterRepository service;
	/*@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EmployeeRepository repository;*/
	
	/*@GetMapping("/")
	public String viewHomePage (Model model) {
		model.addAttribute("listEmployee", employeeService.getAllEmployee());
		return "index";
	}*/
	
	@GetMapping("/FormTambahKaryawan")
	public String FormTambahKaryawan(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@GetMapping("/")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<EmployeeView> listEmployee = employeeService.listAll(keyword);
        model.addAttribute("listEmployee", listEmployee);
        model.addAttribute("keyword", keyword);
         
        return "index";
	}
	
	/*
	private void CheckData(String namakar, String tglmsk, String nohp, String lim) {
		if (namakar.isBlank() || tglmsk.isBlank() || nohp.chars().allMatch( Character::isDigit ) || nohp.isBlank() || 
				lim.chars().allMatch( Character::isDigit ) || lim.isBlank())
		{
			
		}
		else
		{
			String sql = "select count(*) from datakaryawan";
			int id = 0;
			int number = jdbcTemplate.queryForObject(sql, new Object[] { id }, int.class) + 1;
			String angka;
			if (number < 10){
				angka = "00" + number;
			}
			else if (number < 100 && number >= 10){
				angka = "0" + number;
			}
			else {
				angka = "" + number;
			}
			sql = "INSERT INTO datakaryawan (personid, nama_kar, tgl_msk, no_hp, lim_reimburse) VALUES ("
	                + "'K-"+ angka +"', '" + namakar + "', '" + tglmsk + "', '" + nohp + "', '" + lim + "')";
	         
	        jdbcTemplate.update(sql);
		}
	}//*/
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee, Model model){
		/*
		String namakar = "", tglmsk = "", nohp = "", lim = "";
		model.addAttribute(namakar, employee.getNama_kar());
		model.addAttribute(tglmsk, employee.getNama_kar());
		model.addAttribute(nohp, employee.getNama_kar());
		model.addAttribute(lim, employee.getNama_kar());//*/
		/*
		String namakar = employee.getNama_kar();
		String tglmsk = employee.getTgl_msk();
		String nohp = "" + employee.getNo_hp();
		String lim = "" + employee.getLim_reimburse();//*/
		//CheckData(namakar, tglmsk, nohp, lim);
		employeeService.saveEmployee(employee);
        return "redirect:/";
	}
	
	@GetMapping("/FormUpdateKaryawan/{id}")
    public String FormUpdateKaryawan(@PathVariable(value = "id") Integer id, Model model) {

        Employee employee = employeeService.getEmployeeById(id);

        model.addAttribute("employee", employee);
        return "update_employee";
    }
	
	@GetMapping("/HapusKaryawan/{id}")
    public String HapusKaryawan(@PathVariable(value = "id") Integer id) {

        this.employeeService.HapusKaryawanById(id);
        return "redirect:/";
    }
}
