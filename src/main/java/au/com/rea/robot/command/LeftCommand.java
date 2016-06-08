package au.com.rea.robot.command;

import java.util.HashMap;

import au.com.rea.robot.interf.RobotTable;
import au.com.rea.robot.model.Robot;

public class LeftCommand implements Command {

	private static final HashMap<Directions, Directions> directionMap;
	
	@Override
	public void execute(RobotTable robotTable) {
		Robot robot = robotTable.getRobot();
		if (null != robot) {
			Directions next = directionMap.get(robot.getFacing());
			robot.setFacing(next);
		}

	}

	static {
		directionMap = new HashMap<Directions, Directions>();
		directionMap.put(Directions.EAST, Directions.NORTH);
		directionMap.put(Directions.NORTH, Directions.WEST);
		directionMap.put(Directions.WEST, Directions.SOUTH);
		directionMap.put(Directions.SOUTH, Directions.EAST);
	}
}
