/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4504.robot;

import org.usfirst.frc.team4504.robot.commands.*;
import org.usfirst.frc.team4504.robot.objects.BCRXboxController;
import org.usfirst.frc.team4504.robot.objects.ButtonBoard;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	// Controllers
	private BCRXboxController controller;
	private ButtonBoard buttonBoard;
	
	// Buttons
	public JoystickButton grab; // button; press; on xbox
	public JoystickButton letGo; // button; press; on xbox
	public JoystickButton deployClimber; // button; hold
	public JoystickButton climb; // button; hold
	public JoystickButton shoot; // button; hold
	public JoystickButton intake; // button; hold; on xbox
	public JoystickButton elevatorSt1; // button; hold
	public JoystickButton elevatorSt2; // button; hold
	public JoystickButton autoElevator;
	
	public JoystickButton changeElevatorDirection; // switch
	// this changes the direction of the elevator
	// from U/D when the buttons for it are pressed
	public JoystickButton changeShooterSpeed; // switch
	// this makes one of the dials control the shooter speed
	// instead of a set speed
	
	public OI()
	{
		controller = new BCRXboxController(0);
		buttonBoard =  new ButtonBoard(1);
		
		grab = controller.getXJoystickButton();
		letGo = controller.getBJoystickButton();
		climb = buttonBoard.getTopLeft();
		deployClimber = buttonBoard.getBottomLeft();
		shoot = buttonBoard.getBottomMiddle();
		intake = controller.getAJoystickButton();
		elevatorSt1 = buttonBoard.getTopMiddle();
		elevatorSt2 = buttonBoard.getTopRight();
		autoElevator = buttonBoard.getTopRight();
		
		changeShooterSpeed = buttonBoard.getTopSwitch();
		changeElevatorDirection = buttonBoard.getBottomSwitch();
		
		climb.whileHeld(new Climb());
		deployClimber.whileHeld(new DeployClimber());
		grab.whileHeld(new Grab());
		letGo.whileHeld(new LetGo());
		shoot.whileHeld(new Shoot());
		intake.whileHeld(new Intake());
		elevatorSt1.whileHeld(new ElevatorSt1());
		elevatorSt2.whileHeld(new ElevatorSt2());
		autoElevator.whileHeld(new LiftAutomatically());
	}
	

	
	public ButtonBoard getButtonBoard()
	{
		return buttonBoard;
	}
	
	public BCRXboxController getController()
	{
		return controller;
	}
}
