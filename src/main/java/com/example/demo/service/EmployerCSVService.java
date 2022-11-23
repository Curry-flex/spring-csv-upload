package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Employers;
import com.example.demo.helper.Helper;
import com.example.demo.repository.EmployersRepository;

@Service
public class EmployerCSVService {

	 @Autowired
	 private EmployersRepository employersRepository;
	 
	 public void save(MultipartFile file)
	 {
		 try {
			 Helper helper = new Helper();
			 List<Employers> employers =helper.employersCSV(file.getInputStream());
			 employersRepository.saveAll(employers);
			
		} catch (Exception e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	 }
	 
	 public List<Employers>  getEmployersList()
	 {
		 
		 return employersRepository.findAll();
	 }
}
