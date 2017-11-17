package au.com.rea.robot.command;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import au.com.rea.robot.input.UserInput;

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
		assertThat(command, is(instanceOf(DoNothingCommand.class)));
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
		assertThat(command, is(instanceOf(DoNothingCommand.class)));
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
		assertThat(command, is(instanceOf(DoNothingCommand.class)));
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
		assertThat(command, is(instanceOf(PlaceCommand.class)));
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
		assertThat(command, is(instanceOf(MoveCommand.class)));
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
		assertThat(command, is(instanceOf(LeftCommand.class)));
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
		assertThat(command, is(instanceOf(RightCommand.class)));
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
		assertThat(command, is(instanceOf(ReportCommand.class)));
	}
	
	/**
	 * Given the testInstance
	 * When the closeInput method called
	 * Then the UserInterf close method should be called
	 */
	@Test
	public void whenCloseInputCalledThenCloseMehtodShouldCalled() {
		//Given
		UserInput mockUserInput = Mockito.mock(UserInput.class);
		defaultCommandFactory = new DefaultCommandFactory(mockUserInput);
		//When
		defaultCommandFactory.closeInput();
		//Then
		verify(mockUserInput).close();
	}
}
