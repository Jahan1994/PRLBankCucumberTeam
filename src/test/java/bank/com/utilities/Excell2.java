package bank.com.utilities;


import bank.com.pojos.Customer;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Excell2 {


    public static void main(String[]args) {

        String path = "C:\\Users\\hiset\\IdeaProjects\\Gmibankapplication\\src\\test\\resources\\test_data\\IbrahimData.xls";
      Customer customer = new Customer();
      customer.setFirstName("Ibrahim");
      customer.setLastName("Kalin");
      customer.setSsn("123-23-3456");
      customer.setAddress("Bellingham CT");
      customer.setZipCode("22180");
      customer.setEmail("hisetkal@gmail.com");

        Customer customer2 = new Customer();
        customer2.setFirstName("Osman");
        customer2.setLastName("Koruk");
        customer2.setSsn("876-23-9988");
        customer2.setAddress("Belgium");
        customer2.setZipCode("34765");
        customer2.setEmail("kork@gmaiL.com");

      List<Customer> customers = new ArrayList<>();
      customers.add(customer);
      customers.add(customer2);
      int [] nums = {1,2};

      List <String> headers = new ArrayList<>();
        headers.add("First Name");
        headers.add("Last Name");
        headers.add("SSN");
        headers.add("Address");
        headers.add("Zip Code");
        headers.add("Email");

        createExcel(path,nums,customers ,headers);

    }


    public static void createExcel(String path, int [] row, List<Customer>list, List<String >headers){

        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");
            HSSFRow rowhead = sheet.createRow((short) 0);

            for (int i = 0; i < headers.size(); i++) {
                rowhead.createCell(i).setCellValue(headers.get(i));

            }


            HSSFRow roww;
            for (int j = 0; j < row.length; j++) {
               roww= sheet.createRow((short) j);


                for (int i = 0; i < list.size(); i++) {

                    roww.createCell(i).setCellValue(list.get(i).getFirstName());
                    roww.createCell(i).setCellValue(list.get(i).getLastName());
                    roww.createCell(i).setCellValue(list.get(i).getSsn());
                    roww.createCell(i).setCellValue(list.get(i).getAddress());
                    roww.createCell(i).setCellValue(list.get(i).getZipCode());
                    roww.createCell(i).setCellValue(list.get(i).getEmail());

                }
            }

            FileOutputStream fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
