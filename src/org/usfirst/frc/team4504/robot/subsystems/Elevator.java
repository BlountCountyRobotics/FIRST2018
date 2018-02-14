package org.usfirst.frc.team4504.robot.subsystems;

import org.usfirst.frc.team4504.robot.RobotMap;
import org.usfirst.frc.team4504.robot.commands.StopElevator;
import org.usfirst.frc.team4504.robot.objects.TalonBCR;

import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * To use this subsystem's simultaneous
 * lift, you need to start by starting
 * the "filler" thread with 
 * "startFillingLiftProfile()" and then
 * immediately run the "startSimulatenous-
 * LiftProfile()" to begin running it, so
 * it will not overflow with points.
 */
public class Elevator extends Subsystem {

	
	TalonBCR stageOne;
	TalonBCR stageTwo;
	Notifier pointProcessingNotifier = new Notifier(new PeriodicRunnable());
	DigitalInput topLimitSwitch = new DigitalInput(0);
	DigitalInput bottomLimitSwitch = new DigitalInput(1);

	
	public MotionProfileStatus getMotionProfileStatus()
	{
		MotionProfileStatus status = new MotionProfileStatus();
		stageOne.getMotionProfileStatus(status);
		return status;
	}
	
	public void startAutomaticLiftProfile()
	{
		fillProfiles();
		stageOne.processMotionProfileBuffer(); // just to make sure one goes through
		stageTwo.processMotionProfileBuffer();
		startProcessingPoints();
		
		if(topLimitSwitch.get())
		{
			stopAutomaticLiftProfile();
			return;
		}
		
		stageOne.set(ControlMode.MotionProfile, 1); // enable motion profile
		stageTwo.set(ControlMode.MotionProfile, 1);
	}
	
	public void keepAutomaticLifting()
	{
		if(topLimitSwitch.get())
		{
			stopAutomaticLiftProfile();
			return;
		}
		
		stageOne.set(ControlMode.MotionProfile, 1); // enable motion profile
		stageTwo.set(ControlMode.MotionProfile, 1);
	}
	
	public void stopAutomaticLiftProfile()
	{
		stageOne.set(ControlMode.MotionProfile, 0); // disable motion profile
		stageTwo.set(ControlMode.MotionProfile, 0);
		
		pointProcessingNotifier.stop();
		
		stageOne.clearMotionProfileTrajectories();
		stageTwo.clearMotionProfileTrajectories();		
	}
	
	public void stageOne(double percent)
	{
		if(topLimitSwitch.get() && percent > 0.0)
		{
			percent = 0.0;
		}else if (bottomLimitSwitch.get() && percent < 0.0)
		{
			percent = 0.0;
		}
		double input = percent * RobotMap.Elevator.maxRPMStageOne * RobotMap.Constants.rpmConversion;
		stageOne.set(ControlMode.Velocity, input);
	}
	
	public void stageTwo(double percent)
	{
		double input = percent * RobotMap.Elevator.maxRPMStageTwo * RobotMap.Constants.rpmConversion;
		stageTwo.set(ControlMode.Velocity, input);
	}
	
	private void fillProfiles()
	{
		stageOne.fillProfile(RobotMap.MotionProfiles.stageOnePoints,
				RobotMap.MotionProfiles.stageOneNumPoints);
		stageTwo.fillProfile(RobotMap.MotionProfiles.stageTwoPoints,
				RobotMap.MotionProfiles.stageTwoNumPoints);
	}
	
	class PeriodicRunnable implements Runnable
	{
		public void run()
		{
			stageOne.processMotionProfileBuffer();
			stageTwo.processMotionProfileBuffer();
		}
	}
	
	private void startProcessingPoints()
	{
		pointProcessingNotifier.startPeriodic(.005);
	}
	
	public void setStageOne(double output)
	{
		stageOne.set(ControlMode.PercentOutput, output);
	}
	
	public void setStageTwo(double output)
	{
		stageTwo.set(ControlMode.PercentOutput, output);
	}
	
	
	public Elevator()
	{
		// create motors
		stageOne = new TalonBCR(RobotMap.Elevator.stageOne);
		stageTwo = new TalonBCR(RobotMap.Elevator.stageTwo);
		
		stageOne.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 
				0, RobotMap.Constants.timeout);
		stageTwo.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 
				0, RobotMap.Constants.timeout);

		
		stageOne.changeMotionControlFramePeriod(5);
		stageTwo.changeMotionControlFramePeriod(5);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StopElevator());
    }
}

