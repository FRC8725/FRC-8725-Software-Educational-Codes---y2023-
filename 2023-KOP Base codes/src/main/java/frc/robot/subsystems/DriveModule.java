package frc.robot.subsystems;

import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveModule {
    CANSparkMax CANMotor;

    RelativeEncoder Encoder;

    double Position;
    double speed_input;

    String device;

    public DriveModule(int Port_ID, boolean reverse) {
        CANMotor = new CANSparkMax(Port_ID, MotorType.kBrushless);

        CANMotor.setSmartCurrentLimit(30);
        CANMotor.setIdleMode(IdleMode.kBrake); // the other mode is kCoast
        CANMotor.setInverted(reverse);

        Encoder = CANMotor.getEncoder();
        Encoder.setPositionConversionFactor(Constants.DriveConstants.kDriveEncoderRot2Meter);
        Encoder.setVelocityConversionFactor(Constants.DriveConstants.kDriveEncoderRPM2MeterPerSec);
        
        device = Integer.toString(Port_ID);
    }

    public double getDrivePosition(){
        return Encoder.getPosition();
    }

    public double getDriveVelocity() {
        return Encoder.getVelocity();
    }

    public void resetEncoder() {
        Encoder.setPosition(0);
        putDashBoard();
    }

    public void setDesiredState(double speed) {
        speed_input = speed * Constants.DriveConstants.kSpeed;
        CANMotor.set(speed * Constants.DriveConstants.kSpeed);
        putDashBoard();
    }

    public void stop() {
        CANMotor.set(0);
        putDashBoard();
    }

    public void putDashBoard() {
        SmartDashboard.putNumber("Drive Position " + device, getDrivePosition());
        SmartDashboard.putNumber("Drive Velocity " + device, getDriveVelocity());
        SmartDashboard.putNumber("Drive Get Speed input " + device, speed_input);
    }
}
