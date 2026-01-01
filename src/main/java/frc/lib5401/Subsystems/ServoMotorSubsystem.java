// For subsystems with limited range of motion or fixed position setpoints

package frc.lib5401.Subsystems;

import java.util.function.DoubleSupplier;

import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.units.measure.MutAngle;
import edu.wpi.first.units.measure.MutAngularVelocity;
import edu.wpi.first.units.measure.MutDistance;
import edu.wpi.first.wpilibj.Alert;
import edu.wpi.first.wpilibj.Alert.AlertType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib5401.HardwareIOs.MotorIO;
import frc.lib5401.HardwareIOs.MotorIOInputs.MotorInputs;

public abstract class ServoMotorSubsystem<T extends MotorIO, U extends MotorInputs> extends SubsystemBase {

    protected final T motor;
    protected U inputs;
    protected ServoMotorSubsystemConfig subsystemConfig;

    protected Alert motorDisconectedAlert;

    /** Creates a new ServoMotorSubsystem. */
    public ServoMotorSubsystem(ServoMotorSubsystemConfig subsystemConfig, T motor, U inputs) {
        
        super(subsystemConfig.subsystemName);

        this.motor = motor;
        this.inputs = inputs;
        this.subsystemConfig = subsystemConfig;

        motorDisconectedAlert = new Alert(getName() + "\'s Lead motor Disconnected", AlertType.kWarning);
        
        /*  Defaults motor to have 0 movement */
        setDefaultCommand(
            setDutyCycle(()->0.0)
        );
        
    }

    @Override
    public void periodic() {
        motor.updateInputs(inputs);
        motorDisconectedAlert.set(!inputs.isConnected);
    }

    /*  Non command Interactions */
    protected void set(double percent){
        motor.set(percent);
    }

    protected void setDistanceTarget(Distance target){
        motor.setPosition(target);
    }
    
    /*  Commands */
    public Command setDutyCycle(DoubleSupplier percent){
        return runEnd(
            () -> set(percent.getAsDouble()),
            () -> set(0.0)
        );
    }

    public Command goToDistance(Distance target){
        return runOnce(
            () -> setDistanceTarget(target)
        );
    }

    /*  Motor Input Getters */

    public MutAngularVelocity getAngularVelocity(){
        return inputs.velocity;
    }

    public MutAngle getAngle(){
        return inputs.anglePosition;
    }

    public MutDistance getDistance(){
        return inputs.distancePosition;
    }

}
