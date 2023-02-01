package frc.robot.subsystems;

import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NeoMotorModule {
    
    CANSparkMax CANMotor;

    RelativeEncoder Encoder;

    double Position;
    double speed_input;

    public NeoMotorModule(int Port_ID, boolean reverse) {
        CANMotor = new CANSparkMax(Port_ID, MotorType.kBrushless);

        CANMotor.setSmartCurrentLimit(30);
        CANMotor.setIdleMode(IdleMode.kBrake); // the other mode is kCoast
        CANMotor.setInverted(reverse);

        Encoder = CANMotor.getEncoder();
        Encoder.setPositionConversionFactor(Constants.NEOMotorConstants.kDriveEncoderRot2Meter);
        Encoder.setVelocityConversionFactor(Constants.NEOMotorConstants.kDriveEncoderRPM2MeterPerSec);


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
        speed_input = speed * Constants.NEOMotorConstants.kSpeed;
        CANMotor.set(speed * Constants.NEOMotorConstants.kSpeed);
        putDashBoard();
    }

    public void stop() {
        CANMotor.set(0);
        putDashBoard();
    }

    public void putDashBoard() {
        SmartDashboard.putNumber("CANMotor Position ", getDrivePosition());
        SmartDashboard.putNumber("CANMotor Velocity ", getDriveVelocity());
        SmartDashboard.putNumber("CANMotor Get Speed input ", speed_input);
    }

}
