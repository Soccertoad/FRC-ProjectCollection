// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Launcher;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.Launcher.Shooter.ShooterIO;
import frc.robot.subsystems.Launcher.Shooter.ShooterIO.ShooterIOInputs;
import frc.robot.subsystems.Launcher.Turret.TurretIO;
import frc.robot.subsystems.Launcher.Turret.TurretIO.TurretIOInputs;

public class Launcher extends SubsystemBase {

    /*   */
    private final TurretIO turretIO;
    private final TurretIOInputs turretInputs = new TurretIOInputs();
    private final ShooterIO shooterIO;
    private final ShooterIOInputs shooterInputs = new ShooterIOInputs();
    

    /** Creates a new Turret. */
    public Launcher(TurretIO m_TurretIO, ShooterIO m_ShooterIO) {
        this.turretIO = m_TurretIO;
        this.shooterIO = m_ShooterIO;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        turretIO.update(turretInputs);
        shooterIO.update(shooterInputs);

    }
}
