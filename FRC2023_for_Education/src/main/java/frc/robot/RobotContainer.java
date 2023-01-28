// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.DriveJoystickCmd;
import frc.robot.subsystems.DriveMotorSubststem;
import frc.robot.Constants;
import frc.robot.GamepadJoystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;



public class RobotContainer {

  private final DriveMotorSubststem DriveSubsystem = new DriveMotorSubststem();

  private final Joystick driverJoytick = new Joystick(GamepadJoystick.kDriverControllerPort);


  public RobotContainer() {

    DriveSubsystem.setDefaultCommand(new DriveJoystickCmd(
      DriveSubsystem, () -> driverJoytick.getRawAxis(GamepadJoystick.kDriverYAxis)));

    configureBindings();
  }


  private void configureBindings() {

  }

  /*
  public Command getAutonomousCommand() {

  } 
  */
}
