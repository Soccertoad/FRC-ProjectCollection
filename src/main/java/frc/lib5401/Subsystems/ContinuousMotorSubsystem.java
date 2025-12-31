//Subsystems with unlimited range of motion, flywheels rollers, intakes

package frc.lib5401.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib5401.HardwareIOs.MotorIO;
import frc.lib5401.HardwareIOs.MotorIOInputs;

public class ContinuousMotorSubsystem<T extends MotorIO, U extends MotorIOInputs> extends SubsystemBase{

    protected T motor;
    protected U motorInputs;

    public ContinuousMotorSubsystem(){

    }

    @Override
    public void periodic(){

    }
    
}
