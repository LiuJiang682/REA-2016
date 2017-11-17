package au.com.rea.robot.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.Test;

import au.com.rea.robot.fixture.InputStreamFixture;
import au.com.rea.robot.fixture.StringInputFixture;

/**
 * Test class for UserInput class
 */
public class UserInputTest {

	private UserInput UserInput;

	//Given the user can access to the UserInput class
	//When the user called the default constructor
	//Then Scanner object should be exit
	@Test
	public void whenDefaultConstructorCalledThenScannerShouldExist() {
		//Given the user can access the UserInput class
		//When the default constructor called
		UserInput input = new UserInput();
		//Then the scanner should exist
		assertNotNull(input);
		assertNotNull(input.getScanner());
	}
	
	/**
	 * Given the InputStream to UserInput
	 * When the user called the real constructor
	 * Then the Command should be accept input from provided InputStream
	 */
	@Test
	public void whenByteArryInputStreamProvideThenRobotTableShouldAcceptInput() {
		//Given the byte array input stream
		InputStream in = InputStreamFixture.givenByteArrayInputStream(StringInputFixture.getSingleLineString());
		//When the constructor called
		this.UserInput = new UserInput(in);
		//Then the robot table should be accept input
		Scanner scanner = this.UserInput.getScanner();
		assertNotNull(scanner);
		assertEquals(StringInputFixture.TEST_DATA, scanner.nextLine());
		try {
			scanner.nextLine();
			fail("program reached unexpected point!");
		}
		catch (NoSuchElementException e) {
			accessNoLineFoundException(e);
		}
	}
	
	private void accessNoLineFoundException(NoSuchElementException e) {
		String errorMessage = e.getMessage();
		assertNotNull(errorMessage);
		assertEquals("No line found", errorMessage);
	}
}
