package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.OrderByField;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EmployeeView;

@Repository
public interface EmployeeRepositoryView extends JpaRepository<EmployeeView, Integer>{
	public List<EmployeeView> findAllByOrderByIdAsc();
}