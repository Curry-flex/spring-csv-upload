package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.DTO.ResponseMessage;
import com.example.demo.entity.Employers;
import com.example.demo.helper.Helper;
import com.example.demo.service.EmployerCSVService;

@RestController
@RequestMapping("api/v1/")
public class EmplyerCSVController {
	
	@Autowired
	private EmployerCSVService employerCSVService;
	
	@Autowired
	private Helper helper;
	
	@PostMapping("upload")
	
	public ResponseEntity<ResponseMessage> uploadCSVFiles(@RequestParam("file") MultipartFile file)
	{
		String message ="";
		if(helper.checkisCSVFile(file))
		{
			try {
				employerCSVService.save(file);
				message = "file uploaded successfully " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Could not upload the file: " + e.getMessage() + "!";
			     return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}
		
		message = "Please upload an csv file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}
	
	@GetMapping("employers")
	
	public ResponseEntity<List<Employers>> getEmployersList()
	{
		try {
		List<Employers> empList =employerCSVService.getEmployersList();
		return new ResponseEntity<>(empList,HttpStatus.OK);
		} catch (Exception e) {
			 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
