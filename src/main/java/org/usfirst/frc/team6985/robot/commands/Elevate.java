package org.usfirst.frc.team6985.robot.commands;

import org.usfirst.frc.team6985.robot.Robot;
import org.usfirst.frc.team6985.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Elevate extends Command {
double x;
    public Elevate(double x) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gripperElevator);
    	this.x=x;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gripperElevator.move(x);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(!RobotMap.elevatorTop.get() && x>0)
    		return true;
    	else if (!RobotMap.elevatorBottom.get() && x<0)
    		return true;
    	else
    		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gripperElevator.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
