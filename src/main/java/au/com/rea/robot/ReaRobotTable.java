package au.com.rea.robot;

import java.io.InputStream;
import java.util.Scanner;

import au.com.rea.robot.command.Command;
import au.com.rea.robot.command.CommandFactory;
import au.com.rea.robot.interf.RobotTable;
import au.com.rea.robot.model.Robot;

public class ReaRobotTable implements RobotTable {

	//Dimension Constants 
	private static final int MAX_X = 5;
	private static final int MAX_Y = 5;
	
	private Scanner scanner;
	private Robot robot;
	
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
				command.execute(this);
			}
		} finally {
			scanner.close();
			this.scanner = null;
		}
		
	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	@Override
	public int getMaxX() {
		return MAX_X;
	}

	@Override
	public int getMaxY() {
		return MAX_Y;
	}
	
	public static void main(String[] args) {
		ReaRobotTable  table = new ReaRobotTable();
		table.run();
	}
}
