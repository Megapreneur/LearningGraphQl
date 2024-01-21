package com.uncledaimmy.learninggraphql.service;

import com.uncledaimmy.learninggraphql.dto.UserDto;
import com.uncledaimmy.learninggraphql.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<User> getAllUsers();
    User findUserByEmail(String email) throws Exception;
    void addUser(UserDto userDto) throws Exception;
}
