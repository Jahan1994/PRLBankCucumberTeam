package bank.com.stepDefinitions;

import bank.com.pojos.Customer;
import bank.com.pojos.CustomerRole;
import io.cucumber.java.en.Given;
import java.util.ArrayList;
import java.util.List;
import static bank.com.utilities.DatabaseUtility.createConnection;
import static bank.com.utilities.DatabaseUtility.getQueryResultList;
import static bank.com.utilities.PDFGenerator.*;

public class US_030_PDFGeneratorStepDefinition {

        @Given("pdf user creates a connection with db using {string} , {string} and {string}")
        public void pdf_user_creates_a_connection_with_db_using_and(String url, String user, String password) {

            //   createConnection();
            createConnection(url, user, password);

        }

        @Given("pdf user provides the query {string}")
        public void pdf_user_provides_the_query(String query) {

            List<CustomerRole> customerList = new ArrayList<>();

            List<List<Object>> lists = getQueryResultList(query);

            for (int i = 0 ; i <= 33 ; i++){

                CustomerRole customer = new CustomerRole();

                customer.setFirstName(lists.get(i).get(1).toString());
                customer.setLastName(lists.get(i).get(2).toString());
                customer.setMiddleInitial(lists.get(i).get(3).toString());
//                customer.setEmail(lists.get(i).get(4).toString());
//                customer.setMobilePhoneNumber(lists.get(i).get(5).toString());

                customerList.add(customer);
            }

            pdfGeneratorRowsAndCellsWithListLast20("                        **** TEAM 53 ****   \n                          " +
                            "           ==== First 53 Users' info As Name, Last name And Role ====                " ,
                    customerList , "TEAM53.pdf"         );

     }
    }

