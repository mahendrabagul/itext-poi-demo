package com.neova.controller.export;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

@SuppressWarnings("unchecked")
public class PdfReportView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// Set the headers
		response.setHeader("Content-Type", "application/octet-stream");
		response.setHeader("Content-Disposition",
				"attachment; filename=UserReport.pdf");
		List<UserReportDetails> userList = (List<UserReportDetails>) model
				.get("userList");

		Table table = new Table(4);
		table.addCell("User Name");
		table.addCell("First Name");
		table.addCell("Last Name");
		table.addCell("Email");

		// create data rows
		for (UserReportDetails user : userList) {

			table.addCell(user.getUserName());
			table.addCell(user.getFirstName());
			table.addCell(user.getLastName());
			table.addCell(user.getEmail());

		}
		
		document.add(table);
		document.addTitle("User List");
		HeaderFooter headerFooter = new HeaderFooter(new Phrase(
				"Neova Solutions"), true);
		document.setHeader(headerFooter);

		// try (OutputStream outStream = response.getOutputStream()) {
		// workbook.write(outStream);
		// outStream.flush();
		// } catch (Exception e) {
		// System.out.println("Exception Occurred...");
		// }

	}
}