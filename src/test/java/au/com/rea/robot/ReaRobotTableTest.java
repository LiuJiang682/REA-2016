package au.com.rea.robot;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import au.com.rea.robot.command.Command;
import au.com.rea.robot.command.CommandFactory;
import au.com.rea.robot.command.DefaultCommandFactory;
import au.com.rea.robot.interf.RobotTable;

/**
 * In order to use the robot
 * As a robot user
 * I want to place command and observe robot movements.
 */
public class ReaRobotTableTest {
	
	@Mock
	private DefaultCommandFactory mockDefaultCommandFactory;
	@Mock
	private Command mockCommand;
	
	private ReaRobotTable robotTable;
	

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		robotTable = null;
		
	}
	
	/**
	 * Given the user has login to PC
	 * When the user start the robot table
	 * Then the robot table should be ready to accept input
	 */
	@Test
	public void whenUserStartedTheRobotThenRobotShouldBeReadyForInput() {
		//Given
		robotTable = new ReaRobotTable();
		//When the robot table started
		CommandFactory commandFactory = robotTable.getCommandFactory();
		//Then the robot should be ready to accept input.
		assertThat(commandFactory, is(notNullValue()));
	}
	
	/**
	 * Given the user provided a mock CommandFactory
	 * When the user start the robot table
	 * Then the robot table should ready to accept input
	 */
	@Test
	public void whenMockCommandFacotryProvidedThenRobotShouldBeReadyWithMockCommandFactory() {
		//Given 
		//When the robot table started
		ReaRobotTable robotTable = new ReaRobotTable(mockDefaultCommandFactory);
		//Then the robot table should ready with mock CommandFactory
		assertThat(robotTable.getCommandFactory(), is(equalTo(mockDefaultCommandFactory)));
	}
	
	/**
	 * Given the robot table started
	 * When the user input a command
	 * Then a command object should be executed
	 */
	@Test
	public void whenUserEnteredCommandThenCommandObjectShouldExecuted() {
		//Given 
		robotTable = new ReaRobotTable(mockDefaultCommandFactory);
	    
	    when((mockDefaultCommandFactory)
	    		.getNextCommand()).thenReturn(mockCommand, 
	    				(Command)null);
	    
		//When 
		robotTable.run();
		
		//Then
		ArgumentCaptor<RobotTable> tableCaptor = ArgumentCaptor.forClass(RobotTable.class);
		verify(mockCommand).execute(tableCaptor.capture());
		assertThat(tableCaptor.getAllValues().size(), is(equalTo(1)));
	}

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

//	private ReaRobotTable givenPartialMockRobotTable(final String input) throws Exception {
//		ReaRobotTable partialMockRobotTable = PowerMockito.mock(ReaRobotTable.class);
//		
//		givenMockByteArrayInputStreamScanner(input);
//		
//		Whitebox.setInternalState(partialMockRobotTable, "scanner", mockScanner);
//		PowerMockito.doCallRealMethod().when(partialMockRobotTable, "run");
//		PowerMockito.doCallRealMethod().when(partialMockRobotTable, "getNextCommand", Matchers.any(Scanner.class));
//		PowerMockito.doCallRealMethod().when(partialMockRobotTable, "getScanner");
//		return partialMockRobotTable;
//	}
	

}
