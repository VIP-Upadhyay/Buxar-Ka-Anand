package vip.example.buxarkaanand.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vip.example.buxarkaanand.model.Suggestion;
import vip.example.buxarkaanand.model.UserData;
import vip.example.buxarkaanand.repository.UserRepo;
import vip.example.buxarkaanand.service.DataService;

@RestController
@RequestMapping("admin/api")
public class ApiController {
	
	@Autowired
	DataService service;
	
	@GetMapping(value = "/getUser", produces = "application/json")
	public List<UserData> methodName(@RequestParam(defaultValue = "0") int size,@RequestParam(defaultValue = "25") int page) {
		return service.getPages(page, size);
	}

	@GetMapping(value = "/getSuggest", produces = "application/json")
	public List<Suggestion> methodNames(@RequestParam(defaultValue = "0") int size,@RequestParam(defaultValue = "25") int page) {
		return service.getSPages(page, size);
	}
	
	
	@GetMapping("/download/excel")
    public ResponseEntity<byte[]> downloadExcel() throws IOException {
        // Prepare data (assuming you have a list of objects called 'data')
        List<UserData> data = service.getData();

        // Create Excel workbook and sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("anandkabuxar_data");

        // Create header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Name", "Email", "Phone Number","Amount","Address","PAN No","Transaction Message","Status"}; // Example column headers
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Create data rows
        int rowNum = 1;
        for (UserData obj : data) {
            Row row = sheet.createRow(rowNum++);
            // Example: Set cell values based on your object properties
            row.createCell(0).setCellValue(obj.getName());
            row.createCell(1).setCellValue(obj.getEmail());
            row.createCell(2).setCellValue(obj.getPhoneNo());
            row.createCell(3).setCellValue(obj.getAmount());
            row.createCell(4).setCellValue(obj.getAddress());
            row.createCell(5).setCellValue(obj.getPanNo());
            row.createCell(6).setCellValue(obj.getTransactionMessage());
            if (obj.getStatus()!=null) {
            	row.createCell(7).setCellValue(obj.getStatus().toString());
			}else {
				row.createCell(7).setCellValue("");
			}
        }

        // Write workbook to ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);

        // Set response headers
        HttpHeaders headers1 = new HttpHeaders();
        headers1.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        headers1.setContentDispositionFormData("attachment", "anandkabuxar_data.xlsx");
        headers1.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity<>(outputStream.toByteArray(), headers1, HttpStatus.OK);
    }

}
