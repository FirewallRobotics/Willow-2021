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

import frc.robot.RobotMap;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.PIDOutput;
//import edu.wpi.first.wpilibj.PIDSource;
//import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.Controller;
//import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.PWMVictorSPX;
//import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.geometry.Pose2d;

//import java.util.ResourceBundle.Control;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.networktables.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends Subsystem {
    private static WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.LEFT_MASTER_DRIVETRAIN_ADDRESS);
    private static WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.RIGHT_MASTER_DRIVETRAIN_ADDRESS);
    private static WPI_VictorSPX leftSlave = new WPI_VictorSPX(RobotMap.LEFT_SLAVE_DRIVETRAIN_ADDRESS);
    private static WPI_VictorSPX rightSlave = new WPI_VictorSPX(RobotMap.RIGHT_SLAVE_DRIVETRAIN_ADDRESS);
    private static DifferentialDrive m_myRobot;
    private static SpeedControllerGroup m_leftMotors =
    new SpeedControllerGroup(
        leftMaster,
        leftSlave);
    private static SpeedControllerGroup m_rightMotors =
    new SpeedControllerGroup(
        rightMaster,
        rightSlave);
    private static Encoder m_leftEncoder =
    new Encoder(
        RobotMap.kLeftEncoderPorts[0],
        RobotMap.kLeftEncoderPorts[1],
        RobotMap.kLeftEncoderIndex);
    private static Encoder m_rightEncoder =
    new Encoder(
        RobotMap.kRightEncoderPorts[0],
        RobotMap.kRightEncoderPorts[1],
        RobotMap.kRightEncoderIndex);
    private static Gyro m_gyro = new ADXRS450_Gyro();

      // Odometry class for tracking robot pose
  public final DifferentialDriveOdometry m_odometry;
  public static final double kTrackwidthMeters = 0.67;
  public static final DifferentialDriveKinematics kDriveKinematics =
      new DifferentialDriveKinematics(kTrackwidthMeters);
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    private static NetworkTableInstance inst = NetworkTableInstance.getDefault();
    private static NetworkTable table = inst.getTable("powerball");
    private static NetworkTableEntry x = table.getEntry("X");
    private static NetworkTableEntry y = table.getEntry("Y");
    private static NetworkTableEntry radius = table.getEntry("R");
    private static NetworkTable goalTable = inst.getTable("goal");
    private static NetworkTableEntry goalX = goalTable.getEntry("X");
    private static NetworkTableEntry goalY = goalTable.getEntry("Y");
    private static NetworkTableEntry goalRadius = goalTable.getEntry("R");

    public static double goalMaxRadius = 98;
    private static double goalMinRadius = 5;
    private static double goalMaxOutR = 1;
    private static double goalMinOutR = -1;

    // Ball radius when we stop will be 37.5 / 160 = 0.23
    private static double goalNeutralOffSetR = 0.23;
    private static double goalPGainR = 0.250;
    private static double goalMaxX = 150;
    private static double goalMinX = 5;
    private static double goalMaxx = 1;
    private static double goalMinx = -1;
    private static double goalNeutralOffSetX = 0;
    private static double goalPGainX = 0.25;
    private static double goalScaledX = 0;
    public static double goalScaledRadius = 0;
    public static double MaxRadius = 38;
    private static double MinRadius = 7;
    private static double MaxOutR = 1;
    private static double MinOutR = -1;
    private static double NeutralOffSetR = 0.25;
    private static double PGainR = 0.250;
    private static double MaxX = 150;
    private static double MinX = 5;
    private static double Maxx = 1;
    private static double Minx = -1;

    // NeutralOffSetX - center of ball is at 937 / 1280 = 0.76 on the x axis when 
    // robot is right on the ball.  640 / 1280 = 0.50 is straight in the middle.  
    // 0.76 - 0.50 = 0.26.
    private static double NeutralOffSetX = 0.26;
    private static double PGainX = 0.25;
    private static double ScaledX = 0;
    public static double ScaledRadius = 0;

    //encoder
    private static double m_distancePerPulse;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public DriveTrain() {
        // Factory default Talons and Victors before configuring
        leftMaster.configFactoryDefault();
        rightMaster.configFactoryDefault();
        leftSlave.configFactoryDefault();
        rightSlave.configFactoryDefault();

        m_myRobot = new DifferentialDrive(m_leftMotors, m_rightMotors);
        m_myRobot.setDeadband(RobotMap.DRIVETRAIN_DEADBAND);
        leftSlave.follow(leftMaster);
        rightSlave.follow(rightMaster);
        //sets the distance per pulse for the encoders
        m_leftEncoder.setDistancePerPulse(RobotMap.kEncoderDistancePerPulse);
        m_rightEncoder.setDistancePerPulse(RobotMap.kEncoderDistancePerPulse);
    
        resetEncoders();
        m_odometry = new DifferentialDriveOdometry(m_gyro.getRotation2d());
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveTrainCommand());
    }

    @Override
    public void periodic() {
            // Update the odometry in the periodic block
        m_odometry.update(
            m_gyro.getRotation2d(), m_leftEncoder.getDistance(), m_rightEncoder.getDistance());
        SmartDashboard.putNumber("goalScaledX", goalScaledX);
        SmartDashboard.putNumber("goalScaledRadius",goalScaledRadius);
        SmartDashboard.putNumber("ScaledX", ScaledX);
        SmartDashboard.putNumber("ScaledRadius",ScaledRadius);
        SmartDashboard.putNumber("LeftMaster",leftMaster.getStatorCurrent());
        SmartDashboard.putNumber("RightMaster",rightMaster.getStatorCurrent());
        SmartDashboard.putNumber("LeftRate", m_leftEncoder.getRate());
        SmartDashboard.putNumber("RightRate", m_rightEncoder.getRate());

    }
    public void resetEncoders() {
        m_leftEncoder.reset();
        m_rightEncoder.reset();
      }
      public void setDistancePerPulse(double distancePerPulse) {
        m_distancePerPulse = distancePerPulse;
      }
      public double getAverageEncoderDistance() {
        return (m_leftEncoder.getDistance() + m_rightEncoder.getDistance()) / 2.0;
      }
      public Encoder getLeftEncoder() {
        return m_leftEncoder;
      }
      public Encoder getRightEncoder() {
        return m_rightEncoder;
      }
      public void tankDriveVolts(double leftVolts, double rightVolts) {
        m_leftMotors.setVoltage(0.2*leftVolts);
        m_rightMotors.setVoltage(0.2*-rightVolts);
        m_myRobot.feed();
      }
      public void m_odometry(Pose2d initialPose) {
	}
      /**
   * Sets the max output of the drive. Useful for scaling the drive to drive more slowly.
   *
   * @param maxOutput the maximum output to which the drive will be constrained
   */
  public void setMaxOutput(double maxOutput) {
    m_myRobot.setMaxOutput(maxOutput);
  }

  /** Zeroes the heading of the robot. */
  public void zeroHeading() {
    m_gyro.reset();
  }
  public double getHeading() {
    return m_gyro.getRotation2d().getDegrees();
  }
  public double getTurnRate() {
    return -m_gyro.getRate();
  }
      public static void Drive(double y, double y2, boolean extraButtonPressed) {

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS
        String driveChoiceSelected = SmartDashboard.getString("DriveChoice", "ArcadeDrive");
        System.out.println("DriveChoice " + driveChoiceSelected);
        switch (driveChoiceSelected) {
        case "CurvatureDrive":
            m_myRobot.curvatureDrive(y, y2, extraButtonPressed);
            break;
        case "TankDrive":
            m_myRobot.tankDrive(y, y2);
            break;
        default:
            // default to curvature drive
            m_myRobot.tankDrive(.75*y, .75*y2);
            break;
        }
    }

    public static void testMotors(double motorSpeed) {
        m_myRobot.tankDrive(motorSpeed, motorSpeed);
    }

    public static void testOneMotorAtATimePerSide() {
        leftMaster.set(0.5);
        rightMaster.set(0.5);
    }

    public static void driveToPowerCell() {
        double X = Math.round(x.getDouble(-1));
        double Radius = Math.round(radius.getDouble(-1));
        if (X == -1) {
            ScaledX = 0;
            ScaledRadius = 0;
        } else {
            ScaledX = PGainX * ((((Maxx - Minx) * ((X - MinX) / (MaxX - MinX))) + Minx) - NeutralOffSetX);
            ScaledRadius =  PGainR * ((((MaxOutR - MinOutR)*((Radius - MinRadius)/(MaxRadius - MinRadius))) + MinOutR) -  NeutralOffSetR);
        }
        
        Double LeftSpeed = (ScaledRadius +  ScaledX);
        Double RightSpeed = -(ScaledRadius -  ScaledX);
        //System.out.println("ScaledX: "+ ScaledX + " ScaledRadius: " + ScaledRadius);
        //System.out.println("LeftSpeed: "+ LeftSpeed + " RightSpeed: " + RightSpeed);
        leftMaster.set(ControlMode.PercentOutput,  -RightSpeed);
        rightMaster.set(ControlMode.PercentOutput, -LeftSpeed);

    }

	public void moveToShootingSpot() {
        double X = Math.round(goalX.getDouble(-1));
        double Radius = Math.round(goalRadius.getDouble(-1));
        if (X == -1) {
            goalScaledX = 0;
            goalScaledRadius = 0;
        } else {
            goalScaledX = goalPGainX * ((((goalMaxx - goalMinx) * ((X - goalMinX) / (goalMaxX - goalMinX))) + goalMinx) - goalNeutralOffSetX);
            goalScaledRadius =  goalPGainR * ((((goalMaxOutR - goalMinOutR)*((Radius - goalMinRadius)/(goalMaxRadius - goalMinRadius))) + goalMinOutR) -  goalNeutralOffSetR);
        }
        
        Double LeftSpeed = (goalScaledRadius +  goalScaledX);
        Double RightSpeed = -(goalScaledRadius -  goalScaledX);
        //System.out.println("goalScaledX: "+ goalScaledX + " goalScaledRadius: " + goalScaledRadius);
        //System.out.println("LeftSpeed: "+ LeftSpeed + " RightSpeed: " + RightSpeed);
        leftMaster.set(ControlMode.PercentOutput,  -RightSpeed);
        rightMaster.set(ControlMode.PercentOutput, -LeftSpeed);
               
    }
    public void driveAuto(double speed, double turnRate) {
        System.out.println("Entering driveAuto command");
        //m_myRobot.arcadeDrive(speed, turnRate);
        leftMaster.set(ControlMode.PercentOutput,  -speed);
        rightMaster.set(ControlMode.PercentOutput, speed);
    }

    public Pose2d getPose() {
        return m_odometry.getPoseMeters();
    }
    public DifferentialDriveWheelSpeeds getWheelSpeeds() {
        return new DifferentialDriveWheelSpeeds(m_leftEncoder.getRate(), m_rightEncoder.getRate());
      }
	public Object arcadeDrive(int i, double output) {
		return null;
	}
}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
