package com.example.passanger.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerEntity {
    @Id
    private Long passengerId;
    private String passengerName;
    private int age;
    private Long trainNo;
}
