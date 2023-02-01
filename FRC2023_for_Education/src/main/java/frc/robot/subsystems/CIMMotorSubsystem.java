package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.CIMMotorModule;
import frc.robot.robotMap;

public class CIMMotorSubsystem extends SubsystemBase {

    private static CIMMotorModule m_Motor;

    public CIMMotorSubsystem() {
        m_Motor = new CIMMotorModule( 
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