package com.optus;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value=SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:EmpDetails-servlet.xml")
public class EmpControllerTest {
	    @Autowired
	    private WebApplicationContext wac;
	    private MockMvc mockMvc;
	    @Before
	    public void setup() {
	    	 this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	    }
	    @Test
	    public void showEmpTest() throws Exception {
	       this.mockMvc.perform(get("/getAllEmployees")).andExpect(status().isOk());
	    }
	    @Test
	    public void EmpDetailsTest() throws Exception {
			MvcResult result = this.mockMvc.perform(get("/getAllEmployees/1")).andReturn();
			ModelAndView mav = result.getModelAndView();
			Employee e = (Employee) mav.getModel().get("employee");
			assertNotNull(e);
		}
	   
	}
