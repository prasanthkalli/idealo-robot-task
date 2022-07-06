package com.idealo.robot.task.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idealo.robot.task.model.Robot;
import com.idealo.robot.task.service.RobotTaskService;
import com.idealo.robot.task.utils.RobotTaskUtils;

@RestController
@RequestMapping("/robot")
public class RobotTaskController {
	
	private static final Logger logger = LoggerFactory.getLogger(RobotTaskController.class);
	
	@Autowired
	private RobotTaskService roboTaskService;
	
	@PostMapping(value = "/getPosition", produces = "application/json")
	@ResponseBody
	public ResponseEntity<Robot> getRobotPosition(@RequestBody String inputCommands) throws Exception {
		Robot robot = null;
		try {
			if (!StringUtils.hasLength(inputCommands)) {
				throw new Exception("Input commands cannot be null or empty");
			}
			long startTime = RobotTaskUtils.getCurrentTime();
			logger.info("Getting the position of the robot");
			robot = roboTaskService.getRobotPosition(inputCommands);
			long timeTaken = RobotTaskUtils.getCurrentTime() - startTime;
			logger.info("Time taken to get the robot position {}", timeTaken);
			return new ResponseEntity<>(robot, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error occured while getting the robot position -  {}", e.getMessage());
			return new ResponseEntity<>(robot, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
