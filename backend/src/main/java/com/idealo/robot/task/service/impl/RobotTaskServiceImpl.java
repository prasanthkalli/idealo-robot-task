package com.idealo.robot.task.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.idealo.robot.task.model.FacingDirection;
import com.idealo.robot.task.model.Robot;
import com.idealo.robot.task.service.RobotCommand;
import com.idealo.robot.task.service.RobotTaskService;

@Service
public class RobotTaskServiceImpl implements RobotTaskService {
	
	private static final Logger logger = LoggerFactory.getLogger(RobotTaskServiceImpl.class);
	
	@Override
	public Robot getRobotPosition(String inputCommands) throws RobotTaskException {
		try {
			Robot robot = initializeRobot(); // Initialize the robot to {0,0} and EAST Facing direction
			String[] robotCommands = inputCommands.split("\\r?\\n"); // Split given set of commands line by line
			for(String command : robotCommands) {
				String[] subCommands = command.split(" "); // Split a command by a space
				String robotAction = subCommands[0];
				logger.info("action {}", robotAction);
				RobotCommand robotCommand = RobotCommandFactory.getRobotCommand(robotAction);
				if (robotCommand != null) {
					robot = robotCommand.getRobot(robot, subCommands);
				} else {
					throw new RobotTaskException("Invalid command given for the robot");
				}
			}
			logger.debug("Robot {}", robot.toString());
			return robot;
		} catch (Exception e) {
			logger.error("Exception occured while getting the robot position - {}", e.getMessage());
			throw new RobotTaskException(e.getMessage());
		}
		
	}

	private Robot initializeRobot() {
		Robot robot = new Robot();
		robot.setxCoordinate(0);
		robot.setyCoordinate(0);
		robot.setDirection(FacingDirection.EAST);
		return robot;
	}

}
