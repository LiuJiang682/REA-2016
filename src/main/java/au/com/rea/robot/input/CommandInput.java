package au.com.rea.robot.input;

import java.io.InputStream;
import java.util.Scanner;

public class CommandInput implements InputInterf {

	private Scanner scanner;
	
	public CommandInput() {
		this(System.in);
	}
	
	public CommandInput(InputStream in) {
		this.scanner = new Scanner(in);
	}

	@Override
	public String getNextLine() {
		// TODO Auto-generated method stub
		return null;
	}

	public Scanner getScanner() {
		return this.scanner;
	}

}
