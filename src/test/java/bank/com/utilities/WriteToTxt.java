
package bank.com.utilities;
import bank.com.pojos.Country;
import bank.com.pojos.Customer;
import bank.com.pojos.Registration;
import bank.com.pojos.States;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteToTxt {


//    public static void saveDataInFileWithSSN(String fileName, Customer[] customers)  {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < customers.length; i++)
//                writer.append(customers[i].getSsn() + "\n");
//
//    public static void saveDataInFile(String fileName, Customer[] customers) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < customers.length; i++)
//                writer.append(customers[i].getSsn() + ",\n");
//
//            writer.close();
//        } catch (Exception e) {
//        }
//    }




//    public static void saveDataInFileWithSSN(String fileName, Customer customer) {
//
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < customer.length; i++) {
//                writer.append(customer[i].getId() + " , " + customer[i].getFirstName() + " , " + customer[i].getLastName() + " , " + customer[i].getSsn() + "\n");
//                if (customer[i].getUser() != null) {
//                    writer.append(customer[i].getUser().getFirstName() + " , " + customer[i].getUser().getLastName() + "\n");
//                }
//                if (customer[i].getCountry() != null) {
//                    writer.append(customer[i].getCountry().getName() + " , " + customer[i].getCountry().getState() + "\n");
//                }
//            }
//            writer.close();
//        } catch (Exception e) {
//        }
//    }


//    public static void saveDataInFileSsn(String fileName, Customer customer) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            writer.append(customer.getSsn());
//
//    public static void saveDataInFileWithSSN(String fileName, Customer[] customers) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < customers.length; i++) {
//                writer.append(customers[i].getSsn() + ",\n");
//            }
//
//            writer.close();
//        } catch (Exception e) {
//        }
//    }



//
//    public static void saveDataInFileWithUserInfo(String fileName, Customer customer) {
//
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < states.length; i++) {
//                writer.append(states[i].getName() + "," + states[i].getTpcountry() + "\n");
//            }
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//
//    public static void saveDataInFileWithJsonListMap(String fileName, List<Map<String, Object>> json) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//
//            for (int i = 0; i < json.size(); i++) {
//                writer.append(json.get(i).get("id") + " , " + json.get(i).get("name") + " , " + json.get(i).get("states") + "\n");
//
//    public static void saveDataInFileWithAllCustomerInfo(String fileName, Customer[] customers) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < customers.length; i++) {
//                writer.append(customers[i].getFirstName() + " , " + customers[i].getLastName() + "\n");
//                if (customers[i].getUser() != null)
//                    writer.append(customers[i].getUser().getFirstName());
//                if (customers[i].getCountry() != null)
//                    writer.append(customers[i].getCountry().getName());
//
//            }
//
//            writer.close();
//        } catch (Exception e) {
//
//
//        }
//    }
//
//    public static void saveDataInFileWithJsonListMapState(String fileName, List<Map<String, Object>> json) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//
//            for (int i = 0; i < json.size(); i++) {
//                writer.append(json.get(i).get("id") + " , " + json.get(i).get("name") + " , " + json.get(i).get("tpcountry") + "\n");
//            }
//
//            writer.close();
//        } catch (Exception e) {
//
//        }
//    }
//
//    public static void saveDataInFile2(String fileName, Customer[] customers) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < customers.length; i++)
//
//                writer.append(customers[i].getSsn() + ",\n");
//
//            writer.close();
//        } catch (Exception e) {
//
//        }
//    }
//
//    public static void saveDataInFileWithAllCustomerInfo2(String fileName, Customer[] customers) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//
//
//            for (int i = 0; i < customers.length; i++) {
//
//                writer.append(customers[i].getFirstName() + " , " + customers[i].getLastName() + "," + customers[i].getCity() + " , " + customers[i].getAddress() + "\n");
//                if (customers[i].getUser() != null)
//                    writer.append(customers[i].getUser().getFirstName());
//                if (customers[i].getCountry() != null)
//                    writer.append(customers[i].getCountry().getName());
//
//
//        }
//
//
//    public static void saveAllStates(String fileName, States[] states) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < states.length; i++)
//                writer.append(states[i].getName() + " , " + states[i].getId() + "\n");
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//    public static void saveAllStates2(String fileName, States[] states) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < states.length; i++)
//                writer.append(states[i].getName() + " , " + states[i].getId() + "\n");
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//    public static void saveAllCustomers(String fileName, Customer[] customers) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < customers.length; i++) {
//                writer.append(customers[i].getSsn() + "," + customers[i].getFirstName() + ",");
//                if (customers[i].getCountry() != null)
//                    writer.append(customers[i].getCountry().getName() + "," + customers[i].getCountry().getId() + ",\n");
//
//            }
//
//            writer.close();
//        } catch (Exception e) {
//
//
//        }
//    }
//
//    public static void saveDataInFileWithUserInfo(String fileName, Customer customer) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//
//            writer.append(customer.getUser().getFirstName());
//
//            writer.close();
//        } catch (Exception e) {
//
//        }
//    }
//
//    public static void saveAllStates(String fileName, States[] states) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//
//            for (int i = 0; i < states.length; i++)
//                writer.append(states[i].getName() + " , " + states[i].getId() + "\n");
//
//            writer.close();
//        } catch (Exception e) {
//
//        }
//    }
//
//    //hatice method ekleme
//    public static void saveDataInFileWithCountrId(String fileName, Country[] countries) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < countries.length; i++)
//                writer.append(countries[i].getId() + "\n");
//
//        }
//    }
//
//    public static void saveAllCustomer(String fileName, Customer customer, String password, String username) {
//        try {
//            //   String name ="C:\\Users\\sam\\IdeaProjects\\GMIBank\\src\\test\\resources\\test_data\\CustomerInfo.txt";
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            //writer.append("Ibrahim");
////            writer.append(password + "," +username+","+ customer.getFirstName() + ",");
//            writer.append(customer.getFirstPassword() + "," + customer.getUserName() + "," + customer.getFirstName() + ",");
//            writer.append(customer.getLastName() + "," + customer.getSsn() + ",");
//            writer.append(customer.getAddress() + "," + customer.getEmail() + "," + customer.getMobilePhoneNumber() + "\n");
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//    public static void saveAllCustomersComingFromDB(String fileName, List<Object> allCustomer) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < allCustomer.size(); i++) {
//                writer.append(allCustomer.get(i) + ",\n");
//            }
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//    public static void saveDifferentInfoFromDB(String fileName, List<Object> data) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < data.size(); i++) {
//                writer.append(data.get(i) + ",\n");
//            }
//
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//
//
//
//
//    public static void saveDataInFileWithStateid(String fileName, States[] sstates)
//
//
//    {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < sstates.length; i++)
//                writer.append(sstates[i].getId() + "\n");
//
//    public static void saveAccountInfo(String fileName, String description) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            writer.append(description + ",\n");
//
//            writer.close();
//        } catch (Exception e) {
//        }
//
//
//    }
//
//
//    public static void saveDataInFileWithCountryName(String fileName, Country[] countries) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < countries.length; i++)
//                if(countries[i]!=null) {
//                    writer.append(countries[i].getName() + "\n");
//                }
//            writer.close();
//
//    public static void saveCustomerInfo(List<String> items) {
//        String fileLocation = "location";
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true));
//            for (int i = 0; i < items.size(); i++) {
//                writer.append(items.get(i) + "\n");
//            }
//
//        } catch (Exception e) {
//        }
//    }
//
//
//    public static void saveDataInFileWithCountry5Id(String fileName, Country[] countries) {
//
//    public static void saveAllSSNs(String fileName, List<Object> ssns) {
//
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < countries.length; i++)
//                writer.append(countries[i].getId() + "\n");
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//
//
//    public static void saveAllCustomer(String fileName, Customer customer, String firstPassword, String userName) {
//    }
//}

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//    public static void saveDataInFile(String fileName, Customer[] customers)  {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i=0;i<customers.length;i++)
//                writer.append(customers[i].getSsn()+",\n");
//            writer.close();
//        } catch(Exception e){
//        }
//    }
//    public static void saveDataInFileWithSSN(String fileName, Customer customer)  {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            writer.append(customer.getSsn());
//            writer.close();
//        } catch(Exception e){
//        }
//    }
//    public static void saveDataInFileWithSSN(String fileName, Customer[] customers)  {

//
////package bank.com.utilities;
////import bank.com.pojos.Country;
////import bank.com.pojos.Customer;
////import bank.com.pojos.States;
////import java.io.BufferedWriter;
////import java.io.FileWriter;
////import java.util.List;
////public class WriteToTxt {
////    public static void saveDataInFile(String fileName, Customer[] customers)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0;i<customers.length;i++)
////                writer.append(customers[i].getSsn()+",\n");
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveDataInFileWithSSN(String fileName, Customer customer)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            writer.append(customer.getSsn());
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveDataInFileWithSSN(String fileName, Customer[] customers)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i = 0; i < customers.length ; i++) {
////                writer.append(customers[i].getSsn()+",\n");
////            }
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveDataInFileWithUserInfo(String fileName, Customer customer)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            writer.append(customer.getUser().getFirstName());
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveDataInFileWithAllCustomerInfo(String fileName, Customer[] customers)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i =0; i<customers.length;i++){
////                writer.append(customers[i].getFirstName()+" , "+customers[i].getLastName()+"\n");
////                if(customers[i].getUser() != null)
////                    writer.append(customers[i].getUser().getFirstName());
////                if(customers[i].getCountry() != null)
////                    writer.append(customers[i].getCountry().getName());
////            }
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAllStates(String fileName, States[] states)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0; i<states.length; i++)
////                writer.append(states[i].getName()+" , "+states[i].getId()+"\n");
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAllStates2(String fileName, States[] states)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0; i<states.length; i++)
////                writer.append(states[i].getName()+" , "+states[i].getId()+"\n");
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAllCustomers(String fileName, Customer[]customers)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0; i<customers.length; i++) {
////                writer.append(customers[i].getSsn() + "," + customers[i].getFirstName() + ",");
////                if(customers[i].getCountry() != null)
////                    writer.append(customers[i].getCountry().getName() + "," + customers[i].getCountry().getId() + ",\n");
////            }
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAllCustomer(String fileName, Customer customer, String password, String username)  {
////        try {
////         //   String name ="C:\\Users\\sam\\IdeaProjects\\GMIBank\\src\\test\\resources\\test_data\\CustomerInfo.txt";
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            //writer.append("Ibrahim");
//////            writer.append(password + "," +username+","+ customer.getFirstName() + ",");
//// //           writer.append(customer.getFirstPassword()+ "," +customer.getUserName() +","+ customer.getFirstName() + ",");
////            writer.append(customer.getLastName() + "," + customer.getSsn() + ",");
////            writer.append(customer.getAddress() + "," + customer.getEmail() + ","+customer.getMobilePhoneNumber()+"\n");
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAllCustomersComingFromDB(String fileName, List<Object> allCustomer)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0; i<allCustomer.size(); i++) {
////                writer.append(allCustomer.get(i) + ",\n" );
////            }
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////
////    public static void saveDifferentInfoFromDB(String fileName, List<Object> data)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0; i<data.size(); i++) {
////                writer.append(data.get(i) + ",\n" );
////            }
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAccountInfo(String fileName, String description)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            writer.append(description + ",\n" );
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveCustomerInfo ( List <String> items){
////        String fileLocation = "location";
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true));
////            for (int i = 0; i < items.size(); i++) {
////                writer.append(items.get(i)+"\n");
////            }
////        }catch (Exception e){
////        }
////
////    }
////    public static void saveAllSSNs(String fileName, List<Object> ssns) {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////
////            for (int i = 0; i < ssns.size(); i++)
////                writer.append(ssns.get(i).toString() + ",\n");
////
////            writer.close();
////        } catch (Exception e) {
////
////        }
////    }
////
////    public static void saveDataInFileWithUserInfo5(String fileName, Customer customer) {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////
////            writer.append(customer.getUser().getFirstName());
////
////            writer.close();
////        } catch (Exception e) {
////
////        }
////    }
////
////    public static void saveAllStates5(String fileName, States[] states) {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////
////            for (int i = 0; i < states.length; i++)
////                writer.append(states[i].getName() + " , " + states[i].getId() + "\n");
////
////            writer.close();
////        } catch (Exception e) {
////
////        }
////    }
////
////    //hatice method ekleme
////    public static void saveDataInFileWithCountrId(String fileName, Country[] countries) {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i = 0; i < countries.length; i++)
////                writer.append(countries[i].getId() + "\n");
////            writer.close();
////        } catch (Exception e) {
////        }
////    }
////
////    public static void saveDataInFileWithStateid(String fileName, States[] sstates) {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i = 0; i < sstates.length; i++)
////                writer.append(sstates[i].getId() + "\n");
////            writer.close();
////        } catch (Exception e) {
////        }
////
////
////    }
////
////    public static void saveDataInFileWithCountryName(String fileName, Country[] countries) {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i = 0; i < countries.length; i++)
////                if (countries[i] != null) {
////                    writer.append(countries[i].getName() + "\n");
////                }
////            writer.close();
////        } catch (Exception e) {
////        }
////    }
////
////    public static void saveDataInFileWithCountry5Id(String fileName, Country[] countries) {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i = 0; i < countries.length; i++)
////                writer.append(countries[i].getId() + "\n");
////            writer.close();
////        } catch (Exception e) {
////        }
////    }
////
////    public static void saveDataInFileWithCountryIdAndName(String fileName, Country[] countries) {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i = 0; i < countries.length; i++)
////                writer.append(countries[i].getId() + " , " + countries[i].getName() + "\n");
////            writer.close();
////        } catch (Exception e) {
////        }
////    }
////
////}
//=======
//package bank.com.utilities;
//import bank.com.pojos.Country;
//import bank.com.pojos.Customer;
//import bank.com.pojos.Registration;
//import bank.com.pojos.States;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.util.List;
//import java.util.Map;
//
//public class WriteToTxt {
//<<<<<<< HEAD
//
//    public static void saveDataInFileWithSSN(String fileName, Customer[] customers) {

//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < customers.length; i++)
//                writer.append(customers[i].getSsn() + "\n");
//=======
//    public static void saveDataInFile(String fileName, Customer[] customers) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < customers.length; i++)
//                writer.append(customers[i].getSsn() + ",\n");

//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//

//    public static void saveDataInFileAllCustomersInfo(String fileName, Customer[] customer) {

//    public static void saveDataInFileWithSSN(String fileName, Customer customer) {

//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < customer.length; i++) {
//                writer.append(customer[i].getId() + " , " + customer[i].getFirstName() + " , " + customer[i].getLastName() + " , " + customer[i].getSsn() + "\n");
//                if (customer[i].getUser() != null) {
//                    writer.append(customer[i].getUser().getFirstName() + " , " + customer[i].getUser().getLastName() + "\n");
//                }
//                if (customer[i].getCountry() != null) {
//                    writer.append(customer[i].getCountry().getName() + " , " + customer[i].getCountry().getState() + "\n");
//                }
//            }
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//<<<<<<< HEAD
//    public static void saveDataInFileSsn(String fileName, Customer customer) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            writer.append(customer.getSsn());
//=======
//    public static void saveDataInFileWithSSN(String fileName, Customer[] customers) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < customers.length; i++) {
//                writer.append(customers[i].getSsn() + ",\n");
//            }
//>>>>>>> main
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//<<<<<<< HEAD
//    public static void saveAllStates2(String fileName, States[] states) {
//=======
//    public static void saveDataInFileWithUserInfo(String fileName, Customer customer) {
//>>>>>>> main
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < states.length; i++) {
//                writer.append(states[i].getName() + "," + states[i].getTpcountry() + "\n");
//            }
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//<<<<<<< HEAD
//    public static void saveDataInFileWithJsonListMap(String fileName, List<Map<String, Object>> json) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//
//            for (int i = 0; i < json.size(); i++) {
//                writer.append(json.get(i).get("id") + " , " + json.get(i).get("name") + " , " + json.get(i).get("states") + "\n");
//=======
//    public static void saveDataInFileWithAllCustomerInfo(String fileName, Customer[] customers) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < customers.length; i++) {
//                writer.append(customers[i].getFirstName() + " , " + customers[i].getLastName() + "\n");
//                if (customers[i].getUser() != null)
//                    writer.append(customers[i].getUser().getFirstName());
//                if (customers[i].getCountry() != null)
//                    writer.append(customers[i].getCountry().getName());
//>>>>>>> main
//            }
//
//            writer.close();
//        } catch (Exception e) {
//<<<<<<< HEAD
//
//        }
//    }
//
//    public static void saveDataInFileWithJsonListMapState(String fileName, List<Map<String, Object>> json) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//
//            for (int i = 0; i < json.size(); i++) {
//                writer.append(json.get(i).get("id") + " , " + json.get(i).get("name") + " , " + json.get(i).get("tpcountry") + "\n");
//            }
//
//            writer.close();
//        } catch (Exception e) {
//
//        }
//    }
//
//    public static void saveDataInFile2(String fileName, Customer[] customers) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < customers.length; i++)
//
//                writer.append(customers[i].getSsn() + ",\n");
//
//            writer.close();
//        } catch (Exception e) {
//
//        }
//    }
//
//    public static void saveDataInFileWithAllCustomerInfo2(String fileName, Customer[] customers) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//
//
//            for (int i = 0; i < customers.length; i++) {
//
//                writer.append(customers[i].getFirstName() + " , " + customers[i].getLastName() + "," + customers[i].getCity() + " , " + customers[i].getAddress() + "\n");
//                if (customers[i].getUser() != null)
//                    writer.append(customers[i].getUser().getFirstName());
//                if (customers[i].getCountry() != null)
//                    writer.append(customers[i].getCountry().getName());
//
//=======
//        }
//    }
//
//    public static void saveAllStates(String fileName, States[] states) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < states.length; i++)
//                writer.append(states[i].getName() + " , " + states[i].getId() + "\n");
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//    public static void saveAllStates2(String fileName, States[] states) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < states.length; i++)
//                writer.append(states[i].getName() + " , " + states[i].getId() + "\n");
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//    public static void saveAllCustomers(String fileName, Customer[] customers) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < customers.length; i++) {
//                writer.append(customers[i].getSsn() + "," + customers[i].getFirstName() + ",");
//                if (customers[i].getCountry() != null)
//                    writer.append(customers[i].getCountry().getName() + "," + customers[i].getCountry().getId() + ",\n");
//>>>>>>> main
//            }
//
//            writer.close();
//        } catch (Exception e) {
//<<<<<<< HEAD
//
//        }
//    }
//
//    public static void saveDataInFileWithUserInfo(String fileName, Customer customer) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//
//            writer.append(customer.getUser().getFirstName());
//
//            writer.close();
//        } catch (Exception e) {
//
//        }
//    }
//
//    public static void saveAllStates(String fileName, States[] states) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//
//            for (int i = 0; i < states.length; i++)
//                writer.append(states[i].getName() + " , " + states[i].getId() + "\n");
//
//            writer.close();
//        } catch (Exception e) {
//
//        }
//    }
//
//    //hatice method ekleme
//    public static void saveDataInFileWithCountrId(String fileName, Country[] countries) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < countries.length; i++)
//                writer.append(countries[i].getId() + "\n");
//=======
//        }
//    }
//

//
//}
   public static void saveDataInFile(String fileName, Customer[] customers)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i=0;i<customers.length;i++)
                writer.append(customers[i].getSsn()+",\n");
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveDataInFileWithSSN(String fileName, Customer customer)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(customer.getSsn());
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveDataInFileWithSSN(String fileName, Customer[] customers)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < customers.length ; i++) {
                writer.append(customers[i].getSsn()+",\n");
            }
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveDataInFileWithUserInfo(String fileName, Customer customer)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(customer.getUser().getFirstName());
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveDataInFileWithAllCustomerInfo(String fileName, Customer[] customers)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i =0; i<customers.length;i++){
                writer.append(customers[i].getFirstName()+" , "+customers[i].getLastName()+"\n");
                if(customers[i].getUser() != null)
                    writer.append(customers[i].getUser().getFirstName());
                if(customers[i].getCountry() != null)
                    writer.append(customers[i].getCountry().getName());
            }
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveAllStates(String fileName, States[] states)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i=0; i<states.length; i++)
                writer.append(states[i].getName()+" , "+states[i].getId()+"\n");
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveAllStates2(String fileName, States[] states)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i=0; i<states.length; i++)
                writer.append(states[i].getName()+" , "+states[i].getId()+"\n");
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveAllCustomers(String fileName, Customer[]customers)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i=0; i<customers.length; i++) {
                writer.append(customers[i].getSsn() + "," + customers[i].getFirstName() + ",");
                if(customers[i].getCountry() != null)
                    writer.append(customers[i].getCountry().getName() + "," + customers[i].getCountry().getId() + ",\n");
            }
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveAllCustomer(String fileName, Customer customer,String password,String username)  {
        try {
//            String name ="C:\\Users\\sam\\IdeaProjects\\GMIBank\\src\\test\\resources\\test_data\\CustomerInfo.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(password + "," +username+","+ customer.getFirstName() + ",");
            writer.append(customer.getLastName() + "," + customer.getSsn() + ",");
            writer.append(customer.getAddress() + "," + customer.getEmail() + ","+customer.getMobilePhoneNumber()+"\n");
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveAllCustomersComingFromDB(String fileName, List<Object> allCustomer)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i=0; i<allCustomer.size(); i++) {
                writer.append(allCustomer.get(i) + ",\n" );
            }
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveDifferentInfoFromDB(String fileName, List<Object> data)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i=0; i<data.size(); i++) {
                writer.append(data.get(i) + ",\n" );
            }
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveAccountInfo(String fileName, String description)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(description + ",\n" );
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveCustomerInfo ( List <String> items){
        String fileLocation = "location";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true));
            for (int i = 0; i < items.size(); i++) {
                writer.append(items.get(i)+"\n");
            }
        }catch (Exception e){
        }
    }

    public static void saveDataInFileWithUserInfo5(String fileName, Customer customer) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            writer.append(customer.getUser().getFirstName());

            writer.close();
        } catch (Exception e) {

        }
    }

    public static void saveAllStates5(String fileName, States[] states) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            for (int i = 0; i < states.length; i++)
                writer.append(states[i].getName() + " , " + states[i].getId() + "\n");

            writer.close();
        } catch (Exception e) {

        }
    }

    //hatice method ekleme
    public static void saveDataInFileWithCountrId(String fileName, Country[] countries) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < countries.length; i++)
                writer.append(countries[i].getId() + "\n");
            writer.close();
        } catch (Exception e) {
        }
    }

    public static void saveDataInFileWithStateid(String fileName, States[] sstates) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < sstates.length; i++)
                writer.append(sstates[i].getId() + "\n");
            writer.close();
        } catch (Exception e) {
        }


    }

    public static void saveDataInFileWithCountryName(String fileName, Country[] countries) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < countries.length; i++)
                if (countries[i] != null) {
                    writer.append(countries[i].getName() + "\n");
                }
            writer.close();
        } catch (Exception e) {
        }
    }

    public static void saveDataInFileWithCountry5Id(String fileName, Country[] countries) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < countries.length; i++)
                writer.append(countries[i].getId() + "\n");
            writer.close();
        } catch (Exception e) {
        }
    }

    public static void saveDataInFileWithCountryIdAndName(String fileName, Country[] countries) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < countries.length; i++)
                writer.append(countries[i].getId() + " , " + countries[i].getName() + "\n");
            writer.close();
        } catch (Exception e) {
        }
    }

    public static void saveDataInFileWithSSN(String fileName, Registration[] registrations1) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < registrations1.length; i++) {
                writer.append(registrations1[i].getSsn() + ",\n");
            }
            writer.close();
        } catch (Exception e) {
        }

    }}



//    public static void saveAllCustomer(String fileName, Customer customer, String password, String username) {
//        try {
//            //   String name ="C:\\Users\\sam\\IdeaProjects\\GMIBank\\src\\test\\resources\\test_data\\CustomerInfo.txt";
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            //writer.append("Ibrahim");
////            writer.append(password + "," +username+","+ customer.getFirstName() + ",");
//            writer.append(customer.getFirstPassword() + "," + customer.getUserName() + "," + customer.getFirstName() + ",");
//            writer.append(customer.getLastName() + "," + customer.getSsn() + ",");
//            writer.append(customer.getAddress() + "," + customer.getEmail() + "," + customer.getMobilePhoneNumber() + "\n");
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//    public static void saveAllCustomersComingFromDB(String fileName, List<Object> allCustomer) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < allCustomer.size(); i++) {
//                writer.append(allCustomer.get(i) + ",\n");
//            }
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//    public static void saveDifferentInfoFromDB(String fileName, List<Object> data) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < data.size(); i++) {
//                writer.append(data.get(i) + ",\n");
//            }
//>>>>>>> main
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//<<<<<<< HEAD
//
//
//
//    public static void saveDataInFileWithStateid(String fileName, States[] sstates)
//
//
//    {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < sstates.length; i++)
//                writer.append(sstates[i].getId() + "\n");
//=======
//    public static void saveAccountInfo(String fileName, String description) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            writer.append(description + ",\n");
//>>>>>>> main
//            writer.close();
//        } catch (Exception e) {
//        }
//
//
//    }
//
//<<<<<<< HEAD
//    public static void saveDataInFileWithCountryName(String fileName, Country[] countries) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < countries.length; i++)
//                if(countries[i]!=null) {
//                    writer.append(countries[i].getName() + "\n");
//                }
//            writer.close();
//=======
//    public static void saveCustomerInfo(List<String> items) {
//        String fileLocation = "location";
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true));
//            for (int i = 0; i < items.size(); i++) {
//                writer.append(items.get(i) + "\n");
//            }
//>>>>>>> main
//        } catch (Exception e) {
//        }
//    }
//
//<<<<<<< HEAD
//    public static void saveDataInFileWithCountry5Id(String fileName, Country[] countries) {
//=======
//    public static void saveAllSSNs(String fileName, List<Object> ssns) {
//>>>>>>> main
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < countries.length; i++)
//                writer.append(countries[i].getId() + "\n");
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//
//<<<<<<< HEAD
//    public static void saveAllCustomer(String fileName, Customer customer, String firstPassword, String userName) {
//    }
//}
//>>>>>>> main
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//
////    public static void saveDataInFile(String fileName, Customer[] customers)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0;i<customers.length;i++)
////                writer.append(customers[i].getSsn()+",\n");
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveDataInFileWithSSN(String fileName, Customer customer)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            writer.append(customer.getSsn());
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveDataInFileWithSSN(String fileName, Customer[] customers)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i = 0; i < customers.length ; i++) {
////                writer.append(customers[i].getSsn()+",\n");
////            }
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveDataInFileWithUserInfo(String fileName, Customer customer)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            writer.append(customer.getUser().getFirstName());
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveDataInFileWithAllCustomerInfo(String fileName, Customer[] customers)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i =0; i<customers.length;i++){
////                writer.append(customers[i].getFirstName()+" , "+customers[i].getLastName()+"\n");
////                if(customers[i].getUser() != null)
////                    writer.append(customers[i].getUser().getFirstName());
////                if(customers[i].getCountry() != null)
////                    writer.append(customers[i].getCountry().getName());
////            }
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAllStates(String fileName, States[] states)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0; i<states.length; i++)
////                writer.append(states[i].getName()+" , "+states[i].getId()+"\n");
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAllStates2(String fileName, States[] states)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0; i<states.length; i++)
////                writer.append(states[i].getName()+" , "+states[i].getId()+"\n");
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAllCustomers(String fileName, Customer[]customers)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0; i<customers.length; i++) {
////                writer.append(customers[i].getSsn() + "," + customers[i].getFirstName() + ",");
////                if(customers[i].getCountry() != null)
////                    writer.append(customers[i].getCountry().getName() + "," + customers[i].getCountry().getId() + ",\n");
////            }
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAllCustomer(String fileName, Customer customer, String password, String username)  {
////        try {
////         //   String name ="C:\\Users\\sam\\IdeaProjects\\GMIBank\\src\\test\\resources\\test_data\\CustomerInfo.txt";
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            //writer.append("Ibrahim");
//////            writer.append(password + "," +username+","+ customer.getFirstName() + ",");
////            writer.append(customer.getFirstPassword()+ "," +customer.getUserName() +","+ customer.getFirstName() + ",");
////            writer.append(customer.getLastName() + "," + customer.getSsn() + ",");
////            writer.append(customer.getAddress() + "," + customer.getEmail() + ","+customer.getMobilePhoneNumber()+"\n");
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAllCustomersComingFromDB(String fileName, List<Object> allCustomer)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0; i<allCustomer.size(); i++) {
////                writer.append(allCustomer.get(i) + ",\n" );
////            }
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveDifferentInfoFromDB(String fileName, List<Object> data)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0; i<data.size(); i++) {
////                writer.append(data.get(i) + ",\n" );
////            }
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAccountInfo(String fileName, String description)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            writer.append(description + ",\n" );
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveCustomerInfo ( List <String> items){
////        String fileLocation = "location";
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true));
////            for (int i = 0; i < items.size(); i++) {
////                writer.append(items.get(i)+"\n");
////            }
////        }catch (Exception e){
////        }
////
////    }
////    public static void saveAllSSNs(String fileName, List<Object> ssns) {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////
////            for (int i = 0; i < ssns.size(); i++)
////                writer.append(ssns.get(i).toString() + ",\n");
////
////            writer.close();
////        } catch (Exception e) {
////
////        }
////    }
////}
//
////package gmibank.utilities;
////
////import gmibank.pojos.Customer;
////import gmibank.pojos.States;
////
////import java.io.BufferedWriter;
////import java.io.FileWriter;
////import java.util.List;
////
////public class WriteToTxt {
////
////    public static void saveDataInFile(String fileName, Customer[] customers)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0;i<customers.length;i++)
////
////            writer.append(customers[i].getSsn()+",\n");
////
////            writer.close();
////        } catch(Exception e){
////
////        }
////    }
////    public static void saveDataInFileWithSSN(String fileName, Customer customer)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////
////            writer.append(customer.getSsn());
////
////            writer.close();
////        } catch(Exception e){
////
////        }
////    }
////
////
////    public static void saveDataInFileWithUserInfo(String fileName, Customer customer)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////
////            writer.append(customer.getUser().getFirstName());
////
////            writer.close();
////        } catch(Exception e){
////
////        }
////    }
////
////    public static void saveDataInFileWithAllCustomerInfo(String fileName, Customer[] customers)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////
////
////            for (int i =0; i<customers.length;i++){
////
////                writer.append(customers[i].getFirstName()+" , "+customers[i].getLastName()+"\n");
////                if(customers[i].getUser() != null)
////                writer.append(customers[i].getUser().getFirstName());
////                if(customers[i].getCountry() != null)
////                writer.append(customers[i].getCountry().getName());
////
////            }
////
////            writer.close();
////        } catch(Exception e){
////
////        }
////    }
////
////    public static void saveAllStates(String fileName, States[] states)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////
////            for (int i=0; i<states.length; i++)
////            writer.append(states[i].getName()+" , "+states[i].getId()+"\n");
////
////            writer.close();
////        } catch(Exception e){
////
////        }
////    }
////
////
////
////    public static void saveAllStates2(String fileName, States[] states)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////
////            for (int i=0; i<states.length; i++)
////                writer.append(states[i].getName()+" , "+states[i].getId()+"\n");
////
////            writer.close();
////        } catch(Exception e){
////
////        }
////    }
////
////
////
////}
////   public static void saveDataInFile(String fileName, Customer[] customers)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0;i<customers.length;i++)
////                writer.append(customers[i].getSsn()+",\n");
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveDataInFileWithSSN(String fileName, Customer customer)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            writer.append(customer.getSsn());
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveDataInFileWithSSN(String fileName, Customer[] customers)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i = 0; i < customers.length ; i++) {
////                writer.append(customers[i].getSsn()+",\n");
////            }
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveDataInFileWithUserInfo(String fileName, Customer customer)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            writer.append(customer.getUser().getFirstName());
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveDataInFileWithAllCustomerInfo(String fileName, Customer[] customers)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i =0; i<customers.length;i++){
////                writer.append(customers[i].getFirstName()+" , "+customers[i].getLastName()+"\n");
////                if(customers[i].getUser() != null)
////                    writer.append(customers[i].getUser().getFirstName());
////                if(customers[i].getCountry() != null)
////                    writer.append(customers[i].getCountry().getName());
////            }
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAllStates(String fileName, States[] states)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0; i<states.length; i++)
////                writer.append(states[i].getName()+" , "+states[i].getId()+"\n");
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAllStates2(String fileName, States[] states)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0; i<states.length; i++)
////                writer.append(states[i].getName()+" , "+states[i].getId()+"\n");
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAllCustomers(String fileName, Customer[]customers)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0; i<customers.length; i++) {
////                writer.append(customers[i].getSsn() + "," + customers[i].getFirstName() + ",");
////                if(customers[i].getCountry() != null)
////                    writer.append(customers[i].getCountry().getName() + "," + customers[i].getCountry().getId() + ",\n");
////            }
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAllCustomer(String fileName, Customer customer,String password,String username)  {
////        try {
//////            String name ="C:\\Users\\sam\\IdeaProjects\\GMIBank\\src\\test\\resources\\test_data\\CustomerInfo.txt";
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            writer.append(password + "," +username+","+ customer.getFirstName() + ",");
////            writer.append(customer.getLastName() + "," + customer.getSsn() + ",");
////            writer.append(customer.getAddress() + "," + customer.getEmail() + ","+customer.getMobilePhoneNumber()+"\n");
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAllCustomersComingFromDB(String fileName, List<Object> allCustomer)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0; i<allCustomer.size(); i++) {
////                writer.append(allCustomer.get(i) + ",\n" );
////            }
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveDifferentInfoFromDB(String fileName, List<Object> data)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            for (int i=0; i<data.size(); i++) {
////                writer.append(data.get(i) + ",\n" );
////            }
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveAccountInfo(String fileName, String description)  {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
////            writer.append(description + ",\n" );
////            writer.close();
////        } catch(Exception e){
////        }
////    }
////    public static void saveCustomerInfo ( List <String> items){
////        String fileLocation = "location";
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true));
////            for (int i = 0; i < items.size(); i++) {
////                writer.append(items.get(i)+"\n");
////            }
////        }catch (Exception e){
////        }
////    }
////}
//=======
//    public static void saveDataInFileWithUserInfo5(String fileName, Customer customer) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//
//            writer.append(customer.getUser().getFirstName());
//
//            writer.close();
//        } catch (Exception e) {
//
//        }
//    }
//
//    public static void saveAllStates5(String fileName, States[] states) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//
//            for (int i = 0; i < states.length; i++)
//                writer.append(states[i].getName() + " , " + states[i].getId() + "\n");
//
//            writer.close();
//        } catch (Exception e) {
//
//        }
//    }
//
//    //hatice method ekleme
//    public static void saveDataInFileWithCountrId(String fileName, Country[] countries) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < countries.length; i++)
//                writer.append(countries[i].getId() + "\n");
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//    public static void saveDataInFileWithStateid(String fileName, States[] sstates) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < sstates.length; i++)
//                writer.append(sstates[i].getId() + "\n");
//            writer.close();
//        } catch (Exception e) {
//        }
//
//
//    }
//
//    public static void saveDataInFileWithCountryName(String fileName, Country[] countries) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < countries.length; i++)
//                if (countries[i] != null) {
//                    writer.append(countries[i].getName() + "\n");
//                }
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//    public static void saveDataInFileWithCountry5Id(String fileName, Country[] countries) {
//
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < countries.length; i++)
//                writer.append(countries[i].getId() + "\n");
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//    public static void saveDataInFileWithCountryIdAndName(String fileName, Country[] countries) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < countries.length; i++)
//                writer.append(countries[i].getId() + " , " + countries[i].getName() + "\n");
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
//    public static void saveDataInFileWithSSN(String fileName, Registration[] registrations1) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < registrations1.length; i++) {
//                writer.append(registrations1[i].getSsn() + ",\n");
//            }
//            writer.close();
//        } catch (Exception e) {
//        }
//
//    }
//
//}
//

