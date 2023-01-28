package frc.robot.lib;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.Encoder;

public class DriverTable {
    private final static double MOTOR_PULSE = 526.;
    private final static double MOTOR_PERIMETER = 4.;
    private final static double MAX_PERIOD = .1; // ??

    public static PWMVictorSPX DriveTable_Setup() {
        PWMVictorSPX PWM_VictorSPX = new PWMVictorSPX(Constants.dirver.MOTOR);

        PWM_VictorSPX.setInverted(true);

        return PWM_VictorSPX;
    }

    public static Encoder Encoder_Setup() {
        Encoder Motor_Encoder = new Encoder(0, 1, false, Encoder.EncodingType.k1X);
        Motor_Encoder.setDistancePerPulse(MOTOR_PERIMETER / MOTOR_PULSE);
        
        return Motor_Encoder;
    }

    public static double DriveDistance(Encoder Motor_Encoder) {
        double Distance = Motor_Encoder.getDistance();
        return Distance;
    }
    
    public static void Encoder_Zero(Encoder Motor_Encoder) {
        Motor_Encoder.reset();
    }
}