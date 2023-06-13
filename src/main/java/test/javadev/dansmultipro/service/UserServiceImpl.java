package test.javadev.dansmultipro.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import test.javadev.dansmultipro.model.UserModel;
import test.javadev.dansmultipro.repository.UserDb;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDb userDb;
    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public UserModel getUserByUsername(String username) {
        return userDb.findByUsername(username);
    }
}