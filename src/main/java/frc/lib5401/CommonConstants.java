package frc.lib5401;

import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.Robot;

public class CommonConstants {
    public enum RobotMode{
        REAL,
        SIM,
        REPLAY
    }
    public static final RobotMode kSimRobot = RobotMode.SIM;
    public static final RobotMode kCurrentMode = Robot.isReal() ? RobotMode.REAL : kSimRobot; //Change kSimRobot to replay for replay

    public static final boolean kIsCompetition = DriverStation.isFMSAttached();
    public static final boolean kIsLiveTuning = kIsCompetition ? false : true; // To disable live tuning during home use change true to false 

}
