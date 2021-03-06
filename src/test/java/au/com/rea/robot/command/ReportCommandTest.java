package au.com.rea.robot.command;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import au.com.rea.robot.fixture.RobotFixture;
import au.com.rea.robot.fixture.RobotTableFixture;
import au.com.rea.robot.interf.RobotTable;
import au.com.rea.robot.model.Robot;

/**
 * Tests for PlaceCommand class.
 *
 */
public class ReportCommandTest {

	// Given the robot is NOT on the table
	// When the execute method called
	// Then nothing happen
	@Test
	public void whenNoRobotOnTableThenReportCommandDoNothing() {
		// Given the robot is NOT on the table
		ReportCommand command = new ReportCommand();
		RobotTable mockTable = RobotTableFixture.givenMockRobotTable();
		ByteArrayOutputStream baos = givenOutputStream();
		// When the execute method is called
		command.execute(mockTable);
		// Then nothing happen
		String content = new String(baos.toByteArray(), StandardCharsets.UTF_8);
		assertThat(StringUtils.isBlank(content), is(true));
	}

	// Given the robot is on the table
	// When the execute method called
	// Then report the robot position
	@Test
	public void whenRobotOnTableThenReportCommandDoNothing() {
		// Given the robot is NOT on the table
		ReportCommand command = new ReportCommand();
		RobotTable mockTable = RobotTableFixture.givenMockRobotTable();
		Robot robot = RobotFixture.givenRobot();
		robot.setX(1);
		robot.setY(2);
		robot.setFacing(Directions.NORTH);
		when(mockTable.getRobot()).thenReturn(robot);
		
		ByteArrayOutputStream baos = givenOutputStream();
		// When the execute method is called
		command.execute(mockTable);
		// Then nothing happen
		String content = new String(baos.toByteArray(), StandardCharsets.UTF_8);
		assertThat(content, is(equalTo("1, 2, NORTH\n")));
	}

	private ByteArrayOutputStream givenOutputStream() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		return baos;
	}
}
