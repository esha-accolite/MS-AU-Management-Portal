package com.msaumanagementportal.onboarding.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.msaumanagementportal.onboarding.models.OnboardeeCompleteInfo;

public interface IOnboardeeOperationsService {
	
	public Integer addOnboardee(OnboardeeCompleteInfo onboardeeCompleteInfo);
	
	public OnboardeeCompleteInfo getOnboardee(Integer onboardee_id);
	
	public List<OnboardeeCompleteInfo> getAllOnboardee();
	
	public boolean deleteOnboardee(Integer onboardee_id);
	
	public boolean editOnboardee(OnboardeeCompleteInfo onboardeeCompleteInfo);

}
