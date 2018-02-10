package org.usfirst.frc.team4504.robot.subsystems;

import org.usfirst.frc.team4504.robot.RobotMap;
import org.usfirst.frc.team4504.robot.objects.TalonBCR;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	
	TalonBCR stageOne;
	TalonBCR stageTwo;
	
	public void startSimulataneousLift()
	{
		stageOne.set(ControlMode.MotionProfile, 1); // enable motion profile
		stageTwo.set(ControlMode.MotionProfile, 1);
	}
	
	public void stopSimulataneousLift()
	{
		stageOne.set(ControlMode.MotionProfile, 0); // disable motion profile
		stageTwo.set(ControlMode.MotionProfile, 0);
	}
	
	public void fillProfile()
	{
		stageOne.fillProfile(RobotMap.MotionProfiles.stageOnePoints, 
					RobotMap.MotionProfiles.stageOneNumPoints);
		stageTwo.fillProfile(RobotMap.MotionProfiles.stageTwoPoints, 
					RobotMap.MotionProfiles.stageTwoNumPoints);
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
	
		/* Delete if not using motion magic TODO
		// set up constants
		stageOne.configMotionAcceleration(RobotMap.Elevator.stageOneAcceleration, 
				RobotMap.Constants.timeout);
		stageTwo.configMotionAcceleration(RobotMap.Elevator.stageTwoAcceleration, 
				RobotMap.Constants.timeout);
		
		stageOne.configMotionCruiseVelocity(RobotMap.Elevator.stageOneVelocity, 
				RobotMap.Constants.timeout);
		stageTwo.configMotionCruiseVelocity(RobotMap.Elevator.stageTwoVelocity, 
				RobotMap.Constants.timeout);*/
	
		stageOne.fillProfile(RobotMap.MotionProfiles.stageOnePoints,
					RobotMap.MotionProfiles.stageOneNumPoints);
		stageTwo.fillProfile(RobotMap.MotionProfiles.stageTwoPoints,
				RobotMap.MotionProfiles.stageTwoNumPoints);
		
		stageOne.changeMotionControlFramePeriod(5);
		stageTwo.changeMotionControlFramePeriod(5);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

