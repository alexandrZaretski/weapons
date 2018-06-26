package model.logic;

import model.dao.ProductDAO;
import model.dao.TransactionDAO;
import model.dao.UserDAO;
import model.dao.impl.ProductDAOImpl;
import model.dao.impl.TransactionDAOImpl;
import model.dao.impl.UserDAOImpl;
import model.entity.Product;
import model.entity.Transaction;
import model.entity.TransactionForPage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminReceiver {
    private TransactionDAO transactionDAO = new TransactionDAOImpl();

    private UserDAO userDAO = new UserDAOImpl();

    private ProductDAO productDAO = new ProductDAOImpl();

    private List<Transaction> list = new ArrayList<Transaction>();
    ;

    public List<TransactionForPage> getallTransactions() {
        list = new ArrayList<Transaction>();
        list = transactionDAO.getallTransactions();
        return transactionToTransactionForPage(list);
    }

    public List<TransactionForPage> getTransactionsByDate(Date start, Date finish) {
        list = transactionDAO.getTransactionsByDate(start, finish);

        return transactionToTransactionForPage(list);
    }

    public List<TransactionForPage> getTransactionsByUser(int idUser) {
        list = transactionDAO.getTransactionsByUser(idUser);

        return transactionToTransactionForPage(list);
    }


    public List<TransactionForPage> getTransactionsByDate(Date date) {
        return null;
    }


    private List<TransactionForPage> transactionToTransactionForPage(List<Transaction> list) {

        List<TransactionForPage> rezaltList = new ArrayList<TransactionForPage>();
        for (int i = 0; i < list.size(); i++) {
            Transaction tr = list.get(i);
            rezaltList.add(new TransactionForPage(tr.getId_transaction(), tr.getSumm(),
                    productDAO.findProductById(tr.getId_of_product()),
                    userDAO.findUserById(tr.getId_of_user()), tr.getDate()));
        }
        return rezaltList;
    }

}
