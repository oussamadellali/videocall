package com.dellali.videocall.user;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {
    private static final List<User> USERS_LIST=new ArrayList<>();

    public void register(User user){
        user.setStatus("online");
        USERS_LIST.add(user);
    }
    public User login(User user){
        var userIndex = IntStream.range(0,USERS_LIST.size())
                .filter(u -> USERS_LIST.get(u).getEmail().equals(user.getEmail()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("User not Found"));

        var cUser = USERS_LIST.get(userIndex);
        if(!cUser.getPassword().equals(user.getPassword())){
            throw new RuntimeException("Password incorrect");
        }
        cUser.setStatus("online");
        return cUser;

    }
    public void logout(String email){
        var userIndex = IntStream.range(0,USERS_LIST.size())
                .filter(u -> USERS_LIST.get(u).getEmail().equals(email))
                .findAny()
                .orElseThrow(() -> new RuntimeException("User not Found"));
        USERS_LIST.get(userIndex).setStatus("offline");

    }

    public  List<User> findAll() {
        return USERS_LIST;
    }

}
