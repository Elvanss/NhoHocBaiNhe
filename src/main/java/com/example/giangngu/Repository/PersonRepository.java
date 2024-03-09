package com.example.giangngu.Repository;

import com.example.giangngu.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Integer> {

//    Customize the SQL Query
//    @Query("SELECT u FROM Person u WHERE u.phone = ?")
//    public Person findByPhone (Integer phone);

}
