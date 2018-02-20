package org.usfirst.frc.team4504.robot.subsystems;

import org.usfirst.frc.team4504.robot.Robot;
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

	
	TalonBCR stageOneOne;
	TalonBCR stageOneTwo;
	TalonBCR stageTwo;
	DigitalInput topLimitSwitch = new DigitalInput(0);
	DigitalInput bottomLimitSwitch = new DigitalInput(1);

	public void setStageOne(double output)
	{
		if(conflictsWithLimitSwitch(output))
			output = 0.0;
		stageOneOne.set(ControlMode.PercentOutput, output);
		if(Robot.oi.doubleElevatorMotors.get())
			stageOneTwo.set(ControlMode.PercentOutput, output);
	}
	
	public void setStageTwo(double output)
	{
		stageTwo.set(ControlMode.PercentOutput, output);
	}
	
	public void runStageOne()
	{
		setStageOne(RobotMap.Elevator.stageOneOutput);
	}
	
	public void runStageTwo()
	{
		setStageTwo(RobotMap.Elevator.stageTwoOutput);
	}
	
	private boolean conflictsWithLimitSwitch(double output)
	{
		if((output > 0.0 && topLimitSwitch.get()) 
				|| (output < 0.0 && bottomLimitSwitch.get()))
		{
			return true;
		}

		return false;
	}
	
	public Elevator()
	{
		// create motors
		stageOneOne = new TalonBCR(RobotMap.Elevator.stageOneOne);
		stageOneTwo = new TalonBCR(RobotMap.Elevator.stageOneTwo);
		stageTwo = new TalonBCR(RobotMap.Elevator.stageTwo);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StopElevator());
    }
}

