package com.example.exercise_repository.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "user name cant be empty")
    @Size(min = 5,message = "user length must be more than 4")
    @Column(columnDefinition = "varchar(20) not null ")
    private String name;

    @NotEmpty(message = "username cant be empty")
    @Size(min = 5,message = "user length must be more than 4")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL UNIQUE")
    private String userName;

    @NotEmpty(message = "user password cant be empty")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL ")
    private String password;

    @Email(message = "enter valid email")
    @NotEmpty(message = "user email cant be empty")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL UNIQUE ")
    private String email;

    @NotEmpty(message = "user role cant be empty")
    @Pattern(regexp = "^[user|admin]+$",message = "role must be ether user or admin")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL ")
    private String role;

    @NotNull(message = "user age cant be empty")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer age;

}
