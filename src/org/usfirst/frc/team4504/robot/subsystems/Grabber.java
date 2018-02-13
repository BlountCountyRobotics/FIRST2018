package org.usfirst.frc.team4504.robot.subsystems;

import org.usfirst.frc.team4504.robot.RobotMap;
import org.usfirst.frc.team4504.robot.commands.stopGrabber;
import org.usfirst.frc.team4504.robot.objects.TalonBCR;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	TalonBCR grabMotor = new TalonBCR(RobotMap.Grabber.motor);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new stopGrabber());
    }
    
    public void grab() {
    		grabMotor.set(ControlMode.PercentOutput, RobotMap.Grabber.grabSpeed);
    }
    
    public void stop() {
    		grabMotor.set(ControlMode.PercentOutput, 0.0);
    }
    
    public void open() {
    		grabMotor.set(ControlMode.PercentOutput, RobotMap.Grabber.openSpeed);
    }
}

