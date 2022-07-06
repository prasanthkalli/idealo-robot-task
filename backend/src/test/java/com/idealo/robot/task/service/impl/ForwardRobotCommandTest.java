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
public class ForwardRobotCommandTest {
	
	@InjectMocks
	ForwardRobotCommand forwardRobotCommand;
	
	@Test(expected=RobotTaskException.class)
	public void shouldNotGetRobotWithInsufficientArguments() throws RobotTaskException {
		String[] commands = new String[] {"FORWARD"};
		Robot robot = new Robot();
		robot.setxCoordinate(1);
		robot.setyCoordinate(1);
		robot.setDirection(FacingDirection.EAST);
		Assert.assertEquals(1, forwardRobotCommand.getRobot(robot, commands).getxCoordinate());
	}
	
	@Test(expected=RobotTaskException.class)
	public void shouldNotGetRobotForOutOfBoundsOnRightYCoordinate() throws RobotTaskException {
		String[] commands = new String[] {"FORWARD", "3"};
		Robot robot = new Robot();
		robot.setxCoordinate(1);
		robot.setyCoordinate(3);
		robot.setDirection(FacingDirection.EAST);
		forwardRobotCommand.getRobot(robot, commands);
	}
	
	@Test
	public void getRobotWhenMovingForwardsTowardsEast() throws RobotTaskException {
		String[] commands = new String[] {"FORWARD", "3"};
		Robot robot = new Robot();
		robot.setxCoordinate(1);
		robot.setyCoordinate(1);
		robot.setDirection(FacingDirection.EAST);
		Assert.assertEquals(4, forwardRobotCommand.getRobot(robot, commands).getyCoordinate());
	}
	
	@Test(expected=RobotTaskException.class)
	public void shouldNotGetRobotForOutOfBoundsOnLeftYCoordinate() throws RobotTaskException {
		String[] commands = new String[] {"FORWARD", "3"};
		Robot robot = new Robot();
		robot.setxCoordinate(1);
		robot.setyCoordinate(1);
		robot.setDirection(FacingDirection.WEST);
		forwardRobotCommand.getRobot(robot, commands);
	}
	
	@Test
	public void getRobotWhenMovingForwardsTowardsWest() throws RobotTaskException {
		String[] commands = new String[] {"FORWARD", "2"};
		Robot robot = new Robot();
		robot.setxCoordinate(1);
		robot.setyCoordinate(3);
		robot.setDirection(FacingDirection.WEST);
		Assert.assertEquals(1, forwardRobotCommand.getRobot(robot, commands).getyCoordinate());
	}
	
	@Test(expected=RobotTaskException.class)
	public void shouldNotGetRobotForOutOfBoundsOnUpXCoordinate() throws RobotTaskException {
		String[] commands = new String[] {"FORWARD", "2"};
		Robot robot = new Robot();
		robot.setxCoordinate(1);
		robot.setyCoordinate(3);
		robot.setDirection(FacingDirection.NORTH);
		forwardRobotCommand.getRobot(robot, commands);
	}
	
	@Test
	public void getRobotWhenMovingForwardsTowardsNorth() throws RobotTaskException {
		String[] commands = new String[] {"FORWARD", "2"};
		Robot robot = new Robot();
		robot.setxCoordinate(3);
		robot.setyCoordinate(1);
		robot.setDirection(FacingDirection.NORTH);
		Assert.assertEquals(1, forwardRobotCommand.getRobot(robot, commands).getxCoordinate());
	}
	
	@Test(expected=RobotTaskException.class)
	public void shouldNotGetRobotForOutOfBoundsOnDownXCoordinate() throws RobotTaskException {
		String[] commands = new String[] {"FORWARD", "4"};
		Robot robot = new Robot();
		robot.setxCoordinate(1);
		robot.setyCoordinate(1);
		robot.setDirection(FacingDirection.SOUTH);
		forwardRobotCommand.getRobot(robot, commands);
	}
	
	@Test
	public void getRobotWhenMovingForwardsTowardsSouth() throws RobotTaskException {
		String[] commands = new String[] {"FORWARD", "3"};
		Robot robot = new Robot();
		robot.setxCoordinate(1);
		robot.setyCoordinate(3);
		robot.setDirection(FacingDirection.SOUTH);
		Assert.assertEquals(4, forwardRobotCommand.getRobot(robot, commands).getxCoordinate());
	}

}
