package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.RobotMap;

public class ShootUpperPowerCells extends CommandGroup {

    public ShootUpperPowerCells() {
       //addSequential(new LightUpCommand());
       addParallel(new ShooterMoveCommand());
       //addParallel(new adjustTurretCommand());
       addSequential(new StartShooterCommand());
       addSequential(new FlushIndexerCommand());
       addSequential(new TimedCommand(RobotMap.FLUSH_INDEXER_TIME));
       addSequential(new StopIndexer());
       addSequential(new StopShooter());
    }
}