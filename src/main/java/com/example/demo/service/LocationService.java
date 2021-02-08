package com.example.demo.service;

import com.example.demo.adapter.AdapterLocation;
import com.example.demo.adapter.AdapterUser;
import com.example.demo.dto.LocationDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final AdapterLocation adapterLocation;
    private final AdapterUser adapterUser;

    public LocationService(LocationRepository locationRepository, AdapterLocation adapterLocation, AdapterUser adapterUser) {
        this.locationRepository = locationRepository;
        this.adapterLocation = adapterLocation;
        this.adapterUser = adapterUser;
    }

    public LocationDto save(UserDto userDto, LocationDto locationDto){
        Location location = this.adapterLocation.toLocation(locationDto);
        location.addUser(this.adapterUser.toUser(userDto));
        return this.adapterLocation.toLocationDto(this.locationRepository.save(location));
    }
    public List<LocationDto> getLocations(){
        List<LocationDto> locations = new ArrayList<>();
        for(Location location: this.locationRepository.findAll()){
            locations.add(this.adapterLocation.toLocationDto(location));
        }
        return locations;
    }
}
