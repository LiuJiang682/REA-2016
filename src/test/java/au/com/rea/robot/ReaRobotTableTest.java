package au.com.rea.robot;

import static org.junit.Assert.assertNotNull;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import au.com.rea.robot.command.Command;

/**
 * In order to use the robot
 * As a robot user
 * I want to place command and observe robot movements.
 */
public class ReaRobotTableTest {

	private ReaRobotTable robotTable;

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
		Scanner mockScanner = PowerMockito.mock(Scanner.class);
		PowerMockito.doReturn("move").when(mockScanner.nextLine());
		//When the user entered a command
		Command command = robotTable.getNextCommand(mockScanner);
		//Then a command object should return
		assertNotNull(command);
	}

	private void givenTheRobotTable() {
		robotTable = new ReaRobotTable();
	}
}
