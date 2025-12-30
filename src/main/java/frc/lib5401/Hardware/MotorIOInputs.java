package frc.lib5401.Hardware;

import edu.wpi.first.units.measure.MutAngle;
import edu.wpi.first.units.measure.MutAngularVelocity;
import edu.wpi.first.units.measure.MutDistance;

public class MotorIOInputs {

    public static class MotorInputs{

        public boolean isConnected = false;
        public double tempCelcius;

        public double appliedVolts = 0.0;
        public double statorCurrent;
        public double supplyCurrent;

        public MutDistance distancePosition;
        public MutAngle anglePosition;
        public MutAngularVelocity velocity;
    }

}
