/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6985.robot;

import org.usfirst.frc.team6985.robot.commands.AutonomousCommand;
import org.usfirst.frc.team6985.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6985.robot.subsystems.GripperClaw;
import org.usfirst.frc.team6985.robot.subsystems.GripperElevator;
import org.usfirst.frc.team6985.robot.subsystems.GripperJoint;
import org.usfirst.frc.team6985.robot.subsystems.RampAttractor;
import org.usfirst.frc.team6985.robot.subsystems.RampReleaser;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	public static OI oi;
	public static DriveTrain driveTrain;
	public static GripperJoint gripperJoint;
	public static GripperElevator gripperElevator;
	public static GripperClaw gripperClaw;
	public static RampReleaser rampReleaser;
	public static RampAttractor rampAttractor;
	public static SendableChooser<Integer> autoChooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		rampAttractor = new RampAttractor();
		rampReleaser = new RampReleaser();
		gripperClaw = new GripperClaw();
		gripperElevator = new GripperElevator();
		oi = new OI();
		driveTrain = new DriveTrain();
		gripperJoint = new GripperJoint();
		autoChooser = new SendableChooser<Integer>();
		oi.gyro.calibrate();
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setVideoMode(VideoMode.PixelFormat.kYUYV,320,180,30);
		SmartDashboard.putData("Autonomous",autoChooser);
		autoChooser.addObject("Station 1-Left", 1);
		autoChooser.addDefault("Station 2-Middle", 2);
		autoChooser.addObject("Station 3-Right", 3);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		oi.gyro.reset();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		new AutonomousCommand(autoChooser.getSelected()).start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("gyro",Robot.oi.gyro.getAngle());
		}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
