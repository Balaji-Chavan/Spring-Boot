package com.project.BookMyCinemaProject.service;

import com.project.BookMyCinemaProject.entity.Movies;
import com.project.BookMyCinemaProject.entity.Theatre;
import com.project.BookMyCinemaProject.repository.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TheatreService {
    @Autowired
    TheatreRepo theatreRepo;

    public String addTheatre(Theatre theatre){

        List<Theatre> theatreList = theatreRepo.findAll();
        List list =new ArrayList<>() ;
        if(theatreList.size()>0){
            theatreList.forEach(theatre1  -> {
                if(theatre1.getLocation().equalsIgnoreCase(theatre.getLocation()) &&
                        theatre1.getTheatreName().equalsIgnoreCase(theatre.getTheatreName()) ){
                    list.add(1);
                }
            });
        }

        if(list.size()>0)
            return "Theatre already Present!!";


        long a = theatreRepo.count();

        theatreRepo.save(theatre);

        long b = theatreRepo.count();

        if(b>a)
            return "Theatre Added Successfully!!";

        return "Theatre Not Added";

    }



    public String addMovies(String tid, Movies movies){
        Optional<Theatre> t = theatreRepo.findById(tid);
        if(t.isPresent()){
            Theatre theatre = t.get();

            if(LocalDate.now().compareTo(movies.getDate())>0){
                return "please check movies date!!";
            }

            int a = theatre.getListOfTheatreMovies().size();
            theatre.getListOfTheatreMovies().add(movies);
            theatreRepo.save(theatre);
            if(a<theatre.getListOfTheatreMovies().size())
                return "movies added successfully!!";

            return "movies not added!!";
        }

        return "please write correct Theatre id";
    }

    public List<Theatre> getTheatreBasedOnLocation(String location){
        List<Theatre> theatreList = theatreRepo.findAll();

        if(theatreList.size()>0){
            theatreList =  theatreList
                    .stream()
                    .filter(theatre ->  theatre.getLocation().equalsIgnoreCase(location))
                    .collect(Collectors.toList());

            if(theatreList.size()>0){
                return  theatreList;
            }

            return null;
        }

        return null;
    }



    public List<Movies> getAllMoviesBasedOnLocationPriceName(String location,String price,String name){

        List<Theatre> theatreList = theatreRepo.findAll();

        List<Movies> moviesList = new ArrayList<>();

        if(theatreList.size()>0){
            theatreList
                    .stream()
                    .filter(theatre -> theatre.getLocation().equalsIgnoreCase(location))
                    .forEach(theatre -> {
                        theatre.getListOfTheatreMovies()
                                .forEach(movie ->{
                                    if(movie.getMovieName().equalsIgnoreCase(name) &&
                                            movie.getPrice().equalsIgnoreCase(price)){
                                        moviesList.add(movie);
                                    }
                                });
                    });
            return moviesList;
        }
        return null;
    }
}

