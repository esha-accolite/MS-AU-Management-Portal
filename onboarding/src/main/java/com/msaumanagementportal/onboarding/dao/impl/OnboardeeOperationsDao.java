package com.msaumanagementportal.onboarding.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.msaumanagementportal.onboarding.dao.IOnboardeeOperationsDao;
import com.msaumanagementportal.onboarding.models.OnboardeeCompleteInfo;
import com.msaumanagementportal.onboarding.queries.OnboardeeOperationsQueries;
import com.msaumanagementportal.onboarding.tableconstants.OnboardeePersonalDetailsTableConstants;
import com.msaumanagementportal.onboarding.tableconstants.OnboardeeStatusInfoTableConstants;

@Repository
public class OnboardeeOperationsDao implements IOnboardeeOperationsDao{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private static Logger logger = LoggerFactory.getLogger(OnboardeeOperationsDao.class);

	@Override
	public Integer addOnboardee(OnboardeeCompleteInfo onboardeeCompleteInfo) {
		Integer key = addOnboardeePersonalDetails(onboardeeCompleteInfo);
		addOnboardeeStatusInfo(onboardeeCompleteInfo, key);
		return key;
	}
	
	private Integer addOnboardeePersonalDetails(OnboardeeCompleteInfo onboardeeCompleteInfo) {
		final KeyHolder holder = new GeneratedKeyHolder();
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		srcMap.addValue(OnboardeePersonalDetailsTableConstants.name, onboardeeCompleteInfo.getName());
		srcMap.addValue(OnboardeePersonalDetailsTableConstants.contact, onboardeeCompleteInfo.getContact());
		srcMap.addValue(OnboardeePersonalDetailsTableConstants.email, onboardeeCompleteInfo.getEmail());
		srcMap.addValue(OnboardeePersonalDetailsTableConstants.dob, onboardeeCompleteInfo.getDob());
		srcMap.addValue(OnboardeePersonalDetailsTableConstants.address, onboardeeCompleteInfo.getAddress());
		srcMap.addValue(OnboardeePersonalDetailsTableConstants.experience, onboardeeCompleteInfo.getExperience());
		srcMap.addValue(OnboardeePersonalDetailsTableConstants.highest_education, onboardeeCompleteInfo.getHighest_education());
		srcMap.addValue(OnboardeePersonalDetailsTableConstants.college_name, onboardeeCompleteInfo.getCollege_name());
		srcMap.addValue(OnboardeePersonalDetailsTableConstants.bank_name, onboardeeCompleteInfo.getBank_name());
		srcMap.addValue(OnboardeePersonalDetailsTableConstants.bank_account_num, onboardeeCompleteInfo.getBank_account_num());
		namedParameterJdbcTemplate.update(OnboardeeOperationsQueries.addOnboardeePersonalDetails_Query, srcMap, holder, new String[] { OnboardeePersonalDetailsTableConstants.id });
		return holder.getKey().intValue();
	}
	
	private void addOnboardeeStatusInfo(OnboardeeCompleteInfo onboardeeCompleteInfo, Integer key) {
		
		Calendar cal = Calendar.getInstance();
		Timestamp create_time = new Timestamp(System.currentTimeMillis());
		cal.setTime(create_time);
		Timestamp completion_time = new Timestamp(System.currentTimeMillis());
		cal.add(Calendar.MONDAY, 6);
		completion_time.setTime(cal.getTime().getTime());
		
		final KeyHolder holder = new GeneratedKeyHolder();
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		srcMap.addValue(OnboardeeStatusInfoTableConstants.id, key);
		srcMap.addValue(OnboardeeStatusInfoTableConstants.hiring_manager, onboardeeCompleteInfo.getHiring_manager());
		srcMap.addValue(OnboardeeStatusInfoTableConstants.demand_id, onboardeeCompleteInfo.getDemand_id());
		srcMap.addValue(OnboardeeStatusInfoTableConstants.location, onboardeeCompleteInfo.getLocation());
		srcMap.addValue(OnboardeeStatusInfoTableConstants.onboarding_status, "PENDING");
		srcMap.addValue(OnboardeeStatusInfoTableConstants.onboarding_start_date, create_time);
		srcMap.addValue(OnboardeeStatusInfoTableConstants.eta_for_completion, completion_time);
		srcMap.addValue(OnboardeeStatusInfoTableConstants.bgc_check_status, "NOT VERIFIED");
		srcMap.addValue(OnboardeeStatusInfoTableConstants.creation_tm, create_time);
		namedParameterJdbcTemplate.update(OnboardeeOperationsQueries.addOnboardeeStatusInfo_Query, srcMap, holder, new String[] { OnboardeeStatusInfoTableConstants.id });
	}
	
//	private MapSqlParameterSource srcmapOnboardeeStatusInfo(MapSqlParameterSource srcMap,OnboardeeCompleteInfo onboardeeCompleteInfo, Integer key) {
//		Calendar cal = Calendar.getInstance();
//		Timestamp create_time = new Timestamp(System.currentTimeMillis());
//		cal.setTime(create_time);
//		Timestamp completion_time = new Timestamp(System.currentTimeMillis());
//		cal.add(Calendar.MONDAY, 6);
//		completion_time.setTime(cal.getTime().getTime());
//		
//		srcMap.addValue(OnboardeeStatusInfoTableConstants.id, key);
//		srcMap.addValue(OnboardeeStatusInfoTableConstants.hiring_manager, onboardeeCompleteInfo.getHiring_manager());
//		srcMap.addValue(OnboardeeStatusInfoTableConstants.demand_id, onboardeeCompleteInfo.getDemand_id());
//		srcMap.addValue(OnboardeeStatusInfoTableConstants.location, onboardeeCompleteInfo.getLocation());
//		srcMap.addValue(OnboardeeStatusInfoTableConstants.onboarding_status, "PENDING");
//		srcMap.addValue(OnboardeeStatusInfoTableConstants.onboarding_start_date, create_time);
//		srcMap.addValue(OnboardeeStatusInfoTableConstants.eta_for_completion, completion_time);
//		srcMap.addValue(OnboardeeStatusInfoTableConstants.bgc_check_status, "NOT VERIFIED");
//		srcMap.addValue(OnboardeeStatusInfoTableConstants.creation_tm, create_time);
//		return srcMap;
//	}

	
	
//	private OnboardeePersonalDetails getOnboardeePersonalDetails(Integer onboardee_id) {
//		MapSqlParameterSource srcMap = new MapSqlParameterSource();
//		srcMap.addValue(OnboardeePersonalDetailsTableConstants.id, onboardee_id);
//		List<OnboardeePersonalDetails> onboardeePersonalDetails =  namedParameterJdbcTemplate.query(OnboardeeOperationsQueries.getOnboardeePersonalDetails_Query, srcMap,(resultSet, rowNum) -> {
//			return mapOnboardeePersonalDetails(resultSet);
//		});
//		return onboardeePersonalDetails.get(0);
//	}
//	
//	private OnboardeeStatusInfo getOnboardeeStatusInfo(Integer onboardee_id) {
//		MapSqlParameterSource srcMap = new MapSqlParameterSource();
//		srcMap.addValue(OnboardeeStatusInfoTableConstants.id, onboardee_id);
//		List<OnboardeeStatusInfo> onboardeeStatusInfo = namedParameterJdbcTemplate.query(OnboardeeOperationsQueries.getOnboardeeStatusInfo_Query, srcMap,(resultSet, rowNum) -> {
//			return mapOnboardeeStatusInfo(resultSet);
//		});
//		return onboardeeStatusInfo.get(0);
//	}
//	
//	private OnboardeePersonalDetails mapOnboardeePersonalDetails(ResultSet resultSet) throws SQLException {
//		OnboardeePersonalDetails onboardeePersonalDetails = new OnboardeePersonalDetails();
//		onboardeePersonalDetails.setName(resultSet.getString(OnboardeePersonalDetailsTableConstants.name));
//		onboardeePersonalDetails.setContact(resultSet.getString(OnboardeePersonalDetailsTableConstants.contact));
//		onboardeePersonalDetails.setEmail(resultSet.getString(OnboardeePersonalDetailsTableConstants.email));
//		onboardeePersonalDetails.setDob(resultSet.getDate(OnboardeePersonalDetailsTableConstants.dob));
//		onboardeePersonalDetails.setAddress(resultSet.getString(OnboardeePersonalDetailsTableConstants.address));
//		onboardeePersonalDetails.setExperience(resultSet.getInt(OnboardeePersonalDetailsTableConstants.experience));
//		onboardeePersonalDetails.setHighest_education(resultSet.getString(OnboardeePersonalDetailsTableConstants.highest_education));
//		onboardeePersonalDetails.setCollege_name(resultSet.getString(OnboardeePersonalDetailsTableConstants.college_name));
//		onboardeePersonalDetails.setBank_name(resultSet.getString(OnboardeePersonalDetailsTableConstants.bank_name));
//		onboardeePersonalDetails.setBank_account_num(resultSet.getString(OnboardeePersonalDetailsTableConstants.bank_account_num));
//		return onboardeePersonalDetails;
//	}
//	
//	private OnboardeeStatusInfo mapOnboardeeStatusInfo(ResultSet resultSet) throws SQLException {
//		OnboardeeStatusInfo onboardeeStatusInfo = new OnboardeeStatusInfo();
//		onboardeeStatusInfo.setDemand_id(resultSet.getInt(OnboardeeStatusInfoTableConstants.demand_id));
//		onboardeeStatusInfo.setHiring_manager(resultSet.getString(OnboardeeStatusInfoTableConstants.hiring_manager));
//		onboardeeStatusInfo.setLocation(resultSet.getString(OnboardeeStatusInfoTableConstants.location));
//		onboardeeStatusInfo.setOnboarding_status(resultSet.getString(OnboardeeStatusInfoTableConstants.onboarding_status));
//		onboardeeStatusInfo.setOnboarding_start_date(resultSet.getDate(OnboardeeStatusInfoTableConstants.onboarding_start_date));
//		onboardeeStatusInfo.setEta_for_completion(resultSet.getDate(OnboardeeStatusInfoTableConstants.eta_for_completion));
//		onboardeeStatusInfo.setBgc_check_status(resultSet.getString(OnboardeeStatusInfoTableConstants.bgc_check_status));
//		onboardeeStatusInfo.setCreation_tm(resultSet.getTimestamp(OnboardeeStatusInfoTableConstants.creation_tm));
//		onboardeeStatusInfo.setModified_tm(resultSet.getTimestamp(OnboardeeStatusInfoTableConstants.modified_tm));
//		return onboardeeStatusInfo;
//	}

	private OnboardeeCompleteInfo mapOnboardeeCompleteInfo(ResultSet resultSet) throws SQLException {
		OnboardeeCompleteInfo onboardeeCompleteInfo = new OnboardeeCompleteInfo();
		onboardeeCompleteInfo.setId(resultSet.getInt(OnboardeePersonalDetailsTableConstants.id));
		onboardeeCompleteInfo.setName(resultSet.getString(OnboardeePersonalDetailsTableConstants.name));
		onboardeeCompleteInfo.setContact(resultSet.getString(OnboardeePersonalDetailsTableConstants.contact));
		onboardeeCompleteInfo.setEmail(resultSet.getString(OnboardeePersonalDetailsTableConstants.email));
		onboardeeCompleteInfo.setDob(resultSet.getDate(OnboardeePersonalDetailsTableConstants.dob));
		onboardeeCompleteInfo.setAddress(resultSet.getString(OnboardeePersonalDetailsTableConstants.address));
		onboardeeCompleteInfo.setExperience(resultSet.getInt(OnboardeePersonalDetailsTableConstants.experience));
		onboardeeCompleteInfo.setHighest_education(resultSet.getString(OnboardeePersonalDetailsTableConstants.highest_education));
		onboardeeCompleteInfo.setCollege_name(resultSet.getString(OnboardeePersonalDetailsTableConstants.college_name));
		onboardeeCompleteInfo.setBank_name(resultSet.getString(OnboardeePersonalDetailsTableConstants.bank_name));
		onboardeeCompleteInfo.setBank_account_num(resultSet.getString(OnboardeePersonalDetailsTableConstants.bank_account_num));
		onboardeeCompleteInfo.setDemand_id(resultSet.getInt(OnboardeeStatusInfoTableConstants.demand_id));
		onboardeeCompleteInfo.setHiring_manager(resultSet.getString(OnboardeeStatusInfoTableConstants.hiring_manager));
		onboardeeCompleteInfo.setLocation(resultSet.getString(OnboardeeStatusInfoTableConstants.location));
		onboardeeCompleteInfo.setOnboarding_status(resultSet.getString(OnboardeeStatusInfoTableConstants.onboarding_status));
		onboardeeCompleteInfo.setOnboarding_start_date(resultSet.getDate(OnboardeeStatusInfoTableConstants.onboarding_start_date));
		onboardeeCompleteInfo.setEta_for_completion(resultSet.getDate(OnboardeeStatusInfoTableConstants.eta_for_completion));
		onboardeeCompleteInfo.setBgc_check_status(resultSet.getString(OnboardeeStatusInfoTableConstants.bgc_check_status));
		onboardeeCompleteInfo.setCreation_tm(resultSet.getTimestamp(OnboardeeStatusInfoTableConstants.creation_tm));
		onboardeeCompleteInfo.setModified_tm(resultSet.getTimestamp(OnboardeeStatusInfoTableConstants.modified_tm));
		return onboardeeCompleteInfo;
	}

	@Override
	public OnboardeeCompleteInfo getOnboardee(Integer onboardee_id) {
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		srcMap.addValue("onboardee_id", onboardee_id);
		List<OnboardeeCompleteInfo> onboardeeCompleteInfo = namedParameterJdbcTemplate.query(OnboardeeOperationsQueries.getOnboardee_Query,srcMap, (resultSet, rowNum) -> {
			return mapOnboardeeCompleteInfo(resultSet);
		});
		return onboardeeCompleteInfo.get(0);
	}
	
	@Override
	public List<OnboardeeCompleteInfo> getAllOnboardee() {
		return namedParameterJdbcTemplate.query(OnboardeeOperationsQueries.getAllOnboardee_Query,(resultSet, rowNum) -> {
			return mapOnboardeeCompleteInfo(resultSet);
		});
	}

	@Override
	public boolean deleteOnboardee(Integer onboardee_id) {
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		srcMap.addValue("onboardee_id", onboardee_id);
		namedParameterJdbcTemplate.update(OnboardeeOperationsQueries.deleteOnboardeePersonalDetails_Query, srcMap);
		namedParameterJdbcTemplate.update(OnboardeeOperationsQueries.deleteOnboardeeStatusInfo_Query, srcMap);
		return true;
	}

	@Override
	public boolean editOnboardee(OnboardeeCompleteInfo onboardeeCompleteInfo) {
		System.out.println(onboardeeCompleteInfo.getDemand_id());
		Integer nonNullEdiableValues = 0;
		String editOnboardeePersonalDetails_Query = "UPDATE " + OnboardeePersonalDetailsTableConstants.TABLE_NAME + " SET "; 
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		if(onboardeeCompleteInfo.getContact() != null) {
			nonNullEdiableValues++;
			editOnboardeePersonalDetails_Query += " " + OnboardeePersonalDetailsTableConstants.contact + "= :" + OnboardeePersonalDetailsTableConstants.contact + " , ";
			srcMap.addValue(OnboardeePersonalDetailsTableConstants.contact, onboardeeCompleteInfo.getContact());
		}
		if(onboardeeCompleteInfo.getEmail() != null) {
			nonNullEdiableValues++;
			editOnboardeePersonalDetails_Query += " " + OnboardeePersonalDetailsTableConstants.email + "= :" + OnboardeePersonalDetailsTableConstants.email + " , ";
			srcMap.addValue(OnboardeePersonalDetailsTableConstants.email, onboardeeCompleteInfo.getEmail());
		}
		if(onboardeeCompleteInfo.getDob() != null) {
			nonNullEdiableValues++;
			editOnboardeePersonalDetails_Query += " " + OnboardeePersonalDetailsTableConstants.dob + "= :" + OnboardeePersonalDetailsTableConstants.dob + " , ";
			srcMap.addValue(OnboardeePersonalDetailsTableConstants.dob, onboardeeCompleteInfo.getDob());
		}
		if(onboardeeCompleteInfo.getAddress() != null) {
			nonNullEdiableValues++;
			editOnboardeePersonalDetails_Query += " " + OnboardeePersonalDetailsTableConstants.address + "= :" + OnboardeePersonalDetailsTableConstants.address + " , ";
			srcMap.addValue(OnboardeePersonalDetailsTableConstants.address, onboardeeCompleteInfo.getAddress());
		}
		if(onboardeeCompleteInfo.getExperience() != null) {
			nonNullEdiableValues++;
			editOnboardeePersonalDetails_Query += " " + OnboardeePersonalDetailsTableConstants.experience + "= :" + OnboardeePersonalDetailsTableConstants.experience + " , ";
			srcMap.addValue(OnboardeePersonalDetailsTableConstants.experience, onboardeeCompleteInfo.getExperience());
		}
		if(onboardeeCompleteInfo.getHighest_education() != null) {
			nonNullEdiableValues++;
			editOnboardeePersonalDetails_Query += " " + OnboardeePersonalDetailsTableConstants.highest_education + "= :" + OnboardeePersonalDetailsTableConstants.highest_education + " , ";
			srcMap.addValue(OnboardeePersonalDetailsTableConstants.highest_education, onboardeeCompleteInfo.getHighest_education());
		}
		if(onboardeeCompleteInfo.getCollege_name() != null) {
			nonNullEdiableValues++;
			editOnboardeePersonalDetails_Query += " " + OnboardeePersonalDetailsTableConstants.college_name + "= :" + OnboardeePersonalDetailsTableConstants.college_name + " , ";
			srcMap.addValue(OnboardeePersonalDetailsTableConstants.college_name, onboardeeCompleteInfo.getCollege_name());
		}
		if(onboardeeCompleteInfo.getBank_name() != null) {
			nonNullEdiableValues++;
			editOnboardeePersonalDetails_Query += " " + OnboardeePersonalDetailsTableConstants.bank_name + "= :" + OnboardeePersonalDetailsTableConstants.bank_name + " , ";
			srcMap.addValue(OnboardeePersonalDetailsTableConstants.bank_name, onboardeeCompleteInfo.getBank_name());
		}
		if(onboardeeCompleteInfo.getBank_account_num() != null) {
			nonNullEdiableValues++;
			editOnboardeePersonalDetails_Query += " " + OnboardeePersonalDetailsTableConstants.bank_account_num + "= :" + OnboardeePersonalDetailsTableConstants.bank_account_num + " , ";
			srcMap.addValue(OnboardeePersonalDetailsTableConstants.bank_account_num, onboardeeCompleteInfo.getBank_account_num());
		}
		System.out.println(nonNullEdiableValues);
		if(nonNullEdiableValues>0)
		{
			editOnboardeePersonalDetails_Query = editOnboardeePersonalDetails_Query.substring(0, editOnboardeePersonalDetails_Query.length() - 2);
			editOnboardeePersonalDetails_Query += " WHERE " + OnboardeePersonalDetailsTableConstants.id + " = " + onboardeeCompleteInfo.getId(); 
			logger.info(editOnboardeePersonalDetails_Query);
			namedParameterJdbcTemplate.update(editOnboardeePersonalDetails_Query, srcMap);
		}
		nonNullEdiableValues=0;
		
		String editOnboardeeStatusInfo_Query = "UPDATE " + OnboardeeStatusInfoTableConstants.TABLE_NAME + " SET ";
		
		if(onboardeeCompleteInfo.getLocation() != null) {
			nonNullEdiableValues++;
			editOnboardeeStatusInfo_Query += " " + OnboardeeStatusInfoTableConstants.location + "= :" + OnboardeeStatusInfoTableConstants.location + " , ";
			srcMap.addValue(OnboardeeStatusInfoTableConstants.location, onboardeeCompleteInfo.getLocation());
		}
		if(onboardeeCompleteInfo.getOnboarding_status() != null) {
			nonNullEdiableValues++;
			editOnboardeeStatusInfo_Query += " " + OnboardeeStatusInfoTableConstants.onboarding_status + "= :" + OnboardeeStatusInfoTableConstants.onboarding_status + " , ";
			srcMap.addValue(OnboardeeStatusInfoTableConstants.onboarding_status, onboardeeCompleteInfo.getOnboarding_status());
		}
		if(onboardeeCompleteInfo.getEta_for_completion() != null) {
			nonNullEdiableValues++;
			editOnboardeeStatusInfo_Query += " " + OnboardeeStatusInfoTableConstants.eta_for_completion + "= :" + OnboardeeStatusInfoTableConstants.eta_for_completion + " , ";
			srcMap.addValue(OnboardeeStatusInfoTableConstants.eta_for_completion, onboardeeCompleteInfo.getEta_for_completion());
		}
		if(onboardeeCompleteInfo.getBgc_check_status() != null) {
			nonNullEdiableValues++;
			editOnboardeeStatusInfo_Query += " " + OnboardeeStatusInfoTableConstants.bgc_check_status + "= :" + OnboardeeStatusInfoTableConstants.bgc_check_status + " , ";
			srcMap.addValue(OnboardeeStatusInfoTableConstants.bgc_check_status, onboardeeCompleteInfo.getBgc_check_status());
		}
		System.out.println(nonNullEdiableValues);
		if(nonNullEdiableValues>0)
		{
			editOnboardeeStatusInfo_Query = editOnboardeeStatusInfo_Query.substring(0, editOnboardeeStatusInfo_Query.length() - 2);
			editOnboardeeStatusInfo_Query += " WHERE " + OnboardeeStatusInfoTableConstants.id + " = " + onboardeeCompleteInfo.getId(); 
			logger.info(editOnboardeeStatusInfo_Query);
			namedParameterJdbcTemplate.update(editOnboardeeStatusInfo_Query, srcMap);
		}
		
		return true;
	}

}
