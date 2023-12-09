package sercice;

import models.User;

import java.util.ArrayList;

public interface UserService {
    User register(User user);
    User login(String email, String password);
    void getUserByEmail(String email);
     void getAllUsers();

}
