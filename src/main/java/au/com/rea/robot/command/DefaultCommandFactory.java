package au.com.rea.robot.command;

import java.io.InputStream;

import au.com.rea.robot.input.InputInterf;
import au.com.rea.robot.input.UserInput;

/**
 * The factory class product all command object.
 *
 */
public class DefaultCommandFactory implements CommandFactory {

	private InputInterf userInput;
	
	public DefaultCommandFactory() {
		this(System.in);
	}
	
	public DefaultCommandFactory(InputStream in) {
		this.userInput = new UserInput(in);
	}

	public Command constructCommand(String userEntered) {
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

	@Override
	public Command getNextCommand() {
		Command command = null;

		// User interactive mode
		System.out.println("Please enter your command: ");
		String userEntered = userInput.getNextLine();
		command = constructCommand(userEntered);

		return command;
	}

}
