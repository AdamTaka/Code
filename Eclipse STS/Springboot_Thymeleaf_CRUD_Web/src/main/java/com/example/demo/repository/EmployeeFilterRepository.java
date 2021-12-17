package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.model.EmployeeView;

public interface EmployeeFilterRepository extends JpaRepository<EmployeeView, Integer> {
    
	@Query(value = "SELECT a FROM datakaryawan a WHERE nama_kar LIKE ?1% "
			+ " OR tgl_msk LIKE ?1%"
			+ " OR no_hp LIKE ?1%"
			+ " OR lim_reimburse LIKE ?1%"
			+ "  order by id asc")
    public List<EmployeeView> search(String keyword);
}
