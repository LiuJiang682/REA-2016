package au.com.rea.robot.command;

import org.apache.commons.lang3.StringUtils;

/**
 * The place command class
 *
 */
public class PlaceCommand implements Command {

	private static final int TWO = 2;

	private static final int ZERO = 0;

	private static final int ONE = 1;

	private static final int THREE = 3;

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
			if ((null != params) && (THREE == params.length)) {
				try {
					this.x = Integer.parseInt(params[ZERO].trim());
					this.y = Integer.parseInt(params[ONE].trim());
					this.facing = Directions.valueOf(params[TWO].trim().toUpperCase());
					validCommand = true;
				} 
				catch (Exception e) {
					//Ignore the exception
				}
			}
		}
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	public boolean isValidCommand() {
		return validCommand;
	}

}
