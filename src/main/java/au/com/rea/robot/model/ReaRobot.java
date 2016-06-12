package au.com.rea.robot.model;

import java.io.Serializable;

import au.com.rea.robot.command.Directions;

/**
 * This is the implementation class of the Robot. It is a
 * DTO class with all position attributes of a robot.
 *
 */
public class ReaRobot implements Robot, Serializable {

	/**
	 * Generated serial version UID.
	 */
	private static final long serialVersionUID = 7650653537721822280L;

	private int x;
	private int y;
	private Directions facing;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Directions getFacing() {
		return facing;
	}
	public void setFacing(Directions facing) {
		this.facing = facing;
	}
}
