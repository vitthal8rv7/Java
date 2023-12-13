package com.learn.java.excel.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

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
			int totalSheets = workbook.getNumberOfSheets();
			for (int i = 0; i < totalSheets; i++) {
				readSheet(workbook.getSheetAt(i));
			}
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void readFile(String file) {
		System.out.println("This API is used to read and print excel file.");
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(file));
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Iterator<Sheet> sheetIterator = workbook.sheetIterator();
			do {
				readSheet(sheetIterator.next());
			} while (sheetIterator.hasNext());
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readSheet(Sheet sheet) {
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
	}

}
