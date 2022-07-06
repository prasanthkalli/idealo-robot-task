package com.idealo.robot.task.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.idealo.robot.task.model.FacingDirection;
import com.idealo.robot.task.model.Robot;
import com.idealo.robot.task.service.RobotTaskService.RobotTaskException;

@RunWith(SpringRunner.class)
public class PositionRobotCommandTest {
	
	@InjectMocks
	PositionRobotCommand positionRobotCommand;
	
	@Test
	public void getRobotWhenFacingEast() throws RobotTaskException {
		String[] commands = new String[] {"POSITION", "1", "3", "EAST"};
		Robot robot = new Robot();
		robot.setxCoordinate(1);
		robot.setyCoordinate(1);
		robot.setDirection(FacingDirection.EAST);
		Assert.assertEquals(FacingDirection.EAST, positionRobotCommand.getRobot(robot, commands).getDirection());
		Assert.assertEquals(1, positionRobotCommand.getRobot(robot, commands).getxCoordinate());
	}
	
	@Test(expected=RobotTaskException.class)
	public void shouldNotGetRobotWithInsufficientArguments() throws RobotTaskException {
		String[] commands = new String[] {"POSITION", "1", "3"};
		Robot robot = new Robot();
		robot.setxCoordinate(1);
		robot.setyCoordinate(1);
		robot.setDirection(FacingDirection.EAST);
		Assert.assertEquals(1, positionRobotCommand.getRobot(robot, commands).getxCoordinate());
	}
	
}
