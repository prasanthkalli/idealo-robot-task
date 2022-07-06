import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppConstants } from '../constants/app-constants';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  public API_BASE_URL = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  /**
   * @param script 
   * Gets the robot position from the API
   */
  getRobotPosition(script: any) {
    const url  = this.API_BASE_URL + AppConstants.REST_API_ENDPOINTS.GET_ROBOT_POSITION;
    return this.http.post(url, script, { responseType: 'json' });
  }
}
