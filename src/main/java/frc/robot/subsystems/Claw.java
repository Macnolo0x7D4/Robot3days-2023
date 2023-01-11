// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClawConstants;

public class Claw extends SubsystemBase {

  private final Servo m_servito = new Servo(ClawConstants.kServitoPort);
  private final Servo m_servo = new Servo(ClawConstants.kServoPort);

  public Claw() {
    m_servo.set(1);
    m_servito.set(1);
  }

  public Command open() {
    return runOnce(() -> {
      m_servito.setAngle(0);
    });
  }

  public Command close() {
    return runOnce(() -> {
      m_servito.setAngle(30);
    });
  }
}
