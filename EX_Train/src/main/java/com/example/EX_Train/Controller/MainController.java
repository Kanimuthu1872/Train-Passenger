package com.example.EX_Train.Controller;

import com.example.EX_Train.Entity.TrainEntity;
import com.example.EX_Train.Repo.TrainRepository;
import com.example.EX_Train.model.TrainPojo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {
    @Autowired
    TrainRepository trainRepository;

    @PostMapping("/train")
    public ResponseEntity<TrainEntity> saveDetails(@RequestBody TrainPojo trainPojo) {
        TrainEntity trainEntity = new TrainEntity();
        BeanUtils.copyProperties(trainPojo, trainEntity);
        trainEntity = trainRepository.save(trainEntity);  // Save the entity and get the saved instance
        return new ResponseEntity<>(trainEntity, HttpStatus.CREATED); // Return the saved entity
    }

    @GetMapping("/train/{id}")
    public ResponseEntity<TrainEntity> getDetails(@PathVariable Long id) {
        Optional<TrainEntity> res = trainRepository.findById(id);
        if (res.isPresent()) {
            return new ResponseEntity<>(res.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/train/update/{id}")
    public ResponseEntity<TrainEntity> updateTrain(@PathVariable Long id, @RequestBody TrainPojo trainPojo) {
        Optional<TrainEntity> getres = trainRepository.findById(id);
        if (getres.isPresent()) {
            TrainEntity trainEntity = getres.get();
            BeanUtils.copyProperties(trainPojo, trainEntity, "trainNo"); // Avoid overwriting trainNo
            TrainEntity updatedDetail = trainRepository.save(trainEntity);
            return new ResponseEntity<>(updatedDetail, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/train/delete/{id}")
    public ResponseEntity<Void> deleteTrain(@PathVariable Long id) {
        Optional<TrainEntity> res = trainRepository.findById(id);
        if (res.isPresent()) {
            trainRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
