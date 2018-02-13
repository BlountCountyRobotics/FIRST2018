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
	
	public void xboxToVoltage(BCRXboxController controller)
	{
		percentVoltageDrive(controller.getY(Hand.kLeft), 
				controller.getY(Hand.kRight));
	}
	
	public void xboxToRPM(BCRXboxController controller)
	{
		percentVoltageDrive(controller.getY(Hand.kLeft), 
				controller.getY(Hand.kRight));
	}
	
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
		setEncodersRelative();
		if(!inputsAreValid(left, right))
		{
			left = 0.0;
			right = 0.0;
		}
		
		double leftRPM = left * RobotMap.DriveTrain.maxRPM;
		double rightRPM = right * RobotMap.DriveTrain.maxRPM;
		
		rpmDrive(leftRPM, rightRPM);
	}
	
	public void rpmDrive(double leftRPM, double rightRPM)
	{
		setEncodersRelative();
		leftRPM *= RobotMap.Constants.rpmConversion;
		rightRPM *= RobotMap.Constants.rpmConversion;
		
		leftBack.set(ControlMode.Follower, RobotMap.DriveTrain.leftFront);
		leftFront.set(ControlMode.Velocity, leftRPM);
		
		rightBack.set(ControlMode.Follower, RobotMap.DriveTrain.leftBack);
		rightFront.set(ControlMode.Velocity, rightRPM);
	}
	
	public void setMotorPosition(double position)
	{
		setEncodersAbsolute();
		
		position *= RobotMap.Constants.rpmConversion;
		
		leftBack.set(ControlMode.Follower, RobotMap.DriveTrain.leftFront);
		leftFront.set(ControlMode.Position, position);
		
		rightBack.set(ControlMode.Follower, RobotMap.DriveTrain.leftBack);
		rightFront.set(ControlMode.Position, position);
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
	
	public DriveTrain()
	{
		leftFront = new TalonSRX(RobotMap.DriveTrain.leftFront);
		rightFront = new TalonSRX(RobotMap.DriveTrain.rightFront);
		leftBack = new TalonSRX(RobotMap.DriveTrain.leftBack);
		rightBack = new TalonSRX(RobotMap.DriveTrain.rightBack);
	
		setEncodersRelative();
	}
	
	
	// * TODO: check if relative/absolute even makes a difference (I don't think so)
	private void setEncodersRelative()
	{
		leftFront.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.Constants.timeout);
		rightFront.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.Constants.timeout);
	}
	
	private void setEncodersAbsolute()
	{
		leftFront.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, RobotMap.Constants.timeout);
		rightFront.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, RobotMap.Constants.timeout);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

