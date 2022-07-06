package com.idealo.robot.task.service;

import com.idealo.robot.task.model.Robot;

public interface RobotTaskService {
	
	public Robot getRobotPosition(String script) throws Exception;
	
	/*
	 * User defined exception for Robot task
	 */
	class RobotTaskException extends Exception {

		private static final long serialVersionUID = 1L;
		
		public RobotTaskException(String message) {
			super(message);
		}
		
	}

}
