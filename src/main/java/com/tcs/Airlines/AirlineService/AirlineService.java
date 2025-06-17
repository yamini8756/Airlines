package com.tcs.Airlines.AirlineService;

import com.tcs.Airlines.AirlineEntity.Airline;
import com.tcs.Airlines.AirlineRepository.AirlineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineService {

    @Autowired
    AirlineRepo airlinerepo;
    public Airline saveAirlineData(Airline airline) {
        return airlinerepo.save(airline);
    }

    public List<Airline> getAirlineDetails() {
        return airlinerepo.findAll();
    }

    public Optional<Airline> getAirlineById(long id) {
        return airlinerepo.findById(id);
    }

    public Airline updateAirlineData(long id,Airline airline ) {
       Optional<Airline> existingdata=airlinerepo.findById(id);
       if(existingdata.isPresent()){
           Airline updatedata=existingdata.get();
           //updatedata.setAirlineId(airline.getAirlineId());
           updatedata.setAirlineName(airline.getAirlineName());
           updatedata.setAirlineCountry(airline.getAirlineCountry());
           updatedata.setAirlineStatus(airline.getAirlineStatus());
           return airlinerepo.save(updatedata);
       }
       else{
           return null;
       }
    }

    public String deleteAirlineById(long id) {
        if (airlinerepo.existsById(id)) {
            airlinerepo.deleteById(id);
            return "Deleted successfully";
        }
        else{
            return "Delete unsuccessful";
        }

    }
}
