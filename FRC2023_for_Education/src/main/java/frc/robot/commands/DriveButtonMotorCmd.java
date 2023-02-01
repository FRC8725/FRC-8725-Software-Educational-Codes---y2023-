package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveMotorSubsystem;
import frc.robot.Constants;

public class DriveButtonMotorCmd extends CommandBase {
    private final DriveMotorSubsystem MotorSubsystem;
    private int mode;

    public DriveButtonMotorCmd(DriveMotorSubsystem subsystem, int mode) {

        MotorSubsystem = subsystem;
        this.mode = mode;
        
        addRequirements(MotorSubsystem);
    }

    @Override
  public void initialize() {}

  @Override
  public void execute() {
        if (mode == 1)
            MotorSubsystem.move(1.0);
        else if(mode == 2) {
            MotorSubsystem.move(-1.0);
        }
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
