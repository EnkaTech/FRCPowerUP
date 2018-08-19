package org.usfirst.frc.team6985.robot.subsystems;

import org.usfirst.frc.team6985.robot.RobotMap;
import org.usfirst.frc.team6985.robot.commands.Release;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RampReleaser extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Release(0));
    }
    public void move(double x){
    	RobotMap.rampMotor.set(x);
    }
}

