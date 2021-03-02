package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

public class AutonomousShoot extends CommandGroup {

    public AutonomousShoot() {
        addParallel(new ShootUpperPowerCells());
        addSequential(new NewDriveForwardCommand());
        addSequential(new TimedCommand(1.0));
        addParallel(new StopShooter());
    }
}
