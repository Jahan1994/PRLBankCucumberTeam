package bank.com.utilities;

import bank.com.pojos.Customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadText {

    public static void saveDataInFileWithAllCustomerInfo(String fileName, Customer[] customers) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < customers.length; i++) {
                writer.append(customers[i].getId() + " , " + customers[i].getFirstName() + " , " + customers[i].getLastName() + " , "
                        + customers[i].getMiddleInitial() + " , " + customers[i].getEmail() + " , " + customers[i].getMobilePhoneNumber() + " , "
                        + customers[i].getPhoneNumber() + "," + (customers[i].getZipCode() + " , " + customers[i].getAddress() + " , "
                        + customers[i].getCity() + " , " + customers[i].getSsn() + " , " + customers[i].getCreateDate() + " , "
                        + customers[i].isZelleEnrolled() + " , " + customers[i].getCountry() + " , " + customers[i].getState() + " , "
                        + customers[i].getUser() + " , " + customers[i].getAccounts() + "\n"));
                if (customers[i].getUser() != null)
                    writer.append(customers[i].getUser().getFirstName());
                if (customers[i].getCountry() != null)
                    writer.append(customers[i].getCountry().getName());
            }
            writer.close();
        } catch (Exception e) {
        }
    }

    public static List<Customer> returnAWholeCostumer(String filePath) {
        List<Customer> all = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
          //  int i = 0;
            while (line != null) {
                Customer customer = new Customer();
                customer.setId(line.split(",")[0].trim()); 
                customer.setFirstName(line.split(",")[1].trim());
                customer.setLastName(line.split(",")[2].trim());
                customer.setMiddleInitial(line.split(",")[3].trim());
                customer.setEmail(line.split(",")[4].trim());
                customer.setMobilePhoneNumber(line.split(",")[5].trim());
                customer.setPhoneNumber(line.split(",")[6].trim());
                customer.setZipCode(line.split(",")[7].trim());
                customer.setAddress(line.split(",")[8].trim());
                customer.setCity(line.split(",")[9].trim());
                customer.setSsn(line.split(",")[10].trim());
                customer.setCreateDate(line.split(",")[11].trim());
                customer.setZelleEnrolled(Boolean.parseBoolean(line.split(",")[12]));
              // customer.setCountry(line.split(",")[13].trim());
                customer.setState(line.split(",")[14].trim());
              // customer.setUser(line.split(",")[15].trim());
                customer.setAccounts(line.split(",")[16].trim());

                sb.append(System.lineSeparator());
                line = br.readLine();
                all.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }


    public static void saveDataInFileCustomerId(String fileName, Customer[] customers)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i=0;i<customers.length;i++)
                writer.append(customers[i].getId()+",\n");
            writer.close();
        } catch(Exception e){
        }
    }



    public static List<String> returnCustomerIdList(String filePath){
        List<String>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Customer customer = new Customer();
                customer.setId(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();
                System.out.println(i++);
                all.add(customer.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

}



