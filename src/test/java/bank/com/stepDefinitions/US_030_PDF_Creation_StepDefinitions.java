package bank.com.stepDefinitions;

import bank.com.pages.LoginPage;
import bank.com.pages.US_017_Pages;
import bank.com.pojos.Customer;
import bank.com.utilities.*;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bank.com.utilities.DatabaseUtility.createConnection;
import static bank.com.utilities.DatabaseUtility.getQueryResultList;

public class US_030_PDF_Creation_StepDefinitions {

    US_017_Pages us_17 = new US_017_Pages();
    LoginPage loginPage = new LoginPage();
    public static int order;
    public static String userName = "";
    public static int page = 1;

    //buraya bu kodlari ekledim, dinamik olmasi icin
    Customer customer=new Customer();
    Customer customerRole = new Customer();
    String fileName= ConfigReader.getProperty("fileNameOfCustomer");
    String fileNameFromUi= ConfigReader.getProperty("fileNameRoleOfCustomerFromUi");

    @Given("user goes to database and write it and then make a PDF from Database and UI {string}")
    public void userGoesToDatabaseAndWriteItAndThenMakeAPDFFromDatabaseAndUI(String arg0) {

//        Thread.sleep(3000);
//        List<Customer> list2= ReadTxt.returnAWholeCostumer(fileName);
//        userName=list2.get(list2.size()-1).getUserName();
//        WebElement lastCreatedCostumer= Driver.getDriver().findElement(By.xpath("//*[@id='" + userName +"']/td[4]/button"));
//        JSUtils.clickElementByJS(lastCreatedCostumer);
//        Thread.sleep(5000);

        String url = "jdbc:postgresql://157.230.48.97:5432/gmibank_db";
        String user = "techprodb_user";
        String password = "Techpro_@126";
        createConnection(url, user, password);

        //Database den gelen veriler
        List<List<Object>> listQueryResult1 = getQueryResultList("Select * from tpaccount_registration");
        Map<String, Object> databaseCustomerMap = new HashMap<>();
        for (int i = listQueryResult1.size() - 1; i > 0; i--) {
            //listQueryResult1.get(i).get(8).toString() ==> database email kismi
            databaseCustomerMap.put(listQueryResult1.get(i).get(8).toString(), listQueryResult1.get(i));
            // databaseCustomerMap.put(listQueryResult1.get(i).get(8).toString(), listQueryResult1.get(i).get(3).toString());
            System.out.println(databaseCustomerMap.get(listQueryResult1.get(i).get(8).toString()));
        }


        //List<Object> objectList = getColumnData("Select * from tp_customer", "email");
        // System.out.println(objectList.toString());
//      String email= objectList.get(objectList.size()-1).toString();


        //UI email
        Map<String, Object> mapFromUI= new HashMap<>();
        String email;
        String role;
        for (int i = 1; i <= 20; i++) {
            email = Driver.getDriver().findElement(By.xpath("//table//tr["+ i + "]//td[3]")).getText();
            role =Driver.getDriver().findElement(By.xpath("(//*//td[6]/div/span)[" + i + "]")).getText();
            //==>(//span[@class='badge badge-info'])[8]
            //1. yontem
            mapFromUI.put(email,role);
            System.out.println(mapFromUI.get(email));

            //2. yontem
            Customer customer2 = new Customer();
            customer2.setEmail(email);
            customer2.setRole(role);
           WriteToTxt.saveAllCustomerRole(fileNameFromUi,customer2);
        }

        //PDF YAZDRIMA
        List<Customer> listOfCustomers = new ArrayList<>();
        List<Customer> customers3 = ReadTxt.returnAWholeRole(fileNameFromUi);
        for (int i = 1; i < 20; i++) {
            Customer customer1 = new Customer();
            // System.out.println(listQueryResult.get(i).get(1));
            customer1.setFirstName(((List)databaseCustomerMap.get(listQueryResult1.get(listQueryResult1.size()-i).get(8))).get(2).toString());
            customer1.setLastName(((List)databaseCustomerMap.get(listQueryResult1.get(listQueryResult1.size()-i).get(8))).get(3).toString());
            customer1.setRole(customers3.get(i).getRole());
            //Yukarida MAP yapmistik, ama MAP icine listQueryResult1.get(i).get(8).toString()) kabul etmedi,
            // oNdan dolayi CUSTOMER kullandik
            //customer1.setRole(String.valueOf(mapFromUI.get(listQueryResult1.get(i).get(8).toString())));

            listOfCustomers.add(customer1);
        }
        for (int i = 0; i < listOfCustomers.size()-1; i++) {
            System.out.println(listOfCustomers.get(i));
        }

        String fileNamePDF = "src\\test\\resources\\test_data\\Team53.pdf";
        String title = "Customer Info";
        String fileName1 = ConfigReader.getProperty("fileNameRoleOfCustomer");

       // PDFGenerator.pdfGeneratorRowsAndCellsWithList(title, listOfCustomers, fileNamePDF);

        PDFGenerator.pdfGeneratorRowsAndCellsWithListLast20("                        **** TEAM 53 ****   \n                          " +
                        "           ==== Last 20 Users' info As Name, Last name And Role ====                " ,
                listOfCustomers , "TEAM53.pdf"         );


    }

}

