package com.example.passanger.Controller;

import com.example.passanger.Entity.PassengerEntity;
import com.example.passanger.Repo.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/passenger")
public class MainController {
    @Autowired
    private PassengerRepository passengerRepository;

    @PostMapping
    public ResponseEntity<PassengerEntity> addPassenger(@RequestBody PassengerEntity passengerEntity) {
        PassengerEntity res = passengerRepository.save(passengerEntity);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerEntity> getPassenger(@PathVariable Long id) {
        Optional<PassengerEntity> res = passengerRepository.findById(id);
        return res.map(passenger -> new ResponseEntity<>(passenger, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PassengerEntity> updatePassenger(@PathVariable Long id, @RequestBody PassengerEntity passengerEntity) {
        if (passengerRepository.existsById(id)) {
            passengerEntity.setPassengerId(id);
            PassengerEntity updatedPassenger = passengerRepository.save(passengerEntity);
            return new ResponseEntity<>(updatedPassenger, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        if (passengerRepository.existsById(id)) {
            passengerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
