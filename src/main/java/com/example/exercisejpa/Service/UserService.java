package com.example.exercisejpa.Service;

import com.example.exercisejpa.Model.Category;
import com.example.exercisejpa.Model.User;
import com.example.exercisejpa.Repository.CategoryRepository;
import com.example.exercisejpa.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAlluser()
    {
        return userRepository.findAll();
    }

    public void adduser(User user)
    {
        userRepository.save(user);
    }

    public Boolean updateuser( Integer id,User user){
        User u=userRepository.getById(id);
        if (u==null){
            return false;
        }
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        u.setRol(user.getRol());
        u.setBalance(user.getBalance());
        return true;
    }
    public Boolean Deleteuser(Integer id){
        User u=userRepository.getById(id);
        if (u ==null){
            return false;
        }
        userRepository.delete(u);
        return true;
    }

}
