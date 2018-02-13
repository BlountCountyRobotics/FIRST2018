package org.usfirst.frc.team4504.robot.subsystems;

import org.usfirst.frc.team4504.robot.RobotMap;
import org.usfirst.frc.team4504.robot.commands.StopClimb;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	TalonSRX tapeMeasure = new TalonSRX(RobotMap.Climber.tapeMeasure);
	TalonSRX cimMotor = new TalonSRX(RobotMap.Climber.cimMotor);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new StopClimb());
    }
    
    public void up() {
    		tapeMeasure.set(ControlMode.PercentOutput, RobotMap.Climber.tapeMeasureUp * RobotMap.Constants.rpmConversion);
    }
    
    public void stop() {
    		tapeMeasure.set(ControlMode.PercentOutput, 0.0);
    }
    
    public void down() {
    	
    		// TODO: adjust these values so that tape measure is not bent
    		tapeMeasure.set(ControlMode.PercentOutput, RobotMap.Climber.tapeMeasureDown * RobotMap.Constants.rpmConversion);
    		cimMotor.set(ControlMode.PercentOutput, RobotMap.Climber.cimDown * RobotMap.Constants.rpmConversion);
    }
}

