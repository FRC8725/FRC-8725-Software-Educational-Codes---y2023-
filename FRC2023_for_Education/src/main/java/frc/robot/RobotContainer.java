// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.CIMJoystickCmd;
import frc.robot.commands.CIMButtonMotorCmd;
import frc.robot.subsystems.CIMMotorSubsystem;

import frc.robot.commands.NEOJoystickCmd;
import frc.robot.subsystems.NeoMotorSubsystem;

import frc.robot.commands.FalconButtonCmd;
import frc.robot.subsystems.FalconMotorSubsystem;


public class RobotContainer {

  private final CIMMotorSubsystem DriveSubsystem = new CIMMotorSubsystem();
  private final NeoMotorSubsystem NeoSubsystem = new NeoMotorSubsystem();
  private final FalconMotorSubsystem falconSubsystem = new FalconMotorSubsystem();

  private final GamepadJoystick driverJoytick = new GamepadJoystick(0);

  public RobotContainer() {

    DriveSubsystem.setDefaultCommand(new CIMJoystickCmd(DriveSubsystem, 
      () -> driverJoytick.get_LStickY()));

    NeoSubsystem.setDefaultCommand(new NEOJoystickCmd(NeoSubsystem,
      () -> driverJoytick.get_RStickY()));

    configureBindings();
  }


  private void configureBindings() {
      // If commands reflect, roborio will do the latest one
      // "Trigger.whileTrue()" has priority over "setDefaultCommand"

      driverJoytick.btn_A.whileTrue(new CIMButtonMotorCmd(DriveSubsystem,1));
      driverJoytick.btn_B.whileTrue(new CIMButtonMotorCmd(DriveSubsystem,2));
      driverJoytick.btn_X.whileTrue(new FalconButtonCmd(falconSubsystem,1));
      driverJoytick.btn_Y.whileTrue(new FalconButtonCmd(falconSubsystem,2));
  }

  /*
  public Command getAutonomousCommand() {

  } 
  */
}
