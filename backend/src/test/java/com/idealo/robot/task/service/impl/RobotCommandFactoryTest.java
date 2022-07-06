package com.idealo.robot.task.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.idealo.robot.task.service.RobotCommand;

public class RobotCommandFactoryTest {
	
	@InjectMocks
	RobotCommandFactory robotCommandFactory;
	
	@Test
	public void testRegisterAndGetRobotCommand() {
		RobotCommandFactory.registerRobotCommand("POSITION", new PositionRobotCommand());
		RobotCommandFactory.registerRobotCommand("WAIT", new WaitRobotCommand());
		RobotCommand command = RobotCommandFactory.getRobotCommand("POSITION");
		Assert.assertNotNull(command);
		RobotCommand invalidCommand = RobotCommandFactory.getRobotCommand("LEFT");
		Assert.assertNull(invalidCommand);
	}
	
	@Test
	public void shouldNotGetCommand() {
		Assert.assertNull(RobotCommandFactory.getRobotCommand(null));
	}

}
