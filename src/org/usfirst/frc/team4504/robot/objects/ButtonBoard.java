package org.usfirst.frc.team4504.robot.objects;

import org.usfirst.frc.team4504.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class ButtonBoard extends Joystick {

	
	public JoystickButton getBottomLeft()
	{
		return new JoystickButton(this, RobotMap.ButtonBoard.bottomLeft);
	}
	
	public JoystickButton getBottomMiddle()
	{
		return new JoystickButton(this, RobotMap.ButtonBoard.bottomRight);
	}
	
	public JoystickButton getBottomRight()
	{
		return new JoystickButton(this, RobotMap.ButtonBoard.bottomRight);
	}
	
	public JoystickButton getTopLeft()
	{
		return new JoystickButton(this, RobotMap.ButtonBoard.bottomLeft);
	}
	
	public JoystickButton getTopMiddle()
	{
		return new JoystickButton(this, RobotMap.ButtonBoard.bottomRight);
	}
	
	public JoystickButton getTopRight()
	{
		return new JoystickButton(this, RobotMap.ButtonBoard.bottomRight);
	}
	
	public JoystickButton getTopSwitch()
	{
		return new JoystickButton(this, RobotMap.ButtonBoard.topSwitch);
	}
	
	public JoystickButton getBottomSwitch()
	{
		return new JoystickButton(this, RobotMap.ButtonBoard.bottomSwitch);
	}
	
	public double getLeftDialOutput()
	{
		return this.getRawAxis(RobotMap.ButtonBoard.leftDial);
	}
	
	public double getRightDialOutput()
	{
		return this.getRawAxis(RobotMap.ButtonBoard.rightDial);
	}
	
	public ButtonBoard(int port) {
		super(port);
	}

}
