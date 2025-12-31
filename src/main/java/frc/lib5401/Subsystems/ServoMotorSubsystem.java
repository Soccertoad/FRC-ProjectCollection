// For subsystems with limited range of motion or fixed position setpoints

package frc.lib5401.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib5401.HardwareIOs.MotorIO;
import frc.lib5401.HardwareIOs.MotorIOInputs;

public class ServoMotorSubsystem<T extends MotorIO, U extends MotorIOInputs> extends SubsystemBase {

    /** Creates a new ServoMotorSubsystem. */
    public ServoMotorSubsystem() {}

    @Override
    public void periodic() {
    // This method will be called once per scheduler run
    }
}
