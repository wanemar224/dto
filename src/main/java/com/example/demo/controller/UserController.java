package com.example.demo.controller;

import com.example.demo.adapter.AdapterLocation;
import com.example.demo.adapter.AdapterUser;
import com.example.demo.dto.LocationDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Location;
import com.example.demo.entity.User;
import com.example.demo.service.LocationService;
import com.example.demo.service.UserService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static java.lang.System.*;
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;
    private final AdapterUser adapterUser;
    private final AdapterLocation adapterLocation;
    private final LocationService locationService;

    public UserController(UserService userService, AdapterUser adapterUser, AdapterLocation adapterLocation, LocationService locationService) {
        this.userService = userService;
        this.adapterUser = adapterUser;
        this.adapterLocation = adapterLocation;
        this.locationService = locationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody UserDto userDto)
    {
        out.println(userDto);
        return this.adapterUser.toUserDto(this.userService.save(this.adapterUser.toUser(userDto)));
    }

    @PutMapping("/{id}/location")
    @ResponseStatus(HttpStatus.OK)
    public UserDto addLocation(@PathVariable Long id, @RequestBody LocationDto locationDto) throws ChangeSetPersister.NotFoundException {
        User user = this.userService.findById(id);
        Location location = this.adapterLocation.toLocation(locationDto);
        location.addUser(user);
        user.setAddress(this.locationService.save(location));
        return this.adapterUser.toUserDto(this.userService.save(user));
    }
}
