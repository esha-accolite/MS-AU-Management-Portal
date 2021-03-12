import { Component, OnInit, OnChanges, Output, EventEmitter, Input } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { OnboardeeCompleteInfo } from '../../Models/OnboardeeCompleteInfo';
import { OnboardeeService } from '../../services/onboardee.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-new-onboardee',
  templateUrl: './new-onboardee.component.html',
  styleUrls: ['./new-onboardee.component.css']
})
export class NewOnboardeeComponent implements OnInit {
  // @Input('action') buttonLabel !: String;
  // @Output() searchOnboardee = new EventEmitter<any>();

  onboardeeForm!: FormGroup;
  addOnboardeePayload!: OnboardeeCompleteInfo;
  id !: Number;
  

  constructor(private OnboardeeService: OnboardeeService, private router: Router) { }

  ngOnInit(): void {
    // if(!this.buttonLabel){
    //   this.buttonLabel = "Add";
    // }
    this.onboardeeForm = new FormGroup({
      name: new FormControl(null, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
      contact: new FormControl(null, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
      email: new FormControl(null, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
      dob: new FormControl(null, (Validators.required)),
      address: new FormControl(null, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
      experience: new FormControl(null, (Validators.required)),
      highest_education: new FormControl(null, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
      college_name: new FormControl(null, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
      bank_name: new FormControl(null, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
      bank_account_num: new FormControl(null, (Validators.required)),
      hiring_manager: new FormControl(null, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
      demand_id: new FormControl(null, (Validators.required)),
      location: new FormControl(null, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
      onboarding_start_date: new FormControl(null, (Validators.required)),
    });
  }

  // addOrSearchOnboardee(): void {
  //   this.addOnboardeePayload = this.onboardeeForm.value;
  //   console.log(this.addOnboardeePayload);
  //   if (this.buttonLabel.includes("Search")) {
  //     this.searchOnboardee.emit({
  //       ...this.onboardeeForm.value,
  //       id: this.id,
  //     })
  //     //   this.OnboardeeService.searchOnboardee(this.addOnboardeePayload).subscribe(resp => {
  //     //   console.log(resp);
  //     // });  
  //   } else {
  //   this.OnboardeeService.addOnboardee(this.addOnboardeePayload).subscribe(resp => {
  //     console.log(resp);
  //   });
  // }
  // // }

  addOnboardee(): void {
    this.addOnboardeePayload = this.onboardeeForm.value;
    console.log(this.addOnboardeePayload);
    this.OnboardeeService.addOnboardee(this.addOnboardeePayload).subscribe(resp => {
      console.log(resp);
    });
  }

}
