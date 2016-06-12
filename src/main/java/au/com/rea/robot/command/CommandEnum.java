package au.com.rea.robot.command;

import org.apache.commons.lang3.StringUtils;

/**
 * The Command Enum class
 *
 */
public enum CommandEnum {

	PLACE, MOVE, LEFT, RIGHT, REPORT, DONOTHING;

	public static CommandEnum fromString(final String commandString) {
		if ((StringUtils.isNotBlank(commandString))
				&& (commandString.trim().toUpperCase().startsWith(PLACE.toString()))) {
			return PLACE;
		}
		
		for (CommandEnum command : CommandEnum.values()) {
			if (command.toString().equalsIgnoreCase(commandString)) {
				return command;
			}
		}

		return DONOTHING;
	}
}
