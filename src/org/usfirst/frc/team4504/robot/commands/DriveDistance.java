package org.usfirst.frc.team4504.robot.commands;

import org.usfirst.frc.team4504.robot.Robot;
import org.usfirst.frc.team4504.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command implements PIDOutput {

	PIDController angleController;
	PIDController leftController;
	PIDController rightController;
	double inches;
	double position;
	double angleCorrection = 0.0;
	
	
	private class TalonEncoderSource implements PIDSource
	{
		TalonSRX talon;
	
		public TalonEncoderSource(TalonSRX talon)
		{
			super();
			this.talon = talon;
		}
		
		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
		}

		@Override
		public PIDSourceType getPIDSourceType() {
			return PIDSourceType.kDisplacement;
		}

		@Override
		public double pidGet() {
			return talon.getSensorCollection().getQuadraturePosition();
		}
		
	}
	
	private class TalonOutput implements PIDOutput
	{
		TalonSRX talon;
		TalonOutput(TalonSRX talon)
		{
			super();
			this.talon = talon;
		}
		
		@Override
		public void pidWrite(double output) {
			boolean isLeft = false;
			boolean isRight = false;
			if(talon.equals(Robot.driveTrain.getLeftFrontTalon()))
			{
				isLeft = true;
			}
			if(talon.equals(Robot.driveTrain.getRightFrontTalon()))
			{
				isRight = true;
			}
			
			
			if(angleCorrection > 0 && isRight)
			{
				output += angleCorrection;
			}else if(angleCorrection < 0 && isLeft)
			{
				output += angleCorrection;
			}
			
			if(isLeft)
			{
				Robot.driveTrain.percentRPMDriveLeft(output);
			}else if(isRight)
			{
				Robot.driveTrain.percentRPMDriveRight(output);
			}
		}
		
	}
	
    public DriveDistance(double inches) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	this.inches = inches;
    	this.position = inches * RobotMap.DriveTrain.inchToPosition;
    	angleController = new PIDController(RobotMap.DriveTrain.angleKp, RobotMap.DriveTrain.angleKi, RobotMap.DriveTrain.angleKd, 
    			Robot.ahrs, this);
    	leftController = new PIDController(RobotMap.DriveTrain.leftKp, RobotMap.DriveTrain.leftKi, RobotMap.DriveTrain.leftKd, 
    			new TalonEncoderSource(Robot.driveTrain.getLeftFrontTalon()), new TalonOutput(Robot.driveTrain.getLeftFrontTalon()));
    	rightController = new PIDController(RobotMap.DriveTrain.rightKp, RobotMap.DriveTrain.rightKi, RobotMap.DriveTrain.rightKd, 
    			new TalonEncoderSource(Robot.driveTrain.getRightFrontTalon()), new TalonOutput(Robot.driveTrain.getRightFrontTalon()));
    	leftController.setAbsoluteTolerance(RobotMap.DriveTrain.distanceError);
    	rightController.setAbsoluteTolerance(RobotMap.DriveTrain.distanceError);
    	angleController.setContinuous();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	angleController.setSetpoint(Robot.ahrs.getYaw()); // keep it at the same angle that it was
    	leftController.setSetpoint(position);
    	rightController.setSetpoint(position);
    	
    	leftController.setOutputRange(-.6, .6);
    	rightController.setOutputRange(-.6, .6);
    	
    	angleController.setOutputRange(-.1, .1);
    	
    	//reset encoders to state position as zero
		Robot.driveTrain.getLeftFrontTalon().getSensorCollection().setQuadraturePosition(0, RobotMap.Constants.timeout);
		Robot.driveTrain.getRightFrontTalon().getSensorCollection().setQuadraturePosition(0, RobotMap.Constants.timeout);
		
		leftController.enable();
		rightController.enable();
		angleController.enable();
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
		 * both sides have reached within bounds of
		 * their position and the robot has stopped 
		 * movement.
		 */
				
		return leftController.onTarget() && rightController.onTarget() && !isRobotStillMoving;
    }
    
    // Called once after isFinished returns true
    protected void end() {
    	leftController.disable();
    	rightController.disable();
    	angleController.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	leftController.disable();
    	rightController.disable();
    	angleController.disable();
    }

	@Override
	public void pidWrite(double output) {
		angleCorrection = output;
	}
}
