package frc.lib5401.Subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;

import frc.lib5401.CANDeviceID;

public class MotorIOConfig {

    private MotorIOConfig(){}

    public abstract class MotorConfig{
        public CANDeviceID CAN_BUS;
        public double sensorToMechanismRatio = 1.0;
    }

    public class TalonFXConfig extends MotorConfig{
        public TalonFXConfiguration configFX = new TalonFXConfiguration();
        
    }
    
}
