package com.cts.ac.web_sandbox.controller;

import com.cts.ac.web_sandbox.dto.AddPersonDto;
import com.cts.ac.web_sandbox.dto.Address;
import com.cts.ac.web_sandbox.dto.Person;
import com.cts.ac.web_sandbox.service.PeopleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class HomeController {

	private PeopleService service;
	@Inject
	public void setService(PeopleService service){this.service = service;}

	@RequestMapping(value="/")
	public ModelAndView home() {
		ModelAndView ret = new ModelAndView("Home");
		return ret;
	}

	@RequestMapping(value="/Home")
	public ModelAndView test() {
		ModelAndView ret = new ModelAndView("Home");
		return ret;
	}

	@RequestMapping(value="/Delete")
	public ModelAndView delete() {
		ModelAndView ret = new ModelAndView("Delete");
		ret.addObject("Delete",service.findAllPeople());
		return ret;
	}

	@RequestMapping(value="/DeleteView")
	public ModelAndView deleteView(int ssn) {
		ModelAndView ret = new ModelAndView("DeleteView");
		service.personDied(service.findPersonBySsn(ssn));
		return ret;
	}

	@RequestMapping(value={"/Search"})
	public ModelAndView search() {

		ModelAndView ret = new ModelAndView("Search");
		return ret;
	}

	@RequestMapping(value={"/SearchForAddress"})
	public ModelAndView searchForAddress() {
		ModelAndView ret = new ModelAndView("SearchForAddress");
		ret.addObject("SearchAllAddr",service.getAddresses());
		return ret;
	}

	@RequestMapping(value={"/SearchForAllPeople"})
	public ModelAndView searchForAllPeople() {

		ModelAndView ret = new ModelAndView("SearchForAllPeople");
		ret.addObject("SearchForAllPeople",service.listAllPeople());
		return ret;
	}

	@RequestMapping(value={"/SearchAllAddr"})
	public ModelAndView searchAllAddr() {

		ModelAndView ret = new ModelAndView("SearchAllAddr");
		ret.addObject("SearchAllAddr",service.getAddresses());
		return ret;
	}

	@RequestMapping(value={"/SearchForAddressView"})
	public String searchForAddressView(@RequestParam(required=true) String street, Model m) {

		Address adr = service.getAddressBySteetName(street);
		m.addAttribute("adr",adr);
		return "SearchForAddressView";
	}

    @RequestMapping(value={"/SearchPplByAddr"})
    public ModelAndView searchPplByAddr() {

        ModelAndView ret = new ModelAndView("SearchPplByAddr");
        ret.addObject("SearchPplByAddr",service.getAddresses());
        return ret;
    }

    @RequestMapping(value={"/SearchPplByAddrView"})
    public String searchPplByAddrView(@RequestParam(required=true) String street, Model m) {

        List<Person> ppl = service.findPeopleByStreetName(street);
        m.addAttribute("SearchPplByAddrView",ppl);
        return "SearchPplByAddrView";
    }

	@RequestMapping(value="/Add")
	public ModelAndView add() {
		ModelAndView ret = new ModelAndView("Add");
		return ret;
	}

	@RequestMapping(value="/AddPerson")
	public ModelAndView addPerson() {
		ModelAndView ret = new ModelAndView("AddPerson");
		ret.addObject("SearchAllAddr",service.getAddresses());
		return ret;
	}

	@RequestMapping(value="/AddPersonSuc")
	public String addPersonSuc(@RequestParam(required=true) String name, int age, int ssn, String race, int height, double weight, String street, Model m) {
		AddPersonDto p = new AddPersonDto();
		try {
			p = new AddPersonDto(name, age, ssn, race, height, weight, street);
			service.addPerson(p);
		} catch (Exception e){
			System.out.println("Street does not exist");
		}
		m.addAttribute("p",p);
		return "AddPersonSuc";
	}

	@RequestMapping(value="/AddAddress")
	public ModelAndView addAddress() {
		ModelAndView ret = new ModelAndView("AddAddress");
		return ret;
	}

	@RequestMapping(value="/AddAddressSuc")
	public String addAddressSuc(@RequestParam(required=true) String street, String city, String state, int zipcode, Model m) {
		Address p =  new Address(street,city,state,zipcode);
		service.addNewAddress(null,street,city,state,zipcode);
		m.addAttribute("p",p);
		return "AddAddressSuc";
	}

	@RequestMapping(value="/Update")
	public ModelAndView update() {
		ModelAndView ret = new ModelAndView("Update");
        ret.addObject("SearchForAllPeople",service.findAllPeople());
		return ret;
	}

    @RequestMapping(value="/UpdateForm")
    public ModelAndView updateForm(int ssn, Model m) {
        ModelAndView ret = new ModelAndView("UpdateForm");
        Person p = service.findPersonBySsn(ssn);
        ret.addObject("SearchAllAddr",service.getAddresses());
        m.addAttribute("p",p);
        return ret;
    }

    @RequestMapping(value="/UpdateView")
    public ModelAndView updateView(String name, String age, String ssnnew, String race, String height, String weight,String street,int ssn,Model m) {
        ModelAndView ret = new ModelAndView("UpdateView");
        String[] tempArry = {name,age,ssnnew,race,height,weight};
        String[] tempArry2 = {"PersonName","Age","SSN","Race","Height","Weight"};
        int temp = 0;
        String set = "";
        for(int i=0; i< 6; i++)
        {
            if(!tempArry[i].equals("")&&temp!=0)
            {
                if(i==1||i==2||i==4||i==5)
                    set+=", "+tempArry2[i]+" = "+tempArry[i];
                else
                    set+=", "+tempArry2[i]+" = \""+tempArry[i]+"\"";
            }
            else if(!tempArry[i].equals(""))
            {
                if(i==1||i==2||i==4||i==5)
                    set+=tempArry2[i]+" = "+tempArry[i];
                else
                    set+=tempArry2[i]+" = \""+tempArry[i]+"\"";
                temp++;
            }
        }
        Address a = service.getAddressBySteetName(street);
        if(temp!=0)
            set+=", AddressID = "+a.getAddressId();
        else
            set+= " AddressID = "+a.getAddressId();
        Person p = service.findPersonBySsn(ssn);
        service.updatePerson(p,set);
        m.addAttribute("p",p);
        return ret;
    }
}
