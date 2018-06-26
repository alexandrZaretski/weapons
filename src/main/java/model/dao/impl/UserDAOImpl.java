package model.dao.impl;


import model.dao.UserDAO;
import model.entity.User;
import model.pool.ConnectionPool;
import model.pool.ProxyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {

    private static final String FIND_ALL_USERS_SQL = "SELECT `id_users`,`name`,`email`,`phone`,`adress`,`password`,`id_role` FROM `users`  ORDER BY `users`.`id_users`;";

    private static final String CREATE_USER_SQL = "INSERT INTO `users` (`name`,`email`,`phone`,`adress`,`password`,`id_role` )" +

            " VALUES (?, ?, ?, ?, ?, ?);";

    private static final String FIND_USER_BY_ID_SQL = "SELECT `id_users`,`name`,`email`,`phone`,`adress`,`password`,`id_role` FROM `users` WHERE `users`.`id_users` =?   ;";

    private static final String FIND_USER_BY_EMAIL_SQL = "SELECT `id_users`,`name`,`email`,`phone`,`adress`,`password`,`id_role` FROM `users`  " +
            "LEFT JOIN `role` ON `role`.`idrole` = `user`.`role_idrole` WHERE `user`.`email` = ?;";


    private static final String SQL_SELECT_USER_BY_EMAIL_AND_PASSWORD = "SELECT `id_users`,`name`,`email`,`phone`,`adress`,`password`,`id_role` FROM `users`" +
            "   " +
            "    WHERE email = ? AND password = ?";

    private static final String DELETE_USER_BY_ID = "DELETE FROM `users` WHERE `id_users`=?;";


    @Override
    public void create(User user) {
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER_SQL)) {


            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getAdress());

            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setInt(6, 2);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeQuery(FIND_ALL_USERS_SQL);
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                users.add(createUserFromResult(resultSet));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findUserById(long id) {

        User user = null;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_ID_SQL)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = createUserFromResult(resultSet);

            }

        } catch (SQLException e) {

        }
        return user;
    }


    private User createUserFromResult(ResultSet resultSet) throws SQLException {
        User user = null;

        user = new User(resultSet.getInt("id_users"), resultSet.getString("name"), resultSet.getString("email"),
                resultSet.getString("phone"), resultSet.getString("adress"), resultSet.getString("password"),
                resultSet.getInt("id_role"));


        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        User user = null;
        //   Optional<User> userOptional = Optional.empty();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_EMAIL_SQL)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = createUserFromResult(resultSet);


            }

        } catch (SQLException e) {

        }
        return user;
    }

    public User findUserByEmailAndPassword(String email, String password) {
        User user = null;
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();

             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_EMAIL_AND_PASSWORD)) {
            System.out.println("what not " + email + " " + password);
            System.out.println("Pizdec0");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = createUserFromResult(resultSet);
            }


        } catch (SQLException e) {
            System.out.println("Pizdec2");
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public void deleteUser(int id) {
        TransactionDAOImpl transactionDAO = new TransactionDAOImpl();
        transactionDAO.deletTransactionByUserId(id);
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}