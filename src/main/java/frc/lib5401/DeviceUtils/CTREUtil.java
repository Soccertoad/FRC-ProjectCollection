package frc.lib5401.DeviceUtils;

import java.util.function.Supplier;

import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.SlotConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;

public class CTREUtil {

    public static final int MAX_ATTEMPTS = 10;
    
    private CTREUtil(){}

    public static StatusCode genericCheckUntilOkay(Supplier<StatusCode> deviceAttempt, int maxAttempts){
        StatusCode attemptResult = StatusCode.kFailedSetup;
        for(int i = 0; i<=maxAttempts; i++){
            attemptResult = deviceAttempt.get();
            if(attemptResult == StatusCode.OK) return attemptResult;
        }
        if(attemptResult != StatusCode.OK){
            //Figure out way to report error
        }
        return attemptResult;
    }

    public static StatusCode talonConfigCheckUntilOkay(TalonFX talon, TalonFXConfiguration config){
        return genericCheckUntilOkay(() -> talon.getConfigurator().apply(config), MAX_ATTEMPTS);
    } 

    public static StatusCode talonClosedLoopCheckUntilOkay(TalonFX talon, SlotConfigs slotConfig){
        return genericCheckUntilOkay(() -> talon.getConfigurator().apply(slotConfig), MAX_ATTEMPTS);
    }

    public static StatusCode CANCoderConfigCheckUntilOkay(CANcoder canCoder, CANcoderConfiguration config){
        return genericCheckUntilOkay(() -> canCoder.getConfigurator().apply(config), MAX_ATTEMPTS);
    }
}
