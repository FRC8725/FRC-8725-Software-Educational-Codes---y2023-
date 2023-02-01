package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.DriveMotorModule;
import frc.robot.robotMap;

public class DriveMotorSubsystem extends SubsystemBase {

    private static DriveMotorModule m_Motor;

    public DriveMotorSubsystem() {
        m_Motor = new DriveMotorModule( 
            robotMap.DriverPort.PWM_Port.kMotorPort, 
            robotMap.DriverPort.DIO_Port.kMotorPort, 
            false);
    }

    public void move(Double speed) {
        m_Motor.setDesiredState(speed);
    }

    public void Encoder_Zero() {
        m_Motor.ResetEncoder();
    }

    public void stopModules() {
        m_Motor.stop();
    }
}