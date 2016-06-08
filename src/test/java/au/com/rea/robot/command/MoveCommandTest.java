package au.com.rea.robot.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import au.com.rea.robot.ReaRobotTable;
import au.com.rea.robot.fixture.RobotFixture;
import au.com.rea.robot.fixture.RobotTableFixture;
import au.com.rea.robot.interf.RobotTable;
import au.com.rea.robot.model.Robot;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ReaRobotTable.class})
public class MoveCommandTest {

	private MoveCommand command;
	private RobotTable mockRobotTable;
	private Robot robot;
	
	@Before
	public void setUp() {
		this.command = new MoveCommand();
		this.mockRobotTable = RobotTableFixture.givenMockRobotTable();
		this.robot = RobotFixture.givenRobot();
	}
	
	@After
	public void tearDown() {
		this.command = null;
		this.mockRobotTable = null;
		this.robot = null;
	}
	
	/**
	 * Given the robot is null
	 * When the execute method call
	 * Then nothing changed.
	 */
	@Test
	public void whenRobotIsNullThenNothingChange() {
		//When the execute method called
		this.command.execute(mockRobotTable);
		//Then noting change
		assertNull(mockRobotTable.getRobot());
	}
	
	/**
	 * Given the robot east facing and robot's X axle is 5
	 * When the isLegitimateMove method is call
	 * Then false should return false
	 */
	@Test
	public void whenEastFacingNXis5ThenReturnFalse() {
		//Given the robot is East and X is 5
		robot.setFacing(Directions.EAST);
		robot.setX(5);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		when(mockRobotTable.getMaxX()).thenReturn(5);
		//When the execute method called
		boolean flag = this.command.isLegitimateMove(mockRobotTable);
		//Then the flag should be false
		assertFalse(flag);
	}
	
	/**
	 * Given the robot east facing and robot's X axle is 4
	 * When the isLegitimateMove method is call
	 * Then false should return true
	 */
	@Test
	public void whenEastFacingNXis4ThenReturnTrue() {
		//Given the robot is East and X is 4
		robot.setFacing(Directions.EAST);
		robot.setX(4);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		when(mockRobotTable.getMaxX()).thenReturn(5);
		//When the execute method called
		boolean flag = this.command.isLegitimateMove(mockRobotTable);
		//Then the flag should be false
		assertTrue(flag);
	}
	
	/**
	 * Given the robot north facing and robot's Y axle is 5
	 * When the isLegitimateMove method is call
	 * Then false should return false
	 */
	@Test
	public void whenNorthFacingNYis5ThenReturnFalse() {
		//Given the robot is North and Y is 5
		robot.setFacing(Directions.EAST);
		robot.setY(5);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		when(mockRobotTable.getMaxY()).thenReturn(5);
		//When the execute method called
		boolean flag = this.command.isLegitimateMove(mockRobotTable);
		//Then the flag should be false
		assertFalse(flag);
	}
	
	/**
	 * Given the robot north facing and robot's Y axle is 4
	 * When the isLegitimateMove method is call
	 * Then false should return true
	 */
	@Test
	public void whenNorthFacingNXis4ThenReturnTrue() {
		//Given the robot is North and Y is 4
		robot.setFacing(Directions.NORTH);
		robot.setY(4);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		when(mockRobotTable.getMaxY()).thenReturn(5);
		//When the execute method called
		boolean flag = this.command.isLegitimateMove(mockRobotTable);
		//Then the flag should be false
		assertTrue(flag);
	}
	
	/**
	 * Given the robot West facing and robot's X axle is 0
	 * When the isLegitimateMove method is call
	 * Then false should return false
	 */
	@Test
	public void whenWestFacingNXisZeroThenReturnFalse() {
		//Given the robot is West and X is 0
		robot.setFacing(Directions.WEST);
		robot.setX(0);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		
		//When the execute method called
		boolean flag = this.command.isLegitimateMove(mockRobotTable);
		//Then the flag should be false
		assertFalse(flag);
	}
	
	/**
	 * Given the robot west facing and robot's X axle is 1
	 * When the isLegitimateMove method is call
	 * Then false should return true
	 */
	@Test
	public void whenWestFacingNXis1ThenReturnTrue() {
		//Given the robot is East and X is 4
		robot.setFacing(Directions.WEST);
		robot.setX(1);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		
		//When the execute method called
		boolean flag = this.command.isLegitimateMove(mockRobotTable);
		//Then the flag should be false
		assertTrue(flag);
	}
	
	/**
	 * Given the robot south facing and robot's Y axle is 0
	 * When the isLegitimateMove method is call
	 * Then false should return false
	 */
	@Test
	public void whenSouthFacingNYis0ThenReturnFalse() {
		//Given the robot is North and Y is 5
		robot.setFacing(Directions.SOUTH);
		robot.setY(0);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		
		//When the execute method called
		boolean flag = this.command.isLegitimateMove(mockRobotTable);
		//Then the flag should be false
		assertFalse(flag);
	}
	
	/**
	 * Given the robot south facing and robot's Y axle is 1
	 * When the isLegitimateMove method is call
	 * Then false should return true
	 */
	@Test
	public void whenSouthFacingNXis1ThenReturnTrue() {
		//Given the robot is South and Y is 0
		robot.setFacing(Directions.SOUTH);
		robot.setY(1);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		
		//When the execute method called
		boolean flag = this.command.isLegitimateMove(mockRobotTable);
		//Then the flag should be false
		assertTrue(flag);
	}
	
	/**
	 * Given the robot east facing
	 * When the moveRobot method is call
	 * The the X axle should increase by one
	 */
	@Test
	public void whenEastFacingThenXShouldIncreaseByOne() {
		//Given the robot is North and Y is 5
		robot.setFacing(Directions.EAST);
		robot.setX(2);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		
		//When the moveRobot method is called
		this.command.moveRobot(robot);
		
		//Then the X axle should increase by 1.
		assertTrue(3 == robot.getX());
	}
	
	/**
	 * Given the robot north facing
	 * When the moveRobot method is call
	 * The the Y axle should increase by one
	 */
	@Test
	public void whenNorthFacingThenYShouldIncreaseByOne() {
		//Given the robot is North and Y is 2
		robot.setFacing(Directions.NORTH);
		robot.setY(2);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		
		//When the moveRobot method is called
		this.command.moveRobot(robot);
		
		//Then the Y axle should increase by 1.
		assertTrue(3 == robot.getY());
	}
	
	/**
	 * Given the robot west facing
	 * When the moveRobot method is call
	 * The the X axle should decrease by one
	 */
	@Test
	public void whenWestFacingThenXShouldDecreaseByOne() {
		//Given the robot is West and x is 2
		robot.setFacing(Directions.WEST);
		robot.setX(2);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		
		//When the moveRobot method is called
		this.command.moveRobot(robot);
		
		//Then the X axle should decrease by 1.
		assertTrue(1 == robot.getX());
	}
	
	/**
	 * Given the robot south facing
	 * When the moveRobot method is call
	 * The the Y axle should decrease by one
	 */
	@Test
	public void whenSouthFacingThenYShouldDecreaseByOne() {
		//Given the robot is South and Y is 2
		robot.setFacing(Directions.SOUTH);
		robot.setY(2);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		
		//When the moveRobot method is called
		this.command.moveRobot(robot);
		
		//Then the Y axle should decrease by 1.
		assertTrue(1 == robot.getY());
	}
	
	/**
	 * Given the robot is on the table and the move is legal
	 * When the execute method called
	 * Then the robot is moved
	 */
	@Test
	public void whenEastFaceNX1ThenMoveEastByOne() {
		//Given the robot is South and X is 2
		robot.setFacing(Directions.EAST);
		robot.setX(2);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		when(mockRobotTable.getMaxX()).thenReturn(5);
		
		//When the execute method is called
		this.command.execute(mockRobotTable);
		
		//Then the robot move towards east by one
		assertTrue(3 == robot.getX());
		assertEquals(Directions.EAST, robot.getFacing());
	}
	
	/**
	 * Given the robot is on the table and the move is legal
	 * When the execute method called
	 * Then the robot is moved
	 */
	@Test
	public void whenEastFaceNX5ThenNoMove() {
		//Given the robot is South and X is 5
		robot.setFacing(Directions.EAST);
		robot.setX(5);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		when(mockRobotTable.getMaxX()).thenReturn(5);
		
		//When the execute method is called
		this.command.execute(mockRobotTable);
		
		//Then the robot move towards east by one
		assertTrue(5 == robot.getX());
		assertEquals(Directions.EAST, robot.getFacing());
	}
}
