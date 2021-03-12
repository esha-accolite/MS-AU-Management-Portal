package com.msaumanagementportal.onboarding.models;

import java.sql.Date;
import java.sql.Timestamp;

public class OnboardeeStatusInfo {
	
	private Integer id;
	
	private String hiring_manager;
	
	private Integer demand_id;
	
	private String location;
	
	private String onboarding_status;
	
	private Date onboarding_start_date;
	
	private Date eta_for_completion;
	
	private String bgc_check_status;
	
	private Timestamp creation_tm;
	
	private Timestamp modified_tm;

	public OnboardeeStatusInfo() {
		
	}

	public OnboardeeStatusInfo(Integer id, String hiring_manager, Integer demand_id, String location, String onboarding_status,
			Date onboarding_start_date, Date eta_for_completion, String bgc_check_status, Timestamp creation_tm,
			Timestamp modified_tm) {
		super();
		this.id = id;
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

	public String getHiring_manager() {
		return hiring_manager;
	}

	public void setHiring_manager(String hiring_manager) {
		this.hiring_manager = hiring_manager;
	}

	public Integer getDemand_id() {
		return demand_id;
	}

	public void setDemand_id(Integer demand_id) {
		this.demand_id = demand_id;
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
