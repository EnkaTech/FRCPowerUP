package org.usfirst.frc.team6985.robot.subsystems;

import org.usfirst.frc.team6985.robot.RobotMap;
import org.usfirst.frc.team6985.robot.commands.GripperMoveJoint;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GripperJoint extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new GripperMoveJoint());
    }
    public void move(double x) {
    	RobotMap.jointMotor.set(x);
    }
    public void move(Joystick joy) {
    	move(joy.getRawAxis(2)-joy.getRawAxis(3));
    }
}

