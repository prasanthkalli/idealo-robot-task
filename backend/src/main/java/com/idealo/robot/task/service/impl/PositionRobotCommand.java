package com.idealo.robot.task.service.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.idealo.robot.task.model.FacingDirection;
import com.idealo.robot.task.model.Robot;
import com.idealo.robot.task.service.RobotCommand;
import com.idealo.robot.task.service.RobotTaskService.RobotTaskException;

@Component
public class PositionRobotCommand implements RobotCommand {

	private static final Logger logger = LoggerFactory.getLogger(PositionRobotCommand.class);
	
	@PostConstruct
	public void init() {
		// Registering the Position command in the command factory
		RobotCommandFactory.registerRobotCommand("POSITION", new PositionRobotCommand());
	}
	
	@Override
	public Robot getRobot(Robot robot, String[] commands) throws RobotTaskException {
		// Sample input for commands - ["POSITION","1","2","EAST"]
		// Command length is validated before robot is moved
		if (commands.length != 4) {
			throw new RobotTaskException("Invalid number of arguments for the position command");
		}
		robot.setDirection(FacingDirection.valueOf(commands[3]));
		robot.setxCoordinate(Integer.valueOf(commands[1]));
		robot.setyCoordinate(Integer.valueOf(commands[2]));
		logger.info("Robot coordinates are {},{}", robot.getxCoordinate(), robot.getyCoordinate());
		return robot;
	}

}
