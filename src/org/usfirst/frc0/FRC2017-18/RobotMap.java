// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc0.FRC2017-18;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static WPI_TalonSRX drivefrontLeft;
    public static WPI_TalonSRX drivefrontRight;
    public static WPI_TalonSRX drivebackLeft;
    public static WPI_TalonSRX drivebackRight;
    public static RobotDrive driveRobotDrive;
    public static DigitalInput elevatortopElevLimit;
    public static WPI_TalonSRX elevatorElevator;
    public static DigitalInput elevatorbottomElevLimit;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivefrontLeft = new WPI_TalonSRX(0);
        
        
        drivefrontRight = new WPI_TalonSRX(1);
        
        
        drivebackLeft = new WPI_TalonSRX(2);
        
        
        drivebackRight = new WPI_TalonSRX(3);
        
        
        driveRobotDrive = new RobotDrive(drivefrontLeft, drivefrontRight,
              drivebackLeft, drivebackRight);
        
        driveRobotDrive.setSafetyEnabled(true);
        driveRobotDrive.setExpiration(0.1);
        driveRobotDrive.setSensitivity(0.5);
        driveRobotDrive.setMaxOutput(0.7);
        driveRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        driveRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        elevatortopElevLimit = new DigitalInput(1);
        LiveWindow.addSensor("Elevator", "topElevLimit", elevatortopElevLimit);
        
        elevatorElevator = new WPI_TalonSRX(4);
        
        
        elevatorbottomElevLimit = new DigitalInput(0);
        LiveWindow.addSensor("Elevator", "bottomElevLimit", elevatorbottomElevLimit);
        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}