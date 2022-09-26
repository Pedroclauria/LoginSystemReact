package com.newdsmeta.newdsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newdsmeta.newdsmeta.entities.Sale;
import com.newdsmeta.newdsmeta.services.SaleService;
import com.newdsmeta.newdsmeta.services.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@Autowired
	private SmsService smsService;
	

	
	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value="minDate", defaultValue="") String minDate, 
			@RequestParam(value="maxDate", defaultValue="") String maxDate,
			Pageable pageable){
		return service.findSales(minDate, maxDate, pageable);
	}
	
	@GetMapping(value = "/search-name")
	public Page<Sale> searchByName(
			@RequestParam(defaultValue = "") String seller_name,
			Pageable pageable){
			Page<Sale> result = service.searchName(seller_name, pageable);
		return result;
	}
	
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
	
	}
