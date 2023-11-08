package com.example.airline_api.components;


import com.example.airline_api.Repositories.FlightRepository;
import com.example.airline_api.Repositories.PassengerRepository;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Flight flight1 = new Flight("Prague", 200, "06/11", "13:00");
        flightRepository.save(flight1);

        Passenger passenger1 = new Passenger("Dave", "Dave@something.com");
        passenger1.addFlight(flight1);
        passengerRepository.save(passenger1);


        Flight flight2 = new Flight("Barcelona", 200, "08/11", "19:00");
        flightRepository.save(flight2);

        Passenger passenger2 = new Passenger("John", "John@something.com");
        passenger2.addFlight(flight2);
        passengerRepository.save(passenger2);


    }
}

