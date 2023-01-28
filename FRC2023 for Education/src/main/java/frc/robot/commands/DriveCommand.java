// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriverTableSub;

/** An example command that uses an example subsystem. */
public class DriveCommand extends CommandBase {


  private final DriverTableSub m_subsystem;


  public DriveCommand(DriverTableSub subsystem) {
    m_subsystem = subsystem;

    addRequirements(m_subsystem);
  }

  
  
  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_subsystem.Move();
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
