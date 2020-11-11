package com.example.adp1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.adp1.exception.ResourceNotFoundException;
import com.example.adp1.model.Location;
import com.example.adp1.repository.LocationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class LocationService {
    public static List<String> Northeast=new ArrayList(Arrays.asList(
            "Connecticut",
            "Maine",
            "Massachusetts",
            "New Hampshire",
            "Rhode Island",
            "Vermont",
            "New Jersey",
            "New York",
            "Pennsylvania"));
    
    public static List<String> Midwest=new ArrayList(Arrays.asList(
            "Illinois",
            "Indiana",
            "Michigan",
            "Ohio",
            "Wisconsin",
            "Iowa",
            "Kansas",
            "Minnesota",
            "Missouri",
            "Nebraska",
            "North Dakota",
            "South Dakota"));

    public static List<String> South=new ArrayList(Arrays.asList(
            "Delaware",
            "Florida",
            "Georgia",
            "Maryland",
            "South Carolina",
            "Virginia",
            "Washington DC",
            "West Virginia",
            "Alabama",
            "Kentucky",
            "Mississippi",
            "Tennessee",
            "Arkansas",
            "Louisiana",
            "Oklahoma",
            "Texas"));

    public static List<String> Western=new ArrayList(Arrays.asList(
            "Arizona",
            "Colorado",
            "Idaho",
            "Montana",
            "Nevada",
            "New Mexico",
            "Utah",
            "Wyoming",
            "Alaska",
            "California",
            "Hawaii",
            "Oregon",
            "Washington"));
    
    @Autowired
    LocationRepository locationRepository;
    
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
    
    public Location getLocationById(Long locationId) { 
                            
                Location location = locationRepository.findById(locationId)
                         .orElseThrow(() -> new ResourceNotFoundException("location", "id", locationId)); 
                                            
                long myLong = -1;
                String myRegion = "Unknown";
                
                myLong = Northeast.lastIndexOf(location.getlocationname());
                if (myLong != -1) {
                     myRegion = "Northeast";
                }    
                myLong = Midwest.lastIndexOf(location.getlocationname());
                if (myLong != -1) {
                    myRegion = "Midwest"; 
                }   
                myLong = South.lastIndexOf(location.getlocationname());
                if (myLong != -1) {
                    myRegion = "South";
                }
                myLong = Western.lastIndexOf(location.getlocationname());
                if (myLong != -1) {
                    myRegion = "Western";                   
                }
                System.out.println("Region = " + myRegion);
                
                location.setregionname(myRegion);
                
                return location;
    }

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }
    public ResponseEntity<?> deleteLocation(Long locationId) {
        Location location = locationRepository.findById(locationId)
            .orElseThrow(() -> new ResourceNotFoundException("location", "id", locationId));

        locationRepository.delete(location);
        
        return new ResponseEntity<>("Location Deleted", HttpStatus.OK);
    }
 // Update a Location
    public Location updateLocation(Long locationId, Location locationDetails) {

        Location location = locationRepository.findById(locationId)
        .orElseThrow(() -> new ResourceNotFoundException("location", "id", locationId));

    //Call Model Setters and Getters

        location.setlocationid(locationDetails.getlocationid());
        location.setlocationname(locationDetails.getlocationname());

        Location updatedLocation = locationRepository.save(location);
        
        return updatedLocation;
    }   

}