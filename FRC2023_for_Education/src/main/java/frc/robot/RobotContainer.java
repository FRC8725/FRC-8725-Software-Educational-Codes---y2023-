// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.DriveJoystickCmd;
import frc.robot.commands.DriveButtonMotorCmd;
import frc.robot.subsystems.DriveMotorSubsystem;

import frc.robot.commands.NEOJoystickCmd;
import frc.robot.subsystems.NeoMotorSubsystem;



public class RobotContainer {

  private final DriveMotorSubsystem DriveSubsystem = new DriveMotorSubsystem();
  private final NeoMotorSubsystem NeoSubsystem = new NeoMotorSubsystem();

  private final GamepadJoystick driverJoytick = new GamepadJoystick(0);

  public RobotContainer() {

    DriveSubsystem.setDefaultCommand(new DriveJoystickCmd(DriveSubsystem, 
      () -> driverJoytick.get_LStickY()));

    NeoSubsystem.setDefaultCommand(new NEOJoystickCmd(NeoSubsystem,
      () -> driverJoytick.get_RStickY()));

    configureBindings();
  }


  private void configureBindings() {
      // If commands reflect, roborio will do the latest one
      // "Trigger.whileTrue()" has priority over "setDefaultCommand"

      driverJoytick.btn_A.whileTrue(new DriveButtonMotorCmd(DriveSubsystem,1));
      driverJoytick.btn_B.whileTrue(new DriveButtonMotorCmd(DriveSubsystem,2));
  }

  /*
  public Command getAutonomousCommand() {

  } 
  */
}
