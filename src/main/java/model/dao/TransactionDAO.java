package model.dao;

import model.entity.Product;
import model.entity.Transaction;

import java.util.Date;
import java.util.List;

public interface TransactionDAO {
    List<Transaction> getallTransactions();

    List<Transaction> getTransactionsByDate(Date start, Date finish);

    List<Transaction> getTransactionsByUser(int idUser);

    void addTransaction(int idUser, Product pr);

    List<Transaction> getTransactionsByDate(Date date);

    void deletTransactionByUserId(int idUser);

}
