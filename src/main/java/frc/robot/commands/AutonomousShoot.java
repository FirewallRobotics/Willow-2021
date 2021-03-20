package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class AutonomousShoot extends CommandGroup {

    public AutonomousShoot() {
        //addSequential(new TimedCommand(1.0));
        //addSequential(new ShootUpperPowerCells());  
        //addSequential(new TimedCommand(5.0));
        //addSequential(new StopShooter());
        //addParallel(new NewDriveForwardCommand());
        //addParallel(new BounceAutoCommand());
    }
}
