package au.com.rea.robot.model;

import au.com.rea.robot.command.Directions;

public interface Robot {

	public int getX();
	public void setX(int x);
	public int getY();
	public void setY(int y);
	public Directions getFacing();
	public void setFacing(Directions facing);
}
