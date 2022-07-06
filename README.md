# Idealo Robot Task Challenge

## Table of contents
* [Application Overview](#application-overview)
* [Technologies](#technologies)
* [Setup](#setup)
* [Enhancements](#enhancements)

## Application Overview
The robot application is built using Java and Spring Boot for backend and Angular for frontend. Robot commands can be passed from the user interface to backend through API calls. The API validates the input commands and returns the final position and direction of the robot. The output is used to render the robot in the grid. An error message will be displayed for invalid input.
	
## Technologies
Project is created with the following tech stack and their respective versions.
* Java: 11
* Spring Boot: 2.7.1
* JUnit: 4
* Angular: 14
* Bootstrap: 5
	
## Setup

* Start the backend application using an IDE with Spring Boot run configuration and open http://localhost:8080/
* Run the frontend using npm install and ng serve commands. After installation is successful and application gets started, open http://localhost:4200/


## Enhancements

* Different error messages can be displayed to the user, one in case of invalid command type and two in case of any invalid scenario(robot crossing the grid limits).
* Inline styling used in the frontend can be externalized into an component css file.
* Tests can be added for frontend application.
* User input can be streamlined. For example, the robot input commands can be changed from single input element to multiple input/dropdown.
* The current position/direction of the robot can be passed as an input to the API to generate the final position and direction of the robot for the next user command.
* Grid sizing and styling after robot rendering could be improved to provide more user friendly experience.
