/*
package bank.com.utilities;

import bank.com.pojos.Country5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;

import bank.com.pojos.Customer5;
import bank.com.pojos.States;

import java.util.List;

public class WriteToTxt {
    public static void saveDataInFileWithSSN(String fileName, Customer5[] customers) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < customers.length; i++)
                writer.append(customers[i].getSsn() + "\n");
            writer.close();
        } catch (Exception e) {
        }
    }

    public static void saveDataInFileAllCustomersInfo(String fileName, Customer5[] customer5) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < customer5.length; i++) {
                writer.append(customer5[i].getId() + " , " + customer5[i].getFirstName() + " , " + customer5[i].getLastName() + " , " + customer5[i].getSsn() + "\n");
                if (customer5[i].getUser() != null) {
                    writer.append(customer5[i].getUser().getFirstName() + " , " + customer5[i].getUser().getLastName() + "\n");
                }
                if (customer5[i].getCountry() != null) {
                    writer.append(customer5[i].getCountry().getName() + " , " + customer5[i].getCountry().getStates() + "\n");
                }
            }
            writer.close();
        } catch (Exception e) {
        }
    }

    public static void saveDataInFileSsn(String fileName, Customer5 customer5) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(customer5.getSsn());
            writer.close();
        } catch (Exception e) {
        }
    }

    public static void saveAllStates2(String fileName, States[] states) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < states.length; i++) {
                writer.append(states[i].getName() + "," + states[i].getTpcountry() + "\n");
            }
            writer.close();
        } catch (Exception e) {
        }
    }

    public static void saveDataInFileWithJsonListMap(String fileName, List<Map<String, Object>> json) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            for (int i = 0; i < json.size(); i++) {
                writer.append(json.get(i).get("id") + " , " + json.get(i).get("name") + " , " + json.get(i).get("states") + "\n");
            }

            writer.close();
        } catch (Exception e) {

        }
    }

    public static void saveDataInFileWithJsonListMapState(String fileName, List<Map<String, Object>> json) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            for (int i = 0; i < json.size(); i++) {
                writer.append(json.get(i).get("id") + " , " + json.get(i).get("name") + " , " + json.get(i).get("tpcountry") + "\n");
            }

            writer.close();
        } catch (Exception e) {

        }
    }

    public static void saveDataInFile2(String fileName, Customer5[] customers) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < customers.length; i++)

                writer.append(customers[i].getSsn() + ",\n");

            writer.close();
        } catch (Exception e) {

        }
    }

    public static void saveDataInFileWithAllCustomerInfo2(String fileName, Customer5[] customers) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));


            for (int i = 0; i < customers.length; i++) {

                writer.append(customers[i].getFirstName() + " , " + customers[i].getLastName() + "," + customers[i].getCity() + " , " + customers[i].getAddress() + "\n");
                if (customers[i].getUser() != null)
                    writer.append(customers[i].getUser().getFirstName());
                if (customers[i].getCountry() != null)
                    writer.append(customers[i].getCountry().getName());

            }

            writer.close();
        } catch (Exception e) {

        }
    }

    public static void saveDataInFileWithUserInfo(String fileName, Customer5 customer5) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            writer.append(customer5.getUser().getFirstName());

            writer.close();
        } catch (Exception e) {

        }
    }

    public static void saveAllStates(String fileName, States[] states) {
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




    public static void saveDataInFileWithStateid(String fileName, States[] sstates)


    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < sstates.length; i++)
                writer.append(sstates[i].getId() + "\n");
            writer.close();
        } catch (Exception e) {
        }


    }

    public static void saveDataInFileWithCountryName(String fileName, Country5[] countries) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < countries.length; i++)
                if(countries[i]!=null) {
                    writer.append(countries[i].getName() + "\n");
                }
            writer.close();
        } catch (Exception e) {
        }
    }

    public static void saveDataInFileWithCountry5Id(String fileName, Country5[] countries) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < countries.length; i++)
                writer.append(countries[i].getId() + "\n");
            writer.close();
        } catch (Exception e) {
        }
    }





}
 */