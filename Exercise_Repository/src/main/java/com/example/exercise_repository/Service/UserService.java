package com.example.exercise_repository.Service;

import com.example.exercise_repository.ApiResponse.ApiException;
import com.example.exercise_repository.Model.User;
import com.example.exercise_repository.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User>findAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void updateUser(Integer id,User user){
       User oldUser=userRepository.findUserById(id);
        if (oldUser==null){
            throw new ApiException("user not found");
        }
        oldUser.setUserName(user.getUserName());
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setRole(user.getRole());
        userRepository.save(oldUser);
    }
    public void deleteUser(Integer id){
        User oldUser=userRepository.findUserById(id);
        if (oldUser==null){
            throw new ApiException("user not found");
        }
        userRepository.delete(userRepository.findUserById(id));
    }
    public User checkUserInfo(String userName,String password){
       User check=userRepository.findUserByUserName(userName);
       if (check==null||check.getPassword()!=password){
           throw new ApiException("user name or password are not correct");
       }
       return check;
       }
    public User getUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new ApiException("user not found");
        }
        return user;
    }
    public List<User> getUsersByRole(String role) {
        List<User> users = userRepository.findUsersByRole(role);
        if (users.isEmpty()) {
            throw new ApiException("user not found");
        }
        return users;
    }
    public List<User> getUsersByAge(Integer age) {
        List<User> users = userRepository.findUsersByAge(age);
        if (users.isEmpty()) {
            throw new ApiException("user not found");
        }
        return users;
    }

}

