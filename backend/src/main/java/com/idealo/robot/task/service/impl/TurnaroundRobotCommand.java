package com.idealo.robot.task.service.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.idealo.robot.task.model.FacingDirection;
import com.idealo.robot.task.model.Robot;
import com.idealo.robot.task.service.RobotCommand;

@Component
public class TurnaroundRobotCommand implements RobotCommand {
	
	private static final Logger logger = LoggerFactory.getLogger(TurnaroundRobotCommand.class);
	
	@PostConstruct
	public void init() {
		// Registering the Turn around command in the command factory
		RobotCommandFactory.registerRobotCommand("TURNAROUND", new TurnaroundRobotCommand());
	}

	@Override
	public Robot getRobot(Robot robot, String[] commands) {
		FacingDirection direction = robot.getDirection();
		
		if (direction.equals(FacingDirection.EAST)) {
			robot.setDirection(FacingDirection.WEST);
		}
		
		else if (direction.equals(FacingDirection.WEST)) {
			robot.setDirection(FacingDirection.EAST);
		}
		
		else if (direction.equals(FacingDirection.SOUTH)) {
			robot.setDirection(FacingDirection.NORTH);
		}
		
		else {
			robot.setDirection(FacingDirection.SOUTH);
		}
		
		logger.info("Robot direction changed from {} to {}", direction.name(), robot.getDirection().name());
		return robot;
	}

}
