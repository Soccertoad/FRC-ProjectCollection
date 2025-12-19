package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotBase;

public class Constants {

    public static final Mode CURRENT_MODE = RobotBase.isReal() ? Mode.REAL : Mode.SIM;

    public enum Mode {
        REAL,

        SIM,
        
        REPLAY
    }

    public static final boolean CONNECTED_TO_FMS = DriverStation.isFMSAttached();
    public static final boolean LIVE_TUNING = CONNECTED_TO_FMS ? true : false;
}
