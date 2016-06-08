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
		//Given user entered an emtpy string 
		String userEntered = "abc";
		//When the constructCommand called
		Command command = CommandFactory.constructCommand(userEntered);
		//Then the a DoNothing command object should return
		assertNotNull(command);
		assertTrue(command instanceof DoNothingCommand);
	}
	
	/**
	 * Given the application can access the CommandFactory class
	 * When the getDoNothingCommand method called
	 * Then a DoNothingCommand object should return
	 */
	@Test
	public void whenGetDoNothingCommandCallThenDoNothingCommandObjectShouldReturn() {
		//Given the application has access the CommandFactory class
		//When the getDoNothingCommand method called
		Command command = CommandFactory.getDoNothingCommand();
		//Then a DoNothingCommand object should return
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
	 * Given the application can access the CommandFactory class
	 * When the getPlaceCommand method called
	 * Then a PlaceCommand object should return
	 */
	@Test
	public void whenGetPlaceCommandCallThenPlaceCommandObjectShouldReturn() {
		//Given the application has access the CommandFactory class
		//When the getDoNothingCommand method called
		Command command = CommandFactory.getPlaceCommand("place");
		//Then a DoNothingCommand object should return
		assertNotNull(command);
		assertTrue(command instanceof PlaceCommand);
	}
}
