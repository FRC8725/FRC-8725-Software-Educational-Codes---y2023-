package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import frc.robot.lib.DriverTable;

public class DriverTableSub extends SubsystemBase {
    static PWMVictorSPX m_Driver;
    static Encoder m_DriverEncoder;
    static Joystick m_Joystick;
    static double Move_Speed = .7, Rotate_Speed = .3;

    public static void Move_Set(Joystick _joystick) {
        m_Driver = DriverTable.DriveTable_Setup();
        m_DriverEncoder = DriverTable.Encoder_Setup();
        m_Joystick = _joystick;
    }

    public static void Move() {
        m_Driver.set(m_Joystick.getY() * Move_Speed);
    }

    public static void Encoder_Zero() {
        m_DriverEncoder.reset();
    }

    public static void Driver_Stop() {
        m_Driver.set(0);
    }
}