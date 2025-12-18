package frc.robot.subsystems.Launcher.Turret;

public interface TurretIO {

    public static class TurretIOInputs{
        public double tempCelcius;
        public double positionMeters;
        public double velocityRadPerSec;

        public double appliedVolts = 0.0;
        public double statorCurrent;
        public double supplyCurrent;
    }

}
