package model.dao;


import model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    void create(User user);

    List<User> findAllUsers();

    User findUserById(long id);

    User findUserByEmail(String email);

    User findUserByEmailAndPassword(String username, String password);

    void deleteUser(int id);


}
