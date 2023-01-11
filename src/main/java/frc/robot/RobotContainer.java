// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;

public class RobotContainer {
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final Arm m_arm = new Arm();
  private final Claw m_claw = new Claw();

  private final CommandGenericHID m_driverController = new CommandGenericHID(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    m_drivetrain.setDefaultCommand(m_drivetrain.drive(m_driverController));

    m_driverController.button(4).onTrue(
        m_drivetrain.toggleTurbo());

    m_driverController.axisGreaterThan(2, 0.3).whileTrue(
        m_arm.move(-0.5));

    m_driverController.axisGreaterThan(3, 0.3).whileTrue(
        m_arm.move(0.5));

    m_driverController.button(1).onTrue(m_claw.open()).onFalse(m_claw.close());
  }

  public Command getAutonomousCommand() {
    return Autos.exampleAuto(m_drivetrain);
  }
}
