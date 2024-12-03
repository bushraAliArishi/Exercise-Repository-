package com.example.exercise_repository.Repository;

import com.example.exercise_repository.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserById(Integer id);

    User findUserByUserNameAndPassword(String userName,String password);
    User findUserByEmail(String email);
    User findUserByUserName(String userName);
    @Query("SELECT user from User user where user.age>=?1")
    List<User>findUsersByAge(Integer age);
    @Query("SELECT user from User user where user.role==?1")
    List<User>findUsersByRole(String role);

}
