package au.com.rea.robot.command;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
		//When the constructor called
		PlaceCommand command = new PlaceCommand(param);
		assertNotNull(command);
		assertTrue(command.isValidCommand());
	}
}
