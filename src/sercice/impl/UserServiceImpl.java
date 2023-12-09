package sercice.impl;

import db.DataBase;
import models.GenerateId;
import models.User;
import sercice.UserService;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {
    DataBase dataBase;

    public UserServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public User register(User user) {
        user.setUserId(GenerateId.userIdGen());
        dataBase.users.add(user);
        return user;
    }

    @Override
    public User login(String email, String password) {
        for (User user : dataBase.users) {
            if (user.getEmail().equals(email) && user.getPassowrd().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void getUserByEmail(String email) {
        for (User user : dataBase.users) {
            if (user.getEmail().equalsIgnoreCase(email)){
                System.out.println(user);
                return;
            }
        }
        System.out.println("Myndai email da user jok");
    }


    @Override
    public void getAllUsers() {
        System.out.println(dataBase.users);
    }
}
