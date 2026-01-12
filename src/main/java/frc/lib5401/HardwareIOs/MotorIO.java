package frc.lib5401.HardwareIOs;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.RotationsPerSecond;

import edu.wpi.first.units.measure.Distance;
import frc.lib5401.DeviceUtils.CANDeviceID;
import frc.lib5401.Gains;
import frc.lib5401.HardwareIOs.MotorIOInputs.MotorInputs;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

public interface MotorIO {

    void updateInputs(MotorInputs inputs);

    void set(double speed);

    /**
     * 
     * @param percent -1 to 1
     */
    void setDutyCycle(double percent);

    /**
     * 
     * @param velocity default rps
     */
    default void setVelocity(AngularVelocity velocity) {
        setVelocity(velocity.in(RotationsPerSecond));
    }

    void setVelocity(double velocity);

        /**
     * 
     * @param angle degrees
     */
    default void setPosition(Angle angle, int slot){
        setPosition(angle.in(Degrees), slot);
    }

    /**
     * 
     * @param distance meters
     */
    default void setPosition(Distance distance, int slot) {
        setPosition(distance.in(Meters), slot);
    }

    void setPosition(double position, int slot);

    /**
     * 
     * @param angle degrees
     */
    default void setPosition(Angle angle){
        setPosition(angle, 0);
    }

    /**
     * 
     * @param distance meters
     */
    default void setPosition(Distance distance) {
        setPosition(distance, 0);
    }

    default void setPosition(double position) {
        setPosition(position, 0);
    }

    void setVoltage(double voltage);

    void setGains(Gains gains);

    default void stop() {
        set(0.0);
    }

    void setEncoder(double position);

    void follow(CANDeviceID leader, boolean opposeLeaderDirection);

}
