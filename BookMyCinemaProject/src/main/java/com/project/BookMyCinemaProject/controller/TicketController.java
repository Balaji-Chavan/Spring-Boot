package com.project.BookMyCinemaProject.controller;

import com.project.BookMyCinemaProject.entity.Ticket;
import com.project.BookMyCinemaProject.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @PostMapping("/book/{id}")
    public String bookTicket(@PathVariable int id , @RequestBody Ticket ticket){
        return ticketService.bookTicket(id,ticket);
    }
}