package com.example.demo.service;

import com.example.demo.adapter.AdapterLocation;
import com.example.demo.adapter.AdapterUser;
import com.example.demo.dto.LocationDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Location;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AdapterUser adapterUser;
    private final AdapterLocation adapterLocation;
    private final LocationService locationService;

    public UserService(UserRepository userRepository, AdapterUser adapterUser, AdapterLocation adapterLocation, LocationService locationService) {
        this.userRepository = userRepository;
        this.adapterUser = adapterUser;
        this.adapterLocation = adapterLocation;
        this.locationService = locationService;
    }
    public UserDto getUser(Long id) throws Exception {
        Optional<User> user = this.userRepository.findById(id);
        if(user.isPresent()){
            return this.adapterUser.toUserDto(user.get());
        }
        else throw new Exception("Not found user " + id);
    }
    public UserDto save(UserDto userDto)
    {
        return this.adapterUser.toUserDto(this.userRepository.save(this.adapterUser.toUser(userDto)));
    }
    public UserDto addLocation(Long id, LocationDto locationDto) throws Exception {
       Optional<User> user = this.userRepository.findById(id);
       user.ifPresent(user1 -> {
           Location location = this.adapterLocation.toLocation(locationDto);
           user1.setAddress(location);
            //.addUser(user1);
            //this.locationService.save(this.)
       });
       if(user.isPresent()) {
           return this.adapterUser.toUserDto(user.get());
       } else throw new Exception("Not found user " + id);
    }
}
