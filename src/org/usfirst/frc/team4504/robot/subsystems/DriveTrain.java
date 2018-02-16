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
		
		leftBack.set(ControlMode.Follower, RobotMap.DriveTrain.leftFront);
		leftFront.set(ControlMode.Velocity, leftRPM);
		
		rightBack.set(ControlMode.Follower, RobotMap.DriveTrain.leftBack);
		rightFront.set(ControlMode.Velocity, rightRPM);
	}
	
	
	public void driveDistance(double inches)
	{
		double position = convertInchesToPosition(inches);
		
		leftBack.set(ControlMode.Follower, RobotMap.DriveTrain.leftFront);
		leftFront.set(ControlMode.Position, position);
		
		rightBack.set(ControlMode.Follower, RobotMap.DriveTrain.leftBack);
		rightFront.set(ControlMode.Position, position);
	}
	
	public double convertInchesToPosition(double inches)
	{
		double rotations = inches / (6.0 * Math.PI); // inches to rotations of the wheel
		return rotations * 4096.0; // rotations of the wheel to native units of the talon (see documentation)
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

