/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4504.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static class DriveTrain
	{
		public static int leftFront = 1;
		public static int rightFront = 2;
		public static int leftBack = 3;
		public static int rightBack = 4;
		
		// Motor info for Drivetrain
		public static double maxRPM = 1500;
	} 
	
	public static class ButtonBoard
	{
		public static int bottomLeft = 0;
		public static int bottomMiddle = 1;
		public static int bottomRight = 2;
		public static int topLeft = 3;
		public static int topMiddle = 4;
		public static int topRight = 5;
		
		public static int leftDial = 0;
		public static int rightDial = 1;
		
		public static int topSwitch = 6;
		public static int bottomSwitch = 7;
	}
	
	public static class Elevator
	{
		public static int stageOne = 5;
		public static int stageTwo = 6;
		
		public static int stageOneAcceleration = 0;
		public static int stageOneVelocity = 0;
		public static int stageTwoAcceleration = 0;
		public static int stageTwoVelocity = 0;
	}
	
	public static class Constants
	{
		public static double talonUnitsPerRev = 4096.0;
		public static double rpmConversion = talonUnitsPerRev * 600.0; // 600.0 = 100ms/min
		public static int timeout = 0;
	}
	
	public static class Climber {
		public static int tapeMeasure = 0;
		public static int cimMotor = 0;
		
		public static double tapeMeasureSpeedDown = 0;
		public static double speedGoingUp = 0;
	}
}
