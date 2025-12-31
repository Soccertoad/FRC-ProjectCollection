package frc.lib5401.HardwareIOs;

import static edu.wpi.first.units.Units.Meters;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import frc.lib5401.CANDeviceID;
import frc.lib5401.GainUtil.Gains;
import frc.lib5401.HardwareIOs.MotorIOConfig.TalonFXConfig;
import frc.lib5401.HardwareIOs.MotorIOInputs.MotorInputs;

public class TalonFXIO implements MotorIO{
    
    protected final TalonFX talon;
    protected final TalonFXConfig config;

    private final DutyCycleOut dutyCycleControl = new DutyCycleOut(0.0);
    private final VoltageOut voltageControl = new VoltageOut(0.0);
    private final PositionVoltage positionControl = new PositionVoltage(0.0);
    private final VelocityVoltage velocityControl = new VelocityVoltage(0.0);
    private final Follower followControl = new Follower(0, false);

    public TalonFXIO(TalonFXConfig config){
        this.config = config;
        this.talon = new TalonFX(config.CAN_BUS.getDeviceID(), config.CAN_BUS.getBusName());
        this.talon.getConfigurator().apply(config.configFX);
        
    }

    @Override
    public void updateInputs(MotorInputs inputs) {
        inputs.isConnected = talon.isConnected();
        inputs.tempCelcius = talon.getDeviceTemp().getValueAsDouble();
        inputs.statorCurrent = talon.getStatorCurrent().getValueAsDouble();
        inputs.supplyCurrent = talon.getSupplyCurrent().getValueAsDouble();
        inputs.appliedVolts = talon.getMotorVoltage().getValueAsDouble();

        inputs.anglePosition.mut_plus(talon.getPosition().getValue());
        inputs.velocity.mut_replace(talon.getVelocity().getValue());
        inputs.distancePosition.mut_replace(Meters.of(talon.getPosition().getValueAsDouble()));
    }

    @Override
    public void set(double speed) {
        talon.set(speed);
    }

    @Override
    public void setDutyCycle(double percent) {
        talon.setControl(
            dutyCycleControl
                .withOutput(percent)   
        );
    }

    @Override
    public void setVelocity(double velocity) {
        talon.setControl(
            velocityControl
                .withVelocity(velocity)
        );
    }

    @Override
    public void setVelocity(AngularVelocity velocity){
        talon.setControl(
            velocityControl
                .withVelocity(velocity)   
        );
    }

    @Override
    public void setPosition(double position, int slot) {
        talon.setControl(
            positionControl
                .withPosition(position)
                .withSlot(slot)
        );
    }

    @Override
    public void setPosition(Angle position, int slot){
        talon.setControl(
            positionControl
                .withPosition(position)
                .withSlot(slot)   
        );
    }

    @Override
    public void setVoltage(double voltage) {
        talon.setControl(
            voltageControl
                .withOutput(voltage)
        );
    }

    @Override
    public void setGains(Gains gains) {

    }

    @Override
    public void setEncoder(double position) {
        talon.setPosition(position);
    }

    @Override
    public void follow(CANDeviceID leader, boolean opposeLeaderDirection) {
        talon.setControl(
            followControl
                .withMasterID(leader.getDeviceID())
                .withOpposeMasterDirection(opposeLeaderDirection)
        );
    }

}
