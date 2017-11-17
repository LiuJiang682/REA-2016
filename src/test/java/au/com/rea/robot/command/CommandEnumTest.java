package au.com.rea.robot.command;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Tests for CommandEnum class.
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
		assertThat(CommandEnum.fromString(null), is(equalTo(CommandEnum.DONOTHING)));
		assertThat(CommandEnum.fromString(""), is(equalTo(CommandEnum.DONOTHING)));
		assertThat(CommandEnum.fromString("abc"), is(equalTo(CommandEnum.DONOTHING)));
		
		assertThat(CommandEnum.fromString("Move"), is(equalTo(CommandEnum.MOVE)));
		assertThat(CommandEnum.fromString("LEFT"), is(equalTo(CommandEnum.LEFT)));
		assertThat(CommandEnum.fromString("Report"), is(equalTo(CommandEnum.REPORT)));
		assertThat(CommandEnum.fromString("right"), is(equalTo(CommandEnum.RIGHT)));
	}
	
	@Test
	public void whenPlaceStringEnteredThenPlaceCommandEnumReturn() {
		assertThat(CommandEnum.fromString("place"), is(equalTo(CommandEnum.PLACE)));
		assertThat(CommandEnum.fromString("PLACE 0,0,NORTH"),
				is(equalTo(CommandEnum.PLACE)));
	}
}
