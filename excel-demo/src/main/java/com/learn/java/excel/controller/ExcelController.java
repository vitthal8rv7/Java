package com.learn.java.excel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.excel.model.request.ExcelRequest;
import com.learn.java.excel.service.ExcelService;

import io.micrometer.common.util.StringUtils;

@RestController
@RequestMapping("/excel/demo")
public class ExcelController {

	@Autowired
	public ExcelService excelService;

	@GetMapping("/read/old/excel/file")
	public void readOldExcelFile(@RequestParam(required = false) String file) {
		if (StringUtils.isBlank(file)) {
			file = "file1.xls";
		}
		excelService.readOldFile(file);
	}

	@GetMapping("/read/excel/file")
	public void readExcelFile(@RequestParam(required = false) String file) {
		if (StringUtils.isBlank(file)) {
			file = "file2.xlsx";
		}
		excelService.readFile(file);
	}
	
	@PostMapping("/write/old/excel/file")
	public void writeOldExcelFile(@RequestBody ExcelRequest excelRequestBody) {
		excelService.writeToOldFiles(excelRequestBody);
	}

}
