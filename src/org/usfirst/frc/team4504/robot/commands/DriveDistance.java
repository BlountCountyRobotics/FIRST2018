package org.usfirst.frc.team4504.robot.commands;

import org.usfirst.frc.team4504.robot.Robot;
import org.usfirst.frc.team4504.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {

	double inches;
	
    public DriveDistance(double inches) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	this.inches = inches;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetPosition(); // make sure the encoder says it is at 0 when it starts
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.driveDistance(inches);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.hasDrivenToPosition(inches);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
