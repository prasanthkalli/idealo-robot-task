import { Component } from '@angular/core';
import { HttpService } from './services/http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {

  script: any;
  robotPositionFetched = false;
  xCoordinate: any;
  yCoordinate: any;
  xMaxCoordinate: any;
  yMaxCoordinate: any;
  direction: any;
  showErrorMessage = false;

  constructor(private httpService: HttpService) { }

  /** 
   * Submits the commands to API and renders the grid
   */
  submitScript() {
    this.showErrorMessage = false;
    this.httpService.getRobotPosition(this.script).subscribe((response: any) => {
      if (response) {
        this.robotPositionFetched = true;
        this.xMaxCoordinate = response.maximumXCoordinate;
        this.yMaxCoordinate = response.maximumYCoordinate;
        this.xCoordinate = response.xCoordinate;
        this.yCoordinate = response.yCoordinate;
        this.direction = response.direction;
      }
    }, error => {
      if (error) {
        this.robotPositionFetched = false;
        this.showErrorMessage = true;
      }
    });
  }
  
  /** 
   * Callback method for Try Again/Reset
   */
  tryAgainOrReset() {
    this.showErrorMessage = false;
    this.robotPositionFetched = false;
    this.script = null;
  }

  /** 
   * @param xCoordinate
   * @param yCoordinate
   * Gets the robot image html element for the coordinates of the robot
   */
  getRobotImage(i: any, j: any) {
    if (i === this.xCoordinate && j === this.yCoordinate) {
      return '<img src="assets/robot_' + this.direction.toLowerCase() + '.jpg" width="50px" height="50px">';
    }
    return '';
  }
}
