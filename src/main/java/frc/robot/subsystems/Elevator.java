// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
//import frc.robot.commands.*;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

//import edu.wpi.first.wpilibj.PIDOutput;
//import edu.wpi.first.wpilibj.PIDSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

//need 3 sparks for the elevator
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Elevator extends Subsystem {
        //private static Spark climbSpark1 = new Spark(RobotMap.FIRST_ELEVATOR_ADDRESS);
        //private static Spark climbSpark2 = new Spark(RobotMap.SECOND_ELEVATOR_ADDRESS);
        //private static WPI_VictorSPX pullupVictor1 = new WPI_VictorSPX(RobotMap.PULLUP_ELEVATOR1_ADDRESS);
        //private static WPI_VictorSPX pullupVictor2 = new WPI_VictorSPX(RobotMap.PULLUP_ELEVATOR2_ADDRESS);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

        public Elevator() {
            // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

            // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        }

        @Override
        public void initDefaultCommand() {
            // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

            // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

            // Set the default command for a subsystem here.
            // setDefaultCommand(new MySpecialCommand());
        }

        @Override
        public void periodic() {
            // Put code here to be run every loop

        }

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

        // Put methods for controlling this subsystem
        // here. Call these from Commands.
        public static void testMotors(double motorSpeed) {
            // leftMaster.set(motorSpeed);
            // rightMaster.set(motorSpeed);
        }

        public static void extendArms() {
            //climbSpark1.set(.2);
            //climbSpark2.set(-.2);
            System.out.println("Elevator Is On");
    }

    public static void retractArms() {
        //pullupVictor1.set(.7);
        //pullupVictor2.set(.7);
    }
    public static void stopArms() {
        //pullupVictor1.set(0);
        //pullupVictor2.set(0);
        //climbSpark1.set(0);
        //climbSpark2.set(0);
    }
}

