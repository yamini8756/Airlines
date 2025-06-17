package com.tcs.Airlines.AirlineRepository;

import com.tcs.Airlines.AirlineEntity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepo extends JpaRepository<Airline,Long> {
    //Airline findById(long id);
}
