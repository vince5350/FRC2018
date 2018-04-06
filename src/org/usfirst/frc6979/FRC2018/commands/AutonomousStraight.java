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
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc6979.FRC2018.RobotMap;
import org.usfirst.frc6979.FRC2018.subsystems.Arm;
import org.usfirst.frc6979.FRC2018.subsystems.Elevator;
import org.usfirst.frc6979.FRC2018.subsystems.Lift;


public class AutonomousStraight extends Command {
	
	private Timer robotTimer;
	public DriverStation DS;
	private final DifferentialDrive autoDrive = RobotMap.driveDifferentialDrive;

	
	
	int robotLocation;
	
	private double TURN_SPEED = (1/3);

	private double DRIVE_SPEED = 0.5;
	
	
	int positionLeft = 1;
	int positionRight = 3;
	int positionMiddle = 2;
	
	//Used for turn
		//Counter clockwise
		private int CCW;
		//Clockwise
		private int CW;
	
	
    public AutonomousStraight() {
    	robotTimer.start();
    	robotLocation = DS.getLocation();
    	
    	
    	
    	//For Left Side
    	if(robotLocation == positionLeft) {
    		straight(DRIVE_SPEED, 4);
    	}
 	
    	
    	
    	//For Middle Side
    	if(robotLocation == positionMiddle) {
    		tankTurn(CW, TURN_SPEED, 1);
    		straight(DRIVE_SPEED, 4);
    		}
  	
    	
    	
    	//For Right Side
    	if(robotLocation == positionRight) {
    		straight(DRIVE_SPEED, 4);
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
}