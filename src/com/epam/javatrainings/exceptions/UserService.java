package com.epam.javatrainings.exceptions;

public class UserService {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.getUser();

    }

    public void getUser(){
        if (true){
            throw new UserNotFoundException();
        }
    }
}
