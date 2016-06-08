package au.com.rea.robot.fixture;

import org.powermock.api.mockito.PowerMockito;

import au.com.rea.robot.interf.RobotTable;

public class RobotTableFixture {

	public static RobotTable givenMockRobotTable() {
		RobotTable mockRobotTable = PowerMockito.mock(RobotTable.class);
		return mockRobotTable;
	}

}
