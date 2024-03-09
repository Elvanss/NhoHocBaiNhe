package com.example.giangngu.Service;

import com.example.giangngu.Entity.Person;
import com.example.giangngu.Repository.PersonRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // CRUD: CREATE - READ - UPDATE - DELETE

//   Part 1: READ
    //Find all Person object
    public List<Person> findAllPerson() {
        return this.personRepository.findAll();
    }

    public Person findPersonById(Integer id) {
        // lambda 8
//        return this.personRepository.findById(id)
//                .orElseThrow(() -> new ObjectNotFoundException("Person", id));

        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isEmpty()) {
            throw new ObjectNotFoundException("Person", id);
        }
        return personOptional.get();
    }

//    Part 2: CREATE
    public Person createPerson(Person person) {
        Person personObj = new Person();
        personObj.setId(person.getId());
        personObj.setName(person.getName());
        personObj.setPhone(person.getPhone());

//        return personObj;
        return this.personRepository.save(personObj);
    }

//    Part 3: UPDATE
    public Person update (Integer id, Person update) {
        Optional<Person> personTobeFound = this.personRepository.findById(id);

        // isPresent(): null check = (!= null)
        if (!personTobeFound.isPresent()) {
            throw new ObjectNotFoundException("Person is not found!!!", id);
        }
        Person person = personTobeFound.get();
//        person.setId(update.getId()); // Một số cái ko cần updated trong bảng
        person.setName(update.getName());
        person.setPhone(update.getPhone());
        return this.personRepository.save(person);
    }

    //S4: DELETE
    public void deleteById (Integer id) {
        //S1: find the id, if not founded, go to buoc 2, neu ko, step into buoc 3
        //S2: return the Exception
        //S2: delete the existed id
        this.personRepository.findById(id);
        if (!this.personRepository.findById(id).isPresent()) {
            throw new ObjectNotFoundException("Tao đéo tìm thấy id! Hiểu ko", id);
        }
        this.personRepository.deleteById(id);
    }

    public void deleteAll () {
        this.personRepository.deleteAll();
    }

}
