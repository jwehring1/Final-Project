package com.cts.ac.web_sandbox.service;

import com.cts.ac.web_sandbox.dto.AddPersonDto;
import com.cts.ac.web_sandbox.dto.Address;
import com.cts.ac.web_sandbox.dto.Person;

import java.util.List;

public interface PeopleService {
    Person addPerson(AddPersonDto person);

    List<Person> findPeopleByStreetName(String street);

    void addNewAddress(Person p,String street, String city,String state, int zipcode);

    Person findPerson(String name, String street);

    Person findPersonBySsn(int ssn);

    List<Person> findAllPeople();

    boolean personDied(Person person);

    List<Person> getShortPeople(int height);

    List<Person> getAgeByRange(int start,int end);

    List<Person> getSpecificPeople(String name,String age, String race, String height, String weight);

    void updatePerson(Person p,String set);

    public Address getAddressBySteetName(String name);

    List<Address> getAddresses();

    public List<Person> listAllPeople();

}
