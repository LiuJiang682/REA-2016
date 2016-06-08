package au.com.rea.robot.command;

public class CommandFactory {

	public static Command constructCommand(String userEntered) {
		Command command = null;
		
		switch (CommandEnum.fromString(userEntered)) {
			case PLACE:
				command = new PlaceCommand(userEntered);
				break;
			case MOVE:
				command = new MoveCommand();
				break;
			case LEFT:
				command = new LeftCommand();
				break;
			case RIGHT:
				command = new RightCommand();
				break;
			case REPORT:
				command = new ReportCommand();
				break;
			default:
				command = new DoNothingCommand();
		}
		return command;
	}

}
