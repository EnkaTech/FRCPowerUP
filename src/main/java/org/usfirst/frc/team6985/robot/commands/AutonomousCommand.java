package org.usfirst.frc.team6985.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {

    public AutonomousCommand(int x) {
    	//Station 1
    	switch(x) {
    		case 1:
    	
    		switch (DriverStation.getInstance().getGameSpecificMessage().charAt(0)) {
	        	
	        	case 'L':
	        		addSequential(new Grip(0.6), 0.3);
	        		addSequential(new Gyroverse(6, false));
	        		addSequential(new GyroTurn(90));
	        		addSequential(new Gyroverse(1, false));
	        		addSequential(new RemGripperTimed(1,-0.5));
	        		addSequential(new Grip(-0.6));
	        		addSequential(new Gyroverse(0.3,false));
	        		addSequential(new Gyroverse(0.3,true));
	        		break;
	        	case 'R':
	        		addSequential(new Gyroverse(7,false));
	        		break;
    		}
    		break;
    		
    		
    	//Station 2
    		case 2:
    		switch(DriverStation.getInstance().getGameSpecificMessage().charAt(0)) {
    		case 'R':
		        	addSequential(new Grip(0.6), 0.3);
		        	addSequential(new Gyroverse(0.7, false));
		        	addSequential(new GyroTurn(40));
		        	addSequential(new Gyroverse(3.4, false));
		        	addSequential(new GyroTurn(-40));
		        	addSequential(new Gyroverse(2, false));
		        	addSequential(new RemGripperTimed(1,-0.5));
		        	addSequential(new Grip(-0.6));
		        	addSequential(new Gyroverse(0.3,false));
		        	addSequential(new Gyroverse(0.3,true));
		        	break;
    		
    		case 'L': 
		        	addSequential(new Grip(0.6), 0.3);
		        	addSequential(new Gyroverse(0.7, false));
		            addSequential(new GyroTurn(-40));
		            addSequential(new Gyroverse(3.4, false));
		            addSequential(new GyroTurn(40));
		            addSequential(new Gyroverse(2, false));
		            addSequential(new RemGripperTimed(1,-0.5));
		            addSequential(new Grip(-0.6));
		            addSequential(new Gyroverse(0.3,false));
		            addSequential(new Gyroverse(0.3,true));
		            break;
    		}
                break;
    	//Station 3
    		case 3:
    		switch (DriverStation.getInstance().getGameSpecificMessage().charAt(0)) {
    			case 'L':
    				addSequential(new Gyroverse(7,false));
    				break;
    			case 'R':
		    		addSequential(new Grip(0.6), 0.3);
		    		addSequential(new Gyroverse(6, false));
		    		addSequential(new GyroTurn(-90));
		    		addSequential(new Gyroverse(1, false));
		    		addSequential(new RemGripperTimed(1,-0.5));
		    		addSequential(new Grip(-0.6));
		    		addSequential(new Gyroverse(0.3,false));
		    		addSequential(new Gyroverse(0.3,true));
		    		break;
    		}
    		break;
    		
    		
    		}
    	}
    }
    	
    

