package com.example.demo.helper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Employers;

@Service
public class Helper {
	
	public static String TYPE ="text/csv";
	public String[] HEADERS = {"id","fname","lname","depertment","active"};
	//check excel fole format
	public boolean checkisCSVFile(MultipartFile file)
	{
		if(!TYPE.equals(file.getContentType()))
		{
			return false;
		}
		return true;
	}
	
	//Read Excel file
	
	public List<Employers> employersCSV(InputStream is)
	{
	
		try {
			//CREATE BEFFEREDREADER FROM INPUTSTREAM
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			//create CSV parser from buffered reader and csv format
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			
			List<Employers> employers = new ArrayList<Employers>();
			List<CSVRecord> csvRecords =csvParser.getRecords();
			
			for(CSVRecord csvRecord : csvRecords) {
				
				
				Employers employer = new Employers(Long.parseLong(csvRecord.get("id")),
						                          csvRecord.get("fname"),
						                          csvRecord.get("lname"),
						                          csvRecord.get("depertment"),
						                          false);
				employers.add(employer);
			}
			
			return employers;
			
		} catch (Exception e) {
			  throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

}
