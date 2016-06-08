package au.com.rea.robot.command;

public class CommandFactory {

	public static Command constructCommand(String userEntered) {
		Command command = null;
		
		switch (CommandEnum.fromString(userEntered)) {
			case PLACE:
				command = getPlaceCommand(userEntered);
				break;
			default:
				command = getDoNothingCommand();
		}
		return command;
	}

	protected static Command getPlaceCommand(final String userEntered) {
		return new PlaceCommand(userEntered);
	}

	protected static Command getDoNothingCommand() {
		return new DoNothingCommand();
	}

}
