package bank.com.utilities;

import bank.com.pojos.User;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WriteToExcel {

    public static void createExcel(String filePath, List<User> customers, List<String>headers ){

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("firstSheet");

        Row header = sheet.createRow(0);

        for (int i = 0; i <headers.size() ; i++) {
            header.createCell(i).setCellValue(headers.get(i));
        }



        for (int i = 1; i < customers.size(); i++) {

            Row dataRow = sheet.createRow(i);
            dataRow.createCell(0).setCellValue(customers.get(i-1).getFirstName());
            dataRow.createCell(1).setCellValue(customers.get(i-1).getLastName());
            dataRow.createCell(2).setCellValue(customers.get(i-1).getSsn());
            dataRow.createCell(3).setCellValue(customers.get(i-1).getUsername());
            dataRow.createCell(4).setCellValue(customers.get(i-1).getPassword());
            dataRow.createCell(5).setCellValue(customers.get(i-1).getEmail());
            dataRow.createCell(6).setCellValue(customers.get(i-1).getAddress());

        }


        try {
            FileOutputStream out =  new FileOutputStream(new File(filePath));
            workbook.write(out);
            out.close();
            System.out.println("Data has been successfully set in the excel sheet!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> getCustomers() {
        List<User> customers =

                ReadTxt.returnAWholeUser(ConfigurationReader.getProperty("fileNameOfCustomer"));
        return customers;
    }



}
