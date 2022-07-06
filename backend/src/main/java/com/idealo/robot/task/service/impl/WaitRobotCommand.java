package com.idealo.robot.task.service.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.idealo.robot.task.model.Robot;
import com.idealo.robot.task.service.RobotCommand;

@Component
public class WaitRobotCommand implements RobotCommand {
	
	private static final Logger logger = LoggerFactory.getLogger(WaitRobotCommand.class);
	
	@PostConstruct
	public void init() {
		// Registering the wait command in the command factory
		RobotCommandFactory.registerRobotCommand("WAIT", new WaitRobotCommand());
	}

	@Override
	public Robot getRobot(Robot robot, String[] commands) {
		logger.info("Robot is waiting");
		return robot;
	}

}
