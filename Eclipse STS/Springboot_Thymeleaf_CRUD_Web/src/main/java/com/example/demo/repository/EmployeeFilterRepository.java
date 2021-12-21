package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.model.EmployeeView;

public interface EmployeeFilterRepository extends JpaRepository<EmployeeView, Integer> {
    
	@Query(value = "SELECT a FROM datakaryawan a WHERE nama_kar LIKE ?1% "
			+ " AND tgl_msk LIKE ?2%"
			+ " AND no_hp LIKE ?3%"
			+ "  order by id asc")
    public List<EmployeeView> search(String keywordnm, String keywordtgl, String keywordhp);
	
}
