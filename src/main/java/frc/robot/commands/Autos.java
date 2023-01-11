// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autos {
  public static CommandBase exampleAuto(Drivetrain drivetrain) {
    return Commands.sequence(
        Commands.runOnce(() -> drivetrain.getDifferentialDrive().arcadeDrive(0.6, 0), drivetrain),
        Commands.waitSeconds(3),
        Commands.runOnce(() -> drivetrain.getDifferentialDrive().arcadeDrive(0, 0), drivetrain));
  }
}
