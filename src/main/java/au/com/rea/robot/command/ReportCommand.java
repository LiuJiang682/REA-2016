package au.com.rea.robot.command;

import au.com.rea.robot.interf.RobotTable;
import au.com.rea.robot.model.Robot;

public class ReportCommand implements Command {

	@Override
	public void execute(RobotTable robotTable) {
		Robot robot = robotTable.getRobot();
		if (null != robot) {
			System.out.println(robot.getX() + ", " + robot.getY() + ", " + robot.getFacing());
		}
	}

}
