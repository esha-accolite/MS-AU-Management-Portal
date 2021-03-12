package com.msaumanagementportal.onboarding.models;

import java.sql.Date;
import java.sql.Timestamp;

public class OnboardeeCompleteInfo {
	
	private Integer id;
	
	private String name;
	
	private String contact;
	
	private String email;
	
	private Date dob;
	
	private String address;
	
	private Integer experience;
	
	private String highest_education;
	
	private String college_name;
	
	private String bank_name;
	
	private String bank_account_num;
	
	private String hiring_manager;
	
	private Integer demand_id;
	
	private String location;
	
	private String onboarding_status;
	
	private Date onboarding_start_date;
	
	private Date eta_for_completion;
	
	private String bgc_check_status;
	
	private Timestamp creation_tm;
	
	private Timestamp modified_tm;
	
	public OnboardeeCompleteInfo() {
		
	}

	public OnboardeeCompleteInfo(Integer id, String name, String contact, String email, Date dob,
			String address, Integer experience, String highest_education, String college_name, String bank_name,
			String bank_account_num, String hiring_manager, Integer demand_id, String location, String onboarding_status,
			Date onboarding_start_date, Date eta_for_completion, String bgc_check_status, Timestamp creation_tm,
			Timestamp modified_tm) {
//		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.experience = experience;
		this.highest_education = highest_education;
		this.college_name = college_name;
		this.bank_name = bank_name;
		this.bank_account_num = bank_account_num;
		this.hiring_manager = hiring_manager;
		this.demand_id = demand_id;
		this.location = location;
		this.onboarding_status = onboarding_status;
		this.onboarding_start_date = onboarding_start_date;
		this.eta_for_completion = eta_for_completion;
		this.bgc_check_status = bgc_check_status;
		this.creation_tm = creation_tm;
		this.modified_tm = modified_tm;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getHighest_education() {
		return highest_education;
	}

	public void setHighest_education(String highest_education) {
		this.highest_education = highest_education;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBank_account_num() {
		return bank_account_num;
	}

	public void setBank_account_num(String bank_account_num) {
		this.bank_account_num = bank_account_num;
	}

	public Integer getDemand_id() {
		return demand_id;
	}

	public void setDemand_id(Integer demand_id) {
		this.demand_id = demand_id;
	}

	public String getHiring_manager() {
		return hiring_manager;
	}

	public void setHiring_manager(String hiring_manager) {
		this.hiring_manager = hiring_manager;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOnboarding_status() {
		return onboarding_status;
	}

	public void setOnboarding_status(String onboarding_status) {
		this.onboarding_status = onboarding_status;
	}

	public Date getOnboarding_start_date() {
		return onboarding_start_date;
	}

	public void setOnboarding_start_date(Date onboarding_start_date) {
		this.onboarding_start_date = onboarding_start_date;
	}

	public Date getEta_for_completion() {
		return eta_for_completion;
	}

	public void setEta_for_completion(Date eta_for_completion) {
		this.eta_for_completion = eta_for_completion;
	}

	public String getBgc_check_status() {
		return bgc_check_status;
	}

	public void setBgc_check_status(String bgc_check_status) {
		this.bgc_check_status = bgc_check_status;
	}

	public Timestamp getCreation_tm() {
		return creation_tm;
	}

	public void setCreation_tm(Timestamp creation_tm) {
		this.creation_tm = creation_tm;
	}

	public Timestamp getModified_tm() {
		return modified_tm;
	}

	public void setModified_tm(Timestamp modified_tm) {
		this.modified_tm = modified_tm;
	}

}
