package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.FalconMotorModule;
import frc.robot.robotMap;

public class FalconMotorSubsystem extends SubsystemBase {
    private static FalconMotorModule m_Motor;

    public FalconMotorSubsystem() {
        m_Motor = new FalconMotorModule(robotMap.DriverPort.CAN_Port.kFalconMotorPort, false);
    }

    public void move(Double speed) {
        m_Motor.setDesiredState(speed);
    }

    public void Encoder_Zero() {
        m_Motor.resetEncoder();
    }

    public void stopModules() {
        m_Motor.stop();
    }
}
