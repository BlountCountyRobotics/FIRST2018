package org.usfirst.frc.team4504.robot.subsystems;

import org.usfirst.frc.team4504.robot.RobotMap;
import org.usfirst.frc.team4504.robot.commands.StopShooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	TalonSRX left;
	TalonSRX right;
	
	public void shoot()
	{
		left.set(ControlMode.Velocity, 
				RobotMap.Shooter.shootingRPM * RobotMap.Constants.rpmConversion);
		right.set(ControlMode.Velocity, 
				RobotMap.Shooter.shootingRPM * RobotMap.Constants.rpmConversion);
	}
	
	public void shoot(double percent)
	{
		left.set(ControlMode.Velocity, 
				percent * RobotMap.Shooter.maxRPM * RobotMap.Constants.rpmConversion);
		right.set(ControlMode.Velocity, 
				percent * RobotMap.Shooter.maxRPM * RobotMap.Constants.rpmConversion);
	}
	
	public void intake()
	{
		left.set(ControlMode.Velocity, 
				RobotMap.Shooter.intakeRPM * RobotMap.Constants.rpmConversion);
		right.set(ControlMode.Velocity, 
				RobotMap.Shooter.intakeRPM * RobotMap.Constants.rpmConversion);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StopShooter());
    }
    
    public Shooter()
    {
    	left  = new TalonSRX(RobotMap.Shooter.left);
    	right = new TalonSRX(RobotMap.Shooter.right);
    	
    	left.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
    			0, RobotMap.Constants.timeout);
    	right.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
    			0, RobotMap.Constants.timeout);
    }
}

