package com.fatmanur.expenset.service;

import com.fatmanur.expenset.model.User;
import com.fatmanur.expenset.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getUserList();
    public User save(User user);
}
