package com.learn.java.excel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.excel.service.ExcelService;

@RestController
@RequestMapping("/excel/demo")
public class ExcelController {

	@Autowired
	public ExcelService excelService;

	@GetMapping("/read/old/excel/file")
	public void readOldExcelFile() {
		String file = "file1.xls";
		excelService.readOldFile(file);
	}

	@GetMapping("/read/excel/file")
	public void readExcelFile() {
		String file = "file1.xlsx";
		excelService.readFile(file);
	}
}
