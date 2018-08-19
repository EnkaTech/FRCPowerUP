/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6985.robot;

import org.usfirst.frc.team6985.robot.commands.Attractor;
import org.usfirst.frc.team6985.robot.commands.Elevate;
import org.usfirst.frc.team6985.robot.commands.Grip;
import org.usfirst.frc.team6985.robot.commands.Release;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick primary = new Joystick(0);
	public Joystick secondary = new Joystick(1);
	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	Button A1 = new JoystickButton(primary,1);
	Button B1 = new JoystickButton(primary,2);
	Button X1 = new JoystickButton(primary,3);
	Button Y1 = new JoystickButton(primary,4);
	public Button L1 = new JoystickButton(primary,5);
	public Button R1 = new JoystickButton(primary,6);
	Button A2 = new JoystickButton(secondary,1);
	Button B2 = new JoystickButton(secondary,2);
	Button X2 = new JoystickButton(secondary,3);
	Button Y2 = new JoystickButton(secondary,4);
	Button L1_sec = new JoystickButton(secondary,5);
	Button R1_sec = new JoystickButton(secondary,6);
	Button Back = new JoystickButton(secondary,7);
	Button Start = new JoystickButton(secondary,8);
	OI(){
		A1.whileHeld(new Grip(-0.8));
		B1.whileHeld(new Grip(0.8));
		X2.whileHeld(new Elevate(-1));
		Y2.whileHeld(new Elevate(1));
		L1_sec.whileHeld(new Attractor(-1));
		R1_sec.whileHeld(new Attractor(1));
		Back.whileHeld(new Release(0.4));
		Start.whileHeld(new Release(-0.4));
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
