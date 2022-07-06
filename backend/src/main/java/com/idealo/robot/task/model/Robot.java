package com.idealo.robot.task.model;

public class Robot {
	
	private int xCoordinate;
	private int yCoordinate;
	private FacingDirection direction;
	
	private static final int X_MAX = 5;
	private static final int Y_MAX = 5;
	
	public int getxCoordinate() {
		return xCoordinate;
	}
	
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	
	public int getyCoordinate() {
		return yCoordinate;
	}
	
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	public FacingDirection getDirection() {
		return direction;
	}
	
	public void setDirection(FacingDirection direction) {
		this.direction = direction;
	}
	
	public int getMaximumXCoordinate() {
		return X_MAX;
	}
	
	public int getMaximumYCoordinate() {
		return Y_MAX;
	}

	@Override
	public String toString() {
		return "Robot [xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + ", direction=" + direction.name() + "]";
	}
	
	
	
	

}
