// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class Arm extends SubsystemBase {

  private final CANSparkMax m_leftMotor = new CANSparkMax(ArmConstants.kLeftMotorPort, MotorType.kBrushed);
  private final CANSparkMax m_rightMotor = new CANSparkMax(ArmConstants.kRightMotorPort, MotorType.kBrushed);

  private final MotorControllerGroup m_armMotors = new MotorControllerGroup(m_leftMotor, m_rightMotor);

  public Arm() {
    m_rightMotor.follow(m_leftMotor);
  }

  public Command move(double speed) {
    return run(() -> m_armMotors.set(speed));
  }
}
