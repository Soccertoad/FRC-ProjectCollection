package frc.lib5401;

import static edu.wpi.first.units.Units.Kilo;

import java.util.Optional;

import com.ctre.phoenix6.configs.ParentConfiguration;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.Slot1Configs;
import com.ctre.phoenix6.configs.Slot2Configs;
import com.ctre.phoenix6.configs.SlotConfigs;


public class Gains {
    //Method chaining and multiple constructors 
    // return different brand Closed loop objects/configs 

    public double kp = 0; 
    public double ki = 0; 
    public double kd = 0;
    public double kf = 0; 
    public double ka = 0;
    public double kv = 0; 
    public double ks = 0; 
    public double kg = 0;
    Optional<GravityType> gravityType = Optional.of(GravityType.ELEVATOR);

    public Gains(double kp, double ki, double kd){
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;
    }

    public Gains(SlotConfigs slotConfig){
        this(slotConfig.kP, slotConfig.kI, slotConfig.kD);
    }

    public Gains withKp(double kp){
        this.kp = kp;
        return this;
    }

    public Gains withKi(double ki){
        this.ki = ki;
        return this;
    }

    public Gains withKd(double kd){
        this.kd = kd;
        return this;
    }

    public ParentConfiguration getCTREGains(int slot){
        
        if (slot == 0) {
            ParentConfiguration slotConfig = new Slot0Configs();
        } else if (slot == 1){ 
            ParentConfiguration slotConfig = new Slot1Configs();
        } else if (slot == 2) { 
            ParentConfiguration slotConfig = new Slot2Configs();
        } else {
            ParentConfiguration slotConfig = new SlotConfigs();
        }
        ParentConfiguration config;
        switch(slot){
            case 0: {config = new Slot0Configs();}
            default: config = new SlotConfigs();
        }
        config
            .withKP(kp)
            .withKI(ki)
            .withKD(kd)
            .withKA(ka)
            .withKV(kv)
            .withKS(ks)
            .withKG(kg);
    }

    public enum GravityType{
        ELEVATOR,
        ARM
    }

}
