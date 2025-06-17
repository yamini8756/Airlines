package com.tcs.Airlines.AirlineController;

import com.tcs.Airlines.AirlineEntity.Airline;
import com.tcs.Airlines.AirlineService.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class AirlineController {

    @Autowired
    AirlineService airlineservice;

    @PostMapping("/api/airlines")
    public Airline saveAirlineData(@RequestBody Airline airline){
        return airlineservice.saveAirlineData(airline);
    }

    @GetMapping("/api/airlines")
    public List<Airline> getAirlineDetails(){
        return airlineservice.getAirlineDetails();
    }

    @GetMapping("/api/airlines/{id}")
    public Optional<Airline> getAirlineById(@PathVariable long id){
        return airlineservice.getAirlineById(id);
    }

    @PutMapping("/api/airlines/{id}")
    public Airline updateAirlineData(@PathVariable long id,@RequestBody Airline airline){
        return airlineservice.updateAirlineData(id,airline);
    }

    @DeleteMapping("/delete{id}")
    public String deleteAirlineById(@PathVariable long id){
        return airlineservice.deleteAirlineById(id);
    }


}
