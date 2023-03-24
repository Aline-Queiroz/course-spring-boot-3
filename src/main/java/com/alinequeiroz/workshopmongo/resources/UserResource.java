package com.alinequeiroz.workshopmongo.resources;

import com.alinequeiroz.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1","Mariah carrey", "mariah@gmail.com");
        User alef = new User("2", "joseph alef","J.alef@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria,alef));
        return ResponseEntity.ok().body(list);
    }
}
