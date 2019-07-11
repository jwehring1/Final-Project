/*package com.cts.ac.web_sandbox.controller;

import com.cts.ac.web_sandbox.dto.AddPersonDto;
import com.cts.ac.web_sandbox.dto.Address;
import com.cts.ac.web_sandbox.dto.Person;
import com.cts.ac.web_sandbox.service.PeopleServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeopleController {
    private Runner front;
    private PeopleServiceImpl service;

    public PeopleController(Runner front, PeopleServiceImpl service) {
        this.front = front;
        this.service = service;
        front.run(this);
    }

    public Person addPerson(AddPersonDto personData)
    {
        return service.addPerson(personData);
    }

    public List<Person> findPeopleByStreetName(String street)
    {
        return service.findPeopleByStreetName(street);
    }

    public void addNewAddress(Person p,String street, String city,String state, int zipcode)
    {
        service.addNewAddress(p,street,city,state,zipcode);
    }

    public List<Person> listPeople()
    {
        return service.findAllPeople();
    }

    public List<Person> listPeople(String name)
    {
        return service.findPeopleByStreetName(name);
    }

    public List<Person> getShortPeople(int height){ return service.getShortPeople(height); }

    public List<Person> getAgeByRange(int start,int end){return service.getAgeByRange(start,end);}

    public List<Person> getSpecificPeople(String name,String age, String race, String height, String weight){return service.getSpecificPeople(name,age,race,height,weight);}

    public Person findPerson(String name, String street)
    {
        return service.findPerson(name,street);
    }

    public Person findPersonBySsn(int ssn){ return service.findPersonBySsn(ssn);}

    public void personDied(Person person)
    {
        service.personDied(person);
    }

    public void updatePerson(Person p,String set){service.updatePerson(p,set);}

    public List<String> getAddresses()
    {
        List<Address> addrs = service.getAddresses();
        List<String> addrsNames = new ArrayList<>();
        for(Address a:addrs)
        {
            addrsNames.add(a.getStreet());
        }
        Collections.sort(addrsNames);
        return addrsNames;
    }
}*/
