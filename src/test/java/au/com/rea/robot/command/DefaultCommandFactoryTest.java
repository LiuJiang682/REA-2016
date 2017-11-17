package au.com.rea.robot.command;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for CommandFactory class.
 *
 */
public class DefaultCommandFactoryTest {

	private DefaultCommandFactory defaultCommandFactory;
	
	@Before
	public void setUp() {
		this.defaultCommandFactory = new DefaultCommandFactory();
	}
	
	@After
	public void tearDown() {
		this.defaultCommandFactory = null;
	}
	
	/**
	 * Given the user enter null string
	 * When the constructCommand method called
	 * Then a DoNothingCommand object should return
	 */
	@Test
	public void whenUserEnteredNullThenADoNothingCommandObjectShouldReturn() {
		//Given user entered null
		String userEntered = null;
		//When the constructCommand called
		Command command = defaultCommandFactory.constructCommand(userEntered);
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
	public void whenUserEnteredEmptyStringThenADoNothingCommandObjectShouldReturn() {
		//Given user entered an empty string 
		String userEntered = "";
		//When the constructCommand called
		Command command = defaultCommandFactory.constructCommand(userEntered);
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
	public void whenUserEnteredInvalidStringThenADoNothingCommandObjectShouldReturn() {
		//Given user entered an invalid command string 
		String userEntered = "abc";
		//When the constructCommand called
		Command command = defaultCommandFactory.constructCommand(userEntered);
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
		Command command = defaultCommandFactory.constructCommand(userEntered);
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
	public void whenMoveCommandEnteredThenDoCommandConstructShouldReturnMoveommand() {
		//Given the user enter the MOVE command string
		String userEntered = "MOVE";
		//When the doCommandConstruct method called
		Command command = defaultCommandFactory.constructCommand(userEntered);
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
	public void whenLeftCommandEnteredThenDoCommandConstructShouldReturnLeftCommand() {
		//Given the user enter the LEFT command string
		String userEntered = "LEFT";
		//When the doCommandConstruct method called
		Command command = defaultCommandFactory.constructCommand(userEntered);
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
	public void whenRightCommandEnteredThenDoCommandConstructShouldReturnRightCommand() {
		//Given the user enter the Right command string
		String userEntered = "Right";
		//When the doCommandConstruct method called
		Command command = defaultCommandFactory.constructCommand(userEntered);
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
	public void whenReportCommandEnteredThenDoCommandConstructShouldReturnReportCommand() {
		//Given the user enter the Report command string
		String userEntered = "Report";
		//When the doCommandConstruct method called
		Command command = defaultCommandFactory.constructCommand(userEntered);
		//Then the Right command object should return
		assertNotNull(command);
		assertTrue(command instanceof ReportCommand);
	}
	
}
