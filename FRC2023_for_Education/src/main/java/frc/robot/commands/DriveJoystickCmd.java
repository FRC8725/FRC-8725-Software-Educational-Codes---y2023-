// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveMotorSubststem;
import frc.robot.Constants;


/** An example command that uses an example subsystem. */
public class DriveJoystickCmd extends CommandBase {


  private final DriveMotorSubststem MotorSubsystem;
  private final Supplier<Double> SpeedFunction;


  public DriveJoystickCmd(DriveMotorSubststem subsystem, Supplier<Double> SpeedFunction) {

    MotorSubsystem = subsystem;
    this.SpeedFunction = SpeedFunction;

    addRequirements(MotorSubsystem);
  }

  
  
  @Override
  public void initialize() {}

  @Override
  public void execute() {
    // 1. Get real-time joystick inputs
    double Speed = SpeedFunction.get();

    // 2. Apply deadband
    Speed = Math.abs(Speed) > Constants.DriveConstants.kMotor_deadline ? Speed : 0.0;

    MotorSubsystem.move(Speed);
  }

  @Override
  public void end(boolean interrupted) {
    MotorSubsystem.stopModules();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
