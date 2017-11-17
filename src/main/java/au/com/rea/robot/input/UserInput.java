package au.com.rea.robot.input;

import java.io.InputStream;
import java.util.Scanner;

public class UserInput implements InputInterf {

	private Scanner scanner;
	
	public UserInput() {
		this(System.in);
	}
	
	public UserInput(InputStream in) {
		this.scanner = new Scanner(in);
	}

	@Override
	public String getNextLine() {
		return scanner.nextLine();
	}

	public Scanner getScanner() {
		return this.scanner;
	}

}
