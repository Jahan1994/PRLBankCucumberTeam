package bank.com.utilities;




import bank.com.pojos.Country;


import bank.com.pojos.Country;


import bank.com.pojos.Customer;
import bank.com.pojos.States;
import bank.com.pojos.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ReadTxt {


    public static List<Customer> returnCustomer(String filePath) {
        List<Customer> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ConfigReader.getProperty(filePath)))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                Customer customer = new Customer();
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                String[] each = line.split(",");
                customer.setFirstName(each[0]);
                customer.setLastName(each[1]);
                customer.setSsn(each[2]);
                all.add(customer);
            }
            String everything = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }


    public static List<Customer> returnCustomerSNN(String filePath) {
        List<Customer> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Customer customer = new Customer();
                customer.setSsn(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);

                all.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<Customer> readTxtData(String filePath) throws Exception {
        List<Customer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            Customer customer = new Customer();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
//                customer.setSsn(line);

            }
            String everything = sb.toString();

            customer.setSsn(everything);
            list.add(customer);
        } finally {
            br.close();
        }
        return list;

    }

    public static List<States> returnAllStates(String filePath) {
        List<States> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                States state = new States();



                String [] allLine = line.split(",");





                int id = Integer.parseInt(allLine[1].trim());
                state.setId(id);
                state.setName(allLine[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);

                all.add(state);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<String> returnCustomerSNNList(String filePath) {
        List<String> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Customer customer = new Customer();
                customer.setSsn(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);

                all.add(customer.getSsn());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }


    public static List<States> returnAllStates2(String filePath) {
        List<States> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                States states = new States();
                states.setName(line.split(",")[0].trim());
                states.setId(Integer.parseInt(line.split(",")[1].trim()));
                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);

                all.add(states);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<String> returnAllStates3(String filePath) {
        List<String> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                String temp = "";

                temp =line.split(",")[0].trim();

                temp = line.split(",")[0].trim();


                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);

                all.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<User> returnAWholeUser(String filePath) {
        List<User> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            int i = 0;
            while (line != null) {
                User customer = new User();
                customer.setPassword(line.split(",")[0].trim());
                customer.setUsername(line.split(",")[1].trim());
                customer.setFirstName(line.split(",")[2].trim());
                customer.setLastName(line.split(",")[3].trim());
                customer.setSsn(line.split(",")[4].trim());
                customer.setAddress(line.split(",")[5].trim());
                customer.setEmail(line.split(",")[6].trim());
                customer.setPhoneNumber(line.split(",")[7].trim());
                sb.append(System.lineSeparator());
                line = br.readLine();
                all.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<Customer> returnAWholeCostumer(String filePath) {
        List<Customer> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            int i = 0;
            while (line != null) {
                Customer customer = new Customer();
             //   customer.setFirstPassword(line.split(",")[0].trim());
             //   customer.setUserName(line.split(",")[1].trim());
                customer.setFirstName(line.split(",")[2].trim());
                customer.setLastName(line.split(",")[3].trim());
                customer.setSsn(line.split(",")[4].trim());
                customer.setAddress(line.split(",")[5].trim());
                customer.setEmail(line.split(",")[6].trim());
                customer.setPhoneNumber(line.split(",")[7].trim());
                sb.append(System.lineSeparator());
                line = br.readLine();
                all.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }


    public static List<String> returnCountryIdListesi(String filePath) {
        List<String> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Country country = new Country();
                country.setId(Integer.parseInt(line.split(",")[0]));
                sb.append(System.lineSeparator());
                line = br.readLine();
                System.out.println(i++);
                all.add(String.valueOf(country.getId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }


    public static List<String> returnCountryIdList(String filePath) {
        List<String> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Customer customer = new Customer();
                customer.setSsn(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();
                System.out.println(i++);
                all.add(customer.getSsn());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<String> returnCountryNameList5(String filePath) {
        List<String> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Country country5 = new Country();
                country5.setName(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();
                System.out.println(i++);
                all.add(country5.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<String> returnCountryNameList(String filePath){
        List<String>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Country country = new Country();
                country.setName(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();
                System.out.println(i++);
                all.add(country.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    public static List<String> returnCountry5IdList(String filePath) {
        List<String> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Country country5 = new Country();
                country5.setId(Integer.parseInt(line.split(",")[0]));
                // country5.setName((line.split(",")[1]));
                // country5.setId(Integer.parseInt(line.split(",")[0]));
                sb.append(System.lineSeparator());
                line = br.readLine();
                // System.out.println(i++);
                all.add(String.valueOf(country5.getId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }


    public static List<String> returnCountryIdListSibel(String filePath){
        List<String>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Country country = new Country();
                country.setId(Integer.parseInt(line.split(",")[0]));
                // country5.setName((line.split(",")[1]));
                // country5.setId(Integer.parseInt(line.split(",")[0]));
                sb.append(System.lineSeparator());
                line = br.readLine();
                // System.out.println(i++);
                all.add(String.valueOf(country.getId()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    public static List<String> returnCountryIdNameList(String filePath){
        List<String>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {


                    StringBuilder sb = new StringBuilder();
                    String line = br.readLine();
                    System.out.println(line);
                    int i = 0;
                    while (line != null) {
                        Country country5 = new Country();
                        //Burda trim kullanmazsak NullPointerExeption veriyor.
                        country5.setId(Integer.parseInt(line.split(",")[0].trim()));
                        country5.setName(line.split(",")[1].trim());
                        // country5.setId(Integer.parseInt(line.split(",")[0]));
                        sb.append(System.lineSeparator());
                        line = br.readLine();
                        // System.out.println(i++);
                        all.add(String.valueOf(country5.getId()));
                        all.add(country5.getName());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return all;
            }

        }





//    public static List<Customer> returnCustomer(String filePath){
//        List<Customer>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(ConfigReader.getProperty(filePath)))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//
//            while (line != null) {
//                Customer customer = new Customer();
//                sb.append(line);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//                String [] each = line.split(",");
//                customer.setFirstName(each[0]);
//                customer.setLastName(each[1]);
//                customer.setSsn(each[2]);
//                all.add(customer);
//            }
//            String everything = sb.toString();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//
//
//
//    public static List<Customer> returnCustomerSNN(String filePath){
//        List<Customer>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                Customer customer = new Customer();
//                customer.setSsn(line.split(",")[0]);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//
//                System.out.println(i++);
//
//                all.add(customer);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//
//    public static List<Customer> readTxtData(String filePath)throws  Exception{
//        List<Customer> list = new ArrayList<>();
//        BufferedReader br = new BufferedReader(new FileReader(filePath));
//        try {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            Customer customer = new Customer();
//            while (line != null) {
//                sb.append(line);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
////                customer.setSsn(line);
//
//            }
//            String everything = sb.toString();
//
//            customer.setSsn(everything);
//            list.add(customer);
//        } finally {
//            br.close();
//        }
//            return list;
//
//    }
//
//    public static List<States> returnAllStates(String filePath){
//        List<States>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//             States state = new States();
//             String [] allLine = line.split(",");
//
//                int id = Integer.parseInt(allLine[1].trim());
//                state.setId(id);
//                state.setName(allLine[0]);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//
//                System.out.println(i++);
//
//                all.add(state);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//
//    public static List<String> returnCustomerSNNList(String filePath){
//        List<String>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                Customer customer = new Customer();
//                customer.setSsn(line.split(",")[0]);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//
//                System.out.println(i++);
//
//                all.add(customer.getSsn());
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//
//
//    public static List<States> returnAllStates2(String filePath){
//        List<States>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//               States states = new States();
//                states.setName(line.split(",")[0].trim());
//                states.setId(Integer.parseInt(line.split(",")[1].trim()));
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//
//                System.out.println(i++);
//
//                all.add(states);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//
//    public static List<String> returnAllStates3(String filePath){
//        List<String>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                String temp = "";
//               temp =line.split(",")[0].trim();
//
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//
//                System.out.println(i++);
//
//                all.add(temp);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//    public static List<User> returnAWholeUser(String filePath){
//        List<User>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            int i = 0;
//            while (line != null) {
//                User customer = new User();
//                customer.setPassword(line.split(",")[0].trim());
//                customer.setUsername(line.split(",")[1].trim());
//                customer.setFirstName(line.split(",")[2].trim());
//                customer.setLastName(line.split(",")[3].trim());
//                customer.setSsn(line.split(",")[4].trim());
//                customer.setAddress(line.split(",")[5].trim());
//                customer.setEmail(line.split(",")[6].trim());
//                customer.setPhoneNumber(line.split(",")[7].trim());
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//                all.add(customer);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//
//    public static List<Customer> returnAWholeCostumer(String filePath){
//        List<Customer>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            int i = 0;
//            while (line != null) {
//                Customer customer = new Customer();
//                customer.setFirstPassword(line.split(",")[0].trim());
//                customer.setUserName(line.split(",")[1].trim());
//                customer.setFirstName(line.split(",")[2].trim());
//                customer.setLastName(line.split(",")[3].trim());
//                customer.setSsn(line.split(",")[4].trim());
//                customer.setAddress(line.split(",")[5].trim());
//                customer.setEmail(line.split(",")[6].trim());
//                customer.setPhoneNumber(line.split(",")[7].trim());
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//                all.add(customer);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//}


//package gmibank.utilities;
//        import gmibank.pojos.Customer;
//        import gmibank.pojos.States;
//        import gmibank.pojos.User;
//        import java.io.BufferedReader;
//        import java.io.FileReader;
//        import java.util.ArrayList;
//        import java.util.List;
//public class ReadTxt {

//    public static List<Customer> returnCustomer(String filePath){
//        List<Customer>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            while (line != null) {
//                Customer customer = new Customer();
//                sb.append(line);
////                sb.append(System.lineSeparator());
//                line = br.readLine();
//                String [] each = line.split(",");
//                if(each[0] != null)
//                    customer.setFirstName(each[0]);
//                if(each[1] != null)
//                    customer.setLastName(each[1]);
//                if(each[2] != null)
//                    customer.setSsn(each[2]);
//                all.add(customer);
//            }
//            String everything = sb.toString();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//    public static List<Customer> returnCustomerSNN(String filePath){
//        List<Customer>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                Customer customer = new Customer();
//                customer.setSsn(line.split(",")[0]);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//                System.out.println(i++);
//                all.add(customer);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//    public static List<Customer> readTxtData(String filePath)throws  Exception{
//        List<Customer> list = new ArrayList<>();
//        BufferedReader br = new BufferedReader(new FileReader(filePath));
//        try {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            Customer customer = new Customer();
//            while (line != null) {
//                sb.append(line);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
////                customer.setSsn(line);
//            }
//            String everything = sb.toString();
//            customer.setSsn(everything);
//            list.add(customer);
//        } finally {
//            br.close();
//        }
//        return list;
//    }
//    //    public static List<States> returnAllStates(String filePath){
////        List<States>all = new ArrayList<>();
////        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
////            StringBuilder sb = new StringBuilder();
////            String line = br.readLine();
////            System.out.println(line);
////            int i = 0;
////            while (line != null) {
////                States state = new States();
////                String [] allLine = line.split(",");
////
////                int id = Integer.parseInt(allLine[1].trim());
////                state.setId(id);
////                state.setName(allLine[0]);
////                sb.append(System.lineSeparator());
////                line = br.readLine();
////
////                System.out.println(i++);
////
////                all.add(state);
////            }
////        }catch (Exception e){
////            e.printStackTrace();
////        }
////        return all;
////    }
//    public static List<String> returnCustomerSNNList(String filePath){
//        List<String>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                Customer customer = new Customer();
//                customer.setSsn(line.split(",")[0]);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//                System.out.println(i++);
//                all.add(customer.getSsn());
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//    //    public static List<States> returnAllStates2(String filePath){
////        List<States>all = new ArrayList<>();
////        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
////            StringBuilder sb = new StringBuilder();
////            String line = br.readLine();
////            System.out.println(line);
////            int i = 0;
////            while (line != null) {
////                States states = new States();
////                states.setName(line.split(",")[0].trim());
////                states.setId(Integer.parseInt(line.split(",")[1].trim()));
////                sb.append(System.lineSeparator());
////                line = br.readLine();
////
////                System.out.println(i++);
////
////                all.add(states);
////            }
////        }catch (Exception e){
////            e.printStackTrace();
////        }
////        return all;
////    }
//    public static List<String> returnAllStates3(String filePath){
//        List<String>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                String temp = "";
//                temp =line.split(",")[0].trim();
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//                System.out.println(i++);
//                all.add(temp);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//    public static List<String> returnAllCustomerCredentials(String filePath){
//        List<String >list = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
////            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                String username =line.split(",")[1].trim();
//                String password = line.split(",")[0].trim();
//                list.add(password);
//                list.add(username);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//                System.out.println(i++);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return list;
//    }
//    public static List<String> returnAllAccounts(String filePath){
//        List<String >list = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
////            System.out.println(line);
//            while (line != null) {
//                String accountDescription = line.split(",")[0].trim();
//                list.add(accountDescription);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return list;
//    }
//    public static List<States> returnAllStates(String filePath){
//        List<States>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                States state = new States();
//                String [] allLine = line.split(",");
//                int id = Integer.parseInt(allLine[1].trim());
//                state.setId(id);
//                state.setName(allLine[0]);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//                System.out.println(i++);
//                all.add(state);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//}
//public static List<Customer> returnCustomer(String filePath){
//    List<Customer>all = new ArrayList<>();
//    try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//        StringBuilder sb = new StringBuilder();
//        String line = br.readLine();
//        while (line != null) {
//            Customer customer = new Customer();
//            sb.append(line);
////                sb.append(System.lineSeparator());
//            line = br.readLine();
//            String [] each = line.split(",");
//            if(each[0] != null)
//                customer.setFirstName(each[0]);
//            if(each[1] != null)
//                customer.setLastName(each[1]);
//            if(each[2] != null)
//                customer.setSsn(each[2]);
//            all.add(customer);
//        }
//        String everything = sb.toString();
//    }catch (Exception e){
//        e.printStackTrace();
//    }
//    return all;
//}
//    public static List<Customer> returnCustomerSNN(String filePath){
//        List<Customer>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                Customer customer = new Customer();
//                customer.setSsn(line.split(",")[0]);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//                System.out.println(i++);
//                all.add(customer);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//    public static List<Customer> readTxtData(String filePath)throws  Exception{
//        List<Customer> list = new ArrayList<>();
//        BufferedReader br = new BufferedReader(new FileReader(filePath));
//        try {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            Customer customer = new Customer();
//            while (line != null) {
//                sb.append(line);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
////                customer.setSsn(line);
//            }
//            String everything = sb.toString();
//            customer.setSsn(everything);
//            list.add(customer);
//        } finally {
//            br.close();
//        }
//        return list;
//    }
//    public static List<States> returnAllStates(String filePath){
//        List<States>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                States state = new States();
//                String [] allLine = line.split(",");
//
//                int id = Integer.parseInt(allLine[1].trim());
//                state.setId(id);
//                state.setName(allLine[0]);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//
//                System.out.println(i++);
//
//                all.add(state);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//    public static List<String> returnCustomerSNNList(String filePath){
//        List<String>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                Customer customer = new Customer();
//                customer.setSsn(line.split(",")[0]);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//                System.out.println(i++);
//                all.add(customer.getSsn());
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//}
//    public static List<States> returnAllStates2(String filePath){
//        List<States>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                States states = new States();
//                states.setName(line.split(",")[0].trim());
//                states.setId(Integer.parseInt(line.split(",")[1].trim()));
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//
//                System.out.println(i++);
//
//                all.add(states);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//    public static List<String> returnAllStates3(String filePath){
//        List<String>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                String temp = "";
//                temp =line.split(",")[0].trim();
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//                System.out.println(i++);
//                all.add(temp);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//    public static List<User> returnAWholeUser(String filePath){
//        List<User>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            int i = 0;
//            while (line != null) {
//                User customer = new User();
//                customer.setPassword(line.split(",")[0].trim());
//                customer.setUsername(line.split(",")[1].trim());
//                customer.setFirstName(line.split(",")[2].trim());
//                customer.setLastName(line.split(",")[3].trim());
//                customer.setSsn(line.split(",")[4].trim());
//                customer.setAddress(line.split(",")[5].trim());
//                customer.setEmail(line.split(",")[6].trim());
//                customer.setPhoneNumber(line.split(",")[7].trim());
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//                all.add(customer);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//    public static List<String> returnAllCustomerCredentials(String filePath){
//        List<String >list = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
////            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                String username =line.split(",")[1].trim();
//                String password = line.split(",")[0].trim();
//                list.add(password);
//                list.add(username);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//                System.out.println(i++);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return list;
//    }
//    public static List<String> returnAllAccounts(String filePath){
//        List<String >list = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
////            System.out.println(line);
//            while (line != null) {
//                String accountDescription = line.split(",")[0].trim();
//                list.add(accountDescription);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return list;
//    }
//    public static List<States> returnAllStates(String filePath){
//        List<States>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                States state = new States();
//                String [] allLine = line.split(",");
//                int id = Integer.parseInt(allLine[1].trim());
//                state.setId(id);
//                state.setName(allLine[0]);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//                System.out.println(i++);
//                all.add(state);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }

