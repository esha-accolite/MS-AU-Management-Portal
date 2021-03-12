package com.msaumanagementportal.onboarding;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.msaumanagementportal.onboarding.dao.impl.OnboardeeOperationsDao;
import com.msaumanagementportal.onboarding.models.OnboardeeCompleteInfo;
import com.msaumanagementportal.onboarding.services.impl.OnboardeeOperationsService;

@SpringBootTest
class OnboardingApplicationTests {

	@Mock
	OnboardeeOperationsDao onboardeeOperationsDao;
	
	@InjectMocks
	OnboardeeOperationsService onboardeeOperationsService;
	
	@Test
	public void addOnboardeetest() {
		OnboardeeCompleteInfo onboardeeCompleteInfo = getMockedObject();
		Mockito.when(onboardeeOperationsDao.addOnboardee(Mockito.any())).thenReturn(onboardeeCompleteInfo.getId());
		System.out.println(onboardeeCompleteInfo.getId());
		Integer output = onboardeeOperationsService.addOnboardee(onboardeeCompleteInfo);
		assertEquals(7, output);
	}
	
	@Test
	public void deleteOnboardeetest() {
		OnboardeeCompleteInfo onboardeeCompleteInfo = getMockedObject();
		Mockito.when(onboardeeOperationsDao.deleteOnboardee(onboardeeCompleteInfo.getId())).thenReturn(true);
		Boolean output = onboardeeOperationsService.deleteOnboardee(onboardeeCompleteInfo.getId());
		assertEquals(true, output);
	}
	
	@Test
	public void getAllOnboardeetest() {
		List<OnboardeeCompleteInfo> onboardeeCompleteInfoList = new ArrayList<OnboardeeCompleteInfo>();
		OnboardeeCompleteInfo onboardeeCompleteInfo = getMockedObject();
		onboardeeCompleteInfoList.add(onboardeeCompleteInfo);
		Mockito.when(onboardeeOperationsDao.getAllOnboardee()).thenReturn(onboardeeCompleteInfoList);
		List<OnboardeeCompleteInfo> output = onboardeeOperationsService.getAllOnboardee();
		assertNotNull(output);
	}
	
	@Test
	public void editOnboardeetest() {
		OnboardeeCompleteInfo onboardeeCompleteInfo = getMockedObject();
		Mockito.when(onboardeeOperationsDao.editOnboardee(Mockito.any())).thenReturn(true);
		Boolean output = onboardeeOperationsService.editOnboardee(onboardeeCompleteInfo);
		assertEquals(true,output);
	}
	
	public OnboardeeCompleteInfo getMockedObject() {
		Integer a = 7;
		@SuppressWarnings("deprecation")
		Date date = new Date(99,2,1);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		OnboardeeCompleteInfo onboardeeCompleteInfo = new OnboardeeCompleteInfo(a, "Garima", "7854785698", "garima@gmail.com", date, "25, Motinagar", a, "graduate", "IIIT lucknow", "SBI", "SBIN147854785", "Manasa", a, "Bangaore", "PENDING", date, date, "NOT VERIFIED", time, time);
		return onboardeeCompleteInfo;
	}

}
