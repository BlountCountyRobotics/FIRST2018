package org.usfirst.frc.team4504.robot.subsystems.pid;

import org.usfirst.frc.team4504.robot.Robot;
import org.usfirst.frc.team4504.robot.objects.BCRGyro;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class GyroAngle extends PIDSubsystem {

    double finalGyro = 0.0;
    BCRGyro gyro = Robot.driveTrain.gyro;
	
    public GyroAngle() {
    		super(0.1, 0.1, 0.1, 0.1);
    		
    		setInputRange(-180.0, 180.0);
    		setOutputRange(-0.2, 0.2); // range so that motor is only running up to 20%
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return gyro.getRealAngle();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. driveTrain.do(something);
    }
}
