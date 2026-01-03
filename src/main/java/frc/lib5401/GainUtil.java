package frc.lib5401;

public class GainUtil {

    public record Gains(
        double kp,
        double ki,
        double kd,
        double kf,
        double ka,
        double kv,
        double kg
    ) {}
//Method chaining and multiple constructors 
// return different brand Closed loop objects/configs 
}
