package org.usfirst.frc.team4504.robot.subsystems;

import org.usfirst.frc.team4504.robot.RobotMap;
import org.usfirst.frc.team4504.robot.objects.TalonBCR;

import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

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
		
		stageOne.set(ControlMode.MotionProfile, 1); // enable motion profile
		stageTwo.set(ControlMode.MotionProfile, 1);
	}
	
	public void keepAutomaticLifting()
	{
		stageOne.set(ControlMode.MotionProfile, 1); // enable motion profile
		stageTwo.set(ControlMode.MotionProfile, 1);
	}
	
	public void stopAutomaticLiftProfile()
	{
		
		stageOne.set(ControlMode.MotionProfile, 0); // disable motion profile
		stageTwo.set(ControlMode.MotionProfile, 0);
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
	
	public void startProcessingPoints()
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
		
		stageOne.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 
				0, RobotMap.Constants.timeout);
		stageTwo.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 
				0, RobotMap.Constants.timeout);

		
		stageOne.changeMotionControlFramePeriod(5);
		stageTwo.changeMotionControlFramePeriod(5);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

