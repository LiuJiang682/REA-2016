package au.com.rea.robot.command;

import au.com.rea.robot.interf.RobotTable;
import au.com.rea.robot.model.Robot;

public class RightCommand implements Command {

	@Override
	public void execute(RobotTable robotTable) {
		Robot robot = robotTable.getRobot();
		if (null != robot) {
			Directions next = robot.getFacing().getRight();
			robot.setFacing(next);
		}

	}
}
