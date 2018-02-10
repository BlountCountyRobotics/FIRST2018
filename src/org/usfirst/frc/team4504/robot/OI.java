/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4504.robot;

import org.usfirst.frc.team4504.robot.commands.ClimberUp;
import org.usfirst.frc.team4504.robot.objects.ButtonBoard;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	// Controllers
	private XboxController controller;
	private ButtonBoard buttonBoard;
	
	// Buttons
	private JoystickButton controlGrabber; // button; press
	private JoystickButton climb; // button; hold (depends on implementation; may need two buttons)
	private JoystickButton shoot; // button; hold
	private JoystickButton shootInverted; // button; hold
	private JoystickButton elevatorUp; // button; hold
	private JoystickButton elevatorDown; // button; hold
	
	private JoystickButton changeShooterSpeed; // switch
	// this makes one of the dials control the shooter speed
	// instead of a set speed
	
	public OI()
	{
		controller = new XboxController(0);
		buttonBoard =  new ButtonBoard(1);
		
		controlGrabber = buttonBoard.getBottomLeft();
		climb = buttonBoard.getTopLeft();
		shoot = buttonBoard.getBottomMiddle();
		shootInverted = buttonBoard.getBottomRight();
		elevatorUp = buttonBoard.getTopMiddle();
		elevatorDown = buttonBoard.getTopRight();
		changeShooterSpeed = buttonBoard.getTopSwitch();
		
		climb.whileHeld(new ClimberUp());
	}
	

	
	public Joystick getButtonBoard()
	{
		return buttonBoard;
	}
	
	public XboxController getController()
	{
		return controller;
	}
}
