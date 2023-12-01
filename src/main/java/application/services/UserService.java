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
        Optional<User> user = repository.findById(id);

        if(user.get().getLogged() == Boolean.FALSE){
            user.get().setLogged(Boolean.TRUE);
            return user;
        }

        throw new RuntimeException("Usuário já está logado!");
    }


    public User insert(User user){
        return repository.save(user);
    }

    public User update(Long id, User user){
        User entity = repository.getReferenceById(id);
        updateData(entity,user);
        return repository.save(entity);
    }

    private void updateData(User entity, User user){
        entity.setName(user.getName());
        entity.setUsername(user.getUsername());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
        entity.setPassword(user.getPassword());
        entity.setLogged(user.getLogged());
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}
