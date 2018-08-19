package org.usfirst.frc.team6985.robot.commands;

import org.usfirst.frc.team6985.robot.Robot;
import org.usfirst.frc.team6985.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Grip extends Command {
double x;
    public Grip(double x) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gripperClaw);
    	this.x=x;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gripperClaw.move(x);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return(!RobotMap.clawSwitch.get() && x<0);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gripperClaw.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
