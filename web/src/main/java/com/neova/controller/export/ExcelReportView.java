package com.neova.controller.export;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
=======
>>>>>>> 0e1805678c7fdf7cfe12e03b3c7a9292fc2ed2cd
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
<<<<<<< HEAD
import org.apache.poi.hssf.usermodel.HeaderFooter;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
=======
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
>>>>>>> 0e1805678c7fdf7cfe12e03b3c7a9292fc2ed2cd
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelReportView extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// Set the headers
		response.setHeader("Content-Type", "application/octet-stream");
		response.setHeader("Content-Disposition",
				"attachment; filename=UserReport.xls");

		// get data model which is passed by the Spring container
		List<UserReportDetails> userList = (List<UserReportDetails>) model
				.get("userList");

		// create a new Excel sheet
		HSSFSheet sheet = workbook.createSheet("User List");
		sheet.setDefaultColumnWidth(30);

<<<<<<< HEAD
		Footer footer = sheet.getFooter();
		footer.setRight("Neova Solutions");
		Header header1 = sheet.getHeader();
		header1.setCenter("User Report");

		// Style to Make Titles Bold
		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		HSSFCellStyle style1 = workbook.createCellStyle();
		style1.setFont(font);

		//

		// Style the cell with borders all around.
		// HSSFCellStyle styleBorders = workbook.createCellStyle();
		// styleBorders.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// styleBorders.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		// styleBorders.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// styleBorders.setLeftBorderColor(IndexedColors.GREEN.getIndex());
		// styleBorders.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// styleBorders.setRightBorderColor(IndexedColors.BLUE.getIndex());
		// styleBorders.setBorderTop(HSSFCellStyle.BORDER_MEDIUM_DASHED);
		// styleBorders.setTopBorderColor(IndexedColors.BLACK.getIndex());

		//
=======
		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
>>>>>>> 0e1805678c7fdf7cfe12e03b3c7a9292fc2ed2cd

		// create header row
		HSSFRow header = sheet.createRow(0);

		header.createCell(0).setCellValue("User Name");
<<<<<<< HEAD
		header.getCell(0).setCellStyle(style1);

		header.createCell(1).setCellValue("First Name");
		header.getCell(1).setCellStyle(style1);

		header.createCell(2).setCellValue("Last Name");
		header.getCell(2).setCellStyle(style1);

		header.createCell(3).setCellValue("Email");
		header.getCell(3).setCellStyle(style1);
=======
		header.getCell(0).setCellStyle(style);

		header.createCell(1).setCellValue("First Name");
		header.getCell(1).setCellStyle(style);

		header.createCell(2).setCellValue("Last Name");
		header.getCell(2).setCellStyle(style);

		header.createCell(3).setCellValue("Email");
		header.getCell(3).setCellStyle(style);
>>>>>>> 0e1805678c7fdf7cfe12e03b3c7a9292fc2ed2cd

		// create data rows
		int rowCount = 1;
		for (UserReportDetails user : userList) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(user.getUserName());
			aRow.createCell(1).setCellValue(user.getFirstName());
			aRow.createCell(2).setCellValue(user.getLastName());
			aRow.createCell(3).setCellValue(user.getEmail());
		}

		// try (OutputStream outStream = response.getOutputStream()) {
		// workbook.write(outStream);
		// outStream.flush();
		// } catch (Exception e) {
		// System.out.println("Exception Occurred...");
		// }

	}

}