package com.example.demo.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
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
	JdbcTemplate jdbctemplate;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeFilterRepository service;
	
	@GetMapping("/FormTambahKaryawan")
	public String FormTambahKaryawan(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@GetMapping("/")
	public String viewHomePage(Model model, @Param("keywordnm") String keywordnm,  @Param("keywordtgl") String keywordtgl,  @Param("keywordhp") String keywordhp) {
        List<EmployeeView> listEmployee = employeeService.listAll(keywordnm, keywordtgl, keywordhp);
        model.addAttribute("listEmployee", listEmployee);
        model.addAttribute("keywordnm", keywordnm);
        model.addAttribute("keywordtgl", keywordtgl);
        model.addAttribute("keywordhp", keywordhp);
         
        return "index";
	}
	
	///*
	private int CheckData(String hp, String lim) {
		if (hp.chars().allMatch( Character::isDigit ) ==  true && lim.chars().allMatch( Character::isDigit ) == true) {
			return 1;
		}
		else {
			return 0;
		}
	}//*/
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee, Model model, @ModelAttribute("no_hp") String hp, @ModelAttribute("lim_reimburse") String lim){
		int value = CheckData(hp, lim);
		if (value == 1) {
			employeeService.saveEmployee(employee);
	        return "redirect:/";
		}
		else {
			return "new_employee";
		}
	}
	
	
	@PostMapping("/updateEmployee")
	public String updateEmployee(@ModelAttribute("no_hp") String hp, @ModelAttribute("lim_reimburse") String lim, @ModelAttribute("id") Integer id, 
			@ModelAttribute("nama_kar") String nama, @ModelAttribute("tgl_msk") String tgl){
		int value = CheckData(hp, lim);
		String UPDATE_QUERY = "UPDATE datakaryawan SET nama_kar = ?, tgl_msk = ?, no_hp = ?, lim_reimburse = ?, update_date = ? WHERE id = ?";
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
		if (value == 1) {
				jdbctemplate.update(UPDATE_QUERY,nama, tgl, hp, lim, strDate, id);
	        return "redirect:/";
		}
		else {
			return "update_employee";
		}
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
