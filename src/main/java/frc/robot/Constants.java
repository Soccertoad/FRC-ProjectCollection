package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

public class Constants {

    public static final Mode currentMode = RobotBase.isReal() ? Mode.REAL : Mode.SIM;

    public enum Mode {
        REAL,

        SIM,
        
        REPLAY
    }

    public static final boolean LIVE_TUNING = true;
}
