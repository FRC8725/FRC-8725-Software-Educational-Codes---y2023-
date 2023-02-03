// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveModule;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

  private DriveModule Left_Front_Motor;
  private DriveModule Left_Back_Motor;
  private DriveModule Right_Front_Motor;
  private DriveModule Right_Back_Motor;

  private MotorControllerGroup[] m_Driver;

  public DriveSubsystem() {

    Left_Front_Motor = new DriveModule(RobotMap.Drive.left_NEO[0], true);
    Left_Back_Motor = new DriveModule(RobotMap.Drive.left_NEO[1], true);
    Right_Front_Motor = new DriveModule(RobotMap.Drive.right_NEO[0], false);
    Right_Back_Motor = new DriveModule(RobotMap.Drive.right_NEO[1], false);

    MotorControllerGroup leftMotors = new MotorControllerGroup(Left_Front_Motor.CANMotor, Left_Back_Motor.CANMotor);
    MotorControllerGroup rightMotors = new MotorControllerGroup(Right_Front_Motor.CANMotor, Right_Back_Motor.CANMotor);

    MotorControllerGroup[] m_Driver = {leftMotors, rightMotors};
    this.m_Driver = m_Driver;
  }

 public void move(double input, int side) {
    if (side == 0) { // left
      m_Driver[0].set(input);
    } else if (side == 1) {
      m_Driver[1].set(input);
    }
 }

 public void stop() {
    m_Driver[0].set(0);
    m_Driver[1].set(0);
 }

 public void Encoder_Zero() {
  Left_Front_Motor.resetEncoder();
  Left_Back_Motor.resetEncoder();
  Right_Front_Motor.resetEncoder();
  Right_Back_Motor.resetEncoder();
 }

 public void putDashBoard() {
    Left_Front_Motor.putDashBoard();
    Left_Back_Motor.putDashBoard();
    Right_Front_Motor.putDashBoard();
    Right_Back_Motor.putDashBoard();
 }
 
}
