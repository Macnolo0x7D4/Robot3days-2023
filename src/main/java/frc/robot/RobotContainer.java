// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;

public class RobotContainer {
  private final Drivetrain m_drivetrain = new Drivetrain();

  private final CommandGenericHID m_driverController =
      new CommandGenericHID(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    m_drivetrain.setDefaultCommand(
        Commands.run(
            () -> m_drivetrain.getDifferentialDrive().arcadeDrive(
                  m_driverController.getRawAxis(4) * m_drivetrain.getTurbo(),
                  m_driverController.getRawAxis(1) * m_drivetrain.getTurbo()
                ),
            m_drivetrain
            /*() -> m_drivetrain.getDifferentialDrive().tankDrive(
                  -m_driverController.getRawAxis(1) * m_drivetrain.getTurbo(),
                  m_driverController.getRawAxis(5) * m_drivetrain.getTurbo()
                ),
                
            m_drivetrain*/
        )
    );

    configureBindings();
  }

  private void configureBindings() {
    m_driverController.axisGreaterThan(3, 0.3).toggleOnTrue(
      Commands.runOnce(() -> m_drivetrain.toggleTurbo(), m_drivetrain)
    );
  }

  public Command getAutonomousCommand() {
    return Autos.exampleAuto(m_drivetrain);
  }
}
