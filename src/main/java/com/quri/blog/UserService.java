package com.quri.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UsersRepo usersRepo;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UsersRepo usersRepo) {
        this.passwordEncoder = passwordEncoder;
        this.usersRepo = usersRepo;
    }

    public Users registerNewUserAccount(Users user) {
        String hashedPassword = passwordEncoder.encode(user.getPsw());
        user.setPsw(hashedPassword);
        usersRepo.save(user);
        return user;
    }
}
