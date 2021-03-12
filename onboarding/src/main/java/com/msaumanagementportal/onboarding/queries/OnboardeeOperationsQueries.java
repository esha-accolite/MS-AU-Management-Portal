package com.msaumanagementportal.onboarding.queries;

import com.msaumanagementportal.onboarding.tableconstants.OnboardeePersonalDetailsTableConstants;
import com.msaumanagementportal.onboarding.tableconstants.OnboardeeStatusInfoTableConstants;

public class OnboardeeOperationsQueries {
	
	public static final String addOnboardeePersonalDetails_Query = "INSERT INTO " + OnboardeePersonalDetailsTableConstants.TABLE_NAME 
			+ "(" + OnboardeePersonalDetailsTableConstants.name + ", " + OnboardeePersonalDetailsTableConstants.contact + ", "
		    + OnboardeePersonalDetailsTableConstants.email + ", " + OnboardeePersonalDetailsTableConstants.dob + ", " 
			+ OnboardeePersonalDetailsTableConstants.address + ", " + OnboardeePersonalDetailsTableConstants.experience + ", " 
		    + OnboardeePersonalDetailsTableConstants.highest_education + ", " + OnboardeePersonalDetailsTableConstants.college_name + ", " 
			+ OnboardeePersonalDetailsTableConstants.bank_name + ", " + OnboardeePersonalDetailsTableConstants.bank_account_num + " )"
			+ " VALUES ( :" + OnboardeePersonalDetailsTableConstants.name + " , :" + OnboardeePersonalDetailsTableConstants.contact + " , :"
			+ OnboardeePersonalDetailsTableConstants.email + ", :" + OnboardeePersonalDetailsTableConstants.dob + ", :" 
			+ OnboardeePersonalDetailsTableConstants.address + ", :" + OnboardeePersonalDetailsTableConstants.experience + ", :" 
		    + OnboardeePersonalDetailsTableConstants.highest_education + ", :" + OnboardeePersonalDetailsTableConstants.college_name + ", :" 
			+ OnboardeePersonalDetailsTableConstants.bank_name + ", :" + OnboardeePersonalDetailsTableConstants.bank_account_num + " )";

	public static final String addOnboardeeStatusInfo_Query = "INSERT INTO " + OnboardeeStatusInfoTableConstants.TABLE_NAME 
			+ "(" + OnboardeeStatusInfoTableConstants.id + ", " + OnboardeeStatusInfoTableConstants.hiring_manager + ", "
		    + OnboardeeStatusInfoTableConstants.demand_id + ", " + OnboardeeStatusInfoTableConstants.location + ", " 
			+ OnboardeeStatusInfoTableConstants.onboarding_status + ", " + OnboardeeStatusInfoTableConstants.onboarding_start_date + ", " 
		    + OnboardeeStatusInfoTableConstants.eta_for_completion + ", " + OnboardeeStatusInfoTableConstants.bgc_check_status + ", " 
			+ OnboardeeStatusInfoTableConstants.creation_tm + " )"
			+ " VALUES ( :" + OnboardeeStatusInfoTableConstants.id + " , :" + OnboardeeStatusInfoTableConstants.hiring_manager + " , :"
			+ OnboardeeStatusInfoTableConstants.demand_id + ", :" + OnboardeeStatusInfoTableConstants.location + ", :" 
			+ OnboardeeStatusInfoTableConstants.onboarding_status + ", :" + OnboardeeStatusInfoTableConstants.onboarding_start_date + ", :" 
		    + OnboardeeStatusInfoTableConstants.eta_for_completion + ", :" + OnboardeeStatusInfoTableConstants.bgc_check_status + ", :" 
			+ OnboardeeStatusInfoTableConstants.creation_tm + " )";
	
	public static final String getAllOnboardee_Query = "SELECT * FROM " + OnboardeePersonalDetailsTableConstants.TABLE_NAME + " AS personalDetails LEFT JOIN " 
	        + OnboardeeStatusInfoTableConstants.TABLE_NAME + " AS statusInfo ON personalDetails." + OnboardeePersonalDetailsTableConstants.id 
	        + " = statusInfo." + OnboardeeStatusInfoTableConstants.id;
	
	public static final String getOnboardee_Query = "SELECT * FROM " + OnboardeePersonalDetailsTableConstants.TABLE_NAME + " AS personalDetails LEFT JOIN " 
	        + OnboardeeStatusInfoTableConstants.TABLE_NAME + " AS statusInfo ON personalDetails." + OnboardeePersonalDetailsTableConstants.id 
	        + " = statusInfo." + OnboardeeStatusInfoTableConstants.id + " WHERE personalDetails." + OnboardeePersonalDetailsTableConstants.id 
	        + " = " + ":onboardee_id";
	
	public static final String deleteOnboardeePersonalDetails_Query = "DELETE FROM " + OnboardeePersonalDetailsTableConstants.TABLE_NAME + " WHERE " + OnboardeePersonalDetailsTableConstants.id
			+ " = :onboardee_id";
	
	public static final String deleteOnboardeeStatusInfo_Query = "DELETE FROM " + OnboardeeStatusInfoTableConstants.TABLE_NAME + " WHERE " + OnboardeeStatusInfoTableConstants.id
			+ " = :onboardee_id";
	
}
