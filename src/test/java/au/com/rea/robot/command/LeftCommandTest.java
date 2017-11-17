package au.com.rea.robot.command;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import au.com.rea.robot.fixture.RobotFixture;
import au.com.rea.robot.fixture.RobotTableFixture;
import au.com.rea.robot.interf.RobotTable;
import au.com.rea.robot.model.Robot;


public class LeftCommandTest {

	private LeftCommand command;
	private RobotTable mockRobotTable;
	private Robot robot;
	
	@Before
	public void setUp() {
		this.command = new LeftCommand();
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
	 * When the left command executed
	 * Then No thing change
	 */
	@Test
	public void whenRobotIsNullThenNothingChange() {
		//Given the robot is NOT on the table
		//When the execute method called
		this.command.execute(mockRobotTable);
		//Then noting change
		assertThat(mockRobotTable.getRobot(), is(nullValue()));
	}
	
	/**
	 * Given the robot is facing East
	 * When the left command executed
	 * Then the robot should facing North
	 */
	@Test
	public void whenRobotIsEastThenShouldFacingNorth() {
		//Given the robot is East
		robot.setFacing(Directions.EAST);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		//When the execute method called
		this.command.execute(mockRobotTable);
		//Then facing should be North
		assertThat(robot.getFacing(), is(equalTo(Directions.NORTH)));
	}
	
	/**
	 * Given the robot is facing North
	 * When the left command executed
	 * Then the robot should facing West
	 */
	@Test
	public void whenRobotIsNorthThenShouldFacingWest() {
		//Given the robot is North
		robot.setFacing(Directions.NORTH);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		//When the execute method called
		this.command.execute(mockRobotTable);
		//Then facing should be West
		assertThat(robot.getFacing(), is(equalTo(Directions.WEST)));
	}
	
	/**
	 * Given the robot is facing West
	 * When the left command executed
	 * Then the robot should facing South
	 */
	@Test
	public void whenRobotIsWestThenShouldFacingSouth() {
		//Given the robot is West
		robot.setFacing(Directions.WEST);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		//When the execute method called
		this.command.execute(mockRobotTable);
		//Then facing should be South
		assertThat(robot.getFacing(), is(equalTo(Directions.SOUTH)));
	}
	
	/**
	 * Given the robot is facing South
	 * When the left command executed
	 * Then the robot should facing East
	 */
	@Test
	public void whenRobotIsSouthThenShouldFacingEast() {
		//Given the robot is South
		robot.setFacing(Directions.SOUTH);
		when(mockRobotTable.getRobot()).thenReturn(robot);
		//When the execute method called
		this.command.execute(mockRobotTable);
		//Then facing should be East
		assertThat(robot.getFacing(), is(equalTo(Directions.EAST)));
	}
}
