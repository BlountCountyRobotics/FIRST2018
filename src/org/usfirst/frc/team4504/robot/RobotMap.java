/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4504.robot;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static class DriveTrain
	{
		public static final int DistancePIDSlot = 1;
		public static final int VelocityPIDSlot = 0;
		public static final int leftFront = 1;
		public static final int rightFront = 2;
		public static final int leftBack = 3;
		public static final int rightBack = 4;
		
		public static Port gyroPort = SPI.Port.kOnboardCS0;
		
		// Motor info for Drivetrain
		public static final double maxRPM = 1500;
		
		public static final double inchToPosition = 4096.0 / (6.0 * Math.PI); 
		// inches / circumference of wheel = rotations, rotations * native encoder units per rotation = position
		
		public static final int distanceError = 10; // error allowed for the distance in native units
		public static final int distanceMinSpeed = 50;
		
		public static final int turnError = 3;
		
		public static final double angleKp = .1;
		public static final double angleKi = .1;
		public static final double angleKd = .1;
		
		public static final double leftKp = .1;
		public static final double leftKi = .1;
		public static final double leftKd = .1;		
		
		public static final double rightKp = .1;
		public static final double rightKi = .1;
		public static final double rightKd = .1;
		
		public static final double turnKp = .1;
		public static final double turnKi = .1;
		public static final double turnKd = .1;
	} 
	
	public static class ButtonBoard
	{
		public static final int bottomLeft = 0;
		public static final int bottomMiddle = 1;
		public static final int bottomRight = 2;
		public static final int topLeft = 3;
		public static final int topMiddle = 4;
		public static final int topRight = 5;
		
		public static final int leftDial = 0;
		public static final int rightDial = 1;
		
		public static final int topSwitch = 6;
		public static final int bottomSwitch = 7;
	}
	
	public static class Elevator
	{
		public static final int stageOne = 5;
		public static final int stageTwo = 6;
	}
	
	public static class Constants
	{
		public static final double talonUnitsPerRev = 4096.0;
		public static final double rpmConversion = talonUnitsPerRev / 600.0; // 600.0 = 100ms/min
		public static final int timeout = 0;
	}
	
	public static class Shooter
	{
		public static final int left = 7;
		public static final int right = 8;
		
		public static final double shootingRPM = 1300;
		public static final double intakeRPM = 200;
		public static final double maxRPM = 1600;
	}
	
	public static class Climber {
		public static final int tapeMeasure = 0;
		public static final int cimMotor = 0;
		
		public static final double tapeMeasureDown = 0;
		public static final double tapeMeasureUp = 0;
		public static final double cimDown = 0;
	}
	
	public static class Grabber {
		public static final int motor = 0;
		
		public static final double grabPercent = .5;
		
		public static final double dTime = .005;
	}
	
}
