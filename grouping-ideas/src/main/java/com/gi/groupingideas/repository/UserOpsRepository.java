package com.gi.groupingideas.repository;

import com.gi.groupingideas.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserOpsRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private UserRepository userRepository;

    public String saveUser(User user){
        mongoTemplate.save(user);
        return user.toString();
    }

    public String getUser(){
        return userRepository.findAll().toString();
    }

    public String deleteUser(String user){
        userRepository.deleteById(user);
        return "Deleted Successfully";
    }

    public String updateUser(String id, User user) {
        Optional<User> byId = userRepository.findById(id);
        if(byId.isPresent()){
            User user1 = byId.get();
            if(user.getSkills()!=null){
                user1.setSkills(user.getSkills());
            }
            return userRepository.save(user1).toString();
        }else{
            return "user not found";
        }
    }

    public String modifyUser(String id, User user) {
        Optional<User> byId = userRepository.findById(id);
        if(byId.isPresent()){
            User user1 = byId.get();
            user1.setName(user.getName());
            user1.setExp(user.getExp());
            user1.setSkills(user.getSkills());
            return userRepository.save(user1).toString();
        }else{
            return "user not found";
        }
    }
}
