package com.learn.java.excel.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.learn.java.excel.model.request.CellRequest;
import com.learn.java.excel.model.request.ExcelRequest;
import com.learn.java.excel.model.request.ExcelRequestFile;
import com.learn.java.excel.model.request.RowRequest;
import com.learn.java.excel.model.request.WorkbookRequest;
import com.learn.java.excel.service.ExcelService;

import io.micrometer.common.util.StringUtils;

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
					if (DateUtil.isCellDateFormatted(cell)) {
						System.out.print(" " + cell.getDateCellValue());
					} else {
						System.out.print(" " + cell.getNumericCellValue());
					}
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

	@Override
	public void writeToOldExcelFiles(ExcelRequest excelRequestBody) {
		if (verifyRequest(excelRequestBody)) {
			for (ExcelRequestFile excelRequestFile : excelRequestBody.getExcelRequestFiles()) {
				Workbook workbook = new HSSFWorkbook();
				writeToWorkbook(workbook, excelRequestFile);
				writeToExcelFile(workbook, excelRequestFile.getFileName(), ".xls");
			}
		} else {
			// Bad Request Exception
			System.out.println("Bad Request Exception");
		}
	}

	@Override
	public void writeToExcelFiles(ExcelRequest excelRequestBody) {
		if (verifyRequest(excelRequestBody)) {
			for (ExcelRequestFile excelRequestFile : excelRequestBody.getExcelRequestFiles()) {
				Workbook workbook = new XSSFWorkbook();
				writeToWorkbook(workbook, excelRequestFile);
				writeToExcelFile(workbook, excelRequestFile.getFileName(), ".xlsx");
			}
		} else {
			// Bad Request Exception
			System.out.println("Bad Request Exception");
		}
	}

	private void writeToExcelFile(Workbook workbook, String fileName, String format) {

		if (StringUtils.isBlank(fileName)) {
			fileName = getRandomFileName() + format;
		}
		while (isAlreadyExist(fileName)) {
			fileName = getRandomFileName() + format;
		}
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		String fileLocation = path.substring(0, path.length() - 1) + fileName;
		try {
			FileOutputStream outputStream = new FileOutputStream(fileLocation);
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private boolean isAlreadyExist(String fileName) {
		File currDir = new File(".");
//		if(currDir.isDirectory()) {
		if (!(Objects.isNull(currDir.listFiles()))) {
			for (File file : currDir.listFiles()) {
				if ((!file.isDirectory()) && fileName.equalsIgnoreCase(file.getName())) {
					return true;
				}
			}
		}
//		}
		return false;
	}

	private String getRandomFileName() {
		Integer length = 15;
		Boolean useLetters = true;
		Boolean useNumbers = true;
		return RandomStringUtils.random(length, useLetters, useNumbers);

//		byte[] randomByteArray = new byte[15];
//		new Random().nextBytes(randomByteArray);
//		return new String(randomByteArray, Charset.forName("UTF-8"));
	}

	private void writeToWorkbook(Workbook workbook, ExcelRequestFile excelRequestFile) {
		if (verifyExcelRequestFile(excelRequestFile)) {
			Sheet sheet = null;
			if (StringUtils.isBlank(excelRequestFile.getWorkbook().getSheetName())) {
				sheet = workbook.createSheet(excelRequestFile.getWorkbook().getSheetName());
			} else {
				sheet = workbook.createSheet();
			}
			writeToSheet(sheet, excelRequestFile.getWorkbook());
		} else {
			// Empty Request!! SKIP!! VERIFY NEXT EXCEL!!
			System.out.println("Empty Request!! SKIP!! VERIFY NEXT EXCEL!!");
		}
	}

	private void writeToSheet(Sheet sheet, WorkbookRequest workbookRequest) {
		Integer index = 0;
		for (RowRequest rowRequest : workbookRequest.getRowRequest()) {
			Row row = sheet.createRow(index);
			if (verifyRowRequest(rowRequest)) {
				writeToRow(row, rowRequest);
			} else {
				// Empty Row
				System.out.println("Empty Row!!");
			}
			index++;
		}
	}

	private void writeToRow(Row row, RowRequest rowRequest) {
		Integer index = 0;
		for (CellRequest cellRequest : rowRequest.getCellRequest()) {
			Cell cell = row.createCell(index);
			cell.setCellValue(cellRequest.getValue());
			index++;
		}

	}

	private boolean verifyRowRequest(RowRequest rowRequest) {
		if (Objects.isNull(rowRequest) || CollectionUtils.isEmpty(rowRequest.getCellRequest())) {
			return false;
		} else {
			return true;
		}
	}

	private boolean verifyExcelRequestFile(ExcelRequestFile excelRequestFile) {
		if (Objects.isNull(excelRequestFile) || Objects.isNull(excelRequestFile.getWorkbook())) {
			return false;
		} else {
			return true;
		}

	}

	private boolean verifyRequest(ExcelRequest excelRequestBody) {
		if (Objects.isNull(excelRequestBody) || CollectionUtils.isEmpty(excelRequestBody.getExcelRequestFiles())) {
			return false;
		} else {
			return true;
		}

	}
}
