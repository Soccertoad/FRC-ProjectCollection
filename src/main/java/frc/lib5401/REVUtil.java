package frc.lib5401;

import java.util.function.Supplier;

import com.revrobotics.REVLibError;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkBase.Faults;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkBaseConfig;

public class REVUtil {
    public static final int MAX_ATTEMPTS = 10;

    public static REVLibError genericCheckUntilOkay(Supplier<REVLibError> deviceAttempt, int maxAttempts){
        REVLibError attemptResult = REVLibError.kError;
        for(int i = 0; i <= maxAttempts; i++){
            attemptResult = deviceAttempt.get();
            if(attemptResult==REVLibError.kOk) return attemptResult;
        }
        if(attemptResult != REVLibError.kOk){
            // figure out way to report error
        }
        return attemptResult;
    }

    public static REVLibError sparkMotorCheckUntilOkay(SparkBase sparkMotor, SparkBaseConfig config, ResetMode resetMode, PersistMode persistMode){
        return genericCheckUntilOkay(() -> sparkMotor.configure(config, resetMode, persistMode), MAX_ATTEMPTS);
    }
    
    public static REVLibError sparkMotorCheckUntilOkay(SparkBase sparkMotor, SparkBaseConfig config){
        return genericCheckUntilOkay(() -> sparkMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters), MAX_ATTEMPTS);
    }

    public static Faults getSparkStickyFaults(SparkBase sparkMotor){
        return sparkMotor.getStickyFaults();
    }
}
