package frc.lib5401.Subsystems;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.RotationsPerSecond;

import edu.wpi.first.units.measure.Distance;
import frc.lib5401.GainUtil.Gains;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

public interface MotorIO {

    default void updateInputs(MotorIOInputs inputs) {}

    /**
     * 
     * @param percent -1 to 1
     */
    default void setDutyCycle(double percent) {}

    /**
     * 
     * @param velocity default rps
     */
    default void setVelocity(AngularVelocity velocity) {
        setVelocity(velocity.in(RotationsPerSecond));
    }

    default void setVelocity(double velocity) {}

    /**
     * 
     * @param angle degrees
     */
    default void setPosition(Angle angle){
        setPosition(angle.in(Degrees));
    }

    /**
     * 
     * @param distance meters
     */
    default void setPosition(Distance distance) {
        setPosition(distance.in(Meters));
    }

    default void setPosition(double position) {}

    default void setGains(Gains gains) {}

/* Things to add

go to set point 
stop 
set position/encoder value
follow
voltage control
*/


}
