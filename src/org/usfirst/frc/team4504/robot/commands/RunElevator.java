package org.usfirst.frc.team4504.robot.commands;

import org.usfirst.frc.team4504.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunElevator extends Command {

    public RunElevator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double input = Robot.oi.getButtonBoard().getRightDialOutput();
    	if(Robot.oi.changeElevatorDirection.get())
    	{
    		input *= -1;
    	}
    	
    	if(Robot.oi.elevatorSt1.get())
    	{
	    	Robot.elevator.setStageOne(input);
    	}
    	if(Robot.oi.elevatorSt2.get())
    	{
    		Robot.elevator.setStageTwo(input);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
