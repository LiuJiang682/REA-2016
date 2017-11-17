package au.com.rea.robot;

import au.com.rea.robot.command.Command;
import au.com.rea.robot.command.CommandFactory;
import au.com.rea.robot.command.DefaultCommandFactory;
import au.com.rea.robot.interf.RobotTable;
import au.com.rea.robot.model.Robot;

/**
 * This is the main class for REA robot simulator. It accept user
 * input command and execute it accordingly. It accept the following
 * commands:
 * 
 * 	PLACE X,Y.F
 *  MOVE
 *  LEFT
 *  RIGHT
 *  REPORT
 *  
 * Any other input will be ignore.
 */
public class ReaRobotTable implements RobotTable {

	//Dimension Constants 
	private static final int MAX_X = 5;
	private static final int MAX_Y = 5;
	
	private Robot robot;
	private CommandFactory commandFactory;
	
	//Default constructor
	public ReaRobotTable() {
		this(new DefaultCommandFactory());
	}
	
	//Real constructor
	public ReaRobotTable(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}

	public CommandFactory getCommandFactory() {
		return this.commandFactory;
	}

	/**
	 * The method does all the work.
	 */
	public void run() {
		Command command = null;
		
		while ((command = commandFactory.getNextCommand()) != null) {
			command.execute(this);
		}
		
		commandFactory.closeInput();
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
