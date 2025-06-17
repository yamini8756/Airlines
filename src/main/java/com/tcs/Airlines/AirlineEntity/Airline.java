package com.tcs.Airlines.AirlineEntity;

import jakarta.persistence.*;


@Entity
@Table(name="Airline_table")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long airlineId;
    private String airlineName;
    private String airlineCountry;
    private String airlineStatus;

    public Airline(long airlineId, String airlineName, String airlineCountry, String airlineStatus) {
        this.airlineId = airlineId;
        this.airlineName = airlineName;
        this.airlineCountry = airlineCountry;
        this.airlineStatus = airlineStatus;
    }

    public Airline() {
    }

    public long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(long airlineId) {
        this.airlineId = airlineId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineCountry() {
        return airlineCountry;
    }

    public void setAirlineCountry(String airlineCountry) {
        this.airlineCountry = airlineCountry;
    }

    public String getAirlineStatus() {
        return airlineStatus;
    }

    public void setAirlineStatus(String airlineStatus) {
        this.airlineStatus = airlineStatus;
    }
}
