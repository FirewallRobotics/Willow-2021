package frc.robot.commands;
import java.io.IOException;
import java.nio.file.Path;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryUtil;


public class BounceAutoCommand extends Command{

    public BounceAutoCommand() {
    String trajectoryJSON = "paths/bounce_path.wpilib.json";
Trajectory trajectory = new Trajectory();
try {
  Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSON);
  trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);
} catch (IOException ex) {
  DriverStation.reportError("Unable to open trajectory: " + trajectoryJSON, ex.getStackTrace());
}
}

// Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    return true;
    }
}
