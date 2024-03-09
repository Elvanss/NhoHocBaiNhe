package com.example.giangngu.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity //Set class là Entity

//Lombok package annotation
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

//Đặt tên cho table
@Table(name = "Person")
public class Person implements Serializable {

    @Id // Primary key
    @Column(name = "id") // Đặt tên cho côt trong table
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @Id
    @NotEmpty(message = "Tự chú thích vào")  // NOT NULL CONSTRAINT
    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private Integer phone;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "person")
    List<Car> carList = new ArrayList<>();


}
