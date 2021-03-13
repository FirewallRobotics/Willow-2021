package frc.robot.commands;

public class BounceAutoCommand {
    String trajectoryJSON = "paths/YourPath.wpilib.json";
Trajectory trajectory = new Trajectory();
try {
  Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSON);
  trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);
} catch (IOException ex) {
  DriverStation.reportError("Unable to open trajectory: " + trajectoryJSON, ex.getStackTrace());
}
}
