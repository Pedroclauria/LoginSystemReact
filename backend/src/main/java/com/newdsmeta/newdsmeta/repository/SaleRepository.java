package com.newdsmeta.newdsmeta.repository;


import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.newdsmeta.newdsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
	
	@Query("SELECT obj FROM Sale obj WHERE LOWER(obj.sellerName) LIKE LOWER(CONCAT('%',:seller_name,'%'))")
	Page<Sale> searchName(String seller_name, Pageable pageable);
}


