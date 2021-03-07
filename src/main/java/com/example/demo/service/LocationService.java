package com.example.demo.service;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import org.springframework.stereotype.Service;


@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;

    }

    public Location save(Location location) {
        return this.locationRepository.save(location);
    }
}
