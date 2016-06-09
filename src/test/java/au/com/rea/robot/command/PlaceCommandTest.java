package au.com.rea.robot.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;

import au.com.rea.robot.fixture.RobotFixture;
import au.com.rea.robot.fixture.RobotTableFixture;
import au.com.rea.robot.interf.RobotTable;
import au.com.rea.robot.model.Robot;

/**
 * Tests for CommandFactory class.
 *
 */
public class PlaceCommandTest {

	/**
	 * Given the user enter a string
	 * When the constructor called
	 * Then a place command object should return
	 */
	@Test
	public void whenConstructorCalledThenPlaceCommandShouldReturn() {
		//Given the user enter the place string
		String param = "place";
		//When the constructor called
		PlaceCommand command = new PlaceCommand(param);
		assertNotNull(command);
		assertFalse(command.isValidCommand());
	}
	
	/**
	 * Given the user enter a string as "place a"
	 * When the constructor called
	 * Then a place command object should return with invalid flag
	 */
	@Test
	public void whenPlaceNAPassedThenPlaceCommandShouldReturn() {
		//Given the user enter the place string
		String param = "place a";
		//When the constructor called
		PlaceCommand command = new PlaceCommand(param);
		assertNotNull(command);
		assertFalse(command.isValidCommand());
	}
	
	/**
	 * Given the user enter a string as "place 1"
	 * When the constructor called
	 * Then a place command object should return with invalid flag
	 */
	@Test
	public void whenPlaceN1PassedThenPlaceCommandShouldReturn() {
		//Given the user enter the place string
		String param = "place 1";
		//When the constructor called
		PlaceCommand command = new PlaceCommand(param);
		assertNotNull(command);
		assertFalse(command.isValidCommand());
	}
	
	/**
	 * Given the user enter a string as "place a,b"
	 * When the constructor called
	 * Then a place command object should return with invalid flag
	 */
	@Test
	public void whenPlaceNANBPassedThenPlaceCommandShouldReturn() {
		//Given the user enter the place string
		String param = "place a,b";
		//When the constructor called
		PlaceCommand command = new PlaceCommand(param);
		assertNotNull(command);
		assertFalse(command.isValidCommand());
	}
	
	/**
	 * Given the user enter a string as "place 1,1"
	 * When the constructor called
	 * Then a place command object should return with invalid flag
	 */
	@Test
	public void whenPlaceN1N1PassedThenPlaceCommandShouldReturn() {
		//Given the user enter the place string
		String param = "place 1,1";
		//When the constructor called
		PlaceCommand command = new PlaceCommand(param);
		assertNotNull(command);
		assertFalse(command.isValidCommand());
	}
	
	/**
	 * Given the user enter a string as "place 1,B"
	 * When the constructor called
	 * Then a place command object should return with invalid flag
	 */
	@Test
	public void whenPlaceN1NBPassedThenPlaceCommandShouldReturn() {
		//Given the user enter the place string
		String param = "place 1,B";
		//When the constructor called
		PlaceCommand command = new PlaceCommand(param);
		assertNotNull(command);
		assertFalse(command.isValidCommand());
	}
	
	/**
	 * Given the user enter a string as "place a,b,c"
	 * When the constructor called
	 * Then a place command object should return with invalid flag
	 */
	@Test
	public void whenPlaceNANBNCPassedThenPlaceCommandShouldReturn() {
		//Given the user enter the place string
		String param = "place a,b,c";
		//When the constructor called
		PlaceCommand command = new PlaceCommand(param);
		assertNotNull(command);
		assertFalse(command.isValidCommand());
	}
	
	/**
	 * Given the user enter a string as "place 1,B,c"
	 * When the constructor called
	 * Then a place command object should return with invalid flag
	 */
	@Test
	public void whenPlaceN1NBNCPassedThenPlaceCommandShouldReturn() {
		//Given the user enter the place string
		String param = "place 1,B,c";
		//When the constructor called
		PlaceCommand command = new PlaceCommand(param);
		assertNotNull(command);
		assertFalse(command.isValidCommand());
	}
	
	/**
	 * Given the user enter a string as "place 1,1,c"
	 * When the constructor called
	 * Then a place command object should return with invalid flag
	 */
	@Test
	public void whenPlaceN1N1NCPassedThenPlaceCommandShouldReturn() {
		//Given the user enter the place string
		String param = "place 1,1,c";
		//When the constructor called
		PlaceCommand command = new PlaceCommand(param);
		assertNotNull(command);
		assertFalse(command.isValidCommand());
	}
	
	/**
	 * Given the user enter a correct string
	 * When the constructor called
	 * Then a place command object should return with valid set to true
	 */
	@Test
	public void whenCorrectStringPassedThenPlaceCommandShouldReturn() {
		//Given the user enter the place string
		String param = "place 3, 5, north";
		givenCorrectCommand(param);
	}
	
	/**
	 * Given the user enter an incorrect command
	 * When the execute method called
	 * Then no thing will happen
	 */
	@Test
	public void whenInCorrectCommandEnteredThenNothingWillExecute() {
		//Given the user enter an incorrect command
		String commandString = "place 3, 7, abc";
		PlaceCommand command = new PlaceCommand(commandString);
		assertNotNull(command);
		assertFalse(command.isValidCommand());
		RobotTable mockRobotTable = RobotTableFixture.givenMockRobotTable();
		
		//When the execute method called
		command.execute(mockRobotTable);
		
		//Then nothing will happen
		verify(mockRobotTable, times(0)).setRobot(Matchers.any(Robot.class));
	}
	
	/**
	 * Given the user enter an correct command
	 * When the execute method called
	 * Then robot will be updated
	 */
	@Test
	public void whenCorrectCommandEnteredThenRobotUpdated() {
		//Given the user enter an incorrect command
		String commandString = "place 3,5, North";
		PlaceCommand command = givenCorrectCommand(commandString);
		RobotTable mockRobotTable = RobotTableFixture.givenMockRobotTable();
		givenCorrectDimesions(mockRobotTable);
		
		//When the execute method called
		command.execute(mockRobotTable);
		
		//Then robot updated
		ArgumentCaptor<Robot> robotCaptor = ArgumentCaptor.forClass(Robot.class);
		verify(mockRobotTable).setRobot(robotCaptor.capture());
		Robot capturedRobot = robotCaptor.getValue();
		assessRobot(capturedRobot);
	}
	
	/**
	 * Given the user enter an correct command in existing robot
	 * When the execute method called
	 * Then robot will be updated
	 */
	@Test
	public void whenCorrectCommandEnteredExistingRobotThenRobotUpdated() {
		//Given the user enter an incorrect command
		String commandString = "place 3,5, North";
		PlaceCommand command = givenCorrectCommand(commandString);
		RobotTable mockRobotTable = RobotTableFixture.givenMockRobotTable();
		givenCorrectDimesions(mockRobotTable);
		Robot robot = RobotFixture.givenRobot();
		robot.setX(4);
		robot.setY(4);
		robot.setFacing(Directions.EAST);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		
		//When the execute method called
		command.execute(mockRobotTable);
		
		//Then robot updated.
		assessRobot(robot);
	}

	
	
	/**
	 * Given the user enter a correct command
	 * When the isLegitimateMove method called
	 * Then return True
	 */
	@Test
	public void whenCorrectCommandEnteredThenIsLegitimateMoveShouldReturnTrue() {
		//Given the user enter an correct command
		String commandString = "place 3, 3, North";
		PlaceCommand command = givenCorrectCommand(commandString);
		RobotTable mockRobotTable = RobotTableFixture.givenMockRobotTable();
		givenCorrectDimesions(mockRobotTable);
		//When the isLegitimateMove called
		boolean flag = command.isLegitimateMove(mockRobotTable);
		//Then the flag should be true
		assertTrue(flag);
	}

	/**
	 * Given the user enter a incorrect command
	 * When the isLegitimateMove method called
	 * Then return false
	 */
	@Test
	public void whenInCorrectXEnteredThenIsLegitimateMoveShouldReturnFalse() {
		//Given the user enter an incorrect command
		String commandString = "place 7, 3, North";
		PlaceCommand command = givenCorrectCommand(commandString);
		RobotTable mockRobotTable = RobotTableFixture.givenMockRobotTable();
		givenCorrectDimesions(mockRobotTable);
		//When the isLegitimateMove called
		boolean flag = command.isLegitimateMove(mockRobotTable);
		//Then the flag should be true
		assertFalse(flag);
	}
	
	/**
	 * Given the user enter a incorrect command on Y axle
	 * When the isLegitimateMove method called
	 * Then return false
	 */
	@Test
	public void whenInCorrectYEnteredThenIsLegitimateMoveShouldReturnFalse() {
		//Given the user enter an incorrect command
		String commandString = "place 3, 7, North";
		PlaceCommand command = givenCorrectCommand(commandString);
		RobotTable mockRobotTable = RobotTableFixture.givenMockRobotTable();
		givenCorrectDimesions(mockRobotTable);
		//When the isLegitimateMove called
		boolean flag = command.isLegitimateMove(mockRobotTable);
		//Then the flag should be true
		assertFalse(flag);
	}
	
	/**
	 * Given the user enter a incorrect command on X axle and Y axle
	 * When the isLegitimateMove method called
	 * Then return false
	 */
	@Test
	public void whenInCorrectXYEnteredThenIsLegitimateMoveShouldReturnFalse() {
		//Given the user enter an incorrect command
		String commandString = "place 7, 7, North";
		PlaceCommand command = givenCorrectCommand(commandString);
		RobotTable mockRobotTable = RobotTableFixture.givenMockRobotTable();
		givenCorrectDimesions(mockRobotTable);
		//When the isLegitimateMove called
		boolean flag = command.isLegitimateMove(mockRobotTable);
		//Then the flag should be true
		assertFalse(flag);
	}
	
	private PlaceCommand givenCorrectCommand(String commandString) {
		PlaceCommand command = new PlaceCommand(commandString);
		assertNotNull(command);
		assertTrue(command.isValidCommand());
		return command;
	}
	
	private void givenCorrectDimesions(RobotTable mockRobotTable) {
		when(mockRobotTable.getMaxX()).thenReturn(5);
		when(mockRobotTable.getMaxY()).thenReturn(5);
	}
	
	private void assessRobot(Robot capturedRobot) {
		assertNotNull(capturedRobot);
		assertTrue(3 == capturedRobot.getX());
		assertTrue(5 == capturedRobot.getY());
		assertEquals(Directions.NORTH, capturedRobot.getFacing());
	}
}
