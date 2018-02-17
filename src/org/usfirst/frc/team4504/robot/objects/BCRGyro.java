package org.usfirst.frc.team4504.robot.objects;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI.Port;

public class BCRGyro extends ADXRS450_Gyro {
	public BCRGyro(Port port) {
		super(port);
	}
	
	public double getRealAngle() {
		double angle = getAngle();
		int revolutions = Math.abs((int) angle / 180);
		
		if (angle < 0.0) {
			angle += revolutions * 180.0;
			if (revolutions % 2 != 0) {
				angle += 180.0;
			}
		} else {
			angle -= revolutions * 180.0;
			if(revolutions % 2 != 0) {
				angle += -180.0;
			}
		}
		return angle;
	}
}
