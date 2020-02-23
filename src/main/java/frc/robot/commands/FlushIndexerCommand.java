package frc.robot.commands;
import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;
import frc.robot.subsystems.Indexer;

public class FlushIndexerCommand extends TimedCommand {

    public FlushIndexerCommand(double timeout) {
        super(timeout);
        requires(Robot.indexer);// indexer is needed to intake the ball
    }

    protected void initialize() {
        Indexer.flush();
    }

    protected void end() {
        Indexer.stop();
    }
}
