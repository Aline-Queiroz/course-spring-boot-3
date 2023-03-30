package com.alinequeiroz.workshopmongo.services;

import com.alinequeiroz.workshopmongo.domain.User;
import com.alinequeiroz.workshopmongo.dto.UserDTO;
import com.alinequeiroz.workshopmongo.repository.UserRepository;
import com.alinequeiroz.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User insert(User obj){
        return repo.insert(obj);
    }
    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
