import { Component, OnInit,NgModule } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { OnboardeeCompleteInfo } from '../../Models/OnboardeeCompleteInfo';
import { OnboardeeService } from '../../services/onboardee.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
 
import { Location } from '@angular/common';

@Component({
  selector: 'app-edit-onboardee',
  templateUrl: './edit-onboardee.component.html',
  styleUrls: ['./edit-onboardee.component.css']
})
export class EditOnboardeeComponent implements OnInit {

  sub:any;
  id:Number = 0;
  item!: OnboardeeCompleteInfo;
  editableOnboardee !: any;
  showEditForm !: HTMLElement | null;
  onboardeeForm!: FormGroup;
  editOnboardeePayload!: OnboardeeCompleteInfo;

  constructor(private OnboardeeService: OnboardeeService, private router: Router, private activatedroute:ActivatedRoute, private location:Location) { }

  ngOnInit(): void {
    // this.showEditForm = document.getElementById("edit");
    // console.log(this.showEditForm);
      console.log(this.location.getState());
      this.editableOnboardee = this.location.getState();
      console.log(this.editableOnboardee);
      this.id = this.editableOnboardee.id

      this.onboardeeForm = new FormGroup({
        name: new FormControl(this.editableOnboardee.name, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
        contact: new FormControl(this.editableOnboardee.contact, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
        email: new FormControl(this.editableOnboardee.email, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
        dob: new FormControl(this.editableOnboardee.dob, (Validators.required)),
        address: new FormControl(this.editableOnboardee.address, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
        experience: new FormControl(this.editableOnboardee.experience, (Validators.required)),
        highest_education: new FormControl(this.editableOnboardee.highest_education, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
        college_name: new FormControl(this.editableOnboardee.college_name, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
        bank_name: new FormControl(this.editableOnboardee.bank_name, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
        bank_account_num: new FormControl(this.editableOnboardee.bank_account_num, (Validators.required)),
        hiring_manager: new FormControl(this.editableOnboardee.hiring_manager, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
        demand_id: new FormControl(this.editableOnboardee.demand_id, (Validators.required)),
        location: new FormControl(this.editableOnboardee.location, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
        onboarding_start_date: new FormControl(this.editableOnboardee.onboarding_start_date, (Validators.required)),
        onboarding_status: new FormControl(this.editableOnboardee.onboarding_status, (Validators.required)),
        eta_for_completion: new FormControl(this.editableOnboardee.eta_for_completion, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
        bgc_check_status: new FormControl(this.editableOnboardee.bgc_check_status, (Validators.required)),
      });
  }

  // updateWord($event: any): void {
  //   console.log($event);
  //   this.wordService.updateWord($event).subscribe(resp => {
  //     console.log(resp);
  //     if (this.showEditForm != null) {
  //       this.showEditForm.style.display = "none";
  //     }
  //     window.location.reload();
  //   });
  // }

  editOnboardee(): void {
    this.editOnboardeePayload = this.onboardeeForm.value;
    this.editOnboardeePayload.id = this.id;
    console.log(this.editOnboardeePayload);
    this.OnboardeeService.editOnboardee(this.editOnboardeePayload).subscribe(resp => {
      console.log(resp);
    });
  }
}
