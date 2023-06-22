package com.project.BookMyCinemaProject.repository;

import com.project.BookMyCinemaProject.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre,String> {
}
