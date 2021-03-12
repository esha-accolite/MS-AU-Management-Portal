import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { OnboardeeCompleteInfo } from '../Models/OnboardeeCompleteInfo';

@Injectable({
  providedIn: 'root'
})
export class OnboardeeService {
  // onboardeeList!: Array<OnboardeeCompleteInfo>;

  GET_ALL_ONBOARDEE = "/onboardee/getAllOnboardee";
  ADD_ONBOARDEE = "/onboardee/addOnboardee";
  DELETE_ONBOARDEE = "/onboardee/delete";
  EDIT_ONBOARDEE = "/onboardee/edit";
  GET_ONBOARDEE_BY_ID = "/onboardee/getOnboardee"

  constructor(private http: HttpClient) { }

  getAllOnboardee(): Observable<any> {
    // console.log(this.onboardeeList);
    return this.http.get(this.GET_ALL_ONBOARDEE);
  }

  addOnboardee(payload: OnboardeeCompleteInfo): Observable<any> {
    return this.http.post(this.ADD_ONBOARDEE,payload);
  }

  deleteOnboardee(id: Number): Observable<any> {
    return this.http.delete(this.DELETE_ONBOARDEE+ "/"+id);
  }

  editOnboardee(payload: OnboardeeCompleteInfo): Observable<any> {
    return this.http.put(this.EDIT_ONBOARDEE, payload);
  }

  getOnboardeeById(id: Number): Observable<any> {
    return this.http.get(this.GET_ONBOARDEE_BY_ID + "/" + id);
  }

  // setOnboardeeList(onboardeeList : Array<OnboardeeCompleteInfo>) : void {
  //   this.onboardeeList = onboardeeList;
  // } 

}
