package com.task1.EmployeeTask1.Services;

import com.task1.EmployeeTask1.Model.Employee;
import com.task1.EmployeeTask1.Model.Location;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {
    List<Location> locationModel = List.of(new Location("1", "Hyderabad", "India"),
                                           new Location("2","Chennai","India"),
                                           new Location("3","London","United Kingdom")  );

    public List<Location> addLocation(Location e){
        locationModel.add(e);
        return locationModel;
    }

    public List<Location> getLocationAll(){
        return  locationModel;
    }

    public List<Location> getLocationById(String id){
     return    locationModel
               .stream()
               .filter(location-> location.getLocationId().equals(id))
               .collect(Collectors.toList());
    }

    public List<Location> deleteLocationById(String id){
        List<Location> ls  =   locationModel
                .stream()
                .filter(location -> !(location.getLocationId().equals(id)))
                .collect(Collectors.toList());

        locationModel.clear();
        locationModel.addAll(ls);
        return  locationModel;
    }

    public List<String> listOfLocationId(String country){

        return locationModel
                .stream()
                .filter(location -> location.getLocationCountry().equalsIgnoreCase(country))
                .map(location -> location.getLocationId())
                .collect(Collectors.toList());
    }

    public List<String> listOfLocationId(String city1 ,String city2){

        return locationModel
                .stream()
                .filter(location -> location.getLocationName().equalsIgnoreCase(city1) ||
                                    location.getLocationName().equalsIgnoreCase(city2))
                .map(location -> location.getLocationId())
                .collect(Collectors.toList());
    }


    public  List<String> cityAndCountryWiseLocationId(String city ,String country){
        return locationModel
                .stream()
                .filter(location -> location.getLocationName().equalsIgnoreCase(city) &&
                                     location.getLocationCountry().equalsIgnoreCase(country))
                .map(location -> location.getLocationId()).collect(Collectors.toList());
    }
}
