package com.idealo.robot.task.service.impl;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.idealo.robot.task.service.RobotCommand;

@Component
public class RobotCommandFactory {
	
	private static final Map<String, RobotCommand> robotCommands = new HashMap<>();
	
	public static RobotCommand getRobotCommand(String commandName) {
		if (commandName != null && robotCommands.containsKey(commandName)) {
			return robotCommands.get(commandName);
		}
		return null;
	}
	
	public static void registerRobotCommand(String commandName, RobotCommand robotCommand) {
		robotCommands.put(commandName, robotCommand);
	}
	

}
