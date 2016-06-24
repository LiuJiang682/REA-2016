package au.com.rea.robot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import au.com.rea.robot.command.Command;
import au.com.rea.robot.command.CommandFactory;
import au.com.rea.robot.command.DefaultCommandFactory;
import au.com.rea.robot.command.DoNothingCommand;
import au.com.rea.robot.fixture.InputStreamFixture;

/**
 * In order to use the robot
 * As a robot user
 * I want to place command and observe robot movements.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ReaRobotTable.class, DefaultCommandFactory.class})
public class ReaRobotTableTest {
	
	private Scanner mockScanner;
	
	private ReaRobotTable robotTable;
	private Command mockCommand;

	@Before
	public void setUp() {
		robotTable = null;
		mockScanner = null;
	}
	
	/**
	 * Given the user has login to PC
	 * When the user start the robot table
	 * Then the robot table should be ready to accept input
	 */
	@Test
	public void whenUserStartedTheRobotThenRobotShouldBeReadyForInput() {
		givenTheRobotTable();
		//When the robot table started
		CommandFactory commandFactory = robotTable.getCommandFactory();
		//Then the robot should be ready to accept input.
		assertNotNull(commandFactory);
	}
	
	/**
	 * Given the user provided a mock CommandFactory
	 * When the user start the robot table
	 * Then the robot table should ready to accept input
	 */
	@Test
	public void whenMockCommandFacotryProvidedThenRobotShouldBeReadyWithMockCommandFactory() {
		//Given the user provided a mock CommandFactory
		CommandFactory mockCommandFactory = PowerMockito.mock(CommandFactory.class);
		//When the robot table started
		ReaRobotTable robotTable = new ReaRobotTable(mockCommandFactory);
		//Then the robot table should reday with mock CommandFactory
		assertNotNull(robotTable.getCommandFactory());
		assertEquals(mockCommandFactory, robotTable.getCommandFactory());
	}
	
//	/**
//	 * Given the robot table started
//	 * When the user input a command
//	 * Then a command object should be return
//	 */
//	@Test
//	public void whenUserEnteredCommandThenCommandObjectShouldReturn() {
//		//Given the robot table and scanner
//		givenTheRobotTable();
//		givenMockByteArrayInputStreamScanner(StringInputFixture.getSingleLineString());
//	    
//	    //Given the CommandFactory class
//	    givenDoNothingCommand();
//	    PowerMockito.mockStatic(DefaultCommandFactory.class);
////	    PowerMockito.doReturn(mockCommand).when(CommandFactory.constructCommand(Matchers.anyString()));
//	    when(DefaultCommandFactory.constructCommand(Matchers.anyString())).thenReturn(mockCommand);
//	    
//		//When the user entered a command
//		Command command = robotTable.getNextCommand(mockScanner);
//		//Then a command object should return
//		assertNotNull(command);
//		assertEquals(mockCommand, command);
//		
//		PowerMockito.verifyStatic();
//		DefaultCommandFactory.constructCommand(Matchers.eq(StringInputFixture.TEST_DATA));
//	}

	/**
	 * Given the user entered a Ctrl-C
	 * When the robot table received the input inside the run method
	 * Then the robot table exit
	 * @throws Exception 
	 */
//	@Test
//	public void whenUserEnteredCtrlCThenExistRun() throws Exception {
//		//Given the robot table and mock scanner 
//		ReaRobotTable partialMockRobotTable = givenPartialMockRobotTable( "\u0003");
//		
//		assertNotNull(partialMockRobotTable.getScanner());
//		
//		//When the run method called
//		try {
//			partialMockRobotTable.run();
//		}
//		catch (NoSuchElementException e) {
//			accessNoLineFoundException(e);
//		}
//		//Then the run method should exist with scanner null
//		assertNull(partialMockRobotTable.getScanner());
//		
//	}

	
	
//	/**
//	 * Given the user enter correct command
//	 * When robot table runs
//	 * Then command has been executed
//	 * @throws Exception 
//	 */
//	@Test
//	public void whenUserEnteredCorrectCommandThenCommandShouldExecuted() throws Exception {
//		//Given the robot table and mock scanner 
//		ReaRobotTable partialMockRobotTable = givenPartialMockRobotTable(StringInputFixture.getTwoLineString());
//		this.mockCommand = PowerMockito.mock(Command.class);
//		PowerMockito.mockStatic(DefaultCommandFactory.class);
//		when(DefaultCommandFactory.constructCommand(Matchers.anyString())).thenReturn(mockCommand, null);
//		
//		//When the run method called
//		partialMockRobotTable.run();
//		
//		//Then the command should execute
//		verify(mockCommand, times(1)).execute(Matchers.any(RobotTable.class));
//	}

	private ReaRobotTable givenPartialMockRobotTable(final String input) throws Exception {
		ReaRobotTable partialMockRobotTable = PowerMockito.mock(ReaRobotTable.class);
		
		givenMockByteArrayInputStreamScanner(input);
		
		Whitebox.setInternalState(partialMockRobotTable, "scanner", mockScanner);
		PowerMockito.doCallRealMethod().when(partialMockRobotTable, "run");
		PowerMockito.doCallRealMethod().when(partialMockRobotTable, "getNextCommand", Matchers.any(Scanner.class));
		PowerMockito.doCallRealMethod().when(partialMockRobotTable, "getScanner");
		return partialMockRobotTable;
	}
	

	private void givenDoNothingCommand() {
		mockCommand = new DoNothingCommand();
	}
	private void givenTheRobotTable() {
		robotTable = new ReaRobotTable();
	}
	
	private void givenMockByteArrayInputStreamScanner(String input) {
		InputStream in = InputStreamFixture.givenByteArrayInputStream(input);
	    System.setIn(in);
	    mockScanner = new Scanner(System.in);
	}
	
	private void accessNoLineFoundException(NoSuchElementException e) {
		String errorMessage = e.getMessage();
		assertNotNull(errorMessage);
		assertEquals("No line found", errorMessage);
	}
}
