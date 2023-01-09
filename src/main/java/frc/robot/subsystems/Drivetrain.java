// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SubsystemBase {

  private final CANSparkMax m_leftMotor = new CANSparkMax(DrivetrainConstants.kMotorLeftPort, MotorType.kBrushed);
  private final CANSparkMax m_rightMotor = new CANSparkMax(DrivetrainConstants.kMotorRightPort, MotorType.kBrushed);

  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  private boolean turboEnabled = false;

  public DifferentialDrive getDifferentialDrive () {
    return this.m_drive;
  }

  public double getTurbo() {
    return turboEnabled ? 1 : DrivetrainConstants.kNormalSpeed;
  }

  public void toggleTurbo() {
    turboEnabled = !turboEnabled;
  }
}
