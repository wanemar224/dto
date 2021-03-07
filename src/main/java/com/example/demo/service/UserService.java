package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final LocationService locationService;

    public UserService(UserRepository userRepository, LocationService locationService) {
        this.userRepository = userRepository;
        this.locationService = locationService;
    }

    public User save(User user){
        return this.userRepository.save(user);
    }


    public User findById(Long id) throws ChangeSetPersister.NotFoundException {
        return this.userRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
