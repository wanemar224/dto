package com.example.demo.controller;

import com.example.demo.dto.LocationDto;
import com.example.demo.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<LocationDto> createLocation(){
        return this.locationService.getLocations();
    }
}
