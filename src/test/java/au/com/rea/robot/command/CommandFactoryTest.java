package au.com.rea.robot.command;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Tests for CommandFactory class.
 *
 */
public class CommandFactoryTest {

	/**
	 * Given the user enter null string
	 * When the constructCommand method called
	 * Then a command object should return
	 */
	@Test
	public void whenUserEnterNullThenACommandObjectShouldReturn() {
		//Given user entered null
		String userEntered = null;
		//When the constructCommand called
		Command command = CommandFactory.constructCommand(userEntered);
		//Then the a DoNothing command object should return
		assertNotNull(command);
		
	}
}
