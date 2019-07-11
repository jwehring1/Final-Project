package com.cts.ac.web_sandbox.doa;

import com.cts.ac.web_sandbox.dto.Address;
import com.cts.ac.web_sandbox.dto.Person;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PeopleDatabaseDao {
    public Person getPersonById(int id);
    public Address getAddressById(int id);

    public Map<Address, List<Person>> getAllPeople();

    public List<Address> getAllAddresses();

    public List<Person> listAllPeople();

    public List<Person> getPeopleByStreetName(Address adr);

    public Address getAddressBySteetName(String name);

    public void addNewPerson(Person p);

    public void addNewAddress(Person p,String street, String city,String state, int zipcode);

    public boolean personDied(Person p);

    public Person findPerson(String name, String street);

    public Person findPersonBySsn(int ssn);

    public List<Person> getShortPeople(int height);

    public List<Person> getSpecificPeople(String name,String age, String race, String height, String weight);

    public List<Person> getAgeByRange(int start,int end);

    public void updatePerson(Person p,String set);

    public List<Person> findPerson(Map<String, String> params);
}
