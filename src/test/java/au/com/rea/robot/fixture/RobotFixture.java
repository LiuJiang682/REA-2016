package au.com.rea.robot.fixture;

import au.com.rea.robot.model.ReaRobot;
import au.com.rea.robot.model.Robot;

public class RobotFixture {

	public static Robot givenRobot() {
		Robot robot = new ReaRobot();
		return robot;
	}

}
