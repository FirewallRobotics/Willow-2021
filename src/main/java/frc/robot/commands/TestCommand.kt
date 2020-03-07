/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package src.main.java.frc.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.robot.Robot

/**
 * An example command. You can replace me with your own command.
 */
class TestCommand : Command() {
  init {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveTrain)
  }

  // Called just before this Command runs the first time
  override fun initialize() {}

  // Called repeatedly when this Command is scheduled to run
  override fun execute() {
    Robot.driveTrain.driveAuto(0.35,0)
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun isFinished(): Boolean {
    return isTimedOut()
  }

  // Called once after isFinished returns true
  override fun end() {
    Robot.driveTrain.stop()
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  override fun interrupted() {}
}
