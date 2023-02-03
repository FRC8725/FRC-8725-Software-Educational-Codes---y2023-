package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger; 

public class GamepadJoystick extends Joystick {
    public GamepadJoystick(int port) {
        super(port);
    }

    public Trigger btn_RT = new JoystickButton(this, 8);
    
    public double get_LStickY() {
        return getRawAxis(1);
    }
    
    public double get_RStickY() {
        return getRawAxis(3);
    }
}
