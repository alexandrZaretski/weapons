package model.dao.impl;

import model.dao.TransactionDAO;
import model.entity.Product;
import model.entity.Transaction;
import model.entity.User;
import model.pool.ConnectionPool;
import model.pool.ProxyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {
    private static final String CREATE_TRANSACTION_SQL = "INSERT INTO `transaction` (`summ`,`id_of_product`,`id_of_user`,`count`,`date` )" +
            " VALUES (?, ? , ? ,?,?);";

    private static final String FIND_ALL_TRANSACTIONS_SQLXR = "SELECT `id_transaction`,`summ`,`id_of_product`,`id_of_user`,`id_of_user`, `date` FROM `transaction` WHERE `transaction`.`id_transaction` Between ? AND ?  ;";

    private static final String FIND_ALL_TRANSACTIONS_SQL = "SELECT `id_transaction`,`summ`,`id_of_product`,`id_of_user`,`id_of_user`, `date` FROM `transaction`   ;";

    private static final String FIND_ALL_TRANSACTIONS_BY_DATES_SQL = "SELECT `transaction`.`id_transaction`,`transaction`.`summ`,`transaction`.`id_of_product`,`transaction`.`id_of_user`,`transaction`.`id_of_user`, `transaction`.`date` FROM `transaction` WHERE `transaction`.`date` Between ? AND ? ;";

    private static final String FIND_ALL_TRANSACTIONS_BY_USERID = "SELECT `transaction`.`id_transaction`,`transaction`.`summ`,`transaction`.`id_of_product`,`transaction`.`id_of_user`,`transaction`.`id_of_user`, `transaction`.`date` FROM `transaction` WHERE `transaction`.`id_of_user`=? ;";

    private static final String FIND_TRANSACTIONS_BY_DATES_SQL = "SELECT * FROM transaction  WHERE date Between ? AND ? ;";

    private static final String FIND_TRANSACTIONS_BY_DATES_ONE_SQL = "SELECT * FROM transaction  WHERE date = ? ;";

    private static final String DELETE_transaction_BY_USER_ID = "DELETE FROM `transaction` WHERE `id_of_user`=?;";

    public List<Transaction> getallTransactions() {
        List<Transaction> products = new ArrayList<Transaction>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeQuery(FIND_ALL_TRANSACTIONS_SQL);
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {

                products.add(createTransactionFromRezalt(resultSet));
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;


    }

    @Override
    public List<Transaction> getTransactionsByDate(Date start, Date finish) {
        List<Transaction> listTransaction = new ArrayList<Transaction>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_TRANSACTIONS_BY_DATES_SQL)) {

            Object paramStart = new Timestamp(start.getTime());
            Object paramFinish = new Timestamp(finish.getTime());

            statement.setObject(1, paramStart);
            statement.setObject(2, paramFinish);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                listTransaction.add(createTransactionFromRezalt(resultSet));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTransaction;
    }


    private Transaction createTransactionFromRezalt(ResultSet resultSet) {
        Transaction transaction = null;

        try {

            transaction = new Transaction(resultSet.getInt("id_transaction"), resultSet.getInt("summ"), resultSet.getInt("id_of_product"), resultSet.getInt("id_of_user"),
                    resultSet.getDate("date"));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return transaction;
    }

    @Override
    public List<Transaction> getTransactionsByUser(int idUser) {
        List<Transaction> listTransaction = new ArrayList<Transaction>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_TRANSACTIONS_BY_USERID)) {


            statement.setInt(1, idUser);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                listTransaction.add(createTransactionFromRezalt(resultSet));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTransaction;
    }


    @Override
    public void addTransaction(int idUser, Product product) {
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TRANSACTION_SQL)) {
            Date date = new Date();
            Timestamp param = new Timestamp(date.getTime());

            preparedStatement.setInt(1, product.getPrice());
            preparedStatement.setInt(2, product.getId());
            preparedStatement.setInt(3, idUser);
            preparedStatement.setInt(4, 1);
            preparedStatement.setObject(5, param);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    @Override
    public List<Transaction> getTransactionsByDate(Date date) {

        List<Transaction> listTransaction = new ArrayList<Transaction>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_TRANSACTIONS_BY_DATES_ONE_SQL)) {


            statement.setObject(1, date);

            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {

                listTransaction.add(createTransactionFromRezalt(resultSet));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTransaction;
    }

    @Override
    public void deletTransactionByUserId(int idUser) {

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_transaction_BY_USER_ID)) {
            preparedStatement.setLong(1, idUser);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

