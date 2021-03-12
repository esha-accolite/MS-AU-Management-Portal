package com.msaumanagementportal.onboarding.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msaumanagementportal.onboarding.dao.IOnboardeeOperationsDao;
import com.msaumanagementportal.onboarding.models.OnboardeeCompleteInfo;
import com.msaumanagementportal.onboarding.services.IOnboardeeOperationsService;

@Service
public class OnboardeeOperationsService implements IOnboardeeOperationsService{
	
	@Autowired
	IOnboardeeOperationsDao iOnboardeeOperationsDao;

	@Override
	public Integer addOnboardee(OnboardeeCompleteInfo onboardeeCompleteInfo) {
		return iOnboardeeOperationsDao.addOnboardee(onboardeeCompleteInfo);
	}

	@Override
	public OnboardeeCompleteInfo getOnboardee(Integer onboardee_id) {
		return iOnboardeeOperationsDao.getOnboardee(onboardee_id);
	}

	@Override
	public List<OnboardeeCompleteInfo> getAllOnboardee() {
		return iOnboardeeOperationsDao.getAllOnboardee();
	}

	@Override
	public boolean deleteOnboardee(Integer onboardee_id) {
		return iOnboardeeOperationsDao.deleteOnboardee(onboardee_id);
	}

	@Override
	public boolean editOnboardee(OnboardeeCompleteInfo onboardeeCompleteInfo) {
		return iOnboardeeOperationsDao.editOnboardee(onboardeeCompleteInfo);
	}

}
