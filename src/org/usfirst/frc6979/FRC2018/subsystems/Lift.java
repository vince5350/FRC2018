package org.usfirst.frc6979.FRC2018.subsystems;

import org.usfirst.frc6979.FRC2018.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lift extends Subsystem{

	 
    private static final DigitalInput liftHighLimit = RobotMap.liftHighLimit;
    private final Spark lift = RobotMap.lift;
    private static final DigitalInput liftLowLimit = RobotMap.liftLowLimit;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    @Override
    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    	SmartDashboard.putBoolean("Lift Top", liftHighLimit.get());
    	SmartDashboard.putBoolean("Lift Bottom", liftLowLimit.get());
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
   public static boolean getTopLimit(){
    	return liftHighLimit.get();
   }
   
   public void setLiftSpeed(double speed) {
	   this.lift.set(speed);
   }
   
   
   public static boolean getBottomLimit() {
	   return liftLowLimit.get();
   } 

}
