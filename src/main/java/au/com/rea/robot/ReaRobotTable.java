package au.com.rea.robot;

import java.io.InputStream;
import java.util.Scanner;

import au.com.rea.robot.command.Command;
import au.com.rea.robot.command.CommandFactory;

public class ReaRobotTable {

	private Scanner scanner;
	
	//Default constructor
	public ReaRobotTable() {
		this(System.in);
	}
	
	//Real constructor
	public ReaRobotTable(final InputStream is) {
		scanner = new Scanner(is);
	}

	public Scanner getScanner() {
		return scanner;
	}

	public Command getNextCommand(Scanner scanner) {
		Command command = null;

		// User interactive mode
		System.out.println("Please enter your command: ");
		String userEntered = scanner.nextLine();
		command = CommandFactory.constructCommand(userEntered);

		return command;
	}

	public void run() {
		Command command = null;
		
		try {
			while ((command = getNextCommand(scanner)) != null) {
				command.execute();
			}
		} finally {
			scanner.close();
			this.scanner = null;
		}
		
	}

	public static void main(String[] args) {
		

	}
}
