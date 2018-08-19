/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6985.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//Motors
	
	public static SpeedController rampMotor = new PWMTalonSRX(0);
	public static SpeedController clawMotor = new PWMTalonSRX(1);
	public static SpeedController elevatorMotor = new Spark(2);
	public static SpeedController jointMotor = new Spark(3);
	public static SpeedController ropeMotor1 = new Victor(4);
	public static SpeedController ropeMotor2 = new Victor(5);
	public static SpeedController leftMotor1 = new Victor(6);
	public static SpeedController leftMotor2 = new Victor(7);
	public static SpeedController rightMotor1 = new Victor(8);
	public static SpeedController rightMotor2 = new Victor(9);
	
	//DriveTrain & Controller Groups
	
	public static SpeedController left= new SpeedControllerGroup(leftMotor1,leftMotor2);
	public static SpeedController right= new SpeedControllerGroup(rightMotor1,rightMotor2);
	public static DifferentialDrive driveSystem = new DifferentialDrive(left,right);
	public static SpeedController ropeMotors = new SpeedControllerGroup(ropeMotor1,ropeMotor2);
	
	//Switches
	
	public static DigitalInput elevatorTop = new DigitalInput(0);
	public static DigitalInput elevatorBottom = new DigitalInput(1);
	public static DigitalInput clawSwitch = new DigitalInput(2);
	public static DigitalInput jointSwitch = new DigitalInput(3);
	
}
