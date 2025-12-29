package frc.lib5401.Subsystems;

import edu.wpi.first.units.measure.MutAngle;
import edu.wpi.first.units.measure.MutAngularVelocity;
import edu.wpi.first.units.measure.MutDistance;

public class MotorIOInputs {

    private static class GenericMotorInputs{

        public boolean isConnected = false;
        public double tempCelcius;

        public double appliedVolts = 0.0;
        public double hoodStatorCurrent;
        public double hoodSupplyCurrent;
    }

    public static class ServoMotorInputs extends GenericMotorInputs{

        public MutDistance distancePosition;
        public MutAngle anglePosition;
        public MutAngularVelocity velocity;
    
    }

    public static class FlywheelMotorInputs extends GenericMotorInputs{

        public MutAngularVelocity velocity;

    }
}
