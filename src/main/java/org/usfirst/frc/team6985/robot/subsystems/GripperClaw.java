package org.usfirst.frc.team6985.robot.subsystems;

import org.usfirst.frc.team6985.robot.RobotMap;
import org.usfirst.frc.team6985.robot.commands.Grip;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GripperClaw extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Grip(0));
    }
    public void move(double x){
    	RobotMap.clawMotor.set(x);
    }
}

