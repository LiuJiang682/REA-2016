package au.com.rea.robot.interf;

import au.com.rea.robot.model.Robot;

public interface RobotTable {

	public Robot getRobot();
	public void setRobot(Robot robot);
	
	public int getMaxX();
	public int getMaxY();
}
