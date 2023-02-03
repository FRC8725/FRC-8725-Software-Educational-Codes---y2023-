// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.commands.JoystickDriveCmd;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {

  private final DriveSubsystem DriveSubsystem = new DriveSubsystem();
  private final GamepadJoystick driverJoytick = new GamepadJoystick(0);


  public RobotContainer() {

    DriveSubsystem.setDefaultCommand(new JoystickDriveCmd(DriveSubsystem, 
      () -> driverJoytick.get_LStickY(),
      () -> driverJoytick.get_RStickY(),
      () -> driverJoytick.btn_RT.getAsBoolean()));

    configureBindings();
  }

  private void configureBindings() {

  }

  
  /* 
  public Command getAutonomousCommand() {

  }
  */
}
