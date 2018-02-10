package org.usfirst.frc.team4504.robot.objects;

import org.usfirst.frc.team4504.robot.RobotMap;

import com.ctre.phoenix.motion.TrajectoryPoint;

public class TalonBCR extends com.ctre.phoenix.motorcontrol.can.TalonSRX {

	public TalonBCR(int deviceNumber) {
		super(deviceNumber);
	}

	public void fillProfile(double[][] profile, int totalCnt) {

		/* create an empty point */
		TrajectoryPoint point = new TrajectoryPoint();
		
		/*
		 * just in case we are interrupting another MP and there is still buffer
		 * points in memory, clear it.
		 */
		this.clearMotionProfileTrajectories();

		/* set the base trajectory period to zero, use the individual trajectory period below */
		
		/* This is fast since it's just into our TOP buffer */
		for (int i = 0; i < totalCnt; ++i) {
			double positionRot = profile[i][0];
			double velocityRPM = profile[i][1];
			/* for each point, fill our structure and pass it to API */
			point.position = positionRot * RobotMap.Constants.talonUnitsPerRev; //Convert Revolutions to Units
			point.velocity = velocityRPM * RobotMap.Constants.rpmConversion; //Convert RPM to Units/100ms
			point.zeroPos = false;
			if (i == 0)
				point.zeroPos = true; /* set this to true on the first point */

			point.isLastPoint = false;
			if ((i + 1) == totalCnt)
				point.isLastPoint = true; /* set this to true on the last point  */

			this.pushMotionProfileTrajectory(point);
		}
	}
	
}
