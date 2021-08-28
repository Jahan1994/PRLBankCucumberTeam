package bank.com.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    // MMMM dd, yyy  --> February 17, 2019
    public static String todaysDate(){
        String today = new SimpleDateFormat("MMMM dd, yyy").format(new Date());
        return today;
    }

    // MM-dd-yy     --> 02-17-19
    public static String todaysDate2(){
        String today = new SimpleDateFormat("MM-dd-yy").format(new Date());
        return today;
    }

    // dd-MM-yy    --> 17-02-19
    public static String todaysDate3(){
        String today = new SimpleDateFormat("dd-MM-yy").format(new Date());
        return today;
    }

    // yyyy-MM-dd hh:mm:ss   --> 2019-02-17 03:45:11
    public static String todaysDate4(){
        String today = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        return today;
    }

    // dd-MM-yyyy hh:mm   --> -17-02-2019 03:45
    public static String todaysDate5(){
        String today = new SimpleDateFormat("dd-MM-yyyy hh:mm").format(new Date());
        return today;
    }
    // dd-MM-yyyy   --> -17-02-2019
    public static String todaysDate6(){
        String today = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        return today;
    }

    // hh:mm   --> -3:45
    public static String todaysTime(){
        String today = new SimpleDateFormat("hh:mm").format(new Date());
        return today;
    }

    // CLOSED DATE dd-MM-yyyy   --> -17-02-2019
    public static String todaysDate8(){
//        String today = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
//        return today;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 5); //here n is no.of year you want to increase
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
        String closedDate= format1.format(cal.getTime());

        return closedDate;

    }
}
