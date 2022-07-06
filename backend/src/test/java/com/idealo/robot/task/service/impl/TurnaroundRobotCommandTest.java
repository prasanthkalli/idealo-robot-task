package com.idealo.robot.task.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.idealo.robot.task.model.FacingDirection;
import com.idealo.robot.task.model.Robot;

@RunWith(SpringRunner.class)
public class TurnaroundRobotCommandTest {
	
	@InjectMocks
	TurnaroundRobotCommand turnaroundRobotCommand;
	
	@Test
	public void getRobotWhenFacingEast() {
		Robot robot = new Robot();
		robot.setxCoordinate(1);
		robot.setyCoordinate(1);
		robot.setDirection(FacingDirection.EAST);
		Assert.assertEquals(FacingDirection.WEST, turnaroundRobotCommand.getRobot(robot, null).getDirection());
	}
	
	@Test
	public void getRobotWhenFacingWest() {
		Robot robot = new Robot();
		robot.setxCoordinate(1);
		robot.setyCoordinate(1);
		robot.setDirection(FacingDirection.WEST);
		Assert.assertEquals(FacingDirection.EAST, turnaroundRobotCommand.getRobot(robot, null).getDirection());
	}
	
	@Test
	public void getRobotWhenFacingNorth() {
		Robot robot = new Robot();
		robot.setxCoordinate(1);
		robot.setyCoordinate(1);
		robot.setDirection(FacingDirection.NORTH);
		Assert.assertEquals(FacingDirection.SOUTH, turnaroundRobotCommand.getRobot(robot, null).getDirection());
	}
	
	@Test
	public void getRobotWhenFacingSouth() {
		Robot robot = new Robot();
		robot.setxCoordinate(1);
		robot.setyCoordinate(1);
		robot.setDirection(FacingDirection.SOUTH);
		Assert.assertEquals(FacingDirection.NORTH, turnaroundRobotCommand.getRobot(robot, null).getDirection());
	}

}
