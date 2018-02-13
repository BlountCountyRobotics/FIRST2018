package org.usfirst.frc.team4504.robot.commands;

import org.omg.PortableInterceptor.ObjectIdHelper;
import org.usfirst.frc.team4504.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class Shoot extends Command {

    public Shoot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.m_oi.getButtonBoard().getTopSwitch().get())
    	{
    		double input = Robot.m_oi.getButtonBoard().getLeftDialOutput();
    		input -= .5;
    		input *= 2; // go from (0.0, 1.0) to (-1.0, 1.0)
    		Robot.shooter.shoot(input);
    	}else
    	{
    		Robot.shooter.shoot();
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