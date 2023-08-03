package com.jatin.ewallet.user.service.resource;

import com.jatin.ewallet.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserResponse {

    private String userName;
    private String email;
    private String phoneNumber;
    private String balance;

    public void setUser(User user){
        this.userName=user.getUserName();
        this.email=user.getEmail();
        this.phoneNumber=user.getPhoneNumber();
    }

}
