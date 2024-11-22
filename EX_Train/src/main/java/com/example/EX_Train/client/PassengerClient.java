package com.example.EX_Train.client;

import com.example.EX_Train.model.PassPojo; // Ensure this matches your PassengerEntity model
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "passenger-service") // Name of the passenger service registered in Eureka
public interface PassengerClient {

    @GetMapping("/passenger/{id}")
    PassPojo getPassengerDetails(@PathVariable("id") Long passengerId);
}
