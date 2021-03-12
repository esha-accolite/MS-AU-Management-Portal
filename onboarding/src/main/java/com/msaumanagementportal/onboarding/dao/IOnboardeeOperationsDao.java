package com.msaumanagementportal.onboarding.dao;

import java.util.List;

import com.msaumanagementportal.onboarding.models.OnboardeeCompleteInfo;

public interface IOnboardeeOperationsDao {
	
	public Integer addOnboardee(OnboardeeCompleteInfo onboardeeCompleteInfo);
	
	public OnboardeeCompleteInfo getOnboardee(Integer onboardee_id);
	
	public List<OnboardeeCompleteInfo> getAllOnboardee();

	public Integer deleteOnboardee(Integer onboardee_id);
	
	public boolean editOnboardee(OnboardeeCompleteInfo onboardeeCompleteInfo);
	
}
