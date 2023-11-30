package application.services;

import application.entities.User;
import application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Optional<User> findById(Long id){
        return repository.findById(id);
    }
    public User insert(User user){
        return repository.save(user);
    }

    public User update(User user){
        return user;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}
