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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.msaumanagementportal.onboarding.dao.impl.OnboardeeOperationsDao;
import com.msaumanagementportal.onboarding.models.OnboardeeCompleteInfo;
import com.msaumanagementportal.onboarding.models.OnboardeePersonalDetails;
import com.msaumanagementportal.onboarding.models.OnboardeeStatusInfo;
import com.msaumanagementportal.onboarding.services.impl.OnboardeeOperationsService;

@SpringBootTest
class OnboardingApplicationTests {

	@Mock
	OnboardeeOperationsDao onboardeeOperationsDao;
	
	@InjectMocks
	OnboardeeOperationsService onboardeeOperationsService;
	
	@Autowired
	OnboardeeOperationsDao onboardeeOperationsDao1;
	
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
		Mockito.when(onboardeeOperationsDao.deleteOnboardee(onboardeeCompleteInfo.getId())).thenReturn(onboardeeCompleteInfo.getId());
		Integer output = onboardeeOperationsService.deleteOnboardee(onboardeeCompleteInfo.getId());
		assertEquals(7, output);
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
	
	@Test
	public void getOnboardeetest() {
		OnboardeeCompleteInfo onboardeeCompleteInfo = getMockedObject();
		Mockito.when(onboardeeOperationsDao.getOnboardee(Mockito.any())).thenReturn(onboardeeCompleteInfo);
		OnboardeeCompleteInfo output = onboardeeOperationsService.getOnboardee(onboardeeCompleteInfo.getId());
		assertEquals(onboardeeCompleteInfo.getId(),output.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testAddOnboardee() {
		OnboardeeCompleteInfo onboardeeCompleteInfo = getMockedObject();
		onboardeeOperationsDao1.addOnboardee(onboardeeCompleteInfo);
		List<OnboardeeCompleteInfo> onboardeeCompleteInfoList = onboardeeOperationsDao1.getAllOnboardee();
		Integer size = onboardeeCompleteInfoList.size();
		assertEquals(onboardeeCompleteInfo.getName(), onboardeeCompleteInfoList.get(size-1).getName());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testEditOnboardee() {
		OnboardeeCompleteInfo onboardeeCompleteInfo = getMockedObject();
		onboardeeOperationsDao1.addOnboardee(onboardeeCompleteInfo);
		onboardeeCompleteInfo.setLocation("Mumbai");
		onboardeeOperationsDao1.editOnboardee(onboardeeCompleteInfo);
		List<OnboardeeCompleteInfo> onboardeeCompleteInfoList = onboardeeOperationsDao1.getAllOnboardee();
		String changed_location="";
		for(OnboardeeCompleteInfo item : onboardeeCompleteInfoList) {
			if(item.getId()==onboardeeCompleteInfo.getId())
				changed_location = item.getLocation();
		}
		assertEquals("Mumbai", changed_location);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testViewOnboardee() {
		OnboardeeCompleteInfo onboardeeCompleteInfo = getMockedObject();
		onboardeeOperationsDao1.addOnboardee(onboardeeCompleteInfo);
		OnboardeeCompleteInfo viewed_onboardeeCompleteInfo = onboardeeOperationsDao1.getOnboardee(onboardeeCompleteInfo.getId());
		assertEquals(onboardeeCompleteInfo.getId(), viewed_onboardeeCompleteInfo.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteOnboardee() {
		OnboardeeCompleteInfo onboardeeCompleteInfo = getMockedObject();
		onboardeeOperationsDao1.addOnboardee(onboardeeCompleteInfo);
		Integer deleted_id = onboardeeOperationsDao1.deleteOnboardee(onboardeeCompleteInfo.getId());
		assertEquals(onboardeeCompleteInfo.getId(), deleted_id);
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

	@Test
	public void getMockedObjectPersonalDetails() {
		Integer a = 7;
		@SuppressWarnings("deprecation")
		Date date = new Date(99,2,1);
		OnboardeePersonalDetails onboardeePersonalDetails = new OnboardeePersonalDetails(a, "Garima", "7854785698", "garima@gmail.com", date, "25, Motinagar", a, "graduate", "IIIT lucknow", "SBI", "SBIN147854785");
		assertEquals(7, onboardeePersonalDetails.getId());;
	}
	
	@Test
	public void getMockedObjectStatusInfo() {
		Integer a = 7;
		@SuppressWarnings("deprecation")
		Date date = new Date(99,2,1);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		OnboardeeStatusInfo onboardeeStatusInfo  = new OnboardeeStatusInfo(a, "Manasa", a, "Bangalore", "PENDING", date, date, "NOT VERIFIED", time, time);
		assertEquals(7, onboardeeStatusInfo.getId());;
	}
}
