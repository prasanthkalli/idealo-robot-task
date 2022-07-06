package com.idealo.robot.task.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.idealo.robot.task.model.FacingDirection;
import com.idealo.robot.task.model.Robot;
import com.idealo.robot.task.service.RobotCommand;
import com.idealo.robot.task.service.RobotTaskService.RobotTaskException;

@Component
public class ForwardRobotCommand implements RobotCommand {
	
	@PostConstruct
	public void init() {
		// Registering the Forward command in the command factory
		RobotCommandFactory.registerRobotCommand("FORWARD", new ForwardRobotCommand());
	}

	@Override
	public Robot getRobot(Robot robot, String[] commands) throws RobotTaskException {
		// Command length is validated before robot is moved
		if (commands.length != 2) {
			throw new RobotTaskException("Invalid number of arguments for the forward command");
		}
		int stepsCount = Integer.valueOf(commands[1]);
		FacingDirection direction = robot.getDirection();
		if (direction.equals(FacingDirection.EAST)) {
			int newYCoordinate = robot.getyCoordinate() + stepsCount;
			
			if (newYCoordinate > (robot.getMaximumYCoordinate() -1)) {
				throw new RobotTaskException("Robot cannot take the required steps towards " + direction.name());
			}
			
			robot.setyCoordinate(newYCoordinate);
		}
		else if (direction.equals(FacingDirection.WEST)) {
			int newYCoordinate = robot.getyCoordinate() - stepsCount;
			
			if (newYCoordinate < 0) {
				throw new RobotTaskException("Robot cannot take the required steps towards " + direction.name());
			}
			
			robot.setyCoordinate(newYCoordinate);
		}
		else if (direction.equals(FacingDirection.SOUTH)) {
			int newXCoordinate = robot.getxCoordinate() + stepsCount;
			
			if (newXCoordinate > (robot.getMaximumXCoordinate() -1)) {
				throw new RobotTaskException("Robot cannot take the required steps towards " + direction.name());
			}
			
			robot.setxCoordinate(newXCoordinate);
		}
		else {
			int newXCoordinate = robot.getxCoordinate() - stepsCount;
			
			if (newXCoordinate < 0) {
				throw new RobotTaskException("Robot cannot take the required steps towards " + direction.name());
			}
			
			robot.setxCoordinate(newXCoordinate);
		}
		return robot;
	}

}
