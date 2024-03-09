package com.example.giangngu.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String carName;

    private Integer yearMade;

    @ManyToOne
    @JoinColumn(name = "personObj", referencedColumnName = "id")
    private Person person;

// JSON example
//car:
//    id: 01
//    carName: aston martin
//    YEARMADE: 2022
//        person {
//            id: 01
//            name: Duy Le
//            phone: 69696969
//        }
}
