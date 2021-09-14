package bank.com.stepDefinitions;

import bank.com.pages.LoginPage;
import bank.com.pages.US_017_Pages;
import bank.com.pojos.Customer;
import bank.com.pojos.CustomerRole;
import bank.com.utilities.*;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bank.com.utilities.DatabaseUtility.createConnection;
import static bank.com.utilities.DatabaseUtility.getQueryResultList;

public class US_30_PDF_Creation_StepDefinitions {

        US_017_Pages us_17 = new US_017_Pages();
        LoginPage loginPage = new LoginPage();
        public static int order;
        public static String userName = "";
        public static int page = 1;

        //buraya bu kodlari ekledim, dinamik olmasi icin
        Customer customer=new Customer();
        CustomerRole customerRole = new CustomerRole();
        String fileNameRoleCostumer= ConfigReader.getProperty("fileNameRoleOfCustomer");
        String fileNameFromUi= ConfigReader.getProperty("fileNameRoleOfCustomerFromUi");


        @Given("user goes to database and write it and then make a PDF from Database and UI {string}")
        public void userGoesToDatabaseAndWriteItAndThenMakeAPDFFromDatabaseAndUI(String arg0) {

//        Thread.sleep(3000);
//        List<Customer> list2= ReadTxt.returnAWholeCostumer(fileName);
//        userName=list2.get(list2.size()-1).getUserName();
//        WebElement lastCreatedCostumer= Driver.getDriver().findElement(By.xpath("//*[@id='" + userName +"']/td[4]/button"));
//        JSUtils.clickElementByJS(lastCreatedCostumer);
//        Thread.sleep(5000);

            //UI dan geleb veriler kullanilacak
            Map<String, Object> mapFromUI= new HashMap<>();
            String email;
            String role;
            String id;
            for (int i = 1; i <= 20; i++) {
                id =Driver.getDriver().findElement(By.xpath("//table//tr["+ i + "]//td[1]")).getText();
                email = Driver.getDriver().findElement(By.xpath("//table//tr["+ i + "]//td[3]")).getText();
                role =Driver.getDriver().findElement(By.xpath("(//*//td[6]/div/span)[" + i + "]")).getText();
                //==>(//span[@class='badge badge-info'])[8]
                //1. yontem==> Bu yontemde veriler MAP icine atildi.Key olarak email kullanildi.
                mapFromUI.put(email,role);
                System.out.println(mapFromUI.get(email));

                //2. yontem==> BU yontemde Customer pojo classindan obje olustuldu ve veriler yazdirildi.
                CustomerRole customer2 = new CustomerRole();
                customer2.setId(Integer.parseInt(id));
                customer2.setEmail(email);
                customer2.setRole(role);
                //Veriler yazdirildi
                WriteToTxt.saveAllCustomerRoleFromUi(fileNameFromUi,customer2);
            }

            //Database baglanti
            String url = "jdbc:postgresql://157.230.48.97:5432/gmibank_db";
            String user = "techprodb_user";
            String password = "Techpro_@126";
            createConnection(url, user, password);

            //Database den gelen veriler kullanilacak, veriler MAP icine atiliyor. Key=Email
            List<List<Object>> listQueryResult1 = getQueryResultList("Select * from tpaccount_registration");
            Map<String, Object> databaseCustomerMap = new HashMap<>();
            for (int i = listQueryResult1.size() - 1; i > 0; i--) {
                //listQueryResult1.get(i).get(8).toString() ==> database email kismi
                databaseCustomerMap.put(listQueryResult1.get(i).get(8).toString(), listQueryResult1.get(i));
                // databaseCustomerMap.put(listQueryResult1.get(i).get(8).toString(), listQueryResult1.get(i).get(3).toString());
                System.out.println(databaseCustomerMap.get(listQueryResult1.get(i).get(8).toString()));
            }


            //PDF YAZDRIMA
            List<CustomerRole> listOfCustomers = new ArrayList<>();
            List<CustomerRole> customers3 = ReadTxt.returnAWholeRoleFromUI(fileNameFromUi);
            for (int i = 0; i < 20; i++) {
                CustomerRole customer1 = new CustomerRole();
                String query1="Select user_id, first_name, last_name from tpaccount_registration WHERE user_id="+ customers3.get(i).getId() +"";

                //System.out.println( customers3.get(i).);
                List<List<Object>> listQueryResult2 = getQueryResultList(query1);
                System.out.println(listQueryResult2.get(0));

                System.out.println(listQueryResult2.get(0).get(1));
                customer1.setFirstName(listQueryResult2.get(0).get(1).toString());
                customer1.setLastName(listQueryResult2.get(0).get(2).toString());
                customer1.setRole(customers3.get(i).getRole());

                listOfCustomers.add(customer1);
            }
            for (int i = 0; i < listOfCustomers.size()-1; i++) {
                System.out.println(listOfCustomers.get(i));
            }

            String fileNamePDF = "src\\test\\resources\\test_data\\Team53.pdf";
            String title = "Customer Info";
            String fileName1 = ConfigReader.getProperty("fileNameRoleOfCustomer");

        //     PDFGenerator.pdfGeneratorRowsAndCellsWithList(title, listOfCustomers, fileNamePDF);

            PDFGenerator.pdfGeneratorRowsAndCellsWithListLast20("                        **** TEAM 53 ****   \n                          " +
                            "           ==== Last 20 Users' info As Name, Last name And Role ====                " ,
                    listOfCustomers , "TEAM53.pdf"         );

        }

    }


