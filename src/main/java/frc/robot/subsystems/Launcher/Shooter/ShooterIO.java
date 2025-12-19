package frc.robot.subsystems.Launcher.Shooter;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.MutAngle;
import edu.wpi.first.units.measure.MutAngularVelocity;

public interface ShooterIO {
    
    public static class ShooterIOInputs{
        public boolean hoodConnected = false;
        public double hoodTempCelcius;
        public MutAngle hoodAngle;
        public MutAngularVelocity hoodVelocity;

        public double hoodAppliedVolts = 0.0;
        public double hoodStatorCurrent;
        public double hoodSupplyCurrent;

        public boolean flywheelConnected = false;
        public double flywheelTempCelcius;
        public MutAngularVelocity flywheelVelocityRadPerSec;

        public double flywheelAppliedVolts = 0.0;
        public double flywheelStatorCurrent;
        public double flywheelSupplyCurrent;
    }

    default void update(ShooterIOInputs shooterInputs) {}

    default void stop() {}

    default void setHoodAngle(double angle) {}

    default void setHoodAngle(Angle angle) {}

    default void setHoodVoltage(double voltage) {}

    default void setHoodPID(double p, double i, double d) {}

    default void setFlywheelVelocity(double velocity) {}

    default void setFlywheelVelocity(AngularVelocity velocity) {}

    default void setFlywheelVoltage(double voltage) {}

    default void setFlywheelPID(double p, double d, double ff) {}

}
