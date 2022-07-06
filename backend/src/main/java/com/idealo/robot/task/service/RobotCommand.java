package com.idealo.robot.task.service;

import com.idealo.robot.task.model.Robot;
import com.idealo.robot.task.service.RobotTaskService.RobotTaskException;

public interface RobotCommand {
	
	public Robot getRobot(Robot robot, String[] commands) throws RobotTaskException;

}
