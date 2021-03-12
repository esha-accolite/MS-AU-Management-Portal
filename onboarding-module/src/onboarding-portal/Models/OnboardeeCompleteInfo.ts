import { Timestamp } from "rxjs";

export interface OnboardeeCompleteInfo{
    "id": Number,
    "name": String,
    "contact": String,
    "email": String,
    "dob": Date,
    "address": String,
    "experience": Number,
    "highest_education": String,
    "college_name": String,
    "bank_name": String,
    "bank_account_num": String,
    "hiring_manager": String,
    "demand_id": Number,
    "location": String,
    "onboarding_status": String,
    "onboarding_start_date": Date,
    "eta_for_completion": Date,
    "bgc_check_status": String,
    "creation_tm": Timestamp<0>,
    "modified_tm": Timestamp<0>
}