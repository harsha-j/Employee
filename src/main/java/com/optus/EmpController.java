package com.optus;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import com.optus.Employee;

import java.util.*;

@Controller
public class EmpController {

	ObjectMapper mapper=new ObjectMapper();
	public ArrayList empData(){
		Employee e1=new Employee();
		e1.setAge(38);
		e1.setName("lathika");
		e1.setId(1);
		
		Employee e2=new Employee();
		e2.setAge(40);
		e2.setName("Ganesh");
		e2.setId(2);
		
        ArrayList<Employee> al=new ArrayList<Employee>();
		al.add(e1);
		al.add(e2);
		return al;
	}
	ArrayList<Employee> al=empData();
	
	@RequestMapping(value="/getAllEmployees",method = RequestMethod.GET)
	public ModelAndView showEmp() throws Exception
	{
		ArrayList<Employee> al=empData();
		return new ModelAndView("emp","list",al);	
	}
	
	@RequestMapping(value="/getAllEmployees/{id}",method = RequestMethod.GET)
	public ModelAndView EmpDetails(@PathVariable int id) throws Exception
	{
		ArrayList<Employee> all=empData();
		for(Employee e:all)
		{
			if(e.getId()==id)
			return new ModelAndView("showEmp","employee",e);
			
		}
		return null;
	}
	
	@RequestMapping(value = "/rest/getAllEmployees", method = RequestMethod.GET)
	 public @ResponseBody ArrayList<Employee> getEmployee() throws Exception
	 {
		 return al;
	 }
	
	@RequestMapping(value = "/rest/getAllEmployees/{id}", method = RequestMethod.GET)
	 public @ResponseBody Employee getEmployeeInJSON(@PathVariable int id) throws Exception {
		
		Employee json=new Employee();
		ArrayList<Employee> al=empData();
		//ObjectMapper m=new ObjectMapper(); 
		for(Employee e:al)
		{
			if(e.getId()==id)
			return e;
			
		}
		return json;
	}
	
}
