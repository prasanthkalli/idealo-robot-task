package com.idealo.robot.task.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.idealo.robot.task.model.FacingDirection;
import com.idealo.robot.task.model.Robot;

@RunWith(SpringRunner.class)
public class WaitRobotCommandTest {
	
	@InjectMocks
	WaitRobotCommand waitCommand;
	
	@Test
	public void getRobot() {
		Robot robot = new Robot();
		robot.setxCoordinate(0);
		robot.setyCoordinate(0);
		robot.setDirection(FacingDirection.EAST);
		Assert.assertEquals(robot, waitCommand.getRobot(robot, null));
	}

}
