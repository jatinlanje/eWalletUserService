package com.jatin.ewallet.user.service.resource;

import com.jatin.ewallet.user.domain.User;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    public String userName;
    @Email(message = "Email is not valid")
    public String email;
    public String phoneNumber;
    public String password;

    public User toUser(){
        return User.builder().userName(userName).email(email).passwordHash(password).phoneNumber(phoneNumber).build();
    }

}
