package com.project.BookMyCinemaProject.controller;

import com.project.BookMyCinemaProject.entity.Movies;
import com.project.BookMyCinemaProject.entity.Theatre;
import com.project.BookMyCinemaProject.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
    @Autowired
    TheatreService theatreService;

    @PostMapping("/add")
    public String add(@RequestBody Theatre theatre){
        return theatreService.addTheatre(theatre);
    }

    @PostMapping("/add-movie/{id}")
    public String addMovies(@PathVariable String id , @RequestBody Movies movies){
        return theatreService.addMovies(id,movies);
    }

    @GetMapping("/get-by-location/{location}")
    public List<Theatre> getThatreByLocation(@PathVariable String location){
        return theatreService.getTheatreBasedOnLocation(location);
    }

    @GetMapping("get-movie-by-location-price-name/{location}/{price}/{name}")
    public List<Movies> getAllMoviesBasedOnLocationPriceName(@PathVariable String location,
                                                             @PathVariable String price,
                                                             @PathVariable String name){
        return theatreService.getAllMoviesBasedOnLocationPriceName(location, price, name);
    }
}

