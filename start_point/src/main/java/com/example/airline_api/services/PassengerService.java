package com.example.airline_api.services;


import com.example.airline_api.Repositories.FlightRepository;
import com.example.airline_api.Repositories.PassengerRepository;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightService flightService;

    @Autowired
    FlightRepository flightRepository;

    public List<Passenger> findAllPassengers(){
        return passengerRepository.findAll();
    }

    public Optional<Passenger> findPassengerById(long id){
        return passengerRepository.findById(id);
    }

    @Transactional
    public Flight addPassengerToFlight(long flightId, long passengerId ){
        Flight flightToAddPassenger = flightRepository.findById(flightId).get();
        Passenger passengerToBook = passengerRepository.findById(passengerId).get();
        List<Passenger> flight = flightToAddPassenger.getPassengers();
        flight.add(passengerToBook);
        flightToAddPassenger.setPassengers(flight);
        flightRepository.save(flightToAddPassenger);

        return flightToAddPassenger;

    }





}
