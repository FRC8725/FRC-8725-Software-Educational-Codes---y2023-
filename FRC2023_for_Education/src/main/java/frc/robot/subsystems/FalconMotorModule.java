package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class FalconMotorModule {
    
    private WPI_TalonFX Falcon_Motor;

    double speed_input;

    public FalconMotorModule(int Port_ID, boolean reverse) {
        Falcon_Motor = new WPI_TalonFX(Port_ID);

        Falcon_Motor.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, 30, 10, 0.5));
        Falcon_Motor.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 40, 20, 1));

        Falcon_Motor.setInverted(reverse);

    }

    public void resetEncoder() {
        Falcon_Motor.setSelectedSensorPosition(0);
    } 

    public double getPositionAsRad() {
        return Falcon_Motor.getSelectedSensorPosition() / (2048 / Constants.FalconMotorConstants.gearRatio) * 2 * Math.PI;
    }


    public double getDrivePosition(){
        return Falcon_Motor.getSelectedSensorPosition();
    }

    public double getVelocity() {
        double motorRPM = Falcon_Motor.getSelectedSensorVelocity() * (600. / 2048.);
        double mechRPM = motorRPM * Constants.FalconMotorConstants.gearRatio;
        double mechMPS = (mechRPM * Constants.FalconMotorConstants.kCircumstance) / 60;
        return mechMPS;
    }

    public void setDesiredState(double speed) {
        speed_input = speed * Constants.FalconMotorConstants.kSpeed;
        Falcon_Motor.set(speed * Constants.FalconMotorConstants.kSpeed);
        putDashBoard();
    }

    public void stop() {
        Falcon_Motor.set(0);
        putDashBoard();
    }

    public void putDashBoard() {
        SmartDashboard.putNumber("FalconMotor Position ", getDrivePosition());
        SmartDashboard.putNumber("FalconMotor Velocity ", getVelocity());
        SmartDashboard.putNumber("FalconMotor Rad ",  getPositionAsRad());
        SmartDashboard.putNumber("FalconMotor Get Speed input ", speed_input);
    }


}
