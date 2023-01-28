package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import frc.robot.subsystems.DriveMotorModule;
import frc.robot.robotMap;

public class DriveMotorSubststem extends SubsystemBase {

    private static DriveMotorModule m_Motor= new DriveMotorModule( 
            robotMap.DriverPort.PWM_Port.kMotorPort, 
            robotMap.DriverPort.DIO_Port.kMotorPort, 
            false);
    // static Encoder m_DriverEncoder;

    public DriveMotorSubststem() {

    }

    public void move(Double axis_input) {
        m_Motor.setDesiredState(axis_input);
    }

    // public void Encoder_Zero() {
    //     m_DriverEncoder.reset();
    // }

    public void stopModules() {
        m_Motor.stop();
    }
}