package au.com.rea.robot.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
public class RigthCommandTest {

	private RightCommand command;
	private RobotTable mockRobotTable;
	private Robot robot;
	
	@Before
	public void setUp() {
		this.command = new RightCommand();
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
	 * When the Right command executed
	 * Then No thing change
	 */
	@Test
	public void whenRobotIsNullThenNothingChange() {
		//When the execute method called
		this.command.execute(mockRobotTable);
		//Then noting change
		assertNull(mockRobotTable.getRobot());
	}
	
	/**
	 * Given the robot is facing East
	 * When the Right command executed
	 * Then the robot should facing South
	 */
	@Test
	public void whenRobotIsEastThenShouldFacingSouth() {
		//Given the robot is East
		robot.setFacing(Directions.EAST);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		//When the execute method called
		this.command.execute(mockRobotTable);
		//Then facing should be North
		assertEquals(Directions.SOUTH, robot.getFacing());
	}
	
	/**
	 * Given the robot is facing South
	 * When the Right command executed
	 * Then the robot should facing West
	 */
	@Test
	public void whenRobotIsSouthThenShouldFacingWest() {
		//Given the robot is North
		robot.setFacing(Directions.SOUTH);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		//When the execute method called
		this.command.execute(mockRobotTable);
		//Then facing should be West
		assertEquals(Directions.WEST, robot.getFacing());
	}
	
	/**
	 * Given the robot is facing West
	 * When the Right command executed
	 * Then the robot should facing North
	 */
	@Test
	public void whenRobotIsWestThenShouldFacingNoth() {
		//Given the robot is West
		robot.setFacing(Directions.WEST);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		//When the execute method called
		this.command.execute(mockRobotTable);
		//Then facing should be Noth
		assertEquals(Directions.NORTH, robot.getFacing());
	}
	
	/**
	 * Given the robot is facing North
	 * When the Right command executed
	 * Then the robot should facing East
	 */
	@Test
	public void whenRobotIsNorthThenShouldFacingEast() {
		//Given the robot is South
		robot.setFacing(Directions.NORTH);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		//When the execute method called
		this.command.execute(mockRobotTable);
		//Then facing should be East
		assertEquals(Directions.EAST, robot.getFacing());
	}
}