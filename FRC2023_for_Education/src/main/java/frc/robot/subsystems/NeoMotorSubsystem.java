package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.NeoMotorModule;
import frc.robot.robotMap;

public class NeoMotorSubsystem extends SubsystemBase {
    
    private NeoMotorModule NEOMotor;

    public NeoMotorSubsystem() {
        NEOMotor = new NeoMotorModule(robotMap.DriverPort.CAN_Port.kNEOMotorPort, false);
    }

    public void move(Double speed) {
        NEOMotor.setDesiredState(speed);
    }

    public void Encoder_Zero() {
        NEOMotor.resetEncoder();
    }

    public void stopModules() {
        NEOMotor.stop();
    }
}
