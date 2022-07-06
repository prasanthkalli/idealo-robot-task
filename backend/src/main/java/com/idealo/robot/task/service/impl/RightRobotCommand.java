package com.idealo.robot.task.service.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.idealo.robot.task.model.FacingDirection;
import com.idealo.robot.task.model.Robot;
import com.idealo.robot.task.service.RobotCommand;

@Component
public class RightRobotCommand implements RobotCommand {
	
	private static final Logger logger = LoggerFactory.getLogger(RightRobotCommand.class);
	
	@PostConstruct
	public void init() {
		// Registering the Right command in the command factory
		RobotCommandFactory.registerRobotCommand("RIGHT", new RightRobotCommand());
	}

	@Override
	public Robot getRobot(Robot robot, String[] commands) {
		FacingDirection direction = robot.getDirection();
		
		if (direction.equals(FacingDirection.EAST)) {
			robot.setDirection(FacingDirection.SOUTH);
		}
		
		else if (direction.equals(FacingDirection.WEST)) {
			robot.setDirection(FacingDirection.NORTH);
		}
		
		else if (direction.equals(FacingDirection.SOUTH)) {
			robot.setDirection(FacingDirection.WEST);
		}
		
		else {
			robot.setDirection(FacingDirection.EAST);
		}
		
		logger.info("Robot direction changed from {} to {}", direction.name(), robot.getDirection().name());
		return robot;
	}

}
