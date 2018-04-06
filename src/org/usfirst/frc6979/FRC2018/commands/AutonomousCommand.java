// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6979.FRC2018.commands;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc6979.FRC2018.Robot;
import org.usfirst.frc6979.FRC2018.RobotMap;
import org.usfirst.frc6979.FRC2018.subsystems.Arm;
import org.usfirst.frc6979.FRC2018.subsystems.Elevator;
import org.usfirst.frc6979.FRC2018.subsystems.Lift;


public class AutonomousCommand extends Command {
	
	private Timer robotTimer = new Timer();
	public DriverStation DS;
	private final DifferentialDrive autoDrive = RobotMap.driveDifferentialDrive;
	private Lift lift;
	private Elevator elevator;
	private Arm arm;
	
	
	
	int robotLocation;
	
	
	private double LIFT_SPEED = 0.2;
	private double ELEVATOR_SPEED = 0.3;
	private double TURN_SPEED = 0.4;
	private double MIDDLE_DRIVE = 0.3;
	private double DRIVE_SPEED = 0.5;
	private double ARM_SPEED = 0.6;
	
	
	private int positionLeft = 1;
	private int positionRight = 3;
	private int positionMiddle = 2;
	
	//Used for turn
		//Counter clockwise
		private int CCW;
		//Clockwise
		private int CW;

	
    public AutonomousCommand() {
    	robotTimer.start();

    	//robotLocation = DS.getLocation();
    	robotLocation = 1;
    	//Raise lift to clear switch; Should only need a foot but extra space just in case.
    	arm.closeArm(Value.kForward);
    	upLift(LIFT_SPEED);
    	
    	
    	
    	
    	//For Left Side
    	if(robotLocation == positionLeft) {
    		//check gameData for switch colour
    		if(Robot.gameData.length() > 0) { //If switch on left side
    			if(Robot.gameData.charAt(0) == 'L') {
    				straight(DRIVE_SPEED, 4);
    				tankTurn(CW, TURN_SPEED, 1);
    				downLift(LIFT_SPEED);
    			} else {
    				straight(0, 5);
    			  }
    		}
    	}
    	
    	
    	
    	
    	//For Middle Side
    	
    	//TODO
    	if(robotLocation == positionMiddle) {
    		if(Robot.gameData.length() > 0) {
    			if(Robot.gameData.charAt(0) == 'L') {
    				tankTurn(CCW, TURN_SPEED, 0.35);
    				straight(DRIVE_SPEED, 4);
    				//Whatever makes this turn straight again
    				tankTurn(CW, TURN_SPEED, 0.35);
    				downLift(LIFT_SPEED);
    				arm.closeArm(Value.kReverse);
					arm.setArmSpeed(ARM_SPEED);
    			}
    			
    			else if(Robot.gameData.charAt(0) == 'R') {
    				tankTurn(CW, TURN_SPEED, 0.25);
    				straight(DRIVE_SPEED, 4);
    				tankTurn(CCW, TURN_SPEED, 0.25);
    				downLift(LIFT_SPEED);
    				arm.closeArm(Value.kReverse);
    				arm.setArmSpeed(ARM_SPEED);
    			} else {
    				straight(0,5);
    			  }
    		}
    	}
    	
    	
    	
    	
    	//For Right Side
    	if(robotLocation == positionRight) {
    		if(Robot.gameData.length() > 0) {
    			if(Robot.gameData.charAt(0) == 'R') {
    				straight(DRIVE_SPEED, 4);
    				tankTurn(CCW, TURN_SPEED, 1);
    				downLift(LIFT_SPEED);
    			} else {
    				straight(0, 5);
    			  }
    		}
    	}
    	
    }	

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	robotLocation = DS.getLocation();
    	robotTimer.reset();
    	robotTimer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
    
    private void straight(double speed, double time) {
    	robotTimer.reset();
    	while(robotTimer.get() < time) {
    		autoDrive.tankDrive(speed, speed);
    	}
    }

	private void tankTurn(int direction, double speed, double time) {
		robotTimer.reset();
		//Only CCW and CW can be used.
		
		if(direction == CCW) {
			while(robotTimer.get() < time) {
				autoDrive.tankDrive(-speed, speed);
			}
		}
		
		else if(direction == CW) {
			while(robotTimer.get() < time) {
				autoDrive.tankDrive(speed, -speed);
			}
		}
				
	}
	
	private void downLift(double speed) {
		robotTimer.reset();
		//Up is negative speed; vice versa
		while(robotTimer.get() < 3) {
    		if(Lift.getTopLimit() || !Lift.getBottomLimit()) {
    			lift.setLiftSpeed(speed);
    		} else if (Lift.getBottomLimit()) {
    			lift.setLiftSpeed(0);
    		}
    	}
	}
	
	private void upLift(double speed) {
		robotTimer.reset();
		while(robotTimer.get() < 3) {
    		if(!Lift.getTopLimit() || Lift.getBottomLimit()) {
    			lift.setLiftSpeed(-speed);
    		} else if (Lift.getTopLimit()) {
    			lift.setLiftSpeed(0);
    		}
    	}
	}
	
}