package org.usfirst.frc.team6985.robot.subsystems;

import org.usfirst.frc.team6985.robot.RobotMap;
import org.usfirst.frc.team6985.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private final double Kp = 0.02;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new JoystickDrive());
    }
    public void drive(double x,double y) {
    	RobotMap.driveSystem.tankDrive(x, y);
    }
    public void drive(Joystick joy,double mult) {
    	drive(joy.getRawAxis(5)*mult,joy.getRawAxis(1)*mult);
    }
	public void GyroDrive(ADXRS450_Gyro gyro,boolean x) {
		double angle = gyro.getAngle();
		if(x) {
			drive((0.5-angle*Kp),(0.5+angle*Kp));
		}
		else {
			drive(-(angle*Kp+0.5),-(0.5-angle*Kp));
		}
		Timer.delay(0.0004);
	}
	public void GyroTurn(ADXRS450_Gyro gyro,double turn) {
		double angle = gyro.getAngle();
		double power=(turn-angle)*Kp*8;
		if (power>=0.7)
		{
			power=0.7;
		}
		else if(power>0) {
			power= 0.5;
		}
		else if(power <= -0.7) {
			power= -0.7;
		}
		else {
			power= -0.5;
		}
		Timer.delay(0.0004);
		drive(power,-power);
		
	}

}

