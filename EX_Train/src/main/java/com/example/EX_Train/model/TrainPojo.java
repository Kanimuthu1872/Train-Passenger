package com.example.EX_Train.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrainPojo {
    Long trainNo;
    String trainName;
    List<PassPojo> allPassengers;
}
