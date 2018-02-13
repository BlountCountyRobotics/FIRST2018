package org.usfirst.frc.team4504.robot.subsystems;

import org.usfirst.frc.team4504.robot.RobotMap;
import org.usfirst.frc.team4504.robot.commands.StopGrabber;
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
	TalonBCR vexMotorRight = new TalonBCR(RobotMap.Grabber.vexMotorRight);
	TalonBCR vexMotorLeft = new TalonBCR(RobotMap.Grabber.vexMotorLeft);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new StopGrabber());
    }
    
    public double getCurrent() {
    		return grabMotor.getOutputCurrent();
    }
    
    public void grab() {
    		double outputCurrent = grabMotor.getOutputCurrent(); 
    	
    		// TODO: make PID version of this
    		if (outputCurrent <= RobotMap.Grabber.currentThreshold) {
	    		grabMotor.set(ControlMode.PercentOutput, RobotMap.Grabber.grabRPM * RobotMap.Constants.rpmConversion);
	    		
	    		// until someone opens grabber, it will continue to run the vex motors
	    		vexMotorRight.set(ControlMode.PercentOutput, RobotMap.Grabber.vexMotorRightRPM * RobotMap.Constants.rpmConversion);
	    		vexMotorLeft.set(ControlMode.PercentOutput, RobotMap.Grabber.vexMotorLeftRPM * RobotMap.Constants.rpmConversion);
    		}
    }
    
    public void grabPercent(double percent) {
		grabMotor.set(ControlMode.PercentOutput, percent * RobotMap.Grabber.grabRPM * RobotMap.Constants.rpmConversion);
		
		// until someone opens grabber, it will continue to run the vex motors
		vexMotorRight.set(ControlMode.PercentOutput, percent * RobotMap.Grabber.vexMotorRightRPM * RobotMap.Constants.rpmConversion);
		vexMotorLeft.set(ControlMode.PercentOutput, percent * RobotMap.Grabber.vexMotorLeftRPM * RobotMap.Constants.rpmConversion);
    }
    
    public void stop() {
    		grabMotor.set(ControlMode.PercentOutput, 0.0);
    }
    
    public void open() {
    		grabMotor.set(ControlMode.PercentOutput, RobotMap.Grabber.openRPM * RobotMap.Constants.rpmConversion);
    		
    		// stop vex motors
    		vexMotorRight.set(ControlMode.PercentOutput, 0.0);
    		vexMotorLeft.set(ControlMode.PercentOutput, 0.0);
    }
}

