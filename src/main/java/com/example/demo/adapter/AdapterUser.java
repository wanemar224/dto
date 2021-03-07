package com.example.demo.adapter;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

@Service
public class AdapterUser {

    public UserDto toUserDto(User user){
        UserDto.UserDtoBuilder userDto = UserDto.builder()
                .id(user.getId())
                .pseudo(user.getPseudo())
                .telephone(user.getTelephone());
        if (user.getAddress() != null){
            userDto.address(user.getAddress().getStreet()+" "+user.getAddress().getStreetName()+", "+user.getAddress().getCity());
        }
        return userDto.build();
    }

    public User toUser(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .pseudo(userDto.getPseudo())
                .telephone(userDto.getTelephone())
                .password(userDto.getPassword())
                .build();
    }
}
