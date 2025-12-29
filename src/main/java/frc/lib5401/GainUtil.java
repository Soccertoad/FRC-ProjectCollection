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

}
