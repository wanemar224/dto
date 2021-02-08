package com.example.demo.adapter;

import com.example.demo.dto.LocationDto;
import com.example.demo.entity.Location;
import org.springframework.stereotype.Service;

@Service
public class AdapterLocation {

    public LocationDto toLocationDto(Location location){
        return LocationDto.builder()
                .id(location.getId())
                .street(location.getStreet())
                .city(location.getCity())
                .streetName(location.getStreetName())
                .build();
    }

    public Location toLocation(LocationDto locationDto){
        return Location.builder()
                .id(locationDto.getId())
                .city(locationDto.getCity())
                .street(locationDto.getStreet())
                .streetName(locationDto.getStreetName())
                .build();
    }
}
