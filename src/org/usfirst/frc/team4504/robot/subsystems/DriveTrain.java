package org.usfirst.frc.team4504.robot.subsystems;

import org.usfirst.frc.team4504.robot.RobotMap;
import org.usfirst.frc.team4504.robot.objects.BCRXboxController;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	TalonSRX leftFront;
	TalonSRX leftBack;
	TalonSRX rightFront;
	TalonSRX rightBack;
	
	public void driveWithXboxVoltage(BCRXboxController controller)
	{
		percentVoltageDrive(controller.getY(Hand.kLeft), 
				controller.getY(Hand.kRight));
	}
	
	public void driveWithXboxRPM(BCRXboxController controller)
	{
		percentVoltageDrive(controller.getY(Hand.kLeft), 
				controller.getY(Hand.kRight));
	}
	
	public void percentVoltageDrive(double left, double right)
	{	
		
		leftFront.set(ControlMode.PercentOutput, left);
		leftBack.set(ControlMode.PercentOutput, left);
		
		rightFront.set(ControlMode.PercentOutput, right);
		rightBack.set(ControlMode.PercentOutput, right);
	}
	
	public void percentRPMDrive(double left, double right)
	{
		double leftRPM = left * RobotMap.DriveTrain.maxRPM;
		double rightRPM = right * RobotMap.DriveTrain.maxRPM;
		
		rpmDrive(leftRPM, rightRPM);
	}
	
	public void rpmDrive(double leftRPM, double rightRPM)
	{
		leftRPM *= RobotMap.Constants.rpmConversion;
		rightRPM *= RobotMap.Constants.rpmConversion;

		leftFront.selectProfileSlot(RobotMap.DriveTrain.VelocityPIDSlot, 0);
		rightFront.selectProfileSlot(RobotMap.DriveTrain.VelocityPIDSlot, 0);
		
		leftBack.set(ControlMode.Follower, RobotMap.DriveTrain.leftFront);
		leftFront.set(ControlMode.Velocity, leftRPM);
		
		rightBack.set(ControlMode.Follower, RobotMap.DriveTrain.leftBack);
		rightFront.set(ControlMode.Velocity, rightRPM);
	}
	
	
	public void driveDistance(double inches)
	{
		double position = convertInchesToPosition(inches);
		
		leftFront.selectProfileSlot(RobotMap.DriveTrain.DistancePIDSlot, 0);
		rightFront.selectProfileSlot(RobotMap.DriveTrain.DistancePIDSlot, 0);

		
		leftBack.set(ControlMode.Follower, RobotMap.DriveTrain.leftFront);
		leftFront.set(ControlMode.Position, position);
		
		rightBack.set(ControlMode.Follower, RobotMap.DriveTrain.leftBack);
		rightFront.set(ControlMode.Position, position);
	}
	
	public void resetPosition()
	{
		int leftAbsolutePosition = leftFront.getSensorCollection().getPulseWidthPosition();
		leftFront.setSelectedSensorPosition(leftAbsolutePosition, RobotMap.DriveTrain.DistancePIDSlot, RobotMap.Constants.timeout);
		int rightAbsolutePosition = rightFront.getSensorCollection().getPulseWidthPosition();
		rightFront.setSelectedSensorPosition(rightAbsolutePosition, RobotMap.DriveTrain.DistancePIDSlot, RobotMap.Constants.timeout);
	}
	
	public double convertInchesToPosition(double inches)
	{
		double rotations = inches / (6.0 * Math.PI); // inches to rotations of the wheel
		return rotations * 4096.0; // rotations of the wheel to native units of the talon (see documentation)
	}
	
	public boolean hasDrivenToPosition(double inches)
	{
		double position = convertInchesToPosition(inches);

		boolean isLeftDone =  leftFront.getClosedLoopError(0) < position + RobotMap.DriveTrain.distanceError 
				&& leftFront.getClosedLoopError(0) > position - RobotMap.DriveTrain.distanceError;
				
		boolean isRightDone = rightFront.getClosedLoopError(0) < position + RobotMap.DriveTrain.distanceError 
				&& rightFront.getClosedLoopError(0) > position - RobotMap.DriveTrain.distanceError;
				
		boolean isRobotStillMoving = leftFront.getSelectedSensorVelocity(0) > RobotMap.DriveTrain.distanceMinSpeed
				&& rightFront.getSelectedSensorVelocity(0) > RobotMap.DriveTrain.distanceMinSpeed;
			
		/*
		 * The robot has reached its position once
		 * both sides have reached within bounds of
		 * their position and the robot is no longer
		 * moving significantly to maintain it.
		 */
		return isLeftDone && isRightDone && !isRobotStillMoving; 
	}
	
	public DriveTrain()
	{
		leftFront = new TalonSRX(RobotMap.DriveTrain.leftFront);
		rightFront = new TalonSRX(RobotMap.DriveTrain.rightFront);
		leftBack = new TalonSRX(RobotMap.DriveTrain.leftBack);
		rightBack = new TalonSRX(RobotMap.DriveTrain.rightBack);

		leftFront.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.Constants.timeout);
		rightFront.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.Constants.timeout);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

