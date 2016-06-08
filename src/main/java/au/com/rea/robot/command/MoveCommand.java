package au.com.rea.robot.command;

import au.com.rea.robot.constants.CommonConstants;
import au.com.rea.robot.interf.RobotTable;
import au.com.rea.robot.model.Robot;

public class MoveCommand implements Command {

	@Override
	public void execute(RobotTable robotTable) {
		Robot robot = robotTable.getRobot();
		if (null != robot) {
			if (isLegitimateMove(robotTable)) {
				moveRobot(robot);
			}
		}
	}

	protected void moveRobot(Robot robot) {
		switch (robot.getFacing()) {
		case EAST:
			moveEast(robot);
			break;
		case NORTH:
			moveNorth(robot);
			break;
		case WEST:
			moveWest(robot);
			break;
		case SOUTH:
			moveSouth(robot);
		}

	}

	private void moveSouth(Robot robot) {
		int y = robot.getY();
		--y;
		robot.setY(y);
	}

	private void moveWest(Robot robot) {
		int x = robot.getX();
		--x;
		robot.setX(x);
	}

	private void moveNorth(Robot robot) {
		int y = robot.getY();
		++y;
		robot.setY(y);
	}

	private void moveEast(Robot robot) {
		int x = robot.getX();
		++x;
		robot.setX(x);
	}

	/**
	 * Check in the move is legitimate. It assumes
	 * the robot is on the table.
	 * @param robotTable the table the robot currently on
	 * @return true if the move is inside the table dimensions.
	 */
	protected boolean isLegitimateMove(RobotTable robotTable) {
		boolean valid = false;
		Robot robot = robotTable.getRobot();

		// only work on robot on table.
		switch (robot.getFacing()) {
		case EAST:
			if (robot.getX() < robotTable.getMaxX()) {
				valid = true;
			}
			break;

		case NORTH:
			if (robot.getY() < robotTable.getMaxY()) {
				valid = true;
			}
			break;

		case WEST:
			if (CommonConstants.Numeral.ZERO < robot.getX()) {
				valid = true;
			}
			break;

		case SOUTH:
			if (CommonConstants.Numeral.ZERO < robot.getY()) {
				valid = true;
			}
		}

		return valid;
	}

}
