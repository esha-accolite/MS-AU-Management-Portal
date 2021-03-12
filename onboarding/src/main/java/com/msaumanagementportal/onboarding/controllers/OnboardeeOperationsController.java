package com.msaumanagementportal.onboarding.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.msaumanagementportal.onboarding.models.OnboardeeCompleteInfo;
import com.msaumanagementportal.onboarding.services.IOnboardeeOperationsService;

@RestController
@RequestMapping("onboardee")
public class OnboardeeOperationsController {
	
	@Autowired
	IOnboardeeOperationsService iOnboardeeOperationsService;
	
	@PostMapping("/addOnboardee")
//	@CrossOrigin(origins = "http://localhost:4200")
	public Integer addOnboardee(@RequestBody OnboardeeCompleteInfo onboardeeCompleteInfo){
		return iOnboardeeOperationsService.addOnboardee(onboardeeCompleteInfo);
	}
	
	@GetMapping("/getOnboardee/{onboardee_id}")
//	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public OnboardeeCompleteInfo getOnboardee(@PathVariable Integer onboardee_id) {
		return iOnboardeeOperationsService.getOnboardee(onboardee_id);
	}
	
	@GetMapping("/getAllOnboardee")
//	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public List<OnboardeeCompleteInfo> getAllOnboardee() {
		return iOnboardeeOperationsService.getAllOnboardee();
	}
	
	@DeleteMapping("/delete/{onboardee_id}")
//	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public Integer deleteOnboardee(@PathVariable Integer onboardee_id) {
		return iOnboardeeOperationsService.deleteOnboardee(onboardee_id);
	}
	
	@PutMapping("/edit")
//	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public boolean editOnboardee(@RequestBody OnboardeeCompleteInfo onboardeeCompleteInfo) {
		return iOnboardeeOperationsService.editOnboardee(onboardeeCompleteInfo);
	}

}
