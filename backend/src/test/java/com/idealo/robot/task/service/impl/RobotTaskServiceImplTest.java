package com.idealo.robot.task.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.idealo.robot.task.model.FacingDirection;
import com.idealo.robot.task.model.Robot;
import com.idealo.robot.task.service.RobotTaskService.RobotTaskException;

@RunWith(SpringRunner.class)
public class RobotTaskServiceImplTest {
	
	@InjectMocks
	RobotTaskServiceImpl robotTaskService;
	
	@Before
	public void setup() {
		RobotCommandFactory.registerRobotCommand("POSITION", new PositionRobotCommand());
		RobotCommandFactory.registerRobotCommand("WAIT", new WaitRobotCommand());
		RobotCommandFactory.registerRobotCommand("RIGHT", new RightRobotCommand());
		RobotCommandFactory.registerRobotCommand("FORWARD", new ForwardRobotCommand());
		RobotCommandFactory.registerRobotCommand("TURNAROUND", new TurnaroundRobotCommand());
	}
	
	@Test(expected = RobotTaskException.class)
	public void shouldNotGetRobotPosition() throws RobotTaskException {
		String robotCommands = getRobotCommands("commands2.txt");
		robotTaskService.getRobotPosition(robotCommands);
	}
	
	@Test
	public void getRobotPosition() throws RobotTaskException {
		String robotCommands = getRobotCommands("commands.txt");
		Robot robot = robotTaskService.getRobotPosition(robotCommands);
		Assert.assertEquals(0, robot.getxCoordinate());
		Assert.assertEquals(2, robot.getyCoordinate());
		Assert.assertEquals(FacingDirection.NORTH, robot.getDirection());
	}
	
	private String getRobotCommands(String fileName) {
		 File file = FileUtils.getFile("src", "test", "resources", fileName);
		 try {
			 return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		 } catch (IOException e) {
		     return "";
		 }
	}
	
	

}
