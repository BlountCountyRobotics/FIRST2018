package org.usfirst.frc.team4504.robot.commands;

import org.usfirst.frc.team4504.robot.Robot;
import org.usfirst.frc.team4504.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnToAngle extends Command implements PIDOutput {

	PIDController turnController;
	boolean resetGyro = false;
	
    public TurnToAngle(double angle, boolean resetGyro) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	turnController = new PIDController(RobotMap.DriveTrain.turnKp, RobotMap.DriveTrain.turnKi, 
    			RobotMap.DriveTrain.turnKd, Robot.ahrs, this);
    	turnController.setAbsoluteTolerance(RobotMap.DriveTrain.turnError);
    	turnController.setInputRange(-180.0, 180.0);
    	turnController.setOutputRange(-0.3, 0.3); // not -1 to 1 because it's too fast
    	turnController.setContinuous(); // makes the controller know -181deg = 179deg
    	this.resetGyro = resetGyro;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	turnController.enable();
    	if(resetGyro)
    	{
    		Robot.ahrs.reset();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		boolean isRobotStillMoving = Robot.driveTrain.getLeftFrontTalon().getSelectedSensorVelocity(0) > RobotMap.DriveTrain.distanceMinSpeed
				&& Robot.driveTrain.getRightFrontTalon().getSelectedSensorVelocity(0) > RobotMap.DriveTrain.distanceMinSpeed;
			
		/*
		 * The robot has reached its position once
		 * it has finished turning and the robot
		 * is no longer moving
		 */
				
		return turnController.onTarget() && !isRobotStillMoving;    
	}

    // Called once after isFinished returns true
    protected void end() {
    	turnController.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	turnController.disable();
    }

	@Override
	public void pidWrite(double output) {
		Robot.driveTrain.percentRPMDrive(output, -output);
	}
}
