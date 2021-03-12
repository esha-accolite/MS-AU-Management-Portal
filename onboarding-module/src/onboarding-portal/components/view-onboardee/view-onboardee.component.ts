import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { OnboardeeCompleteInfo } from '../../Models/OnboardeeCompleteInfo';
import { OnboardeeService } from '../../services/onboardee.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-view-onboardee',
  templateUrl: './view-onboardee.component.html',
  styleUrls: ['./view-onboardee.component.css']
})
export class ViewOnboardeeComponent implements OnInit {

  sub:any;
  id:Number = 0;
  item!: OnboardeeCompleteInfo;

  constructor(private OnboardeeService: OnboardeeService, private router: Router, private activatedroute:ActivatedRoute) { }

  ngOnInit(): void {
    this.sub = this.activatedroute.params.subscribe(params => {
      this.id = params['id'];
      });
      console.log(this.id);
      this.OnboardeeService.getOnboardeeById(this.id).subscribe(resp => {
        console.log(resp);
        this.item = resp;
      })
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
