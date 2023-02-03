// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants;

public class JoystickDriveCmd extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem MotorSubsystem;
  private final Supplier<Double> SpeedFunction_L;
  private final Supplier<Double> SpeedFunction_R;
  private final Supplier<Boolean> SpeedFunctionBtn;

  public JoystickDriveCmd(DriveSubsystem subsystem, Supplier<Double> SpeedFunction_L, 
      Supplier<Double> SpeedFunction_R,
      Supplier<Boolean> SpeedFunctionBtn) {
    MotorSubsystem = subsystem;
    this.SpeedFunction_L = SpeedFunction_L;
    this.SpeedFunction_R = SpeedFunction_R;
    this.SpeedFunctionBtn = SpeedFunctionBtn;

    addRequirements(subsystem);
  }


  @Override
  public void initialize() {}

  @Override
  public void execute() {

    double speed_L = SpeedFunction_L.get();
    double speed_R = SpeedFunction_R.get();
    double times = 1;

    if (SpeedFunctionBtn.get() == true) {
      times = 0.5;
    }
    

    if (Math.abs(speed_L) < 0.05) {
      speed_L = 0;
    }

    if (Math.abs(speed_R) < 0.05) {
      speed_R = 0;
    }

    MotorSubsystem.move(speed_L * times, 0);
    MotorSubsystem.move(speed_R * times, 1);

  }


  @Override
  public void end(boolean interrupted) {
    MotorSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
