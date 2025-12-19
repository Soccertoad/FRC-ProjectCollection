// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.Mode;
import frc.robot.subsystems.Launcher.Launcher;
import frc.robot.subsystems.Launcher.Shooter.ShooterIO;
import frc.robot.subsystems.Launcher.Turret.TurretIO;

public class RobotContainer {

    private final CommandXboxController operator = new CommandXboxController(1);
    private final Launcher turret;

    public RobotContainer() {
        switch (Constants.CURRENT_MODE) {
            case REAL -> {
                turret = new Launcher(null, null);
            }
            
            case SIM -> {
                turret = new Launcher(null, null);
            }

            case REPLAY -> {
                turret = new Launcher(
                    new TurretIO() {}, 
                    new ShooterIO() {}
                );
            }

            default -> { 
                turret = new Launcher(null, null);
            }
        }
        configureBindings();
    }

    private void configureBindings() {}

    public Command getAutonomousCommand() {
        return Commands.print("No autonomous command configured");
    }
}
