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

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.GenericHID;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.GenericHID.Hand;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class LogicEngine extends Subsystem {
    private static boolean testmode=false;
    private static boolean nvtestmode=false;
    //private static OI oi = Robot.oi;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public LogicEngine() {
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
            //XboxController controller1 = Robot.oi.get1stXboxController();
            //XboxController controller2 = Robot.oi.get2ndXboxController();
            // Willow
            //DriveTrain.Drive(-controller1.getY(GenericHID.Hand.kLeft),controller1.getX(GenericHID.Hand.kRight),controller1.getBumperPressed(GenericHID.Hand.kRight));
            // MiniWillow
            //DriveTrain.Drive(controller1.getY(GenericHID.Hand.kLeft),-controller1.getX(GenericHID.Hand.kRight),controller1.getBumper(GenericHID.Hand.kRight));
            //Shooter.moveTurret(controller2.getBumper(GenericHID.Hand.kLeft),controller2.getBumper(GenericHID.Hand.kRight));
            //Shooter.shoot(controller2.getTriggerAxis(Hand.kLeft));
            /*if (controller2.getStartButtonPressed()){
                if (nvtestmode==true){
                    nvtestmode = false;
                }
                else{
                    nvtestmode = true;
                }
            }
            if (testmode==true) {
                //DriveTrain.testMotors(RobotMap.MOTOR_TEST_SPEED);
                Indexer.testMotors(RobotMap.MOTOR_TEST_SPEED);
                Intake.testMotors(RobotMap.MOTOR_TEST_SPEED);
                Elevator.testMotors(RobotMap.MOTOR_TEST_SPEED);
                Shooter.testMotors(RobotMap.MOTOR_TEST_SPEED);
                //DriveTrain.driveToPowerCell();
            }
            if (nvtestmode==true) {
                //DriveTrain.driveToPowerCell();
                //Indexer.testMotors(RobotMap.MOTOR_TEST_SPEED);
                //Intake.testMotors(RobotMap.MOTOR_TEST_SPEED);
                //Elevator.testMotors(RobotMap.MOTOR_TEST_SPEED);
                //Shooter.testMotors(RobotMap.MOTOR_TEST_SPEED);

            }*/

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}