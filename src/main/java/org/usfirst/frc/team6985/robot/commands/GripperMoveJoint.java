package org.usfirst.frc.team6985.robot.commands;

import org.usfirst.frc.team6985.robot.Robot;
import org.usfirst.frc.team6985.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GripperMoveJoint extends Command {

    public GripperMoveJoint() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gripperJoint);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gripperJoint.move(Robot.oi.secondary);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (!RobotMap.jointSwitch.get() && Robot.oi.secondary.getRawAxis(2)-Robot.oi.secondary.getRawAxis(3)<0);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gripperJoint.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
