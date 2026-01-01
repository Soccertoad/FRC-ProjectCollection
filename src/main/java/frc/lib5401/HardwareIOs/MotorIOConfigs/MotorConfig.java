package frc.lib5401.HardwareIOs.MotorIOConfigs;

import frc.lib5401.DeviceUtils.CANDeviceID;

public abstract class MotorConfig {
    public CANDeviceID CAN_BUS;
    public double sensorToMechanismRatio = 1.0;

}
