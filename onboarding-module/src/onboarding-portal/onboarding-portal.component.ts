import { Component, OnInit } from '@angular/core';
import { OnboardeeCompleteInfo } from './Models/OnboardeeCompleteInfo';
import { OnboardeeService } from './services/onboardee.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-onboarding-portal',
  templateUrl: './onboarding-portal.component.html',
  styleUrls: ['./onboarding-portal.component.css']
})
export class OnboardingPortalComponent implements OnInit {
  onboardeeSearchForm!: FormGroup;
  searchOnboardeePayload!: OnboardeeCompleteInfo;

  searchObject={
    search_parameter: "",
    keyword:""
  }

  onboardees: Array<OnboardeeCompleteInfo> = [];

  constructor(private OnboardeeService: OnboardeeService) { }

  ngOnInit(): void {
    this.OnboardeeService.getAllOnboardee().subscribe(resp => {
      console.log(resp);
      this.onboardees = resp;
      // console.log(this.onboardees);
      // this.OnboardeeService.onboardeeList = resp;
      // this.OnboardeeService.setOnboardeeList(this.onboardees);
    })
    // console.log(this.onboardees);
    

    // this.onboardeeSearchForm = new FormGroup({
    //   name: new FormControl(null, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
    //   experience: new FormControl(null, (Validators.required)),
    //   hiring_manager: new FormControl(null, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
    //   demand_id: new FormControl(null, (Validators.required)),
    //   location: new FormControl(null, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
    //   onboarding_start_date: new FormControl(null, (Validators.required)),
    // });
    this.onboardeeSearchForm = new FormGroup({
      search_parameter: new FormControl(null, (Validators.required)),
      keyword: new FormControl(null, (Validators.required)),
    });


    
  }

  deleteOnboardee(onboardeeCompleteInfo: OnboardeeCompleteInfo): void {
    console.log("delete", onboardeeCompleteInfo);
    this.OnboardeeService.deleteOnboardee(onboardeeCompleteInfo.id).subscribe(resp => {
      console.log(resp);
      if (resp) {
        this.onboardees = this.onboardees.filter(oldOnboardeeCompleteInfo => {
          onboardeeCompleteInfo.id != oldOnboardeeCompleteInfo.id;
        })
      }
      window.location.reload();

    });
  }

  searchOnboardee(): void {
    this.searchObject = this.onboardeeSearchForm.value;
    console.log(this.searchObject.search_parameter=="Name");
      if (this.onboardees.length) {
        if(this.searchObject.search_parameter==""){
          this.ngOnInit();
        }
        if(this.searchObject.search_parameter=="Name")
        {
          this.onboardees = this.onboardees.filter(entry => {
            return this.searchObject.keyword == entry.name;
          })
          console.log(this.onboardees)
        }
          if(this.searchObject.search_parameter=="Location")
          {
            this.onboardees = this.onboardees.filter(entry => {
              return this.searchObject.keyword == entry.location;
          })}
          if(this.searchObject.search_parameter=="Onboarding Status")
          {
            this.onboardees = this.onboardees.filter(entry => {
              return this.searchObject.keyword == entry.onboarding_status;
          })}
          if(this.searchObject.search_parameter=="BGC Verification Status")
          {
            this.onboardees = this.onboardees.filter(entry => {
              return this.searchObject.keyword == entry.bgc_check_status;
          })}
          if(this.searchObject.search_parameter=="Demand ID")
          {this.onboardees = this.onboardees.filter(entry => {
             return Number(this.searchObject.keyword) == entry.demand_id;
          })}
          console.log(this.onboardees);
    };
  }

}
