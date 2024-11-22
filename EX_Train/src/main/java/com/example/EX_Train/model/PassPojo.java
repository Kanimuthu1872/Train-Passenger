package com.example.EX_Train.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassPojo {
    Long passengerId;
    String passangerName;
    int age;
    Long trainNo;
}
