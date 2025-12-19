package frc.robot.subsystems.Launcher.Turret;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.MutAngle;

public interface TurretIO {

    public static class TurretIOInputs{
        public double tempCelcius;
        public MutAngle angle;
        public double velocity;

        public double appliedVolts = 0.0;
        public double statorCurrent;
        public double supplyCurrent;
    }

    default void update(TurretIOInputs turretInputs) {}

    default void stop() {}

    default void setTurretAngle(double angle) {}

    default void setTurretAngle(Angle angle) {}

    default void setTurretVoltage(double voltage) {}

    default void setPID(double p, double i, double d) {}
 
}
