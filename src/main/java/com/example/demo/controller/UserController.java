package com.example.demo.controller;

import com.example.demo.adapter.AdapterLocation;
import com.example.demo.adapter.AdapterUser;
import com.example.demo.dto.LocationDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.LocationService;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static java.lang.System.*;
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;
    private final LocationService locationService;

    public UserController(UserService userService, LocationService locationService) {
        this.userService = userService;
        this.locationService = locationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody UserDto userDto)
    {
        out.println(userDto);
        return this.userService.save(userDto);
    }

    @PutMapping("/{id}/Location")
    @ResponseStatus(HttpStatus.OK)
    public UserDto addLocation(@PathVariable Long id, @RequestBody LocationDto locationDto) throws Exception {
        return this.userService.addLocation(id,this.locationService.save(this.userService.getUser(id), locationDto));
    }
}
