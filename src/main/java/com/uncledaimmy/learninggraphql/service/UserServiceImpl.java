package com.uncledaimmy.learninggraphql.service;

import com.uncledaimmy.learninggraphql.dto.UserDto;
import com.uncledaimmy.learninggraphql.model.Gender;
import com.uncledaimmy.learninggraphql.model.User;
import com.uncledaimmy.learninggraphql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    @Override
    public void addUser(UserDto userDto) throws Exception {
        User savedUser = userRepository.findByEmail(userDto.getEmail());
        if (savedUser!=null) {
            throw new Exception("Email address already exists!!!");
        } else {
            User newUser = new User();
            newUser.setName(userDto.getName());
            newUser.setEmail(userDto.getEmail());
            newUser.setAge(userDto.getAge());
            newUser.setGender(Gender.valueOf(userDto.getGender()));
            userRepository.save(newUser);
        }
    }
}
