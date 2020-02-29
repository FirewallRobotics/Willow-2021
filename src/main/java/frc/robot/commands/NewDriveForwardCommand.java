package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Intake;

public class NewDriveForwardCommand extends Command {

    public NewDriveForwardCommand() {
        requires(Robot.intake);// intake is needed to intake the ball
    }

    protected void initialize() {
        setTimeout(1);
        //Intake.extendSolenoid();
    }

    /*
     * execute() - intake the power cell
     */
    protected void execute() {
        Robot.driveTrain.driveAuto(.35, 0);
        System.out.println("I'm driving");
    }

    /*
     * isFinished
     */
    protected boolean isFinished() {
        return isTimedOut();
        //return false;
    }

    protected void end() {
    }

    protected void interrupted() {
        //Intake.retractSolenoid();
    }
}
