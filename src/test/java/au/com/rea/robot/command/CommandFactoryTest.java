package au.com.rea.robot.command;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests for CommandFactory class.
 *
 */
public class CommandFactoryTest {

	/**
	 * Given the user enter null string
	 * When the constructCommand method called
	 * Then a DoNothingCommand object should return
	 */
	@Test
	public void whenUserEnteredNullThenACommandObjectShouldReturn() {
		//Given user entered null
		String userEntered = null;
		//When the constructCommand called
		Command command = CommandFactory.constructCommand(userEntered);
		//Then the a DoNothing command object should return
		assertNotNull(command);
		assertTrue(command instanceof DoNothingCommand);
	}
	
	/**
	 * Given the user enter an empty string
	 * When the constructCommand method called
	 * Then a DoNothingCommand object should return
	 */
	@Test
	public void whenUserEnteredEmptyStringThenACommandObjectShouldReturn() {
		//Given user entered an emtpy string 
		String userEntered = "";
		//When the constructCommand called
		Command command = CommandFactory.constructCommand(userEntered);
		//Then the a DoNothing command object should return
		assertNotNull(command);
		assertTrue(command instanceof DoNothingCommand);
	}
	
	
	/**
	 * Given the user enter an invalid command string
	 * When the constructCommand method called
	 * Then a DoNothingCommand object should return
	 */
	@Test
	public void whenUserEnteredInvalidStringThenACommandObjectShouldReturn() {
		//Given user entered an invalid command string 
		String userEntered = "abc";
		//When the constructCommand called
		Command command = CommandFactory.constructCommand(userEntered);
		//Then the a DoNothing command object should return
		assertNotNull(command);
		assertTrue(command instanceof DoNothingCommand);
	}
	
	/**
	 * Given the user enter the PLACE command string
	 * When the doCommandConstruct method called
	 * Then the Place command object should return
	 */
	@Test
	public void whenPlaceCommandEnteredThenDoCommandConstructShouldReturnPlaceCommand() {
		//Given the user enter the PLACE command string
		String userEntered = "PLACE x, y,f";
		//When the doCommandConstruct method called
		Command command = CommandFactory.constructCommand(userEntered);
		//Then the Place command object should return
		assertNotNull(command);
		assertTrue(command instanceof PlaceCommand);
	}
	
	
	/**
	 * Given the user enter the Move command string
	 * When the doCommandConstruct method called
	 * Then the Move command object should return
	 */
	@Test
	public void whenMoveCommandEnteredThenDoCommandConstructShouldReturnPlaceCommand() {
		//Given the user enter the MOVE command string
		String userEntered = "MOVE";
		//When the doCommandConstruct method called
		Command command = CommandFactory.constructCommand(userEntered);
		//Then the MOve command object should return
		assertNotNull(command);
		assertTrue(command instanceof MoveCommand);
	}
	
	/**
	 * Given the user enter the Left command string
	 * When the doCommandConstruct method called
	 * Then the Left command object should return
	 */
	@Test
	public void whenLeftCommandEnteredThenDoCommandConstructShouldReturnPlaceCommand() {
		//Given the user enter the LEFT command string
		String userEntered = "LEFT";
		//When the doCommandConstruct method called
		Command command = CommandFactory.constructCommand(userEntered);
		//Then the Left command object should return
		assertNotNull(command);
		assertTrue(command instanceof LeftCommand);
	}
	
	
	/**
	 * Given the user enter the Right command string
	 * When the doCommandConstruct method called
	 * Then the Right command object should return
	 */
	@Test
	public void whenRightCommandEnteredThenDoCommandConstructShouldReturnPlaceCommand() {
		//Given the user enter the Right command string
		String userEntered = "Right";
		//When the doCommandConstruct method called
		Command command = CommandFactory.constructCommand(userEntered);
		//Then the Right command object should return
		assertNotNull(command);
		assertTrue(command instanceof RightCommand);
	}
	
	/**
	 * Given the user enter the Report command string
	 * When the doCommandConstruct method called
	 * Then the Report command object should return
	 */
	@Test
	public void whenReportCommandEnteredThenDoCommandConstructShouldReturnPlaceCommand() {
		//Given the user enter the Report command string
		String userEntered = "Report";
		//When the doCommandConstruct method called
		Command command = CommandFactory.constructCommand(userEntered);
		//Then the Right command object should return
		assertNotNull(command);
		assertTrue(command instanceof ReportCommand);
	}
	
}
