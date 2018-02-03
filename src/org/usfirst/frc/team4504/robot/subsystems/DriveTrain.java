package org.usfirst.frc.team4504.robot.subsystems;

import org.usfirst.frc.team4504.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.hal.ConstantsJNI;

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
	
	public void percentVoltageDrive(double left, double right)
	{
		if(!inputsAreValid(left, right))
		{
			left = 0.0;
			right = 0.0;
		}
		
		
		leftFront.set(ControlMode.PercentOutput, left);
		leftBack.set(ControlMode.PercentOutput, left);
		
		rightFront.set(ControlMode.PercentOutput, right);
		rightBack.set(ControlMode.PercentOutput, right);
	}
	
	public void percentRPMDrive(double left, double right)
	{
		if(!inputsAreValid(left, right))
		{
			left = 0.0;
			right = 0.0;
		}
		
		double leftRPM = left * RobotMap.DriveTrain.rpmConversion;
		double rightRPM = right * RobotMap.DriveTrain.rpmConversion;
		
		leftBack.set(ControlMode.Follower, RobotMap.DriveTrain.leftFront);
		leftFront.set(ControlMode.Velocity, leftRPM);
		
		rightBack.set(ControlMode.Follower, RobotMap.DriveTrain.leftBack);
		rightFront.set(ControlMode.Velocity, rightRPM);
	}
	
	private boolean inputsAreValid(double left, double right)
	{
		boolean violates = left > 1.0 || left < -1.0 || right > 1.0 || right < -1.0;
		
		if(violates)
		{
			System.err.println("* * * ERR: Attempted to send out of range output to motors. * * *");
		}
		return !violates;
	}
	
	DriveTrain()
	{
		leftFront = new TalonSRX(RobotMap.DriveTrain.leftFront);
		rightFront = new TalonSRX(RobotMap.DriveTrain.rightFront);
		leftBack = new TalonSRX(RobotMap.DriveTrain.leftBack);
		rightBack = new TalonSRX(RobotMap.DriveTrain.rightBack);
		
		
		// * configure timeout
		leftFront.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		rightFront.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

