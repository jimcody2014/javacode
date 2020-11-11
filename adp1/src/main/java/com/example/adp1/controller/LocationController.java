/*package com.example.jim.controller;

import com.example.jim.service.LocationService;
import com.example.jim.model.ApplicantStatus;
import com.example.jim.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.validation.Valid;


@RestController
@RequestMapping("/rest")
public class LocationController {
    
    @Autowired
    private LocationService locationService;

    // Get All Location Records
    @GetMapping("/location")
    @ResponseBody
    public List<Location> getAllLocations() {
    return this.locationService.getAllLocations();
    }
    
 // Get a Single Location Record by ID
    @GetMapping("/location/{id}")
    public LocationService getLocationById(@PathVariable(value = "id") Long locationId) {
            return this.locationService.getLocationById(locationId);	
    }
    
 // Create a new Location
    @PostMapping("/location")
    public ApplicantStatus createLocation(@Valid @RequestBody ApplicantStatus newLocation) {
        return this.locationService.createLocation(newLocation);
    }
 // Delete an Location
    @DeleteMapping("/location/{id}")
    public ResponseEntity<?> deleteLocation(@PathVariable(value = "id") Long locationId) {
        return this.locationService.deleteLocation(locationId);
    }
    
 // Update an Existing Location by ID
    @PutMapping("/location/{id}")
    public Location updateLocation(@PathVariable(value = "id") Long locationId, 
         @Valid @RequestBody Location locationDetails) {

         return this.locationService.updateLocation(locationId, locationDetails);
    }



}


*/