package au.com.rea.robot.command;

import org.apache.commons.lang3.StringUtils;

public class CommandFactory {

	public static Command constructCommand(String userEntered) {
		Command command = null;
		if (StringUtils.isBlank(userEntered)) {
			command = getDoNothingCommand();
		}
		
		return command;
	}

	protected static Command getDoNothingCommand() {
		return new DoNothingCommand();
	}

}
