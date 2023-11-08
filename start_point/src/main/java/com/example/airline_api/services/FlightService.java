package com.example.airline_api.services;

import com.example.airline_api.Repositories.FlightRepository;
import com.example.airline_api.Repositories.PassengerRepository;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;



    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }

    public List<Flight> findAllFlights(){
        return flightRepository.findAll();
    }

    public Flight findFlight(Long id){
        return flightRepository.findById(id).get();
    }

    public void cancelFlight(long id){
        Flight flight = flightRepository.findById(id).get();
        for (Passenger passenger : flight.getPassengers()) {
            passenger.removeFlight(flight);
        }
        flightRepository.deleteById(id);
    }





}
