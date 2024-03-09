package com.example.giangngu.Utils;

import com.example.giangngu.Entity.Car;
import com.example.giangngu.Entity.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        Person person1 = new Person();
        person1.setName("Giang gay");
        person1.setPhone(999999999);

        Car car1 = new Car();
        car1.setCarName("Morning");
        car1.setYearMade(2002);
        car1.setPerson(person1);
    }
}
