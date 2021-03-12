import { Component, OnInit } from '@angular/core';
import { OnboardeeCompleteInfo } from 'src/onboarding-portal/Models/OnboardeeCompleteInfo';
import { OnboardeeService } from '../../services/onboardee.service';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';

@Component({
  selector: 'app-graphical-view',
  templateUrl: './graphical-view.component.html',
  styleUrls: ['./graphical-view.component.css']
})
export class GraphicalViewComponent implements OnInit {
  onboardeeList: Array<OnboardeeCompleteInfo> = [];

  // public barChartOptions: ChartOptions = {
  //   responsive: true,
  // };
  // public barChartLabels: Label[] = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
  // public barChartType: ChartType = 'bar';
  // public barChartLegend = true;
  // public barChartPlugins = [];

  // public barChartData: ChartDataSets[] = [
  //   { data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A' },
  //   { data: [28, 48, 40, 19, 86, 27, 90], label: 'Series B' }
  // ];

  constructor(private OnboardeeService: OnboardeeService) { }

  ngOnInit(): void {

    this.OnboardeeService.getAllOnboardee().subscribe(resp => {
      console.log(resp);
      this.onboardeeList = resp;
      console.log(this.onboardeeList);
    });

  }

  // 

  displayByLocation(){
    console.log(this.onboardeeList);
    // var groupBy = function(onboardeeList: Array<OnboardeeCompleteInfo>, key:string) {
    //   return onboardeeList.reduce((rv:any, x: OnboardeeCompleteInfo)=> {
    //       (rv[x[key]] = rv[x[key]] || []).push(x);
    //       return rv;
    //     }, {});
    // };
    // var groubedByLocation=groupBy(this.onboardeeList, "location".toString())
    // console.log(groubedByLocation);
//     // var cars = [{ make: 'audi', model: 'r8', year: '2012' }, { make: 'audi', model: 'rs5', year: '2013' }, { make: 'ford', model: 'mustang', year: '2012' }, { make: 'ford', model: 'fusion', year: '2015' }, { make: 'kia', model: 'optima', year: '2012' }],
//     result = this.onboardeeList.reduce(function (r, a) {
//         r[a.id] = r[a.id] || [];
//         r[a.id].push(a);
//         return r;
//     }, Object.create(null));

// console.log(result);
  }
}
