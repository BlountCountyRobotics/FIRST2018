package org.usfirst.frc.team4504.robot.subsystems;

import org.usfirst.frc.team4504.robot.RobotMap;
import org.usfirst.frc.team4504.robot.commands.ClimberStop;

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
        setDefaultCommand(new ClimberStop());
    }
    
    public void up() {
    		tapeMeasure.set(ControlMode.Position, RobotMap.Climber.tapeMeasureSpeedUp);
    }
    
    public void stop() {
    		tapeMeasure.set(ControlMode.Position, 0.0);
    }
    
    public void down() {
    	
    		// TODO: adjust these values so that tape measure is not bent
    		tapeMeasure.set(ControlMode.Position, RobotMap.Climber.tapeMeasureSpeedDown);
    		cimMotor.set(ControlMode.Position, RobotMap.Climber.cimDown);
    }
}

