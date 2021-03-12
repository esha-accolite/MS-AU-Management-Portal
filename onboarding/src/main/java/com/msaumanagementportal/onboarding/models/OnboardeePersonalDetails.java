package com.msaumanagementportal.onboarding.models;

import java.sql.Date;

public class OnboardeePersonalDetails {
	
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
	
	public OnboardeePersonalDetails() {
		
	}

	public OnboardeePersonalDetails(Integer id, String name, String contact, String email, Date dob, String hometown,
			String address, Integer experience, String highest_education, String college_name, String bank_name,
			String bank_account_num) {
		super();
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

}
