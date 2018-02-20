package org.usfirst.frc.team4504.robot.subsystems;

import org.usfirst.frc.team4504.robot.RobotMap;
import org.usfirst.frc.team4504.robot.commands.DriveWithXbox;
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
		double left = controller.getY(Hand.kLeft);
		double right = controller.getY(Hand.kRight);
		
		
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
	
	public void percentRPMDriveLeft(double left)
	{
		double leftRPM = left * RobotMap.DriveTrain.maxRPM;
		leftRPM *= RobotMap.Constants.rpmConversion;
		
		leftFront.selectProfileSlot(RobotMap.DriveTrain.VelocityPIDSlot, 0);

		
		leftBack.set(ControlMode.Follower, RobotMap.DriveTrain.leftFront);
		leftFront.set(ControlMode.Velocity, leftRPM);
	}
	
	public void percentRPMDriveRight(double right)
	{
		double rightRPM = right * RobotMap.DriveTrain.maxRPM;
		rightRPM *= RobotMap.Constants.rpmConversion;
		
		rightFront.selectProfileSlot(RobotMap.DriveTrain.VelocityPIDSlot, 0);

		
		rightBack.set(ControlMode.Follower, RobotMap.DriveTrain.leftFront);
		rightFront.set(ControlMode.Velocity, rightRPM);
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
	
	public void stop()
	{
		percentVoltageDrive(0.0, 0.0);
	}
	
	public TalonSRX getLeftFrontTalon()
	{
		return leftFront;
	}
	public TalonSRX getRightFrontTalon()
	{
		return rightFront;
	}
	public TalonSRX getLeftBackTalon()
	{
		return leftBack; 
	}
	public TalonSRX getRightBackTalon()
	{
		return rightBack;
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
    	setDefaultCommand(new DriveWithXbox());
    }
}

