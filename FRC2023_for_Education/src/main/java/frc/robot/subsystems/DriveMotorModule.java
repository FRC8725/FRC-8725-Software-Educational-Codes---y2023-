package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj.Encoder;


public class DriveMotorModule {

    private PWMVictorSPX Motor;
    
    // private Encoder Motor_Encoder;

    public DriveMotorModule(int Motor_Port, int Encoder_Port ,boolean Direction) {
        Motor = new PWMVictorSPX(Motor_Port);

        Motor.setInverted(Direction);

        // Motor_Encoder = new Encoder(Encoder_Port, Encoder_Port + 1, Direction, Encoder.EncodingType.k1X);

        // Motor_Encoder.setDistancePerPulse(MOTOR_PERIMETER / MOTOR_PULSE);
    }

    public void setDesiredState(Double speed) {
        Motor.set(speed * Constants.DriveConstants.kSpeed);
        SmartDashboard.putNumber("Speed: ", speed * Constants.DriveConstants.kSpeed);
    }

    public void stop() {
        Motor.set(0);
    }
}
