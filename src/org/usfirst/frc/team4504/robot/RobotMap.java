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
	
	public static class Shooter
	{
		public static int left = 7;
		public static int right = 8;
		
		public static double shootingRPM = 1300;
		public static double intakeRPM = 200;
		public static double maxRPM = 1600;
	}
	
	public static class Climber {
		public static int tapeMeasure = 0;
		public static int cimMotor = 0;
		
		public static double tapeMeasureDown = 0;
		public static double tapeMeasureUp = 0;
		public static double cimDown = 0;
	}
	
	public static class Grabber {
		public static int motor = 0;
		public static int vexMotorLeft = 1;
		public static int vexMotorRight = 2;
		
		public static double grabRPM = 0.0;
		public static double openRPM = 0.0;
		public static double vexMotorLeftRPM = 0.0;
		public static double vexMotorRightRPM = 0.0;
		public static double currentThreshold = 0.0;
	}
	
	public static class MotionProfiles
	{
		public static final int trajectoryPeriod = 10;
		
		public static final int stageTwoNumPoints = 367;		
		// Position (rotations)	Velocity (RPM)	Duration (ms)
		public static double [][]stageTwoPoints = new double[][]{		
		{0,	0	,10},
		{2.35294117647059E-06,	0.028235294	,10},
		{1.05882352941176E-05,	0.070588235	,10},
		{2.70588235294118E-05,	0.127058824	,10},
		{5.41176470588235E-05,	0.197647059	,10},
		{9.41176470588235E-05,	0.282352941	,10},
		{0.000149411764705882,	0.381176471	,10},
		{0.000222352941176471,	0.494117647	,10},
		{0.000315294117647059,	0.621176471	,10},
		{0.000430588235294118,	0.762352941	,10},
		{0.000570588235294118,	0.917647059	,10},
		{0.000737647058823529,	1.087058824	,10},
		{0.000934117647058824,	1.270588235	,10},
		{0.00116235294117647,	1.468235294	,10},
		{0.00142470588235294,	1.68	,10},
		{0.00172352941176471,	1.905882353	,10},
		{0.00206117647058824,	2.145882353	,10},
		{0.00244,	2.4	,10},
		{0.00286235294117647,	2.668235294	,10},
		{0.00333058823529412,	2.950588235	,10},
		{0.00384705882352941,	3.247058824	,10},
		{0.00441411764705882,	3.557647059	,10},
		{0.00503411764705882,	3.882352941	,10},
		{0.00570941176470588,	4.221176471	,10},
		{0.00644235294117647,	4.574117647	,10},
		{0.00723529411764706,	4.941176471	,10},
		{0.00809058823529412,	5.322352941	,10},
		{0.00901058823529412,	5.717647059	,10},
		{0.00999764705882353,	6.127058824	,10},
		{0.0110541176470588,	6.550588235	,10},
		{0.0121823529411765,	6.988235294	,10},
		{0.0133847058823529,	7.44	,10},
		{0.0146635294117647,	7.905882353	,10},
		{0.0160211764705882,	8.385882353	,10},
		{0.01746,	8.88	,10},
		{0.0189823529411765,	9.388235294	,10},
		{0.0205905882352941,	9.910588235	,10},
		{0.0222870588235294,	10.44705882	,10},
		{0.0240741176470588,	10.99764706	,10},
		{0.0259541176470588,	11.56235294	,10},
		{0.0279294117647059,	12.14117647	,10},
		{0.0300023529411765,	12.73411765	,10},
		{0.0321752941176471,	13.34117647	,10},
		{0.0344505882352941,	13.96235294	,10},
		{0.0368305882352941,	14.59764706	,10},
		{0.0393176470588235,	15.24705882	,10},
		{0.0419141176470588,	15.91058824	,10},
		{0.0446223529411765,	16.58823529	,10},
		{0.047444705882353,	17.28	,10},
		{0.0503835294117647,	17.98588235	,10},
		{0.0534411764705882,	18.70588235	,10},
		{0.0566164705882353,	19.39764706	,10},
		{0.0599058823529412,	20.07529412	,10},
		{0.0633070588235294,	20.73882353	,10},
		{0.0668176470588235,	21.38823529	,10},
		{0.0704352941176471,	22.02352941	,10},
		{0.0741576470588235,	22.64470588	,10},
		{0.0779823529411765,	23.25176471	,10},
		{0.0819070588235294,	23.84470588	,10},
		{0.0859294117647059,	24.42352941	,10},
		{0.0900470588235294,	24.98823529	,10},
		{0.0942576470588235,	25.53882353	,10},
		{0.0985588235294118,	26.07529412	,10},
		{0.102948235294118,	26.59764706	,10},
		{0.107423529411765,	27.10588235	,10},
		{0.111982352941176,	27.6	,10},
		{0.116622352941176,	28.08	,10},
		{0.121341176470588,	28.54588235	,10},
		{0.126136470588235,	28.99764706	,10},
		{0.131005882352941,	29.43529412	,10},
		{0.135947058823529,	29.85882353	,10},
		{0.140957647058824,	30.26823529	,10},
		{0.146035294117647,	30.66352941	,10},
		{0.151177647058824,	31.04470588	,10},
		{0.156382352941176,	31.41176471	,10},
		{0.161647058823529,	31.76470588	,10},
		{0.166969411764706,	32.10352941	,10},
		{0.172347058823529,	32.42823529	,10},
		{0.177777647058824,	32.73882353	,10},
		{0.183258823529412,	33.03529412	,10},
		{0.188788235294118,	33.31764706	,10},
		{0.194363529411765,	33.58588235	,10},
		{0.199982352941177,	33.84	,10},
		{0.205642352941177,	34.08	,10},
		{0.211341176470588,	34.30588235	,10},
		{0.217076470588235,	34.51764706	,10},
		{0.222845882352941,	34.71529412	,10},
		{0.228647058823529,	34.89882353	,10},
		{0.234477647058824,	35.06823529	,10},
		{0.240335294117647,	35.22352941	,10},
		{0.246217647058824,	35.36470588	,10},
		{0.252122352941177,	35.49176471	,10},
		{0.258047058823529,	35.60470588	,10},
		{0.263989411764706,	35.70352941	,10},
		{0.269947058823529,	35.78823529	,10},
		{0.275917647058824,	35.85882353	,10},
		{0.281898823529412,	35.91529412	,10},
		{0.287888235294118,	35.95764706	,10},
		{0.293883529411765,	35.98588235	,10},
		{0.299882352941176,	36	,10},
		{0.305882352941176,	36	,10},
		{0.311882352941176,	36	,10},
		{0.317882352941177,	36	,10},
		{0.323882352941177,	36	,10},
		{0.329882352941177,	36	,10},
		{0.335882352941177,	36	,10},
		{0.341882352941177,	36	,10},
		{0.347882352941177,	36	,10},
		{0.353882352941177,	36	,10},
		{0.359882352941177,	36	,10},
		{0.365882352941177,	36	,10},
		{0.371882352941177,	36	,10},
		{0.377882352941177,	36	,10},
		{0.383882352941177,	36	,10},
		{0.389882352941177,	36	,10},
		{0.395882352941177,	36	,10},
		{0.401882352941177,	36	,10},
		{0.407882352941177,	36	,10},
		{0.413882352941177,	36	,10},
		{0.419882352941177,	36	,10},
		{0.425882352941177,	36	,10},
		{0.431882352941177,	36	,10},
		{0.437882352941177,	36	,10},
		{0.443882352941177,	36	,10},
		{0.449882352941177,	36	,10},
		{0.455882352941177,	36	,10},
		{0.461882352941177,	36	,10},
		{0.467882352941177,	36	,10},
		{0.473882352941177,	36	,10},
		{0.479882352941177,	36	,10},
		{0.485882352941177,	36	,10},
		{0.491882352941177,	36	,10},
		{0.497882352941177,	36	,10},
		{0.503882352941177,	36	,10},
		{0.509882352941177,	36	,10},
		{0.515882352941177,	36	,10},
		{0.521882352941177,	36	,10},
		{0.527882352941177,	36	,10},
		{0.533882352941177,	36	,10},
		{0.539882352941177,	36	,10},
		{0.545882352941177,	36	,10},
		{0.551882352941177,	36	,10},
		{0.557882352941177,	36	,10},
		{0.563882352941177,	36	,10},
		{0.569882352941177,	36	,10},
		{0.575882352941177,	36	,10},
		{0.581882352941177,	36	,10},
		{0.587882352941177,	36	,10},
		{0.593882352941177,	36	,10},
		{0.599882352941177,	36	,10},
		{0.605882352941177,	36	,10},
		{0.611882352941177,	36	,10},
		{0.617882352941177,	36	,10},
		{0.623882352941177,	36	,10},
		{0.629882352941177,	36	,10},
		{0.635882352941177,	36	,10},
		{0.641882352941177,	36	,10},
		{0.647882352941177,	36	,10},
		{0.653882352941177,	36	,10},
		{0.659882352941177,	36	,10},
		{0.665882352941177,	36	,10},
		{0.671882352941177,	36	,10},
		{0.677882352941177,	36	,10},
		{0.683882352941177,	36	,10},
		{0.689882352941177,	36	,10},
		{0.695882352941177,	36	,10},
		{0.701882352941177,	36	,10},
		{0.707882352941177,	36	,10},
		{0.713882352941177,	36	,10},
		{0.719882352941177,	36	,10},
		{0.725882352941177,	36	,10},
		{0.731882352941177,	36	,10},
		{0.737882352941177,	36	,10},
		{0.743882352941177,	36	,10},
		{0.749882352941177,	36	,10},
		{0.755882352941177,	36	,10},
		{0.761882352941177,	36	,10},
		{0.767882352941177,	36	,10},
		{0.773882352941177,	36	,10},
		{0.779882352941177,	36	,10},
		{0.785882352941177,	36	,10},
		{0.791882352941177,	36	,10},
		{0.797882352941177,	36	,10},
		{0.803882352941177,	36	,10},
		{0.809882352941177,	36	,10},
		{0.815882352941177,	36	,10},
		{0.821882352941177,	36	,10},
		{0.827882352941177,	36	,10},
		{0.833882352941177,	36	,10},
		{0.839882352941177,	36	,10},
		{0.845882352941177,	36	,10},
		{0.851882352941177,	36	,10},
		{0.857882352941177,	36	,10},
		{0.863882352941177,	36	,10},
		{0.869882352941177,	36	,10},
		{0.875882352941177,	36	,10},
		{0.881882352941177,	36	,10},
		{0.887882352941177,	36	,10},
		{0.893882352941177,	36	,10},
		{0.899882352941177,	36	,10},
		{0.905882352941177,	36	,10},
		{0.911882352941177,	36	,10},
		{0.917882352941177,	36	,10},
		{0.923882352941177,	36	,10},
		{0.929882352941177,	36	,10},
		{0.935882352941177,	36	,10},
		{0.941882352941177,	36	,10},
		{0.947882352941177,	36	,10},
		{0.953882352941177,	36	,10},
		{0.959882352941177,	36	,10},
		{0.965882352941177,	36	,10},
		{0.971882352941177,	36	,10},
		{0.977882352941177,	36	,10},
		{0.983882352941177,	36	,10},
		{0.989882352941177,	36	,10},
		{0.995882352941177,	36	,10},
		{1.00188235294118,	36	,10},
		{1.00788235294118,	36	,10},
		{1.01388235294118,	36	,10},
		{1.01988235294118,	36	,10},
		{1.02588235294118,	36	,10},
		{1.03188235294118,	36	,10},
		{1.03788235294118,	36	,10},
		{1.04388235294118,	36	,10},
		{1.04988235294118,	36	,10},
		{1.05588235294118,	36	,10},
		{1.06188235294118,	36	,10},
		{1.06788235294118,	36	,10},
		{1.07388235294118,	36	,10},
		{1.07988235294118,	36	,10},
		{1.08588235294118,	36	,10},
		{1.09188235294118,	36	,10},
		{1.09788235294118,	36	,10},
		{1.10388235294118,	36	,10},
		{1.10988235294118,	36	,10},
		{1.11588235294118,	36	,10},
		{1.12188235294118,	36	,10},
		{1.12788235294118,	36	,10},
		{1.13388235294118,	36	,10},
		{1.13988235294118,	36	,10},
		{1.14588235294118,	36	,10},
		{1.15188235294118,	36	,10},
		{1.15788235294118,	36	,10},
		{1.16388235294118,	36	,10},
		{1.16988235294118,	36	,10},
		{1.17588235294118,	36	,10},
		{1.18188235294118,	36	,10},
		{1.18788235294118,	36	,10},
		{1.19388235294118,	36	,10},
		{1.19988235294118,	36	,10},
		{1.20588235294118,	36	,10},
		{1.21188235294118,	36	,10},
		{1.21788235294118,	36	,10},
		{1.22388235294118,	36	,10},
		{1.22988235294118,	36	,10},
		{1.23588235294118,	36	,10},
		{1.24188235294118,	36	,10},
		{1.24788235294118,	36	,10},
		{1.25388235294118,	36	,10},
		{1.25988235294118,	36	,10},
		{1.26588235294118,	36	,10},
		{1.27188235294118,	36	,10},
		{1.27788235294118,	36	,10},
		{1.28388235294118,	36	,10},
		{1.28988235294118,	36	,10},
		{1.29588235294118,	36	,10},
		{1.30188235294118,	36	,10},
		{1.30788235294118,	36	,10},
		{1.31388,	35.97176471	,10},
		{1.31987176470588,	35.92941176	,10},
		{1.32585529411765,	35.87294118	,10},
		{1.33182823529412,	35.80235294	,10},
		{1.33778823529412,	35.71764706	,10},
		{1.34373294117647,	35.61882353	,10},
		{1.34966,	35.50588235	,10},
		{1.35556705882353,	35.37882353	,10},
		{1.36145176470588,	35.23764706	,10},
		{1.36731176470588,	35.08235294	,10},
		{1.37314470588235,	34.91294118	,10},
		{1.37894823529412,	34.72941176	,10},
		{1.38472,	34.53176471	,10},
		{1.39045764705882,	34.32	,10},
		{1.39615882352941,	34.09411765	,10},
		{1.40182117647059,	33.85411765	,10},
		{1.40744235294118,	33.6	,10},
		{1.41302,	33.33176471	,10},
		{1.41855176470588,	33.04941176	,10},
		{1.42403529411765,	32.75294118	,10},
		{1.42946823529412,	32.44235294	,10},
		{1.43484823529412,	32.11764706	,10},
		{1.44017294117647,	31.77882353	,10},
		{1.44544,	31.42588235	,10},
		{1.45064705882353,	31.05882353	,10},
		{1.45579176470588,	30.67764706	,10},
		{1.46087176470588,	30.28235294	,10},
		{1.46588470588235,	29.87294118	,10},
		{1.47082823529412,	29.44941176	,10},
		{1.4757,	29.01176471	,10},
		{1.48049764705882,	28.56	,10},
		{1.48521882352941,	28.09411765	,10},
		{1.48986117647059,	27.61411765	,10},
		{1.49442235294118,	27.12	,10},
		{1.4989,	26.61176471	,10},
		{1.50329176470588,	26.08941176	,10},
		{1.50759529411765,	25.55294118	,10},
		{1.51180823529412,	25.00235294	,10},
		{1.51592823529412,	24.43764706	,10},
		{1.51995294117647,	23.85882353	,10},
		{1.52388,	23.26588235	,10},
		{1.52770705882353,	22.65882353	,10},
		{1.53143176470588,	22.03764706	,10},
		{1.53505176470588,	21.40235294	,10},
		{1.53856470588235,	20.75294118	,10},
		{1.54196823529412,	20.08941176	,10},
		{1.54526,	19.41176471	,10},
		{1.54843764705882,	18.72	,10},
		{1.55149882352941,	18.01411765	,10},
		{1.55444117647059,	17.29411765	,10},
		{1.55726588235294,	16.60235294	,10},
		{1.55997647058824,	15.92470588	,10},
		{1.56257529411765,	15.26117647	,10},
		{1.56506470588235,	14.61176471	,10},
		{1.56744705882353,	13.97647059	,10},
		{1.56972470588235,	13.35529412	,10},
		{1.5719,	12.74823529	,10},
		{1.57397529411765,	12.15529412	,10},
		{1.57595294117647,	11.57647059	,10},
		{1.57783529411765,	11.01176471	,10},
		{1.57962470588235,	10.46117647	,10},
		{1.58132352941177,	9.924705882	,10},
		{1.58293411764706,	9.402352941	,10},
		{1.58445882352941,	8.894117647	,10},
		{1.5859,	8.4	,10},
		{1.58726,	7.92	,10},
		{1.58854117647059,	7.454117647	,10},
		{1.58974588235294,	7.002352941	,10},
		{1.59087647058824,	6.564705882	,10},
		{1.59193529411765,	6.141176471	,10},
		{1.59292470588235,	5.731764706	,10},
		{1.59384705882353,	5.336470588	,10},
		{1.59470470588235,	4.955294118	,10},
		{1.5955,	4.588235294	,10},
		{1.59623529411765,	4.235294118	,10},
		{1.59691294117647,	3.896470588	,10},
		{1.59753529411765,	3.571764706	,10},
		{1.59810470588235,	3.261176471	,10},
		{1.59862352941176,	2.964705882	,10},
		{1.59909411764706,	2.682352941	,10},
		{1.59951882352941,	2.414117647	,10},
		{1.5999,	2.16	,10},
		{1.60024,	1.92	,10},
		{1.60054117647059,	1.694117647	,10},
		{1.60080588235294,	1.482352941	,10},
		{1.60103647058824,	1.284705882	,10},
		{1.60123529411765,	1.101176471	,10},
		{1.60140470588235,	0.931764706	,10},
		{1.60154705882353,	0.776470588	,10},
		{1.60166470588235,	0.635294118	,10},
		{1.60176,	0.508235294	,10},
		{1.60183529411765,	0.395294118	,10},
		{1.60189294117647,	0.296470588	,10},
		{1.60193529411765,	0.211764706	,10},
		{1.60196470588235,	0.141176471	,10},
		{1.60198352941177,	0.084705882	,10},
		{1.60199411764706,	0.042352941	,10},
		{1.60199882352941,	0.014117647	,10},
		{1.602,	0	,10}};
		
		
		
		
		
		
		
		public static final int stageOneNumPoints = 365;	
		// Position (rotations)	Velocity (RPM)	Duration (ms)
		public static double [][]stageOnePoints = new double[][]{		
		{0,	0	,10},
		{7.84313725490196E-06,	0.094117647	,10},
		{3.52941176470588E-05,	0.235294118	,10},
		{9.01960784313725E-05,	0.423529412	,10},
		{0.000180392156862745,	0.658823529	,10},
		{0.000313725490196078,	0.941176471	,10},
		{0.000498039215686275,	1.270588235	,10},
		{0.000741176470588235,	1.647058824	,10},
		{0.00105098039215686,	2.070588235	,10},
		{0.00143529411764706,	2.541176471	,10},
		{0.00190196078431373,	3.058823529	,10},
		{0.00245882352941177,	3.623529412	,10},
		{0.00311372549019608,	4.235294118	,10},
		{0.00387450980392157,	4.894117647	,10},
		{0.00474901960784314,	5.6	,10},
		{0.00574509803921569,	6.352941176	,10},
		{0.00687058823529412,	7.152941176	,10},
		{0.00813333333333333,	8	,10},
		{0.00954117647058823,	8.894117647	,10},
		{0.0111019607843137,	9.835294118	,10},
		{0.0128235294117647,	10.82352941	,10},
		{0.0147137254901961,	11.85882353	,10},
		{0.0167803921568627,	12.94117647	,10},
		{0.0190313725490196,	14.07058824	,10},
		{0.0214745098039216,	15.24705882	,10},
		{0.0241176470588235,	16.47058824	,10},
		{0.0269686274509804,	17.74117647	,10},
		{0.0300352941176471,	19.05882353	,10},
		{0.0333254901960784,	20.42352941	,10},
		{0.0368470588235294,	21.83529412	,10},
		{0.0406078431372549,	23.29411765	,10},
		{0.0446156862745098,	24.8	,10},
		{0.048878431372549,	26.35294118	,10},
		{0.0534039215686275,	27.95294118	,10},
		{0.0582,	29.6	,10},
		{0.0632745098039216,	31.29411765	,10},
		{0.0686352941176471,	33.03529412	,10},
		{0.0742901960784314,	34.82352941	,10},
		{0.0802470588235294,	36.65882353	,10},
		{0.0865137254901961,	38.54117647	,10},
		{0.0930980392156863,	40.47058824	,10},
		{0.100007843137255,	42.44705882	,10},
		{0.107250980392157,	44.47058824	,10},
		{0.114835294117647,	46.54117647	,10},
		{0.12276862745098,	48.65882353	,10},
		{0.131058823529412,	50.82352941	,10},
		{0.139713725490196,	53.03529412	,10},
		{0.148741176470588,	55.29411765	,10},
		{0.158149019607843,	57.6	,10},
		{0.167945098039216,	59.95294118	,10},
		{0.178137254901961,	62.35294118	,10},
		{0.188721568627451,	64.65882353	,10},
		{0.199686274509804,	66.91764706	,10},
		{0.211023529411765,	69.12941176	,10},
		{0.222725490196079,	71.29411765	,10},
		{0.23478431372549,	73.41176471	,10},
		{0.247192156862745,	75.48235294	,10},
		{0.259941176470588,	77.50588235	,10},
		{0.273023529411765,	79.48235294	,10},
		{0.28643137254902,	81.41176471	,10},
		{0.300156862745098,	83.29411765	,10},
		{0.314192156862745,	85.12941176	,10},
		{0.328529411764706,	86.91764706	,10},
		{0.343160784313726,	88.65882353	,10},
		{0.358078431372549,	90.35294118	,10},
		{0.373274509803922,	92	,10},
		{0.388741176470588,	93.6	,10},
		{0.404470588235294,	95.15294118	,10},
		{0.420454901960785,	96.65882353	,10},
		{0.436686274509804,	98.11764706	,10},
		{0.453156862745098,	99.52941176	,10},
		{0.469858823529412,	100.8941176	,10},
		{0.48678431372549,	102.2117647	,10},
		{0.503925490196079,	103.4823529	,10},
		{0.521274509803922,	104.7058824	,10},
		{0.538823529411765,	105.8823529	,10},
		{0.556564705882353,	107.0117647	,10},
		{0.574490196078432,	108.0941176	,10},
		{0.592592156862745,	109.1294118	,10},
		{0.61086274509804,	110.1176471	,10},
		{0.629294117647059,	111.0588235	,10},
		{0.647878431372549,	111.9529412	,10},
		{0.666607843137255,	112.8	,10},
		{0.685474509803922,	113.6	,10},
		{0.704470588235295,	114.3529412	,10},
		{0.723588235294118,	115.0588235	,10},
		{0.742819607843138,	115.7176471	,10},
		{0.762156862745099,	116.3294118	,10},
		{0.781592156862746,	116.8941176	,10},
		{0.801117647058824,	117.4117647	,10},
		{0.820725490196079,	117.8823529	,10},
		{0.840407843137255,	118.3058824	,10},
		{0.860156862745099,	118.6823529	,10},
		{0.879964705882354,	119.0117647	,10},
		{0.899823529411765,	119.2941176	,10},
		{0.919725490196079,	119.5294118	,10},
		{0.93966274509804,	119.7176471	,10},
		{0.959627450980393,	119.8588235	,10},
		{0.979611764705883,	119.9529412	,10},
		{0.999607843137255,	120	,10},
		{1.01960784313726,	120	,10},
		{1.03960784313726,	120	,10},
		{1.05960784313726,	120	,10},
		{1.07960784313726,	120	,10},
		{1.09960784313726,	120	,10},
		{1.11960784313726,	120	,10},
		{1.13960784313726,	120	,10},
		{1.15960784313726,	120	,10},
		{1.17960784313726,	120	,10},
		{1.19960784313726,	120	,10},
		{1.21960784313726,	120	,10},
		{1.23960784313726,	120	,10},
		{1.25960784313726,	120	,10},
		{1.27960784313726,	120	,10},
		{1.29960784313726,	120	,10},
		{1.31960784313726,	120	,10},
		{1.33960784313726,	120	,10},
		{1.35960784313726,	120	,10},
		{1.37960784313726,	120	,10},
		{1.39960784313726,	120	,10},
		{1.41960784313726,	120	,10},
		{1.43960784313726,	120	,10},
		{1.45960784313726,	120	,10},
		{1.47960784313726,	120	,10},
		{1.49960784313726,	120	,10},
		{1.51960784313726,	120	,10},
		{1.53960784313726,	120	,10},
		{1.55960784313726,	120	,10},
		{1.57960784313726,	120	,10},
		{1.59960784313726,	120	,10},
		{1.61960784313726,	120	,10},
		{1.63960784313726,	120	,10},
		{1.65960784313726,	120	,10},
		{1.67960784313726,	120	,10},
		{1.69960784313726,	120	,10},
		{1.71960784313726,	120	,10},
		{1.73960784313726,	120	,10},
		{1.75960784313726,	120	,10},
		{1.77960784313726,	120	,10},
		{1.79960784313726,	120	,10},
		{1.81960784313726,	120	,10},
		{1.83960784313726,	120	,10},
		{1.85960784313726,	120	,10},
		{1.87960784313726,	120	,10},
		{1.89960784313726,	120	,10},
		{1.91960784313726,	120	,10},
		{1.93960784313726,	120	,10},
		{1.95960784313726,	120	,10},
		{1.97960784313726,	120	,10},
		{1.99960784313726,	120	,10},
		{2.01960784313726,	120	,10},
		{2.03960784313726,	120	,10},
		{2.05960784313726,	120	,10},
		{2.07960784313726,	120	,10},
		{2.09960784313726,	120	,10},
		{2.11960784313726,	120	,10},
		{2.13960784313726,	120	,10},
		{2.15960784313726,	120	,10},
		{2.17960784313726,	120	,10},
		{2.19960784313726,	120	,10},
		{2.21960784313726,	120	,10},
		{2.23960784313726,	120	,10},
		{2.25960784313726,	120	,10},
		{2.27960784313726,	120	,10},
		{2.29960784313726,	120	,10},
		{2.31960784313726,	120	,10},
		{2.33960784313726,	120	,10},
		{2.35960784313726,	120	,10},
		{2.37960784313726,	120	,10},
		{2.39960784313726,	120	,10},
		{2.41960784313726,	120	,10},
		{2.43960784313726,	120	,10},
		{2.45960784313726,	120	,10},
		{2.47960784313726,	120	,10},
		{2.49960784313726,	120	,10},
		{2.51960784313726,	120	,10},
		{2.53960784313726,	120	,10},
		{2.55960784313726,	120	,10},
		{2.57960784313726,	120	,10},
		{2.59960784313726,	120	,10},
		{2.61960784313726,	120	,10},
		{2.63960784313726,	120	,10},
		{2.65960784313726,	120	,10},
		{2.67960784313726,	120	,10},
		{2.69960784313726,	120	,10},
		{2.71960784313726,	120	,10},
		{2.73960784313726,	120	,10},
		{2.75960784313726,	120	,10},
		{2.77960784313726,	120	,10},
		{2.79960784313726,	120	,10},
		{2.81960784313726,	120	,10},
		{2.83960784313726,	120	,10},
		{2.85960784313726,	120	,10},
		{2.87960784313726,	120	,10},
		{2.89960784313726,	120	,10},
		{2.91960784313726,	120	,10},
		{2.93960784313726,	120	,10},
		{2.95960784313726,	120	,10},
		{2.97960784313726,	120	,10},
		{2.99960784313726,	120	,10},
		{3.01960784313726,	120	,10},
		{3.03960784313726,	120	,10},
		{3.05960784313726,	120	,10},
		{3.07960784313726,	120	,10},
		{3.09960784313726,	120	,10},
		{3.11960784313726,	120	,10},
		{3.13960784313726,	120	,10},
		{3.15960784313726,	120	,10},
		{3.17960784313726,	120	,10},
		{3.19960784313726,	120	,10},
		{3.21960784313726,	120	,10},
		{3.23960784313726,	120	,10},
		{3.25960784313726,	120	,10},
		{3.27960784313726,	120	,10},
		{3.29960784313726,	120	,10},
		{3.31960784313726,	120	,10},
		{3.33960784313726,	120	,10},
		{3.35960784313726,	120	,10},
		{3.37960784313726,	120	,10},
		{3.39960784313726,	120	,10},
		{3.41960784313726,	120	,10},
		{3.43960784313726,	120	,10},
		{3.45960784313726,	120	,10},
		{3.47960784313726,	120	,10},
		{3.49960784313726,	120	,10},
		{3.51960784313726,	120	,10},
		{3.53960784313726,	120	,10},
		{3.55960784313726,	120	,10},
		{3.57960784313726,	120	,10},
		{3.59960784313726,	120	,10},
		{3.61960784313726,	120	,10},
		{3.63960784313726,	120	,10},
		{3.65960784313726,	120	,10},
		{3.67960784313726,	120	,10},
		{3.69960784313726,	120	,10},
		{3.71960784313726,	120	,10},
		{3.73960784313726,	120	,10},
		{3.75960784313726,	120	,10},
		{3.77960784313726,	120	,10},
		{3.79960784313726,	120	,10},
		{3.81960784313726,	120	,10},
		{3.83960784313726,	120	,10},
		{3.85960784313726,	120	,10},
		{3.87960784313726,	120	,10},
		{3.89960784313726,	120	,10},
		{3.91960784313726,	120	,10},
		{3.93960784313726,	120	,10},
		{3.95960784313726,	120	,10},
		{3.97960784313726,	120	,10},
		{3.99960784313726,	120	,10},
		{4.01960784313726,	120	,10},
		{4.03960784313726,	120	,10},
		{4.05960784313726,	120	,10},
		{4.07960784313726,	120	,10},
		{4.09960784313726,	120	,10},
		{4.11960784313726,	120	,10},
		{4.13960784313725,	120	,10},
		{4.15960784313725,	120	,10},
		{4.17960784313725,	120	,10},
		{4.19960784313725,	120	,10},
		{4.21960784313725,	120	,10},
		{4.23960784313725,	120	,10},
		{4.25960784313725,	120	,10},
		{4.27960784313725,	120	,10},
		{4.29960784313725,	120	,10},
		{4.31960784313725,	120	,10},
		{4.3396,	119.9058824	,10},
		{4.3595725490196,	119.7647059	,10},
		{4.37951764705882,	119.5764706	,10},
		{4.39942745098039,	119.3411765	,10},
		{4.41929411764705,	119.0588235	,10},
		{4.43910980392156,	118.7294118	,10},
		{4.45886666666666,	118.3529412	,10},
		{4.47855686274509,	117.9294118	,10},
		{4.4981725490196,	117.4588235	,10},
		{4.51770588235294,	116.9411765	,10},
		{4.53714901960784,	116.3764706	,10},
		{4.55649411764705,	115.7647059	,10},
		{4.57573333333333,	115.1058824	,10},
		{4.59485882352941,	114.4	,10},
		{4.61386274509803,	113.6470588	,10},
		{4.63273725490196,	112.8470588	,10},
		{4.65147450980392,	112	,10},
		{4.67006666666666,	111.1058824	,10},
		{4.68850588235294,	110.1647059	,10},
		{4.70678431372548,	109.1764706	,10},
		{4.72489411764705,	108.1411765	,10},
		{4.74282745098039,	107.0588235	,10},
		{4.76057647058823,	105.9294118	,10},
		{4.77813333333333,	104.7529412	,10},
		{4.79549019607843,	103.5294118	,10},
		{4.81263921568627,	102.2588235	,10},
		{4.8295725490196,	100.9411765	,10},
		{4.84628235294117,	99.57647059	,10},
		{4.86276078431372,	98.16470588	,10},
		{4.879,	96.70588235	,10},
		{4.89499215686274,	95.2	,10},
		{4.9107294117647,	93.64705882	,10},
		{4.92620392156862,	92.04705882	,10},
		{4.94140784313725,	90.4	,10},
		{4.95633333333333,	88.70588235	,10},
		{4.9709725490196,	86.96470588	,10},
		{4.98531764705882,	85.17647059	,10},
		{4.99936078431372,	83.34117647	,10},
		{5.01309411764705,	81.45882353	,10},
		{5.02650980392156,	79.52941176	,10},
		{5.03959999999999,	77.55294118	,10},
		{5.05235686274509,	75.52941176	,10},
		{5.0647725490196,	73.45882353	,10},
		{5.07683921568627,	71.34117647	,10},
		{5.08854901960784,	69.17647059	,10},
		{5.09989411764705,	66.96470588	,10},
		{5.11086666666666,	64.70588235	,10},
		{5.12145882352941,	62.4	,10},
		{5.13166274509803,	60.04705882	,10},
		{5.14147058823529,	57.64705882	,10},
		{5.1508862745098,	55.34117647	,10},
		{5.15992156862745,	53.08235294	,10},
		{5.16858431372549,	50.87058824	,10},
		{5.17688235294117,	48.70588235	,10},
		{5.18482352941176,	46.58823529	,10},
		{5.19241568627451,	44.51764706	,10},
		{5.19966666666666,	42.49411765	,10},
		{5.20658431372549,	40.51764706	,10},
		{5.21317647058823,	38.58823529	,10},
		{5.21945098039215,	36.70588235	,10},
		{5.22541568627451,	34.87058824	,10},
		{5.23107843137254,	33.08235294	,10},
		{5.23644705882353,	31.34117647	,10},
		{5.2415294117647,	29.64705882	,10},
		{5.24633333333333,	28	,10},
		{5.25086666666666,	26.4	,10},
		{5.25513725490196,	24.84705882	,10},
		{5.25915294117647,	23.34117647	,10},
		{5.26292156862745,	21.88235294	,10},
		{5.26645098039215,	20.47058824	,10},
		{5.26974901960784,	19.10588235	,10},
		{5.27282352941176,	17.78823529	,10},
		{5.27568235294117,	16.51764706	,10},
		{5.27833333333333,	15.29411765	,10},
		{5.28078431372549,	14.11764706	,10},
		{5.2830431372549,	12.98823529	,10},
		{5.28511764705882,	11.90588235	,10},
		{5.28701568627451,	10.87058824	,10},
		{5.28874509803921,	9.882352941	,10},
		{5.29031372549019,	8.941176471	,10},
		{5.2917294117647,	8.047058824	,10},
		{5.293,	7.2	,10},
		{5.29413333333333,	6.4	,10},
		{5.29513725490196,	5.647058824	,10},
		{5.29601960784314,	4.941176471	,10},
		{5.29678823529412,	4.282352941	,10},
		{5.29745098039216,	3.670588235	,10},
		{5.29801568627451,	3.105882353	,10},
		{5.29849019607843,	2.588235294	,10},
		{5.29888235294117,	2.117647059	,10},
		{5.2992,	1.694117647	,10},
		{5.29945098039216,	1.317647059	,10},
		{5.2996431372549,	0.988235294	,10},
		{5.29978431372549,	0.705882353	,10},
		{5.29988235294118,	0.470588235	,10},
		{5.29994509803921,	0.282352941	,10},
		{5.29998039215686,	0.141176471	,10},
		{5.29999607843137,	0.047058824	,10},
		{5.3,	0	,10}};
	}
}
