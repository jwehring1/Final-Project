package com.cts.ac.web_sandbox.service;

import com.cts.ac.web_sandbox.doa.PeopleDatabaseDao;
import com.cts.ac.web_sandbox.dto.AddPersonDto;
import com.cts.ac.web_sandbox.dto.Address;
import com.cts.ac.web_sandbox.dto.Person;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PeopleServiceImpl implements PeopleService{
    PeopleDatabaseDao dao;

    public PeopleServiceImpl() {System.out.println("Service Created");}

    @Inject
    public void setDao(PeopleDatabaseDao dao)
    {
        this.dao = dao;
    }

    public Person addPerson(AddPersonDto personData)
    {
        Address addr = dao.getAddressBySteetName(personData.getStreet());
        if(addr == null)
            throw new InvalidAddressStreetException(personData.getStreet());
        Person person = new Person(personData.getName(),personData.getAge(),personData.getSsn(),personData.getRace(),personData.getHeight(),personData.getWeight(),addr);
        dao.addNewPerson(person);
        return person;
    }

    public List<Person> findPeopleByStreetName(String street)
    {
        Address addr = dao.getAddressBySteetName(street);
        if(addr == null)
            throw new InvalidAddressStreetException(street + " is not a recognized street.");

        return dao.getPeopleByStreetName(addr);
    }

    public void addNewAddress(Person p,String street, String city,String state, int zipcode)
    {
        dao.addNewAddress(p,street,city,state,zipcode);
    }

    public Person findPerson(String name, String street)
    {
        return dao.findPerson(name,street);
    }

    public Person findPersonBySsn(int ssn){return dao.findPersonBySsn(ssn);}

    public List<Person> getShortPeople(int height){return dao.getShortPeople(height);}

    public List<Person> getAgeByRange(int start,int end){return dao.getAgeByRange(start,end);}

    public List<Person> getSpecificPeople(String name,String age, String race, String height, String weight){return dao.getSpecificPeople(name,age,race,height,weight);}

    public void updatePerson(Person p,String set){dao.updatePerson(p,set);}

    public List<Person> findAllPeople()
    {
        Map<Address,List<Person>> peopleMap = dao.getAllPeople();
        List<Person> person = new ArrayList<Person>();
        for(List<Person> p : peopleMap.values())
        {
            person.addAll(p);
        }
        return person;
    }

    public boolean personDied(Person person)
    {
        return dao.personDied(person);
    }

    public Address getAddressBySteetName(String name){return dao.getAddressBySteetName(name);}

    public List<Address> getAddresses()
    {
        return dao.getAllAddresses();
    }

    public List<Person> listAllPeople() {return dao.listAllPeople();}
}
