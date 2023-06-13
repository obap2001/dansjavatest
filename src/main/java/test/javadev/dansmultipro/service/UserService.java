package test.javadev.dansmultipro.service;

import test.javadev.dansmultipro.model.UserModel;

public interface UserService {
    public String encrypt(String password);
    UserModel getUserByUsername(String username);
}
