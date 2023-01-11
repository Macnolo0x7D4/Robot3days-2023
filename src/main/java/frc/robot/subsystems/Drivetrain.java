// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SubsystemBase {

  private final Spark m_frontLeftMotor = new Spark(DrivetrainConstants.kMotorFrontLeftPort);
  private final Spark m_rearLeftMotor = new Spark(DrivetrainConstants.kMotorRearLeftPort);
  private final Spark m_frontRightMotor = new Spark(DrivetrainConstants.kMotorFrontRightPort);
  private final Spark m_rearRightMotor = new Spark(DrivetrainConstants.kMotorRearRightPort);

  private final MotorControllerGroup m_leftMotors = new MotorControllerGroup(m_frontLeftMotor, m_rearLeftMotor);
  private final MotorControllerGroup m_rightMotors = new MotorControllerGroup(m_frontRightMotor, m_rearRightMotor);

  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);

  private boolean turboEnabled = false;

  public DifferentialDrive getDifferentialDrive() {
    return this.m_drive;
  }

  public Command drive(CommandGenericHID driverController) {
    return run(
        () -> m_drive.arcadeDrive(
            -driverController.getRawAxis(1) * getTurbo(),
            driverController.getRawAxis(4) * getTurbo()));
  }

  public double getTurbo() {
    return turboEnabled ? 1 : DrivetrainConstants.kNormalSpeed;
  }

  public Command toggleTurbo() {
    return runOnce(() -> turboEnabled = !turboEnabled);
  }
}
