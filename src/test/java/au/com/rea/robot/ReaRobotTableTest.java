package au.com.rea.robot;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import au.com.rea.robot.command.Command;
import au.com.rea.robot.command.CommandFactory;
import au.com.rea.robot.command.DoNothingCommand;

/**
 * In order to use the robot
 * As a robot user
 * I want to place command and observe robot movements.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ReaRobotTable.class, CommandFactory.class, Scanner.class})
public class ReaRobotTableTest {
	
	private Scanner mockScanner;
	
	private ReaRobotTable robotTable;
	private DoNothingCommand mockCommand;

	@Before
	public void setUp() {
		robotTable = null;
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
		Scanner scanner = robotTable.getScanner();
		//Then the robot should be ready to accept input.
		assertNotNull(scanner);
	}
	
	/**
	 * Given the robot table started
	 * When the user input a command
	 * Then a command object should be return
	 */
	@Test
	public void whenUserEnteredCommandThenCommandObjectShouldReturn() {
		//Given the robot table and scanner
		givenTheRobotTable();
		String input = "abc";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    mockScanner = new Scanner(System.in);
	    
	    //Given the CommandFactory class
	    givenDoNothingCommand();
	    PowerMockito.mockStatic(CommandFactory.class);
//	    PowerMockito.doReturn(mockCommand).when(CommandFactory.constructCommand(Matchers.anyString()));
	    when(CommandFactory.constructCommand(Matchers.anyString())).thenReturn(mockCommand);
	    
		//When the user entered a command
		Command command = robotTable.getNextCommand(mockScanner);
		//Then a command object should return
		assertNotNull(command);
		assertEquals(mockCommand, command);
		
		PowerMockito.verifyStatic();
		CommandFactory.constructCommand(Matchers.eq("abc"));
	}

	private void givenDoNothingCommand() {
		mockCommand = new DoNothingCommand();
	}
	private void givenTheRobotTable() {
		robotTable = new ReaRobotTable();
	}
}
