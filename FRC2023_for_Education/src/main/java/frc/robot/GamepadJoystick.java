package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class GamepadJoystick extends Joystick{

    public GamepadJoystick(int port) {
        super(port);
    }

    public Trigger btn_A = new JoystickButton(this, 2);
    public Trigger btn_B = new JoystickButton(this, 3);
    public Trigger btn_X = new JoystickButton(this, 1);
    public Trigger btn_Y = new JoystickButton(this, 4);

    public double get_LStickY() {
        return getRawAxis(1);
    }

    public double get_RStickY() {
        return getRawAxis(3);
    }

}
