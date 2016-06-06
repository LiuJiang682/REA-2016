package au.com.rea.robot;

import java.util.Scanner;

import au.com.rea.robot.command.Command;
import au.com.rea.robot.command.CommandFactory;

public class ReaRobotTable {

	public static void main(String[] args) {
		

	}

	public Scanner getScanner() {
		Scanner scanner = new Scanner(System.in);
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

}
