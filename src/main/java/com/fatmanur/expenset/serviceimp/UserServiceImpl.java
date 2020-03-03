package com.fatmanur.expenset.serviceimp;

import com.fatmanur.expenset.model.User;
import com.fatmanur.expenset.repository.UserRepository;
import com.fatmanur.expenset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUserList() {
        System.out.println("backend service");
        return userRepository.findAll();
    }
    public User save(User user) {
        return userRepository.save(user);

    }
}
