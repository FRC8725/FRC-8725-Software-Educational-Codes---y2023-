
package frc.robot;

import edu.wpi.first.math.util.Units;

public final class Constants {
  public static final class DriveConstants {
    public static final double kWheelDiameterMeters = Units.inchesToMeters(4);
    public static final double kDriveEncoderRot2Meter = kWheelDiameterMeters * Math.PI * kWheelDiameterMeters;
    public static final double kDriveEncoderRPM2MeterPerSec = kDriveEncoderRot2Meter / 60;

    public static final double kSpeed = 0.05;
}
}
