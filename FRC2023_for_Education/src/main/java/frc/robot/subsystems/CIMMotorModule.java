package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.robotMap;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;


public class CIMMotorModule {

    private PWMVictorSPX Motor;
    
    private Encoder Motor_Encoder;

    private double distance;
    private double speed;

    public CIMMotorModule(int Motor_Port, int Encoder_Port ,boolean Direction) {
        Motor = new PWMVictorSPX(Motor_Port);

        Motor.setInverted(Direction);

        Motor_Encoder = new Encoder(Encoder_Port, Encoder_Port + 1, Direction, Encoder.EncodingType.k1X);

        Motor_Encoder.setDistancePerPulse(Constants.DriveConstants.kMotor_Perimeter / Constants.DriveConstants.kEncoder_Pulse);

    }

    public void setDesiredState(Double speed) {
        this.speed = speed;
        Motor.set(speed * Constants.DriveConstants.kSpeed);
        putDashboard();
    }

    public void stop() {
        Motor.set(0);
        putDashboard();
    }

    public void DriveDistance() {
        distance = Motor_Encoder.getDistance();
        putDashboard();
    }

    public void ResetEncoder() {
        Motor_Encoder.reset();
        putDashboard();
    }

    public void putDashboard() {
        SmartDashboard.putNumber("Speed: ", speed * Constants.DriveConstants.kSpeed);
        SmartDashboard.putNumber("Motor ", distance);
    }
}
