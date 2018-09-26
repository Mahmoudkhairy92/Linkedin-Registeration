package task;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel {
	public static String ValidFirstName;
	public String ValidLastName;
	public String Email;
	public String InvalidEmail;
	public String Password;
	public void dataExcel() throws IOException{
		File src = new File("C:\\Users\\Mahmoud.Khairy\\Desktop\\New folder\\RegisterFile.xls");

		FileInputStream fis = new FileInputStream(src);

		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet1 = wb.getSheetAt(0);
		ValidFirstName = sheet1.getRow(1).getCell(0).getStringCellValue();
		System.out.println(ValidFirstName);
		ValidLastName = sheet1.getRow(1).getCell(1).getStringCellValue();
		System.out.println(ValidLastName);
		Email = sheet1.getRow(1).getCell(2).getStringCellValue();
		System.out.println(Email);
		InvalidEmail = sheet1.getRow(2).getCell(2).getStringCellValue();
		System.out.println(InvalidEmail);
		Password = sheet1.getRow(1).getCell(3).getStringCellValue();
		System.out.println(Password);

	}

}