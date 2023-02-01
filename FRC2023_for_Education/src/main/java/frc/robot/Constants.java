// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;

public final class Constants {

    public static final class DriveConstants {
        public static final double kMotor_deadline = 0.05;

        public static final double kSpeed = 0.7;

        public static final double kEncoder_Pulse = 526.;
        public static final double kMotor_Perimeter = 4.;
        public static final double kMax_Period = .1;
    }

    public static final class CANMotorConstants {
        public static final double kWheelDiameterMeters = Units.inchesToMeters(4);
        public static final double kDriveEncoderRot2Meter = kWheelDiameterMeters * Math.PI * kWheelDiameterMeters;
        public static final double kDriveEncoderRPM2MeterPerSec = kDriveEncoderRot2Meter / 60;
    }
}
