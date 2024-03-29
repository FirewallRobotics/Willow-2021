package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Intake;

public class IntakeStopCommand extends Command {

    public IntakeStopCommand() {
        requires(Robot.intake);// intake is needed to intake the ball
    }

    protected void initialize() {
        //Intake.extendSolenoid();
    }

    /*
     * execute() - intake the power cell
     */
    protected void execute() {
        Robot.intake.stop();
    }

    /*
     * isFinished
     */
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
        //Intake.retractSolenoid();
    }
}
