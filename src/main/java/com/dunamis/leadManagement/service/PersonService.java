package com.dunamis.leadManagement.service;
import com.dunamis.leadManagement.domain.Person;
import java.util.List;

public interface PersonService {
    public Person findById(Integer id);
    public void savePerson(Person person_1);
    public boolean deletePerson(Integer personId);
    public List<Person> findAll();
}