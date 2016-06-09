package au.com.rea.robot.command;

import org.apache.commons.lang3.StringUtils;

import au.com.rea.robot.constants.CommonConstants.Numeral;
import au.com.rea.robot.interf.RobotTable;
import au.com.rea.robot.model.ReaRobot;
import au.com.rea.robot.model.Robot;

/**
 * The place command class
 *
 */
public class PlaceCommand implements Command {

	private static final String DELIM = ",";

	private static final String EMPTY = "";
	
	private String userEntered;
	private boolean validCommand;
	private int x;
	private int y;
	private Directions facing;
	
	/**
	 * The constructor. It assumes two things:
	 * 	1) Done the null check
	 * 	2) String start with "place"
	 * 
	 * @param userEntered the user input. 
	 */
	public PlaceCommand(String userEntered) {
		this.userEntered = userEntered;
		validCommand = false;
		String paramsString = this.userEntered.toUpperCase().replace(CommandEnum.PLACE.toString(), EMPTY).trim();
		if (StringUtils.isNotBlank(paramsString)) {
			String[] params = paramsString.split(DELIM);
			if ((null != params) && (Numeral.THREE == params.length)) {
				try {
					this.x = Integer.parseInt(params[Numeral.ZERO].trim());
					this.y = Integer.parseInt(params[Numeral.ONE].trim());
					this.facing = Directions.valueOf(params[Numeral.TWO].trim().toUpperCase());
					validCommand = true;
				} 
				catch (Exception e) {
					//Ignore the exception
				}
			}
		}
	}

	@Override
	public void execute(RobotTable robotTable) {
		if ((this.validCommand) && (isLegitimateMove(robotTable))) {
			Robot robot = robotTable.getRobot();
			if (robot == null) {
				//First command! Build the robot with parameters
				robot  = new ReaRobot();
				robot.setX(x);
				robot.setY(y);
				robot.setFacing(facing);
				robotTable.setRobot(robot);
			} else {
				robot.setX(x);
				robot.setY(y);
				robot.setFacing(facing);
			}
		}
	}

	/**
	 * Checking the ranges, the direction will not need to check
	 * since it is an invalid command.
	 * @param robotTable the robot table is on
	 * @return true if it is in range.
	 */
	protected boolean isLegitimateMove(RobotTable robotTable) {
		boolean isInXRange = (Numeral.ZERO <= x) && (x <= robotTable.getMaxX());
		boolean isInYRange = (Numeral.ZERO <= y) && (y <= robotTable.getMaxY());
		
		return isInXRange && isInYRange;
	}

	public boolean isValidCommand() {
		return validCommand;
	}

}
