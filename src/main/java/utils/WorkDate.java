package utils;

import model.dao.impl.TransactionDAOImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WorkDate {
    public static  Date stringToDate(String str) throws Exception{

        String arStr[] = str.split(" ");
        int year = Integer.valueOf(arStr[2]);
        int month = Integer.valueOf(arStr[1]) - 1;
        int day = Integer.valueOf(arStr[0]);

        TransactionDAOImpl dao = new TransactionDAOImpl();
        System.out.println(dao.getallTransactions());
        Date date = new GregorianCalendar(year, month, day).getTime();

        return date;
    }

}
