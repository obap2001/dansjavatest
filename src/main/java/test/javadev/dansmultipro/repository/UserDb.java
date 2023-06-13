package test.javadev.dansmultipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.javadev.dansmultipro.model.UserModel;

public interface UserDb extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
}
