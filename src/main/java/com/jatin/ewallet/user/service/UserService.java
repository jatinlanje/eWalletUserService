package com.jatin.ewallet.user.service;

import com.jatin.ewallet.user.domain.User;
import com.jatin.ewallet.user.service.resource.UserRequest;
import com.jatin.ewallet.user.service.resource.UserResponse;
import com.jatin.ewallet.user.service.resource.UserTransactionRequest;

public interface UserService {

    public void addUser(UserRequest userRequest);

    public UserResponse getUser(String userId);

    public void deleteUser(String userId);

    public UserResponse updateUser(UserRequest userRequest,String userId);

    public void performTransaction(UserTransactionRequest userTransactionRequest,String userId);

    public void updateBalance(UserTransactionRequest userTransactionRequest,String userId);
}
