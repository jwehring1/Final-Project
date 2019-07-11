package com.cts.ac.web_sandbox.doa;

import com.cts.ac.web_sandbox.dto.Address;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.cts.ac.web_sandbox.dto.Person;

import javax.inject.Inject;

public class PeopleDatabaseDaoImpl implements PeopleDatabaseDao{

    JdbcTemplate jdbcTemplate;

    public PeopleDatabaseDaoImpl()
    {

    }

    @Inject
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static String GET_PERSON_BY_ID
            = "SELECT * "
            + "FROM person "
            + "WHERE SSN = ? ";

    private static String GET_ADDRESS_BY_ID
            = "SELECT * "
            + "FROM address "
            + "WHERE AddressID = ? ";

    public Person getPersonById(int id)
    {
        Person p = jdbcTemplate.queryForObject(GET_PERSON_BY_ID, new PersonMapper(), id);
        return p;
    }

    public Address getAddressById(int id)
    {
        Address a = jdbcTemplate.queryForObject(GET_ADDRESS_BY_ID, new AddressMapper(), id);
        return a;
    }

    private static String GET_PERSON_BY_ADDRESS
            = "SELECT Address "
            + "FROM person "
            + "WHERE AddressID = ? ";


    public Map<Address, List<Person>> getAllPeople()
    {
        Map<Address, List<Person>> output = new HashMap<>();
        List<Address> AddressList = jdbcTemplate.query(GET_All_ADDRESSES, new AddressMapper());
        List<Person> people = jdbcTemplate.query(GET_All_PEOPLE, new PersonMapper());
        for(int i=0; i<AddressList.size(); i++)
        {
            output.put(AddressList.get(i),new ArrayList<Person>());
        }
        for (int j = 0; j < people.size(); j++) {
            for(Address a: output.keySet()) {
                if (people.get(j).getAddr().getAddressId() == a.getAddressId())
                {
                    output.get(a).add(people.get(j));
                    break;
                }
            }
        }

        return output;


    }

    private static String GET_All_ADDRESSES
            = "SELECT * "
            + "FROM address ORDER BY AddressID ASC";

    private static String GET_All_PEOPLE
            = "SELECT * "
            + "FROM person";

    public List<Address> getAllAddresses()
    {
        List<Address> addresses = jdbcTemplate.query(GET_All_ADDRESSES, new AddressMapper());
        return addresses;
    }

    public List<Person> listAllPeople()
    {
        return jdbcTemplate.query(GET_All_PEOPLE, new PersonMapper());
    }

    private static String GET_All_SHORT_PEOPLE
            = "SELECT * "
            + "FROM person "
            + "WHERE Height <= ?";

    public List<Person> getShortPeople(int height)
    {
        return jdbcTemplate.query(GET_All_SHORT_PEOPLE, new PersonMapper(), height);
    }

    private static String GET_All_SPECIFIC_PEOPLE
            = "SELECT * "
            + "FROM person "
            + "WHERE PersonName LIKE ? and Age LIKE ? and Race LIKE ? and Height LIKE ? and Weight LIKE ?";

    public List<Person> getSpecificPeople(String name,String age, String race, String height, String weight)
    {
        return jdbcTemplate.query(GET_All_SPECIFIC_PEOPLE, new PersonMapper(), "%"+name+"%",age,"%"+race+"%",height,weight);
    }

    private static String GET_AGE_IN_RANGE
            = "SELECT * "
            + "FROM person "
            + "WHERE AGE BETWEEN ? and ?";

    public List<Person> getAgeByRange(int start,int end)
    {
        return jdbcTemplate.query(GET_AGE_IN_RANGE, new PersonMapper(), start,end);
    }

    private static String GET_PEOPLE_BY_ADDRESSID
            = "SELECT * "
            + "FROM person "
            + "WHERE AddressID = ?";

    public List<Person> getPeopleByStreetName(Address adr)
    {
        return jdbcTemplate.query(GET_PEOPLE_BY_ADDRESSID, new PersonMapper(), adr.getAddressId());
    }

    public Address getAddressBySteetName(String name){
        Map<Address, List<Person>> people = getAllPeople();
        Set<Address> adrs = people.keySet();
        Address adr = adrs.stream().filter(x -> x.getStreet().equals(name)).findFirst().orElse(null);
        return adr;
    }

    String ADD_PERSON = "INSERT INTO Person(PersonName, Age, SSN, Race, Height,Weight,AddressID) \n VALUES(?,?,?,?,?,?,?)";

    public void addNewPerson(Person p)
    {
        jdbcTemplate.update(ADD_PERSON,p.getName(),p.getAge(),p.getSsn(),p.getRace(),p.getHeight(),p.getWeight(),p.getAddr().getAddressId());
    }

    public void updatePerson(Person p,String set)
    {
        String UPDATE_PERSON
                = "UPDATE Person\n" +
                "SET " +set+"\n"+
                "WHERE PersonName = \""+p.getName()+"\" and AddressID = "+p.getAddr().getAddressId()+";";

        jdbcTemplate.execute(UPDATE_PERSON);
    }

    public void addNewAddress(Person p,String street, String city,String state, int zipcode){
        String ADD_ADDRESS
                = "INSERT INTO Address (Street, City, State, Zipcode)"
                + " VALUES (\""+street+"\",\""+city+"\", \""+state+"\","+zipcode+")";
        jdbcTemplate.execute(ADD_ADDRESS);
    }


    public boolean personDied(Person p)
    {
        String KILL_PERSON
                = "DELETE FROM Person WHERE PersonName = \""+p.getName()+"\" and AddressID = "+p.getAddr().getAddressId()+";";
        jdbcTemplate.execute(KILL_PERSON);
        return false;
    }

    private static String FIND_PERSON
            = "SELECT * "
            + "FROM person "
            + "WHERE AddressID = ? and PersonName = ?";

    public Person findPerson(String name, String street)
    {
        Address a = getAddressBySteetName(street);
        return jdbcTemplate.queryForObject(FIND_PERSON, new PersonMapper(), a.getAddressId(),name);
    }

    private static String FIND_PERSON_BY_SSN
            = "SELECT * "
            + "FROM person "
            + "WHERE SSN = ?";

    public Person findPersonBySsn(int ssn){
        return jdbcTemplate.queryForObject(FIND_PERSON_BY_SSN, new PersonMapper(), ssn);
    }

    public List<Person> findPerson(Map<String, String> params){return null;}

    private class AddressMapper implements RowMapper<Address>
    {
        public Address mapRow(ResultSet rs, int rowNum) throws SQLException
        {
            Address a = new Address();
            a.setAddressId(rs.getInt("AddressID"));
            a.setStreet(rs.getString("Street"));
            a.setCity(rs.getString("City"));
            a.setState(rs.getString("State"));
            a.setZipcode(rs.getInt("Zipcode"));
            return a;
        }
    }

    private class PersonMapper implements RowMapper<Person>
    {
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException
        {
            Person p = new Person();
            p.setName(rs.getString("PersonName"));
            p.setAge(rs.getInt("Age"));
            p.setSsn(rs.getInt("SSN"));
            p.setRace(rs.getString("Race"));
            p.setHeight(rs.getInt("Height"));
            p.setWeight(rs.getDouble("Weight"));
            int AddressId = (rs.getInt("AddressID"));

            Address a = getAddressById(AddressId);
            p.setAddr(a);
            return p;

        }
    }
}
