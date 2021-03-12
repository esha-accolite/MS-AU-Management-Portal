package com.msaumanagementportal.onboarding.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.springframework.http.MediaType;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.msaumanagementportal.onboarding.dao.impl.OnboardeeOperationsDao;
import com.msaumanagementportal.onboarding.models.OnboardeeCompleteInfo;
import com.msaumanagementportal.onboarding.services.impl.OnboardeeOperationsService;


@SpringBootTest
@AutoConfigureMockMvc
class OnboardeeOperationsControllerTest {
	
	@Mock
	OnboardeeOperationsDao onboardeeOperationsDao;
	
	@InjectMocks
	OnboardeeOperationsService onboardeeOperationsService;
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	ObjectMapper ObjectMapper;

	@Test
	public void getAllTest() throws Exception{
		List<OnboardeeCompleteInfo> onboardeeCompleteInfoList = new ArrayList<OnboardeeCompleteInfo>();
		OnboardeeCompleteInfo onboardee = getMockedObject();
		onboardeeCompleteInfoList.add(onboardee);
		Mockito.when(onboardeeOperationsService.getAllOnboardee()).thenReturn(onboardeeCompleteInfoList);
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/onboardee/getAllOnboardee").accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(),response.getStatus());
	}
	
	@Test
	public void addOnboardeeTest() throws Exception{
		List<OnboardeeCompleteInfo> onboardeeCompleteInfoList = new ArrayList<OnboardeeCompleteInfo>();
		OnboardeeCompleteInfo onboardee = getMockedObject();
		onboardeeCompleteInfoList.add(onboardee);
		Mockito.when(onboardeeOperationsService.addOnboardee(onboardee)).thenReturn(onboardee.getId());
		mvc.perform(MockMvcRequestBuilders.post("/onboardee/addOnboardee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ObjectMapper.writeValueAsBytes(onboardee))
        ).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public OnboardeeCompleteInfo getMockedObject() {
		Integer a = 7;
		@SuppressWarnings("deprecation")
		Date date = new Date(99,2,1);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		OnboardeeCompleteInfo onboardeeCompleteInfo = new OnboardeeCompleteInfo(a, "Garima", "7854785698", "garima@gmail.com", date, "25, Motinagar", a, "graduate", "IIIT lucknow", "SBI", "SBIN147854785", "Manasa", a, "Bangalore", "PENDING", date, date, "NOT VERIFIED", time, time);
		return onboardeeCompleteInfo;
	}

}
