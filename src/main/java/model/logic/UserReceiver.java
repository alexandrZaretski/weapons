package model.logic;


import model.dao.UserDAO;
import model.dao.impl.UserDAOImpl;
import model.entity.User;

import java.util.List;

public class UserReceiver {

    public User checkUser(String login, String password) {
        UserDAOImpl dao = new UserDAOImpl();
        System.out.println(login + password);
        return dao.findUserByEmailAndPassword(login, password);

    }

    public void addUser(User user) {
        UserDAO dao = new UserDAOImpl();
        dao.create(user);
    }


    public User addUser(String name, String phone, String adress, String email, String password) {

        UserDAO daoUser = new UserDAOImpl();

        User user = new User(name, email, phone, adress, password, 2);
        daoUser.create(user);
        return user;

    }


    public List<User> findAllUsers() {
        UserDAO dao = new UserDAOImpl();

        return dao.findAllUsers();

    }


    public User findUserById(int id) {
        UserDAO userDAO = new UserDAOImpl();

        return userDAO.findUserById(id);

    }


    public void deleteUser(int id) {
        UserDAO userDAO = new UserDAOImpl();

        userDAO.deleteUser(id);

    }


}