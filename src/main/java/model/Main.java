package model;

import model.dao.impl.TransactionDAOImpl;
import model.dao.impl.UserDAOImpl;
import model.entity.Transaction;
import model.entity.User;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {
    public  static  void  main(String args[]){

      List<Transaction> list=null;
        TransactionDAOImpl dao =new TransactionDAOImpl();
        System.out.println(dao.getallTransactions());
        Date dateStart =   new GregorianCalendar(2018, Calendar.MAY, 11).getTime();
        Date dateFinish = new GregorianCalendar(2018, Calendar.MAY, 25).getTime();

        System.out.println();

        System.out.println(dao.getTransactionsByDate(dateStart,dateFinish));
        System.out.println();
        System.out.println(dao.getTransactionsByDate(dateFinish));
    }

}
