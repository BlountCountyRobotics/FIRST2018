package org.usfirst.frc.team4504.robot.subsystems;

import org.usfirst.frc.team4504.robot.RobotMap;
import org.usfirst.frc.team4504.robot.commands.StopGrabber;
import org.usfirst.frc.team4504.robot.objects.TalonBCR;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	TalonBCR grabMotor = new TalonBCR(RobotMap.Grabber.motor);

	private double pastCurrent;
	private double currentCurrent;
	private double dCurrent;
	
	Notifier currentThreadNotifier;
	Runnable currentThread = new Runnable() {
		@Override
		public void run() {
			updateCurrent();
		}
		
	};
	
	private void updateCurrent() {
		pastCurrent = currentCurrent;
		currentCurrent = getCurrent();
		dCurrent = currentCurrent-pastCurrent;
	}
	
	public double dCurrentdTime()
	{
		return dCurrent/RobotMap.Grabber.dTime;
	}
	
	public Grabber()
	{
		currentThreadNotifier = new Notifier(currentThread);
		currentThreadNotifier.startPeriodic(RobotMap.Grabber.dTime); // get dCurrent every dTime
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new StopGrabber());
    }
    
    public double getCurrent() {
    	return grabMotor.getOutputCurrent();
    }
    
    public void grab() {
    	grabPercent(RobotMap.Grabber.grabPercent);
    }
    
    public void grabPercent(double percent) {
		grabMotor.set(ControlMode.PercentOutput, percent);
    }
    
    public void stop() {
    	grabMotor.set(ControlMode.PercentOutput, 0.0);
    }
    
    public void open() {
    	grabPercent(-RobotMap.Grabber.grabPercent); // grab but in opposite direction
    }
}

