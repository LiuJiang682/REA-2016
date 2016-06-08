package au.com.rea.robot.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests for CommandFactory class.
 *
 */
public class CommandEnumTest {

	/**
	 * Given all combination of strings
	 * When the FormString method called
	 * Then correct command enum returns
	 */
	@Test
	public void whenStringProvidedThenCommandEnumReturn() {
		assertEquals(CommandEnum.DONOTHING, CommandEnum.fromString(null));
		assertEquals(CommandEnum.DONOTHING, CommandEnum.fromString(""));
		assertEquals(CommandEnum.DONOTHING, CommandEnum.fromString("abc"));
		
		assertEquals(CommandEnum.MOVE, CommandEnum.fromString("Move"));
		assertEquals(CommandEnum.LEFT, CommandEnum.fromString("LEFT"));
		assertEquals(CommandEnum.REPORT, CommandEnum.fromString("Report"));
		assertEquals(CommandEnum.RIGHT, CommandEnum.fromString("right"));
	}
	
	@Test
	public void whenPlaceStringEnteredThenPlaceCommandEnumReturn() {
		assertEquals(CommandEnum.PLACE, CommandEnum.fromString("place"));
		assertEquals(CommandEnum.PLACE, CommandEnum.fromString("PLACE 0,0,NORTH"));
	}
}
