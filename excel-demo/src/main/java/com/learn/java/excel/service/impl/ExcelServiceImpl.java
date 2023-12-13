package com.learn.java.excel.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.learn.java.excel.service.ExcelService;

@Service
public class ExcelServiceImpl implements ExcelService {

	@Override
	public void readOldFile(String file) {
		System.out.println("This API is used to read and print excel (old file format).");
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(file));
			Workbook workbook = new HSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				for (Cell cell : row) {
					switch (cell.getCellType()) {
					case STRING:
						System.out.print(" " + cell.getStringCellValue());
						break;
					case NUMERIC:
						System.out.print(" " + cell.getNumericCellValue());
						break;
					case BOOLEAN:
						System.out.print(" " + cell.getBooleanCellValue());
						break;
					case FORMULA:
						System.out.print(" " + cell.getCellFormula());
						break;
					default:
						break;

					}
				}
				System.out.println("");
			}
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void readFile(String file) {
		System.out.println("This API is used to read and print excel file.");
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(file));
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				for (Cell cell : row) {
					switch (cell.getCellType()) {
					case STRING:
						System.out.print(" " + cell.getStringCellValue());
						break;
					case NUMERIC:
						System.out.print(" " + cell.getNumericCellValue());
						break;
					case BOOLEAN:
						System.out.print(" " + cell.getBooleanCellValue());
						break;
					case FORMULA:
						System.out.print(" " + cell.getCellFormula());
						break;
					default:
						break;

					}
				}
				System.out.println("");
			}
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
